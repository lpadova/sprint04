package br.com.fiap.challenge03.repository;

import br.com.fiap.challenge03.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
