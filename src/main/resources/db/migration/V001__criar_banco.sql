
create table TBL_PERMISSOES_ACESSO(
    COD_PERMISSOES_ACESSO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_NOME varchar(500)
);


create table TBL_FERIAS(
    COD_FERIAS bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    DT_FERIAS timestamp
);

create table TBL_TELEFONE(
    COD_TELEFONE bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_NUMERO varchar(500),
    TYPE_PHONE varchar(50)
);


create table TBL_PONTO_FACULTATIVO(
    COD_PONTO_FACULTATIVO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_NOME varchar(500),
    TX_DESCRICAO varchar(500)
);

create table TBL_REGISTRO_ELETRONICO(
    COD_REGISTRO_ELETRONICO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_TIPO varchar(500),
    TX_NOME varchar(500)
);

create table TBL_AFASTAMENTO(
    COD_AFASTAMENTO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    DT_AFASTAMENTO timestamp,
    TYPE_AFASTAMENTO varchar(50)
);

create table TBL_CARGO(
    COD_CARGO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_NOME varchar(256),
    TX_DESCRICAO varchar(800)
);

create table TBL_UF(
    COD_UF bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_NOME varchar(500),
    TX_SIGLA varchar(2)
);


create table TBL_CBO(
    COD_CBO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_NOME varchar(256)
);

create table TBL_CENTRO_CUSTO(
    COD_CENTRO_CUSTO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_DESCRICAO varchar(256),
);



create table TBL_ENDERECO(
    COD_ENDERECO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_CEP varchar(500),
    TX_ENDERECO varchar(500),
    TX_BAIRRO varchar(500),
    TX_CIDADE varchar(500),
    TX_NUMERO varchar(500),
    TX_COMPLEMENTO varchar(500),
    TX_EMAIL varchar(500),
    TX_CODIGO_MUNICIPIO varchar(500),
    COD_UF bigint,
    foreign key (COD_UF) references TBL_UF (COD_UF)
);

create table TBL_USUARIO(
    COD_USUARIO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_NOME varchar(500),
    COD_PERMISSOES_ACESSO bigint,
    foreign key (COD_PERMISSOES_ACESSO) references TBL_PERMISSOES_ACESSO (COD_PERMISSOES_ACESSO)
);


create table TBL_EMPRESA(
    COD_EMPRESA bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    FT_LOGO_MARCA BYTEA,
    ds_tipo_imagem varchar(200),
    TX_CNPJ varchar(20),
    TX_RAZAO_SOCIAL varchar(500),
    TX_NOME_FANTASIA varchar(500),
    TX_CNAE varchar(50),
    TX_ATIVIDADE_PRINCIPAL varchar(500),
    TYPE_IRRF varchar(20),
    TYPE_VINCULO varchar(20),
    TYPE_DOCUMENTO varchar(20),
    TX_NUMERO_DOCUMENTO varchar(500),
    TYPE_EMPRESA varchar(20),
    TX_CODIGO_ENCERRAMENTO_EMPRESA varchar(50),
    DT_INICIO_ATIVIDADE timestamp,
    DT_FINAL_ATIVIDADE timestamp,
    TX_BR_PDH varchar(50),
    TX_DIRECAO_GERAL varchar(500),
    TX_CEO varchar(500),
    TYPE_STATUS varchar(20),
    COD_TELEFONE bigint,
    COD_ENDERECO bigint,
    COD_USUARIO bigint,
    foreign key (COD_ENDERECO) references TBL_ENDERECO (COD_ENDERECO),
    foreign key (COD_TELEFONE) references TBL_TELEFONE (COD_TELEFONE),
    foreign key (COD_USUARIO) references TBL_USUARIO (COD_USUARIO)
);

create table TBL_DIRETORIA(
    COD_DIRETORIA bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_DIRETORIA varchar(256),
    COD_EMPRESA bigint,
    foreign key (COD_EMPRESA) references TBL_EMPRESA (COD_EMPRESA)
);

create table TBL_HORARIO(
    COD_HORARIO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_DESCRICAO varchar(500),
    DT_BASE timestamp,
    TX_CICLO_REPETICAO varchar(500),
    TX_TIPO_TABELA varchar(500),
    BO_REVEZAMENTO boolean,
    TX_EXPEDIENTE_NORMAL varchar(500),
    TX_EXPEDIENTE_FOLGA varchar(500),
    TX_EXPEDIENTE_DSR varchar(500),
    TX_EXPEDIENTE_FERIADO varchar(500),
    TX_EXPEDIENTE_FERIAS varchar(500),
    TX_EXPEDIENTE_SUSPENSAO varchar(500),
    COD_PONTO_FACULTATIVO bigint,
    foreign key (COD_PONTO_FACULTATIVO) references TBL_PONTO_FACULTATIVO (COD_PONTO_FACULTATIVO)
);

