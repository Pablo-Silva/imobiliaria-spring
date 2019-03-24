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
@Entity
public class Imobiliaria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Integer id;
    private Integer idImobiliaria;
    private String nome;
    @Embedded
    @ManyToOne
    @JoinColumn(name = "localizacao_id")
    private Localizacao localizacao;

    public Imobiliaria() {
    }

    public Imobiliaria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdImobiliaria() {
        return idImobiliaria;
    }

    public void setIdImobiliaria(Integer idImobiliaria) {
        this.idImobiliaria = idImobiliaria;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imobiliaria that = (Imobiliaria) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Imobiliaria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
