package br.com.fiap.challenge03.repository;

import br.com.fiap.challenge03.model.InformacaoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformacaoUsuarioRepository extends JpaRepository<InformacaoUsuario, Integer> {

}
