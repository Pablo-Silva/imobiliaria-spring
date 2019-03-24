package br.edu.uniopet.imobiliariaspring.controller;

import br.edu.uniopet.imobiliariaspring.domain.Cidade;
import br.edu.uniopet.imobiliariaspring.service.CidadeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }


    //Method to list cities
    @GetMapping("/list")
    public Iterable<Cidade> list(){
        return cidadeService.list();
    }
}
