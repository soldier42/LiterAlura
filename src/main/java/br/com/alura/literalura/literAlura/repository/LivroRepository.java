package br.com.alura.literalura.literAlura.repository;

import br.com.alura.literalura.literAlura.model.Autor;
import br.com.alura.literalura.literAlura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query("SELECT a FROM Autor a JOIN a.livros l WHERE a.nome ilike :nome")
    Optional<Autor> obterAutorPorNome(String nome);

    @Query("SELECT a FROM Autor a")
    List<Autor> buscarAutores();

    @Query("SELECT a FROM Autor a WHERE :ano BETWEEN a.anoNascimento AND a.anoFalecimento")
    List<Autor> buscarAutoresVivosPorAno(int ano);

}
