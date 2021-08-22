package br.com.letscode.repository;

import br.com.letscode.entity.CursoDisciplinaProfessor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoDisciplinaRepository extends JpaRepository <CursoDisciplinaProfessor, Integer> {
}
