package br.com.letscode.repository;

import br.com.letscode.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository <Aluno, Integer> {
    }
