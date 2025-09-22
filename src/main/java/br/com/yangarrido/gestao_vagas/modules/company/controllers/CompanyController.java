package br.com.yangarrido.gestao_vagas.modules.company.controllers;

import br.com.yangarrido.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.yangarrido.gestao_vagas.modules.company.userCases.CreateCompanyUserCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

  @Autowired
  private CreateCompanyUserCase createCompanyUserCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity){
    try{
      var result = this.createCompanyUserCase.execute(companyEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e){
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
