package br.edu.uniopet.imobiliariaspring.service;

import br.edu.uniopet.imobiliariaspring.domain.Cidade;
import br.edu.uniopet.imobiliariaspring.repository.CidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    //List city objetc
    public Iterable<Cidade> list(){
        return cidadeRepository.findAll();
    }

    //Save a city object
    public Cidade save(Cidade cidade){
        return cidadeRepository.save(cidade);
    }

    //Save a city object list
    public Iterable<Cidade> save(List<Cidade> cidades){
        return cidadeRepository.saveAll(cidades);
    }
}
