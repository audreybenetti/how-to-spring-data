package br.com.letscode.request;

import br.com.letscode.entity.Disciplina;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplinaRequestAtualizar {
    private String nomeDisciplina;
    private int cargaPratica;
    private int cargaTeorica;

    public DisciplinaRequestAtualizar (Disciplina disciplina) {
        this.nomeDisciplina = disciplina.getNomeDisciplina();
        this.cargaPratica = disciplina.getCargaPratica();
        this.cargaTeorica = disciplina.getCargaTeorica();

    }

    public Disciplina convert(int codigoDisciplina){
        return new Disciplina(codigoDisciplina, nomeDisciplina, cargaPratica, cargaTeorica);
    }
}
