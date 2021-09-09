package br.com.fiap.challenge03.service;

import br.com.fiap.challenge03.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {

    Page<Usuario> findAll(String nome, Pageable pageable);

    void create(Usuario usuario);

    Page<Usuario> findOne(String cpf, Pageable pageable);
}
