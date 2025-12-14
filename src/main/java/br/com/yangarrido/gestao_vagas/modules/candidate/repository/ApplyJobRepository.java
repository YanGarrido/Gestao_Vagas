package br.com.yangarrido.gestao_vagas.modules.candidate.repository;

import br.com.yangarrido.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {
}
