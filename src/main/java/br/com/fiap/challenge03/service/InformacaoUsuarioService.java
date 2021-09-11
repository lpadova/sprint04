package br.com.fiap.challenge03.service;

import br.com.fiap.challenge03.dto.InformacaoUsuarioDTO;
import br.com.fiap.challenge03.dto.UsuarioDTO;
import br.com.fiap.challenge03.model.InformacaoUsuario;
import br.com.fiap.challenge03.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface InformacaoUsuarioService {
    Page<InformacaoUsuario> findAll(Pageable pageable);

    void create(List<InformacaoUsuario> infoUsers);

    Optional<InformacaoUsuario> findById(Integer id);

    InformacaoUsuario update(Integer id, InformacaoUsuario informacaoUsuario);

    InformacaoUsuario fromDTO(InformacaoUsuarioDTO usuarioDTO);
}
