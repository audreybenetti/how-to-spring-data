package br.com.letscode.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="telefone_professor")
public class TelefoneProfessor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int numero;

    @ManyToOne
    @JoinColumn(name="codigo_professor", referencedColumnName = "codigo_professor")
    Professor codigoProfessor;
}
