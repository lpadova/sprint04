package br.com.fiap.challenge03.dto;

import br.com.fiap.challenge03.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformacaoUsuarioDTO {

    private Integer id;

    private Integer numeroAtualizacao;

    private Usuario usuario;

    private Calendar dataAtualizacao;

    private double altura;

    private double peso;

}
