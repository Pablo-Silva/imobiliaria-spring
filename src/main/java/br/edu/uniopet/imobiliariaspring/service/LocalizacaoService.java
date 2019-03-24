package br.edu.uniopet.imobiliariaspring.service;

import br.edu.uniopet.imobiliariaspring.domain.Imobiliaria;
import br.edu.uniopet.imobiliariaspring.domain.Localizacao;
import br.edu.uniopet.imobiliariaspring.repository.ImobiliariaRepository;
import br.edu.uniopet.imobiliariaspring.repository.LocalizacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalizacaoService {

    private LocalizacaoRepository localizacaoRepository;

    public LocalizacaoService(LocalizacaoRepository localizacaoRepository) {
        this.localizacaoRepository = localizacaoRepository;
    }

    public Iterable<Localizacao> list(){
        return localizacaoRepository.findAll();
    }

    public Localizacao save(Localizacao localizacao){
        return localizacaoRepository.save(localizacao);
    }

    public Iterable<Localizacao> save(List<Localizacao> localizacoes){
        return localizacaoRepository.saveAll(localizacoes);
    }
}
