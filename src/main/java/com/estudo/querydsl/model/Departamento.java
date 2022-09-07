package com.estudo.querydsl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {

    @Column(name = "id_departamento")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartamento;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Override
    public String toString() {
        return "Departamento(id=" + idDepartamento + ", nome=" + nome + ")";
    }
}
