package br.edu.uniopet.imobiliariaspring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@Embeddable
@Entity
public class Localizacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String cep;
    private String enderoceo;

    @Embedded
    @JsonIgnore
    @OneToMany(mappedBy = "localizacao")
    private List<Imobiliaria> imobiliarias = new ArrayList<>();

    public Localizacao() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEnderoceo() {
        return enderoceo;
    }

    public void setEnderoceo(String enderoceo) {
        this.enderoceo = enderoceo;
    }


}
