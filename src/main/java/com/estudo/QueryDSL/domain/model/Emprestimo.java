package com.estudo.QueryDSL.domain.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Emprestimo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmprestimo;

    @ManyToOne
    @JoinColumn(name = "fk_livro")
    private Livro livro;
    
    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @NotNull
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    @Override
    public String toString() {
        return "Emprestimo [id=" + idEmprestimo + ", livro=" + livro.getTitulo() + ", cliente=" + cliente.getNome()
                + ", dataEmp=" + dataEmprestimo + ", dataDev=" + dataDevolucao + "]";
    }

    
}
