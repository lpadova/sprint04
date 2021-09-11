package br.com.fiap.challenge03.service.impl;

import br.com.fiap.challenge03.dto.UsuarioDTO;
import br.com.fiap.challenge03.exception.DataIntegretyException;
import br.com.fiap.challenge03.exception.ObjectNotFoundException;
import br.com.fiap.challenge03.model.InformacaoUsuario;
import br.com.fiap.challenge03.model.Usuario;
import br.com.fiap.challenge03.repository.InformacaoUsuarioRepository;
import br.com.fiap.challenge03.repository.UsuarioRepository;
import br.com.fiap.challenge03.service.InformacaoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformacaoUsuarioServiceImpl implements InformacaoUsuarioService {

    @Autowired
    private InformacaoUsuarioRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Page<InformacaoUsuario> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @Override
    public Optional<InformacaoUsuario> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public InformacaoUsuario update(Integer id, InformacaoUsuario informacaoUsuario) {
        Optional<InformacaoUsuario> infoUserOptional = findById(id);

        InformacaoUsuario infoUser = infoUserOptional.get();

        infoUser.setAltura(informacaoUsuario.getAltura());
        infoUser.setDataAtualizacao(informacaoUsuario.getDataAtualizacao());
        infoUser.setNumeroAtualizacao(informacaoUsuario.getId());
        infoUser.setUsuario(informacaoUsuario.getUsuario());
        infoUser.setPeso(informacaoUsuario.getPeso());
        infoUser.getImc();

        return infoUser;
    }

    @Override
    public InformacaoUsuario fromDTO(InformacaoUsuario dto) {
        return new InformacaoUsuario(dto.getNumeroAtualizacao(), dto.getDataAtualizacao(), dto.getUsuario(),
                dto.getAltura(), dto.getPeso());
    }

    @Override
    public void create(List<InformacaoUsuario> infoUsers) {
        if (infoUsers.isEmpty())
            throw new DataIntegretyException("Necessário o preenchimento de todos os campos de Informação de usuários");

        for (InformacaoUsuario info : infoUsers) {
            Usuario usuario = usuarioRepository.findByCpf(info.getUsuario().getCpf());

            if (usuario == null)
                throw new ObjectNotFoundException("Usuário não encontrado na base de dados! " +
                        "\nNome: " + info.getUsuario().getNome() + " CPF: " + info.getUsuario().getCpf());

            info.getUsuario().setId(usuario.getId());
        }
        repository.saveAll(infoUsers);
    }


}
