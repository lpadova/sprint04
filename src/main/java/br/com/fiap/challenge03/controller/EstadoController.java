package br.com.fiap.challenge03.controller;

import br.com.fiap.challenge03.model.Estado;
import br.com.fiap.challenge03.service.EstadoService;
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
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping()
    public ResponseEntity<List<Estado>> create(@Valid @RequestBody List<Estado> estados,
                                               UriComponentsBuilder componentsBuilder) {
        estadoService.create(estados);

        URI uri = componentsBuilder.
                path("api/estado/{id}")
                .buildAndExpand(estados)
                .toUri();

        return ResponseEntity.created(uri).body(estados);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Estado> findOne(@PathVariable Integer id) {
        return ResponseEntity.of(estadoService.findById(id));
    }

    @GetMapping
    public Page<Estado> findAll(@PageableDefault Pageable pageable) {
        return estadoService.findAll(pageable);
    }


}
