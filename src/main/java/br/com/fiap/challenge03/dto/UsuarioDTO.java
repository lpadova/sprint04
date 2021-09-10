package br.com.fiap.challenge03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Integer id;

    @NotBlank(message = "Campo nome obrigatório")
    private String nome;

    @Email(message = "Campo email deve conter um email válido")
    @NotBlank(message = "Campo email é obrigatório")
    private String email;

    @Size(min = 8, message = "Campo senha deve conter pelo menos 8 Caracteres")
    @NotBlank(message = "Campo senha é obrigatório")
    private String senha;
}