create table TBL_DEPARTAMENTO(
    COD_DEPARTAMENTO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_DEPARTAMENTO varchar(256),
    COD_DIRETORIA bigint,
    foreign key (COD_DIRETORIA) references TBL_DIRETORIA (COD_DIRETORIA)
);


create table TBL_NACIONALIDADE(
    COD_NACIONALIDADE bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_PAIS varchar(500),
    TX_NACIONALIDADE varchar(500),
);

create table TBL_FOLHA_DE_PONTO(
    COD_FOLHA_DE_PONTO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    DT_ENTRADA timestamp,
    DT_ALMOCO timestamp,
    DT_RETORNO timestamp,
    DT_SAIDA timestamp,
    DT_INICIO_HORA_EXTRA timestamp,
    DT_FINAL_HORA_EXTRA timestamp,
    TX_JUSTIFICATIVA varchar(8000)
);

create table TBL_SETOR(
    COD_SETOR bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_SETOR varchar(500),
    COD_DEPARTAMENTO bigint,
    foreign key (COD_DEPARTAMENTO) references TBL_DEPARTAMENTO (COD_DEPARTAMENTO)
);


create table TBL_SECAO(
    COD_SECAO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_SECAO varchar(500),
    COD_SETOR bigint,
    foreign key (COD_SETOR) references TBL_SETOR (COD_SETOR)
);


create table TBL_FUNCIONARIOS(
    COD_FUNCIONARIO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    FT_AVATAR BYTEA,
    ds_tipo_imagem varchar(200),
    TX_CRACHA varchar(500),
    TX_NOME varchar(500),
    TX_NOME_COMPLETO varchar(500),
    TX_NATURALIDADE varchar(500),
    DT_NASCIMENTO timestamp,
    TX_NOME_MAE varchar(500),
    TX_NOME_PAI varchar(500),
    TYPE_SEXO varchar(50),
    DT_PROXIMO_EXAME timestamp,
    DT_ADMISSAO timestamp,
    TYPE_ESTADO_CIVIL varchar(50),
    TYPE_RACA varchar(50),
    BO_DEFICIENTE boolean,
    TYPE_DEFICIENCIA varchar(50),
    DB_SALARIO double precision,
    TYPE_SALARIO varchar(50),
    LG_HORAS_BASE long,
    DT_DATA timestamp,
    TX_GRUPO_AVAL_DESEMPENHO varchar(500),
    TX_GRUPO_PROFISSIOGRAFICO varchar(500),
    TX_GRUPO_AVAL_EXPERIENCIA varchar(500),
    TX_CPF varchar(500),
    TX_RG varchar(500),
    DT_RG_EXPEDICAO timestamp,
    TX_RG_ORGAO varchar(500),
    TX_NUM_INSS varchar(500),
    TX_CLASSE_INSS varchar(500),
    TX_NUM_PIS varchar(500),
    DT_EMISSAO_PIS timestamp,
    TX_CTPS varchar(500),
    TX_SERIE_CTPS varchar(500),
    DT_CTPS timestamp,
    TX_CNH varchar(500),
    TX_CATEGORIA varchar(500),
    DT_EMISSAO_CNH timestamp,
    DT_VALIDADE_CNH timestamp,
    TX_NUM_RIC varchar(500),
    DT_EMISSAO_RIC timestamp,
    DT_VALIDADE_RIC timestamp,
    TX_ORGAO_RIC varchar(500),
    TX_CIDADE_RIC varchar(500),
    TX_NUM_TITULO_ELEITOR varchar(500),
    TX_NUM_ZONA_TITULO_ELEITOR varchar(500),
    TX_NUM_SECAO_TITULO_ELEITOR varchar(500),
    DT_TITULO_ELEITOR timestamp,
    TX_NUM_RESERVISTA varchar(500),
    TX_SERIE_RESERVISTA varchar(500),
    DT_RESERVISTA timestamp,
    TX_RA_RESERVISTA varchar(500),
    TX_CSM_RESERVISTA varchar(500),
    TYPE_CAT_TRABALHADOR varchar(50),
    TX_APOSENTADO varchar(500),
    TX_AREA varchar(500),
    TX_ESCOLARIDADE varchar(500),
    TX_EMAIL varchar(500),
    LG_DIAS_EXPERIENCIA long,
    LG_DIAS_PORROGACAO long,
    TX_REVEZAMENTO varchar(500),
    TX_BENEFICIARIOS varchar(500),
    TX_APOS_ESPECIAL varchar(500),
    TX_OBSERVACOES_PPP varchar(8000),
    COD_EMPRESA bigint,
    COD_ENDERECO bigint,
    COD_TELEFONE bigint,
    COD_FERIAS bigint,
    COD_AFASTAMENTO bigint,
    COD_NACIONALIDADE bigint,
    COD_CARGO bigint,
    COD_CBO bigint,
    COD_HORARIO bigint,
    COD_UF_NASCIMENTO bigint,
    COD_UF_RG bigint,
    COD_UF_CTPS bigint,
    COD_UF_RIC bigint,
    COD_UF_TITULO_ELEITOR bigint,
    foreign key (COD_UF_NASCIMENTO) references TBL_UF (COD_UF),
    foreign key (COD_UF_RG) references TBL_UF (COD_UF),
    foreign key (COD_UF_CTPS) references TBL_UF (COD_UF),
    foreign key (COD_UF_RIC) references TBL_UF (COD_UF),
    foreign key (COD_UF_TITULO_ELEITOR) references TBL_UF (COD_UF),
    foreign key (COD_HORARIO) references TBL_HORARIO (COD_HORARIO),
    foreign key (COD_EMPRESA) references TBL_EMPRESA (COD_EMPRESA),
    foreign key (COD_ENDERECO) references TBL_ENDERECO (COD_ENDERECO),
    foreign key (COD_TELEFONE) references TBL_TELEFONE (COD_TELEFONE),
    foreign key (COD_FERIAS) references TBL_FERIAS (COD_FERIAS),
    foreign key (COD_AFASTAMENTO) references TBL_AFASTAMENTO (COD_AFASTAMENTO),
    foreign key (COD_NACIONALIDADE) references TBL_NACIONALIDADE (COD_NACIONALIDADE),
    foreign key (COD_CARGO) references TBL_CARGO (COD_CARGO),
    foreign key (COD_CBO) references TBL_CBO (COD_CBO),
);


