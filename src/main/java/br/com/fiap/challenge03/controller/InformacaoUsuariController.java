package br.com.fiap.challenge03.controller;

import br.com.fiap.challenge03.dto.InformacaoUsuarioDTO;
import br.com.fiap.challenge03.model.InformacaoUsuario;
import br.com.fiap.challenge03.service.InformacaoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/api/infoUser")
public class InformacaoUsuariController {

    @Autowired
    private InformacaoUsuarioService service;

    @GetMapping
    public Page<InformacaoUsuario> findAll(@PageableDefault Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<InformacaoUsuario> findOne(@PathVariable Integer id) {
        return ResponseEntity.of(service.findById(id));
    }

    @PostMapping()
    public ResponseEntity<List<InformacaoUsuario>> create(@Valid @RequestBody List<InformacaoUsuario> infoUsers,
                                                          UriComponentsBuilder componentsBuilder) {
        service.create(infoUsers);

        URI uri = componentsBuilder.
                path("api/estado/{id}")
                .buildAndExpand(infoUsers)
                .toUri();

        return ResponseEntity.created(uri).body(infoUsers);
    }

    @PostMapping("{id}")
    public ResponseEntity<InformacaoUsuario> update(@PathVariable Integer id,
                                                    @RequestBody @Valid InformacaoUsuarioDTO usuarioDTO) {

        InformacaoUsuario infoUser = service.fromDTO(usuarioDTO);
        infoUser.setId(id);
        infoUser = service.update(id, infoUser);

        return ResponseEntity.ok(infoUser);
    }

}
