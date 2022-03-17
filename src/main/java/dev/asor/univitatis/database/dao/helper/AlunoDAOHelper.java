package dev.asor.univitatis.database.dao.helper;

/**
 * @author dev.asor
 * @since 16.mar.2022
 */
public class AlunoDAOHelper
{
    public static String createPreparedStatementAluno()
    {
        StringBuilder sqlAluno = new StringBuilder();
            
        sqlAluno.append("INSERT INTO aluno ");
        sqlAluno.append(" (fk_pessoa, matricula_aluno) ");
        sqlAluno.append(" VALUES (?1, ?2) ");
        
        return sqlAluno.toString();
    }
}
