package br.com.fiap.challenge03.service.impl;

import br.com.fiap.challenge03.exception.DataIntegretyException;
import br.com.fiap.challenge03.exception.ObjectNotFoundException;
import br.com.fiap.challenge03.model.Estado;
import br.com.fiap.challenge03.model.Usuario;
import br.com.fiap.challenge03.repository.EstadoRepository;
import br.com.fiap.challenge03.repository.UsuarioRepository;
import br.com.fiap.challenge03.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void create(List<Estado> estados) {

        if (estados.isEmpty()){
            throw new DataIntegretyException("Necessário preenchimento de todos os campos do Estado");
        }

        for (Estado estado : estados) {
            Usuario user = usuarioRepository.findByCpf(estado.getUsuario().getCpf());
            if(user == null )
                throw new ObjectNotFoundException("Usuário não encontrado na base de dados! - Nome: " +
                        estado.getUsuario().getNome() +
                        " CPF: " + estado.getUsuario().getCpf());

            estado.getUsuario().setId(user.getId());
        }

        estadoRepository.saveAll(estados);
    }

    @Override
    public Optional<Estado> findById(Integer id) {
        return estadoRepository.findById(id);
    }

    @Override
    public Page<Estado> findAll(Pageable pageable) {
        return estadoRepository.findAll(pageable);
    }

}
