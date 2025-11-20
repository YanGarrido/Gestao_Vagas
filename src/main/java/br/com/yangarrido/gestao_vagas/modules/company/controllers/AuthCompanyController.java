package br.com.yangarrido.gestao_vagas.modules.company.controllers;

import br.com.yangarrido.gestao_vagas.dto.AuthCompanyDTO;
import br.com.yangarrido.gestao_vagas.modules.company.userCases.AuthCompanyUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/company")
public class AuthCompanyController {

  @Autowired
  private AuthCompanyUserCase authCompanyUserCase;

  @PostMapping("/auth")
  public ResponseEntity<Object> create(@RequestBody AuthCompanyDTO authCompanyDTO){
    try {
      var result = authCompanyUserCase.execute(authCompanyDTO);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

  }
}
