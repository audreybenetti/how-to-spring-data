package br.com.letscode.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name="professor")
public class Professor {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="codigo_professor")
    private int codigoProfessor;
    private String nome;

    @ManyToOne
    @JoinColumn(name="codigo_curso", referencedColumnName = "codigo_curso")
    private Curso codigoCurso;

}