create table TBL_HIERARQUIA_EXTERNA(
    COD_HIERARQUIA_EXTERNA bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    BO_PESSOA boolean,
    BO_EMPRESA boolean,
    TX_NOME varchar(500),
    TYPE_SUBORDINACAO varchar(50),
    COD_EMPRESA bigint,
    foreign key (COD_EMPRESA) references TBL_EMPRESA (COD_EMPRESA)
);


create table TBL_FUNCIONARIO_SECAO(
    COD_SECAO bigint,
    COD_FUNCIONARIO bigint,
    foreign key (COD_SECAO) references TBL_SECAO (COD_SECAO),
    foreign key (COD_FUNCIONARIO) references TBL_FUNCIONARIOS (COD_FUNCIONARIO)
);

create table TBL_FUNCIONARIO_SETOR(
    COD_SETOR bigint,
    COD_FUNCIONARIO bigint,
    foreign key (COD_SETOR) references TBL_SETOR (COD_SETOR),
    foreign key (COD_FUNCIONARIO) references TBL_FUNCIONARIOS (COD_FUNCIONARIO)
);

create table TBL_FUNCIONARIO_DEPARTAMENTO(
    COD_DEPARTAMENTO bigint,
    COD_FUNCIONARIO bigint,
    foreign key (COD_FUNCIONARIO) references TBL_FUNCIONARIOS (COD_FUNCIONARIO),
    foreign key (COD_DEPARTAMENTO) references TBL_DEPARTAMENTO (COD_DEPARTAMENTO)
);

create table TBL_FUNCIONARIO_DIRETORIA(
    COD_DIRETORIA bigint,
    COD_FUNCIONARIO bigint,
    foreign key (COD_FUNCIONARIO) references TBL_FUNCIONARIOS (COD_FUNCIONARIO),
    foreign key (COD_DIRETORIA) references TBL_DIRETORIA (COD_DIRETORIA)
);

create table TBL_FUNCIONARIO_FOLHA_PONTO(
    COD_FOLHA_DE_PONTO bigint,
    COD_FUNCIONARIO bigint,
    foreign key (COD_FUNCIONARIO) references TBL_FUNCIONARIOS (COD_FUNCIONARIO),
    foreign key (COD_FOLHA_DE_PONTO) references TBL_FOLHA_DE_PONTO (COD_FOLHA_DE_PONTO)
);

