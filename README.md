![GitHub License](https://img.shields.io/github/license/rrbotlab/desafio-fipe-web)
![GitHub commit activity](https://img.shields.io/github/commit-activity/t/rrbotlab/desafio-fipe-web)
![GitHub last commit](https://img.shields.io/github/last-commit/rrbotlab/desafio-fipe-web)


# Desafio Fipe Web

![capa](/assets/images/capa.png)

## Alura Latam & Oracle Next Education - ONE - G8

Desafio proposto no programa ONE (Oracle Next Education). Uma parceria entre Alura Latam e Oracle. 
Grupo G8 (2025).

## Objetivo

Aplicativo backend em Java com Spring Boot para consulta da tabela Fipe via API [fipe.online](https://fipe.online/). O frontend
não é foco do exercício, portanto é bem minimalista baseado apenas no framework [Simple.css](https://simplecss.org/).

## Diferencial

A diferença entre essa aplicação e a tabela Fipe no site oficial, é que esta exibe todos os anos e preços 
para um determinado modelo de veículo, em uma única consulta.


## Demontração

Uma instância de demonstração está online em [Desafio Fipe](https://spring.vm3.arbly.com/web/v1/cars)

## Tecnologias utilizadas

* Java SDK 21
* SpringBoot 3.5.0
* Maven

## Dependências

Todas as dependencias são gerenciadas pelo Maven.

## Variáveis de ambiente

A aplicação procura pela variável de ambiente **FIPE_KEY** com o token de acesso que pode ser obtido 
gratuitamente em [fipe.online](https://fipe.online/)

Windows PowerShell:
```
$env:FIPE_KEY="sua-key-aqui"
```

Linux:
```
export FIPE_KEY="sua-key-aqui"
```


