package br.com.letscode.request;

import br.com.letscode.entity.Aluno;
import br.com.letscode.entity.Curso;
import br.com.letscode.repository.CursoRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Optional;


@Getter
@Setter
public class AlunoRequest {
    private int ra;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private int codigoCurso;

    public Aluno convert(CursoRepository cursoRepository) {
        Optional<Curso> cursoOptional = cursoRepository.findById(codigoCurso);
        Curso curso = cursoOptional.get();
        return new Aluno(getRa(), nome, sobrenome, dataNascimento, curso);
    }
}
