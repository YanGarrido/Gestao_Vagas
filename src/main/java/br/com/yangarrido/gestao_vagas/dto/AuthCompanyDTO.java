package br.com.yangarrido.gestao_vagas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCompanyDTO {

  private String username;
  private String password;
}
