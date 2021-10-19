package br.com.fiap.challenge03.service;

import br.com.fiap.challenge03.dto.EstadoDTO;
import br.com.fiap.challenge03.model.Estado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EstadoService {

    void create(List<Estado> estado);

    Optional<Estado> findById(Integer id);

    Page<Estado> findAll(Pageable pageable);

    Estado update(Integer id, Estado estado);

    Estado fromDTO(EstadoDTO estadoDTO);

}
