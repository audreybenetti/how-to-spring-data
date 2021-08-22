package br.com.letscode.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Curso {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_curso")
    private int codigoCurso;

    @Column(name = "nome_curso")
    private String nomeCurso;
    private int duracao;

    @Column(name = "numero_alunos")
    private int numeroAlunos;

    @Enumerated(EnumType.STRING)
    private Modalidade modalidade;
}