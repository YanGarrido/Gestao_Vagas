package br.com.yangarrido.gestao_vagas.modules.company.userCases;

import br.com.yangarrido.gestao_vagas.exceptions.UserFoundException;
import br.com.yangarrido.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.yangarrido.gestao_vagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUserCase {

  @Autowired
  private CompanyRepository companyRepository;

  public CompanyEntity execute(CompanyEntity companyEntity){
    this.companyRepository
        .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent((user) ->{
          throw new UserFoundException();
        });

    return this.companyRepository.save(companyEntity);
  }
}
