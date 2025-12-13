package br.com.yangarrido.gestao_vagas.modules.candidate.userCases;

import br.com.yangarrido.gestao_vagas.modules.company.entities.JobEntity;
import br.com.yangarrido.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllJobsByFilterUserCase {

    @Autowired
    private JobRepository jobRepository;


    public List<JobEntity> execute(String filter) {
        return this.jobRepository.findByDescriptionContainingIgnoreCase(filter);
    }
}
