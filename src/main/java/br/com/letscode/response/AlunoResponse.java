package br.com.letscode.response;

import br.com.letscode.entity.Aluno;
import br.com.letscode.entity.Curso;
import lombok.Getter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AlunoResponse {
    private final int ra;
    private final String nome;
    private final String sobrenome;
    private final Date dataNascimento;
    private final Curso codigoCurso;

    public AlunoResponse (Aluno aluno){
        this.ra = aluno.getRa();
        this.nome = aluno.getNome();
        this.sobrenome = aluno.getSobrenome();
        this.dataNascimento = aluno.getDataNascimento();
        this.codigoCurso = aluno.getCodigoCurso();
    }

    public static List<AlunoResponse> convert(List<Aluno> alunos){
        return alunos.stream().map(AlunoResponse::new).collect(Collectors.toList());
    }
}
