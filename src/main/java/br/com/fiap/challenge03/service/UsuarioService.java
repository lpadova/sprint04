package br.com.fiap.challenge03.service;

import br.com.fiap.challenge03.dto.UsuarioDTO;
import br.com.fiap.challenge03.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UsuarioService {

    Page<Usuario> findAll(String nome, Pageable pageable);

    void create(Usuario usuario);

    Optional<Usuario> findById(Integer id);

    Usuario update(Integer id, Usuario usuario);

    Usuario fromDTO(UsuarioDTO usuarioDTO);

    Usuario findByCpf(String cpf);
}
