package br.com.alura.literalura.literAlura.model;

import br.com.alura.literalura.literAlura.repository.LivroRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Entity
@Table(name="livros")
public class Livro {
    // Atributos
    @Id
    private Long id;
    private String titulo;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "autor_livro",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<Autor> autores = new ArrayList<>();

    private List<String> idiomas = new ArrayList<>();
    private int downloads;

    // Construtores
    public Livro() {}
    public Livro(DadosLivro dadosLivro) {
        this.id = dadosLivro.id();
        this.titulo = dadosLivro.titulo();
        this.downloads = dadosLivro.downloads();
        dadosLivro.autores().forEach(a -> this.autores.add(new Autor(a)));
        idiomas.addAll(dadosLivro.idiomas());
    }

    // Métodos

    @Override
    public String toString() {
        StringBuilder autoresFormatted = new StringBuilder();
        this.autores.forEach(a -> autoresFormatted.append("[").append(a.getNome()).append("] "));
        return """
                ----- Livro -----
            Título: %s
            Autor(es): %s
            Idioma(s): %s
            Número de downloads: %d
                  -------------
            """.formatted(this.titulo, autoresFormatted, this.idiomas, this.downloads);
    }

    // G & S
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return this.autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }
}
