## Índice

**Projeto Agro - Backend - Spring Boot**  
**Versão 1.0.0**  
# Agro Backend - Spring Boot

**Sumário**

- [1. Sobre o projeto](#1-sobre-o-projeto)
- [2. Configuração do Maven](#2-configuração-do-maven)
- [3. Build e execução local](#3-build-e-execução-local)
    - [3.1. Com arquivo jar](#31-com-arquivo-jar)
    - [3.2. Com Docker](#32-com-docker)
- [4. Acessar o projeto](#4-acessar-o-projeto)
- [5. Upload de archetype no nexus](#5-upload-de-archetype-no-nexus)

## Sobre o projeto

Trata-se de um projeto desenvolvido para assumir a função de backend do projeto Sebrae Agro. 
Ele é baseado no documento de arquitetura corporativa backend que utiliza Spring Boot e integração com Amei.

O projeto utiliza a versão 2 do [archetype](https://gitlab.sebrae.com.br/interno/java/backend-spring-boot).

## Configuração do Maven

Para usar o projeto é necessário ajustar as configurações do Maven. Para isso, siga os passos abaixo:

* Crie o arquivo settins.xml na pasta .m2 do usuário logado com a seguinte configuração:

Obs.: Para o usuário usuario.logado utilizando os sistemas operacionais abaixo:

- Windows:
```
C:\Users\usuario.logado\.m2\settings.xml
```
- Linux ou macOS:
```
~/.m2/settings.xml
```

settins.xml:

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
 <servers>
    <server>
      <id>nexus</id>
      <username>******</username> <!-- usuario da rede do sebrae -->
      <password>******</password>
    </server>
  </servers>
  <mirrors>
    <mirror>
      <id>nexus</id>
      <name>central</name>
      <url>https://nexus.sebrae.com.br/repository/maven-public/</url>
      <mirrorOf>*</mirrorOf>
    </mirror>
  </mirrors>
</settings>
```

## Build e execução local

### Via Maven
Para executar o projeto diretamente via Maven, executar o comando:
```bash
mvn clean compile spring-boot:run -Pdev -Drun.jvmArguments="-Dspring.profiles.active=h2"
```
O profile do Spring-Boot **h2**, indica que a execução será por meio do banco de dados local H2.
Em decorrência da natureza do projeto, _optou-se por executar o H2 em disco_ em vez de em memória.
A configuração de apontamento de arquivo do H2 encontra-se no arquivo **application-h2.yml**.

### Com arquivo .jar
Para gerar a versão executável do projeto com a extensão .jar é necessário executar o comando abaixo no diretório raiz:

```bash
mvn clean package
```

Execute o comando abaixo para iniciar o projeto

```bash
java -jar ~\target\app.jar
```

### Com Docker
Para gerar a versão executável do projeto com Docker é necessário executar o comando abaixo no diretório raiz:
```bash
mvn clean package docker:build
```


## Acessar o projeto

Para acessar o projeto digite no navegador o endereço: [http://localhost:8080/napalmadamao/swagger-ui.html](http://localhost:8080/swagger-ui.html)
