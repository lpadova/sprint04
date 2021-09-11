package br.com.fiap.challenge03.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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
    private Integer numeroAtualizacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @JsonBackReference
    private Usuario usuario;

    @CreationTimestamp
    @Column(name = "dt_atualizacao")
    private Calendar dataAtualizacao;

    @Column(name = "nr_altura")
    private double altura;

    @Column(name = "nr_peso")
    private double peso;

    @Column(name = "nr_imc")
    private double imc;

    public InformacaoUsuario(Integer numeroAtualizacao, Calendar dataAtualizacao,
                             Usuario usuario, double altura, double peso) {
        this.numeroAtualizacao = numeroAtualizacao;
        this.dataAtualizacao = dataAtualizacao;
        this.usuario = usuario;
        this.altura = altura;
        this.peso = peso;
    }

    public double getImc() {
        this.imc = this.peso / (this.altura * this.altura);
        return imc;
    }
}
