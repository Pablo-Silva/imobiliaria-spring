package br.edu.uniopet.imobiliariaspring.controller;

import br.edu.uniopet.imobiliariaspring.domain.Imobiliaria;
import br.edu.uniopet.imobiliariaspring.domain.Localizacao;
import br.edu.uniopet.imobiliariaspring.service.ImobiliariaService;
import br.edu.uniopet.imobiliariaspring.service.LocalizacaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/localizacoes")
public class LocoalizacaoController {

    private LocalizacaoService localizacaoService;

    public LocoalizacaoController(LocalizacaoService localizacaoService) {
        this.localizacaoService = localizacaoService;
    }

    @GetMapping("/list")
    public Iterable<Localizacao> list(){
        return localizacaoService.list();
    }
}
