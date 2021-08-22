package br.com.letscode.repository;

import br.com.letscode.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {
}
