package br.com.yangarrido.gestao_vagas.modules.candidate.userCases;

import br.com.yangarrido.gestao_vagas.exceptions.JobNotFoundException;
import br.com.yangarrido.gestao_vagas.exceptions.UserNotFoundException;
import br.com.yangarrido.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.yangarrido.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUserCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    public void execute(UUID candidateId, UUID jobId) {

        this.candidateRepository.findById(candidateId)
        .orElseThrow(() -> {
            throw new UserNotFoundException();
        });

        this.jobRepository.findById(jobId)
        .orElseThrow(() -> {
            throw new JobNotFoundException();
        });
    }
}
