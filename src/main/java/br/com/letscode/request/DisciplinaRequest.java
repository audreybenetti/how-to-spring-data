package br.com.letscode.request;

import br.com.letscode.entity.Disciplina;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DisciplinaRequest {
    private int codigoDisciplina;
    private String nomeDisciplina;
    private int cargaPratica;
    private int cargaTeorica;

    public Disciplina convert(){
        return new Disciplina(getCodigoDisciplina(), nomeDisciplina, cargaPratica, cargaTeorica);
    }

}
