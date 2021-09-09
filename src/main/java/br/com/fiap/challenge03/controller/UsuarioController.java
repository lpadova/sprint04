package br.com.fiap.challenge03.controller;

import br.com.fiap.challenge03.model.Usuario;
import br.com.fiap.challenge03.service.UsuarioService;
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

@Controller
@ResponseBody
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public Page<Usuario> findAll(@RequestParam(required = false) String nome,
                                 @PageableDefault Pageable pageable) {
        return usuarioService.findAll(nome, pageable);
    }

    @PostMapping()
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario,
                                          UriComponentsBuilder componentsBuilder){
        usuarioService.create(usuario);

        URI uri = componentsBuilder.
                path("api/task/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();

        return ResponseEntity.created(uri).body(usuario);
    }
}
