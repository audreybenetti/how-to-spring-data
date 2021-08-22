package br.com.letscode.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="disciplina")
public class Disciplina {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="codigo_disciplina")
    private int codigoDisciplina;

    @Column(name="nome_disciplina")
    private String nomeDisciplina;

    @Column(name="carga_horaria_pratica")
    private int cargaPratica;

    @Column(name="carga_horaria_teorica")
    private int cargaTeorica;
 }


