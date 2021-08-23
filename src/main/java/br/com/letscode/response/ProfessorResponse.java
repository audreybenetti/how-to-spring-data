package br.com.letscode.response;

import br.com.letscode.entity.Curso;
import br.com.letscode.entity.Professor;
import lombok.Getter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProfessorResponse {
    private final int codigoProfessor;
    private final String nome;
    private final Curso codigoCurso;

    public ProfessorResponse(Professor professor){
        this.codigoProfessor = professor.getCodigoProfessor();
        this.nome = professor.getNome();
        this.codigoCurso = professor.getCodigoCurso();
    }

    public static List<ProfessorResponse> convert(List<Professor> professores){
        return professores.stream().map(ProfessorResponse::new).collect(Collectors.toList());
    }
}

