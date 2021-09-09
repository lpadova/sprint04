package br.com.fiap.challenge03.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nm_usuario")
    @NotBlank(message = "Campo nome obrigatório")
    private String nome;

    @Email(message = "campo email deve conter um email válido")
    @NotBlank
    @Column(name = "ds_email", nullable = false)
    private String email;

    @Size(min = 8, message = "Campo senha deve conter pelo menos 8 Caracteres")
    @Column(name = "ds_senha", nullable = false)
    private String senha;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nascimento")
    @NotNull(message = "Campo dataNascimento obrigatório")
    private Calendar dataNascimento;

    @Column(name = "nr_rg")
    private String rg;

    @Column(name = "nr_cpf", unique = true)
    @NotBlank(message = "Campo CPF obrigatório")
    @Size(min = 11, max = 13)
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_genero", referencedColumnName = "id_genero")
    private Genero genero;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Estado> estados;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<InformacaoUsuario> infoUsers;

    public void addEstados(Estado estado) {
        if (estados == null)
            estados = new ArrayList<>();

        estados.add(estado);

        estado.setUsuario(this);
    }

    public void addInformacaoUsuario(InformacaoUsuario informacaoUsuario) {
        if (infoUsers == null)
            infoUsers = new ArrayList<>();

        infoUsers.add(informacaoUsuario);

        informacaoUsuario.setUsuario(this);
    }
}
