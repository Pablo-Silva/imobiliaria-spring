package br.edu.uniopet.imobiliariaspring.repository;

import br.edu.uniopet.imobiliariaspring.domain.Cidade;
import org.springframework.data.repository.CrudRepository;

//Repository extends CrudRepository
public interface CidadeRepository extends CrudRepository<Cidade, Integer> {
}
