package br.com.alura.literalura.literAlura.principal;

import br.com.alura.literalura.literAlura.model.Autor;
import br.com.alura.literalura.literAlura.model.Livro;
import br.com.alura.literalura.literAlura.model.DadosLivro;
import br.com.alura.literalura.literAlura.repository.LivroRepository;
import br.com.alura.literalura.literAlura.service.ConsumoAPI;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private final ConsumoAPI consumoAPI = new ConsumoAPI();
    private final Scanner leitura = new Scanner(System.in);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private LivroRepository repository;

    public Principal(LivroRepository repository) {
        this.repository = repository;
    }

    public void exibeMenu() throws IOException, InterruptedException, URISyntaxException {
        int entradaUsuario = 99;

        while (entradaUsuario != 0) {
            System.out.println("""
                
                ------ LiterAlura ------
                
            O que deseja fazer?
            1 - buscar livro pelo título
            2 - listar livros registrados
            3 - listar autores registrados
            4 - listar autores vivos em determinado ano
            5 - listar livros em determinado idioma
            
            0 - sair
                  --------------------
            """);
            entradaUsuario = leitura.nextInt();
            leitura.nextLine(); //Limpar o buffer do teclado
            switch (entradaUsuario) {
                case 1:
                    buscarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivosPorAno();
                    break;
                case 5:
                    listarLivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Saindo ...");
                    break;
                default:
                    System.out.println("Entrada inválida!");
                    break;
            }
        }
    }

    private void listarLivrosPorIdioma() {
        System.out.println("""
                
                Insira o idioma para realizar a busca:
                es - espanhol
                en - inglês
                fr - francês
                pt - espanhol
                """);
        var idioma = leitura.nextLine();

        List<Livro> livros = repository.findAll()
                .stream()
                .filter(l -> l.getIdiomas().contains(idioma))
                .toList();

        if (!livros.isEmpty()) {
            livros.forEach(System.out::println);
        } else {
            System.out.println("Não há registros de livros com o idioma selecionado -> " + idioma);
        }
    }

    private void listarAutoresVivosPorAno() {
        System.out.println("Insira o ano para realizar a busca: ");
        var ano = leitura.nextInt();
        leitura.nextLine(); // Limpar o buffer

        List<Autor> autores = repository.buscarAutoresVivosPorAno(ano);

        if (!autores.isEmpty()) {
            autores.forEach(System.out::println);
        } else {
            System.out.println("Não foi registrado nenhum autor vivo no ano de " + ano + ".");
        }
    }

    private void listarAutores() {
        List<Autor> autores = repository.buscarAutores();

        if (!autores.isEmpty()) {
            autores.forEach(System.out::println);
        } else {
            System.out.println("Não há autores registrados no momento.");
        }
    }

    private void listarLivros() {
        List<Livro> livros = repository.findAll();

        if (!livros.isEmpty()) {
            livros.forEach(System.out::println);
        } else {
            System.out.println("Não há livros registrados no momento.");
        }
    }

    private void buscarLivro() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Insira o nome do livro para a busca: ");
        String nomeLivro = leitura.nextLine();

        String url = "https://gutendex.com/books?search=" + nomeLivro.replace(" ", "+").trim();

        JSONObject json = new JSONObject(consumoAPI.obterDados(url));

        if (json.getInt("count") != 0) {
            String data = json.getJSONArray("results")
                    .getJSONObject(0)
                    .toString();
            DadosLivro dadosLivro = objectMapper.readValue(data, DadosLivro.class);
            Livro livro = new Livro(dadosLivro);
            verificaAutor(livro);
            System.out.println(livro);
            repository.save(livro);
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    private void verificaAutor(Livro livro) {
        List<Autor> autores = new ArrayList<>();
        livro.getAutores().forEach(a -> {
            Optional<Autor> autor = repository.obterAutorPorNome(a.getNome());
            if (autor.isPresent()) {
                autores.add(autor.get());
            } else {
                autores.add(new Autor(a.getNome(), a.getAnoNascimento(), a.getAnoFalecimento()));
            }
        });
        livro.setAutores(autores);
    }
}
