package com.estudo.QueryDSL.domain.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLivro;

    @NotBlank
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "fk_categoria")
    private Categoria categoria;

    @NotNull
    @Min(value = 0)
    private Double valor;

    @NotNull
    private Boolean disponivel = true;

    @OneToMany(mappedBy = "livro", fetch = FetchType.EAGER)
    private Set<Emprestimo> emprestimos;

    @Override
    public String toString() {
        return "Livro [idLivro=" + idLivro + ", titulo=" + titulo + ", categoria=" + categoria.getNome() + ", valor=" + valor
                + ", disponivel=" + disponivel + ", emprestimos=" + emprestimos.size() + "]";
    }

    
}
