package br.com.fiap.challenge03.model;

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

}
