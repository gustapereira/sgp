drop table if exists sebrae_agro.tbl_indicador_usuario;
create table sebrae_agro.tbl_indicador_usuario(
    COD_INDICADOR bigint,
    COD_USUARIO bigint,
    foreign key (COD_INDICADOR) references sebrae_agro.tbl_indicador(COD_INDICADOR),
    foreign key (COD_USUARIO) references sebrae_agro.TB_USUARIO(COD_USUARIO)
);