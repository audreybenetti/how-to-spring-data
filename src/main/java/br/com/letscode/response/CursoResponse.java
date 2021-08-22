package br.com.letscode.response;

import br.com.letscode.entity.Curso;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
public class CursoResponse {
    private final String nomeCurso;
    private final int duracao;
    private final int numeroAlunos;

    public CursoResponse(Curso curso) {
        this.nomeCurso = curso.getNomeCurso();
        this.duracao = curso.getDuracao();
        this.numeroAlunos = curso.getNumeroAlunos();

    }

    public static List<CursoResponse> convert(List<Curso> cursos) {
        return cursos.stream().map(CursoResponse::new).collect(Collectors.toList());
    }
    
}