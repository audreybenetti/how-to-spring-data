package br.com.letscode.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="aluno")
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ra;
    private String nome;
    private String sobrenome;

    @Column(name="data_nascimento")
    private Date dataNascimento;

    @ManyToOne
    @JoinColumn(name="codigo_curso", referencedColumnName = "codigo_curso")
    private Curso codigoCurso;

}



