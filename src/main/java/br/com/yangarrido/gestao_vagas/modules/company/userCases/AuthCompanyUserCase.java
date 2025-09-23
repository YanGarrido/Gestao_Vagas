package br.com.yangarrido.gestao_vagas.modules.company.userCases;

import br.com.yangarrido.gestao_vagas.dto.AuthCompanyDTO;
import br.com.yangarrido.gestao_vagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AuthCompanyUserCase {

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public void execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
    var company = companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(
        () ->{
          throw new UsernameNotFoundException("Empresa não encontrada");
        }
    );

    var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

    if (!passwordMatches) {
      throw new AuthenticationException();
    }

  }
}
