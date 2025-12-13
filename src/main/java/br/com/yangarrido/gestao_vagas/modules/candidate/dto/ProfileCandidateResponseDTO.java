package br.com.yangarrido.gestao_vagas.modules.candidate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCandidateResponseDTO {

    @Schema(example = "Desenvolvedor Full Stack com 5 anos de experiência em Java e React.")
    private String description;

    @Schema(example = "joao")
    private String username;

    @Schema(example = "joao@gmail.com")
    private String email;
    private UUID id;

    @Schema(example = "João Silva")
    private String name;
}
