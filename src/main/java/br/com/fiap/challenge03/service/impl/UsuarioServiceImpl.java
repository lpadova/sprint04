package br.com.fiap.challenge03.service.impl;

import br.com.fiap.challenge03.exception.DataIntegretyException;
import br.com.fiap.challenge03.exception.ObjectNotFoundException;
import br.com.fiap.challenge03.model.Usuario;
import br.com.fiap.challenge03.repository.UsuarioRepository;
import br.com.fiap.challenge03.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Page<Usuario> findAll(String nome, Pageable pageable) {
        if (nome == null)
            return usuarioRepository.findAll(pageable);

        return usuarioRepository.findAllByNomeContains(nome, pageable);
    }

    @Override
    public void create(Usuario usuario) {
        try {
            Usuario user = usuarioRepository.findByCpf(usuario.getCpf());

            if(user != null)
                if (usuario.getCpf().equals(user.getCpf())) {
                    throw new DataIntegretyException("Usuário já existente no banco de dados");
                }

            usuarioRepository.save(usuario);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Page<Usuario> findOne(String cpf, Pageable pageable) {
        Page<Usuario> usuario = null;
        try {
            usuario = usuarioRepository.findUsuariosByCpf(cpf, pageable);
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Usuario não encontrado", e.getCause());
        }

        return usuario;
    }
}
