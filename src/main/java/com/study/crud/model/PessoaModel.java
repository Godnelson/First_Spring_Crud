package com.study.crud.model;

import lombok.Data;
import javax.persistence.Id;


import javax.persistence.*;

@Entity
@Data
@Table(name = "Pessoa")
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String nome;
    private String nacionalidade;
}