create table TBL_FUNCIONARIO_CENTRO_CUSTO(
    COD_CENTRO_CUSTO bigint,
    COD_FUNCIONARIO bigint,
    foreign key (COD_CENTRO_CUSTO) references TBL_CENTRO_CUSTO (COD_CENTRO_CUSTO),
    foreign key (COD_FUNCIONARIO) references TBL_FUNCIONARIOS (COD_FUNCIONARIO)
);

create table TBL_FUNCIONARIO_HIERARQUIA_EXTERNA(
    COD_HIERARQUIA_EXTERNA bigint,
    COD_FUNCIONARIO bigint,
    foreign key (COD_HIERARQUIA_EXTERNA) references TBL_HIERARQUIA_EXTERNA (COD_HIERARQUIA_EXTERNA),
    foreign key (COD_FUNCIONARIO) references TBL_FUNCIONARIOS (COD_FUNCIONARIO)
);

create table TBL_FUNCIONARIO_USUARIO(
    COD_USUARIO bigint,
    COD_FUNCIONARIO bigint,
    foreign key (COD_USUARIO) references TBL_USUARIO (COD_USUARIO),
    foreign key (COD_FUNCIONARIO) references TBL_FUNCIONARIOS (COD_FUNCIONARIO)
);

create table TBL_FAIXA_FATOR(
    COD_FAIXA_FATOR bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_NOME varchar(255),
    TX_PONTOS varchar(255)
);

create table TBL_FATOR(
    COD_FATOR bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_NOME varchar(255),
    TX_DESCRICAO text
);

create table TBL_FATOR_FAIXA_FATORES(
    COD_FATOR bigint,
    COD_FAIXA_FATOR bigint,
    foreign key (COD_FATOR) references TBL_FATOR (COD_FATOR),
    foreign key (COD_FAIXA_FATOR) references TBL_FAIXA_FATOR (COD_FAIXA_FATOR)
);

create table TBL_CARGO_X_FATOR(
    COD_CARGO_X_FATOR bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_DESCRICAO text,
    COD_CARGO bigint,
    COD_FATOR bigint,
    COD_FAIXA_FATOR bigint,
    foreign key (COD_FATOR) references TBL_FATOR (COD_FATOR),
    foreign key (COD_CARGO) references TBL_CARGO (COD_CARGO),
    foreign key (COD_FAIXA_FATOR) references TBL_FAIXA_FATOR (COD_FAIXA_FATOR)
);

create table TBL_SALARIO(
    COD_SALARIO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    VALOR DOUBLE PRECISION,
    TX_DESCRICAO text,
    COD_USUARIO bigint,
    foreign key (COD_USUARIO) references TBL_USUARIO (COD_USUARIO)
);

create table TBL_GRUPO_SALARIAL(
    COD_GRUPO_SALARIAL bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_DESCRICAO text,
    TX_PONTO_INICIAL varchar(255),
    TX_PONTO_FINAL varchar(255),
    TX_OBSERVACAO varchar(255)
);

create table TBL_GRUPO_SALARIAL_SALARIO(
    COD_GRUPO_SALARIAL bigint,
    COD_SALARIO bigint,
    foreign key (COD_GRUPO_SALARIAL) references TBL_GRUPO_SALARIAL (COD_GRUPO_SALARIAL),
    foreign key (COD_SALARIO) references TBL_SALARIO (COD_SALARIO)
);

create table TBL_QUADRO_FUNCIONARIO(
    COD_QUADRO_FUNCIONARIO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TX_PREVISTO VARCHAR(255),
    TX_REAL VARCHAR(255),
    TX_RESERVADO VARCHAR(255),
    TX_VAGO VARCHAR(255),
    TX_DESCRICAO text,
    COD_EMPRESA bigint,
    COD_DIRETORIA bigint,
    COD_DEPARTAMENTO bigint,
    COD_SETOR bigint,
    COD_SECAO bigint,
    COD_CENTRO_CUSTO bigint,
    COD_CARGO bigint,
    foreign key (COD_EMPRESA) references TBL_EMPRESA (COD_EMPRESA),
    foreign key (COD_DIRETORIA) references TBL_DIRETORIA (COD_DIRETORIA),
    foreign key (COD_DEPARTAMENTO) references TBL_DEPARTAMENTO (COD_DEPARTAMENTO),
    foreign key (COD_SETOR) references TBL_SETOR (COD_SETOR),
    foreign key (COD_SECAO) references TBL_SECAO (COD_SECAO),
    foreign key (COD_CENTRO_CUSTO) references TBL_CENTRO_CUSTO (COD_CENTRO_CUSTO),
    foreign key (COD_CARGO) references TBL_CARGO (COD_CARGO),


);