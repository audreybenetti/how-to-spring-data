package br.com.letscode.request;

import br.com.letscode.entity.Curso;
import br.com.letscode.entity.Professor;
import br.com.letscode.repository.CursoRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
@Getter
@Setter
public class ProfessorRequest {
    private int codigoProfessor;
    private String nome;
    private int codigoCurso;

    public Professor convert(CursoRepository cursoRepository) {
        Optional<Curso> cursoOptional = cursoRepository.findById(codigoCurso);
        Curso curso = cursoOptional.get();
        return new Professor(codigoProfessor, nome, curso);
    }
}
