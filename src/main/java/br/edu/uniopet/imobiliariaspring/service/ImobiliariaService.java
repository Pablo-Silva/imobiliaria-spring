package br.edu.uniopet.imobiliariaspring.service;

import br.edu.uniopet.imobiliariaspring.domain.Imobiliaria;
import br.edu.uniopet.imobiliariaspring.repository.ImobiliariaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImobiliariaService {

    private ImobiliariaRepository imobiliariaRepository;

    public ImobiliariaService(ImobiliariaRepository imobiliariaRepository) {
        this.imobiliariaRepository = imobiliariaRepository;
    }

    public Iterable<Imobiliaria> list(){
        return imobiliariaRepository.findAll();
    }

    public Imobiliaria save(Imobiliaria imobiliaria){
        return imobiliariaRepository.save(imobiliaria);
    }

    public Iterable<Imobiliaria> save(List<Imobiliaria> imobiliarias){
        return imobiliariaRepository.saveAll(imobiliarias);
    }
}
