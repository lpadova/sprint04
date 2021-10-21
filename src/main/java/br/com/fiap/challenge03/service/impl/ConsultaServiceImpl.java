package br.com.fiap.challenge03.service.impl;

import br.com.fiap.challenge03.dto.ConsultaDTO;
import br.com.fiap.challenge03.model.Usuario;
import br.com.fiap.challenge03.repository.UsuarioRepository;
import br.com.fiap.challenge03.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public ConsultaDTO buscarResumoInformacoes(String cpf) {
        Usuario usuario = usuarioRepository.findUsuarioByCpf(cpf);
        return new ConsultaDTO(usuario);
    }
}
