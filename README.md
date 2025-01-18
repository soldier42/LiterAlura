<h1 align="center">Challenge Conversor de Moedas</h1>

<p align="center">
<img loading="lazy" src="http://img.shields.io/static/v1?label=STATUS&message=FINALIZADO&color=00FF00&style=for-the-badge"/>
</p>

# Índice

* [Descrição do Projeto](#descrição-do-projeto)
* [Requisitos](#requisitos)
* [Funcionalidade](#funcionalidade)
* [Demonstração da Aplicação](#demonstração-da-aplicação)
* [Tecnologias utilizadas](#tecnologias-utilizadas)
* [Acesso ao Projeto](#acesso-ao-projeto)

# Descrição do Projeto
Este projeto é um desafio proposto pela equipe da Alura em parceria com a Oracle One. O objetivo é desenvolver um **conversor de moedas dinâmico**, que possibilita a conversão entre diferentes moedas utilizando dados atualizados de uma API externa.

O projeto também tem em vista colocar em prática parte do conteúdo aprendido durante a formação de **Java e Orientação a Objetos**.

# Requisitos
## Gson v2.11.0
Gson é uma biblioteca do Java que pode ser usava para converter Objetos Java em formatos JSON e vice-versa.
- A versão utilizada neste projeto foi a **gson-2.11.0** e pode ser encontrado no site da [**MVN Repository**](https://mvnrepository.com/artifact/com.google.code.gson/gson) ou no [**repositório**](https://github.com/google/gson?tab=readme-ov-file) Github.

## JDK v17.0.12
O JDK é um ambiente de desenvolvimento para construção de aplicações que usa a linguagem Java.
- A versão que foi utilizada neste projeto foi a **jdk-17.0.12** e pode ser encontrado no site da [**Oracle**](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).

## ExchangeRate API-KEY
ExchangeRate é uma API que fornece informações atualizadas sobre cotações em formato JSON através de requisições.
- Para conseguir uma chave de forma gratuita, basta criar sua conta no [**ExchangeRate-API**](https://www.exchangerate-api.com/) e seguir o passo a passo.
- Após conseguir a chave, mude o valor do atributo da classe *Cotacao("/src/Cotacao.java")* e coloque sua chave da API.
## Intellij Community Edition (Opcional)
O projeto foi feito inteiramente no [**Intellij Community Edition IDE**](https://www.jetbrains.com/pt-br/idea/download/?section=windows), mas seu é totalmente opcional.

# Funcionalidades
- **Conversão dinâmica de moedas**: Com o
  uso da [**Exchange Rate - API**](https://www.exchangerate-api.com/) para base de dados, as informações sobre as cotações são frequentemente atualizadas;
- **Log que armazena histórico de conversões**: Todas as conversões são armazenada em um arquivo *txt* que pode ser lido e consultado dentro do próprio programa.

- **Moedas Suportadas**: Por padrão, há oito moedas disponíveis para conversão, mas o usuário pode extender leque de opções, trazendo todas as moedas que possuem o suporte da API.

  É possível conferir as moedas que tem suporte através da [**documentação**](https://www.exchangerate-api.com/docs/supported-currencies) da API.

# Demonstração da Aplicação
A aplicação é intuitiva, portanto basta que o usuário siga as instruções do terminal. Eis um exemplo abaixo:
```
Digite o índice da ação que deseja fazer:

1) Converter moeda
2) Histórico de conversões
0) Sair
------------------------------------------------------

>>> 1
```
```
Digite o índice da moeda que deverá ser convertida:

1) [BRL, Brazilian Real]
2) [USD, United States Dollar]
3) [EUR, Euro]
4) [UYU, Uruguayan Peso]
5) [AUD, Australian Dollar]
6) [CNY, Chinese Renminbi]
7) [CAD, Canadian Dollar]
8) [JPY, Japanese Yen]

0) Listar todas as moedas que possuem suporte da API
------------------------------------------------------

>>> 1
Brazilian Real selecionado!
```

```
Agora digite para qual moeda o valor deverá convertido: 

1) [BRL, Brazilian Real]
2) [USD, United States Dollar]
3) [EUR, Euro]
4) [UYU, Uruguayan Peso]
5) [AUD, Australian Dollar]
6) [CNY, Chinese Renminbi]
7) [CAD, Canadian Dollar]
8) [JPY, Japanese Yen]

0) Mostrar todas as moedas que possui suporte da API
------------------------------------------------------

>>> 2
United States Dollar selecionado!
```

```
Digite a quantia que você deseja converter:
------------------------------------------------------

>>> 10000
```

```
Conversão de Brazilian Real para United States Dollar
10000,00 BRL ===============> 1732,00 USD

Última atualização da cotação: Wed, 20 Nov 2024 00:00:01 +0000
Consulta feita em: Wed Nov 20 16:34:19 BRT 2024
```


O [**vídeo completo**](https://youtu.be/iNFagFbpA-I) mostrando o uso da aplicação está disponível no YouTube.

## Observações
Para bom funcionamento do código, é recomendado que:
- Utilize-se apenas valores **reais** nas **conversões** entres moedas;
- Utilize-se apenas valores **inteiros** nas **seleções de ações**;

O código possui alguns tratamentos de erros, mas não é garantido que ele funcione como deva em qualquer situação.

# Tecnologias Utilizadas
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)

# Acesso ao Projeto
1. Clone este repositório:
```
git clone https://github.com/soldier42/conversor-de-moedas
```
2. Certifique de que todas os [requisitos](#requisitos) estejam certos e instalados.
3. Execute e compile o código.
