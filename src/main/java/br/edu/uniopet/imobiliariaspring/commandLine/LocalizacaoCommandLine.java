package br.edu.uniopet.imobiliariaspring.commandLine;

import br.edu.uniopet.imobiliariaspring.domain.Imobiliaria;
import br.edu.uniopet.imobiliariaspring.domain.Localizacao;
import br.edu.uniopet.imobiliariaspring.service.ImobiliariaService;
import br.edu.uniopet.imobiliariaspring.service.LocalizacaoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.service.Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LocalizacaoCommandLine {

    @Bean
    public CommandLineRunner runner(LocalizacaoService service){
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Localizacao>> typeReference = new TypeReference<List<Localizacao>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/localizacao.json");
            try {
                List<Localizacao> objects = mapper.readValue(inputStream,typeReference);
                service.save(objects);
                System.out.println("Localizacao Salva");
            } catch (IOException e){
                System.out.println("Nao foi possivel salvar localizacao: " + e.getMessage());
            }
        };
    }
}
