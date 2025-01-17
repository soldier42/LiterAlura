package br.com.alura.literalura.literAlura.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name="autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;
    private int anoNascimento;
    private int anoFalecimento;

    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros = new ArrayList<>();

    // Construtores
    public Autor() {}
    public Autor(String nome, int anoNascimento, int anoFalecimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.anoFalecimento = anoFalecimento;
    }
    public Autor(DadosAutor dadosAutor) {
        this.nome = dadosAutor.nome();
        this.anoNascimento = dadosAutor.anoNascimento();
        this.anoFalecimento = dadosAutor.anoFalecimento();
    }

    // Métodos


    @Override
    public String toString() {
        StringBuilder livrosFormatted = new StringBuilder();
        livros.forEach(l -> livrosFormatted.append("[").append(l.getTitulo()).append("] "));
        return """
                ----- Autor -----
            Nome: %s
            Ano de nascimento: %d
            Ano de falecimento: %d
            Livros: %s
                  -------------
            """.formatted(this.nome, this.anoNascimento, this.anoFalecimento, livrosFormatted);
    }

    // G & S
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(int anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
