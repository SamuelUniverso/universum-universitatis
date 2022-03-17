package dev.asor.univitatis.database.dao.helper;

public class PessoaDAOHelper
{
    public static String createPreparedStatementPessoa()
    {
        StringBuilder sqlPessoa = new StringBuilder();
        
        sqlPessoa.append("INSERT INTO pessoas ");
        sqlPessoa.append(" (prenome, nome, sobrenome, telefone, cpf)");
        sqlPessoa.append(" VALUES (?1, ?2, ?3, ?4, ?5) ");
        
        return sqlPessoa.toString();
    }

}
