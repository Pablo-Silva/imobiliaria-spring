package br.edu.uniopet.imobiliariaspring;

import br.edu.uniopet.imobiliariaspring.commandLine.LocalizacaoCommandLine;
import br.edu.uniopet.imobiliariaspring.domain.Imobiliaria;
import br.edu.uniopet.imobiliariaspring.domain.Localizacao;
import br.edu.uniopet.imobiliariaspring.service.ImobiliariaService;
import br.edu.uniopet.imobiliariaspring.service.LocalizacaoService;
import com.fasterxml.jackson.core.type.TypeReference;
import br.edu.uniopet.imobiliariaspring.domain.Cidade;
import br.edu.uniopet.imobiliariaspring.service.CidadeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class ImobiliariaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImobiliariaSpringApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(CidadeService cidadeService){
//        return args -> {
//            // read json and write to db
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<List<Cidade>> typeReference = new TypeReference<List<Cidade>>(){};
//            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/cidade.json");
//            try {
//                List<Cidade> cidades = mapper.readValue(inputStream,typeReference);
//                cidadeService.save(cidades);
//                System.out.println("Citys Saved!");
//            } catch (IOException e){
//                System.out.println("Unable to save citys: " + e.getMessage());
//            }
//        };
//    }

    @Bean
    CommandLineRunner runnerLocalizacao(LocalizacaoService service){
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


    @Bean
    CommandLineRunner runner(ImobiliariaService imobiliariaService){
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Imobiliaria>> typeReference = new TypeReference<List<Imobiliaria>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/imobiliaria.json");
            try {
                List<Imobiliaria> imobiliarias = mapper.readValue(inputStream,typeReference);
                imobiliariaService.save(imobiliarias);
                System.out.println("Imobiliaria Salva");
            } catch (IOException e){
                System.out.println("Nao foi possivel salvar imobiliaria: " + e.getMessage());
            }
        };
    }

}
