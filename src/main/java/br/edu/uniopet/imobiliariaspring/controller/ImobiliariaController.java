package br.edu.uniopet.imobiliariaspring.controller;

import br.edu.uniopet.imobiliariaspring.domain.Imobiliaria;
import br.edu.uniopet.imobiliariaspring.service.ImobiliariaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imobiliarias")
public class ImobiliariaController {

    private ImobiliariaService imobiliariaService;

    public ImobiliariaController(ImobiliariaService imobiliariaService) {
        this.imobiliariaService = imobiliariaService;
    }

    @GetMapping("/list")
    public Iterable<Imobiliaria> list(){
        return imobiliariaService.list();
    }
}
