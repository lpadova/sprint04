package br.com.fiap.challenge03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoDTO {

    private Integer id;

    @NotBlank(message = "Campo dataAtualizacao é obrigatório")
    private Calendar dataAtualizacao;

    @NotBlank(message = "Campo pressaoArterial é obrigatório")
    private String pressaoArterial;

    @NotBlank(message = "Campo monitoramentoCardiaco é obrigatório")
    private String monitoramentoCardiaco;

    @NotBlank(message = "Campo temperatura é obrigatório")
    private String temperatura;

}
