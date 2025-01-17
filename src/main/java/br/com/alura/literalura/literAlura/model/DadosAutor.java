package br.com.alura.literalura.literAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor(@JsonAlias("name") String nome,
                         @JsonAlias("birth_year") Integer anoNascimento,
                         @JsonAlias("death_year") Integer anoFalecimento) {
}
