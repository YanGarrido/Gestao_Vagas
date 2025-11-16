package br.com.yangarrido.gestao_vagas.modules.company.controllers;

import br.com.yangarrido.gestao_vagas.dto.CreateJobDTO;
import br.com.yangarrido.gestao_vagas.modules.company.entities.JobEntity;
import br.com.yangarrido.gestao_vagas.modules.company.userCases.CreateJobUserCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/job")
public class JobController {

  @Autowired
  private CreateJobUserCase createJobUserCase;

  @PostMapping("/")
  public JobEntity create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request){
      var companyID = request.getAttribute("company_id");

      // jobEntity.setCompanyId(UUID.fromString(companyID.toString()));

      var jobEntity = JobEntity.builder()
              .benefits(createJobDTO.getBenefits())
              .companyId(UUID.fromString(companyID.toString()))
              .description(createJobDTO.getDescription())
              .level(createJobDTO.getLevel())
              .build();

    return this.createJobUserCase.execute(jobEntity);

  }
}
