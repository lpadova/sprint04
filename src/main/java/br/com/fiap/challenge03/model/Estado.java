package br.com.fiap.challenge03.model;

import com.fasterxml.jackson.annotation.*;
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
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Integer id;

    @Column(name = "nr_atualizacao", nullable = false)
    private Integer numeroAtualizacao;

    @ManyToOne()
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @JsonBackReference
    private Usuario usuario;

    @CreationTimestamp
    @Column(name = "dt_atualizacao", nullable = false)
    private Calendar dataAtualizacao;

    @Column(name = "md_pressao_arterial", length = 10)
    private String pressaoArterial;

    @Column(name = "md_monitoramento_cardiato", length = 10)
    private String monitoramentoCardiaco;

    @Column(name = "md_temperatura", length = 10)
    private String temperatura;
}
