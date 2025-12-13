package br.com.yangarrido.gestao_vagas.modules.candidate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class CandidateEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Schema(example = "Jorge da Silva", requiredMode = Schema.RequiredMode.REQUIRED, description = "Nome do candidato")
  private String name;

  @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço.")
  @Schema(example = "jorge123", requiredMode = Schema.RequiredMode.REQUIRED, description = "Username do candidato")
  private String username;

  @Email(message = "o campo [email] deve conter um e-mail válido.")
  @Schema(example = "jorge@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED, description = "Email do candidato")
  private String email;

  @Length(min = 10, max = 100, message = "A senha deve conter entre [10] e [100] caracteres.")
  @Schema(example = "admin@1234", minLength = 10, maxLength = 100, requiredMode = Schema.RequiredMode.REQUIRED, description = "Senha do candidato" )
  private String password;
  @Schema(example = "Desenvolvedor Full Stack com 5 anos de experiência em Java e React.", requiredMode = Schema.RequiredMode.REQUIRED, description = "Descrição do candidato")
  private String description;
  @Schema(example = "Link do currículo do candidato", requiredMode = Schema.RequiredMode.REQUIRED, description = "Curriculo do candidato")
  private String curriculum;

  @CreationTimestamp
  private LocalDateTime creationDate;
}
