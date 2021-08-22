package br.com.letscode.request;


import br.com.letscode.entity.Curso;
import br.com.letscode.entity.Modalidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoRequest {
    private int codigoCurso;
    private String nomeCurso;
    private int duracao;
    private int numeroAlunos;

    public Curso convert(){
        return new Curso(getCodigoCurso(),nomeCurso,duracao,numeroAlunos, Modalidade.PRESENCIAL);
    }
}
