package br.com.fiap.challenge03.controller;

import br.com.fiap.challenge03.dto.ConsultaDTO;
import br.com.fiap.challenge03.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/api/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    ConsultaDTO findByCpf(@RequestParam String cpf) {

        return consultaService.buscarResumoInformacoes(cpf);
    }
}
