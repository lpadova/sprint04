package br.com.fiap.challenge03.service.impl;

import br.com.fiap.challenge03.dto.UsuarioDTO;
import br.com.fiap.challenge03.exception.DataIntegretyException;
import br.com.fiap.challenge03.exception.ObjectNotFoundException;
import br.com.fiap.challenge03.model.Usuario;
import br.com.fiap.challenge03.repository.UsuarioRepository;
import br.com.fiap.challenge03.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Page<Usuario> findAll(String nome, Pageable pageable) {
        if (nome == null)
            return usuarioRepository.findAll(pageable);

        return usuarioRepository.findByNomeContains(nome, pageable);
    }

    @Override
    public void create(Usuario usuario) {
        try {
            Usuario user = usuarioRepository.findByCpf(usuario.getCpf());

            if (user != null)
                if (usuario.getCpf().equals(user.getCpf())) {
                    throw new DataIntegretyException("Usuário já existente no banco de dados");
                }

            usuarioRepository.save(usuario);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario update(Integer id, Usuario usuario) {
        Optional<Usuario> userOptional = findById(id);

        Usuario user = userOptional.get();

        user.setNome(usuario.getNome());
        user.setEmail(usuario.getEmail());
        user.setSenha(usuario.getSenha());

        usuarioRepository.save(user);

        return user;
    }

    public Usuario find(Integer id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado! Id: " + id +
                "Tipo: " + Usuario.class.getName()));
    }

    @Override
    public Usuario fromDTO(UsuarioDTO usuarioDTO) {
        return new Usuario(usuarioDTO.getId(), usuarioDTO.getNome(),
                usuarioDTO.getEmail(), usuarioDTO.getSenha());
    }
}
