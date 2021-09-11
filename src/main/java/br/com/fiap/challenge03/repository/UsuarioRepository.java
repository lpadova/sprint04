package br.com.fiap.challenge03.repository;

import br.com.fiap.challenge03.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    Page<Usuario> findByNomeContains(String nome, Pageable pageable);

    Usuario findByCpf(String cpf);
}
