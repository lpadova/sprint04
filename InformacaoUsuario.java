package br.com.fiap.challenge03.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformacaoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "id_usuario_info")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nr_atualizacao", nullable = false)
    @NotBlank(message = "O campo nr_atualizacao é obrigatório")
    private Integer numeroAtualizacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @JsonBackReference
    private Usuario usuario;

    @CreationTimestamp
    @Column(name = "dt_atualizacao")
    @NotBlank(message = "O campo dt_atualizacao é obrigatório")
    private Calendar dataAtualizacao;

    @Column(name = "nr_altura")
    @NotBlank(message = "O campo nr_altura é obrigatório")
    private double altura;

    @Column(name = "nr_peso")
    @NotBlank(message = "O campo nr_peso é obrigatório")
    private double peso;

    @Column(name = "nr_imc")
    private double imc;

    public double getImc() {
        this.imc = this.peso / (this.altura * this.altura);
        return imc;
    }
}
