package dev.asor.univitatis.database.dao.helper;

/**
 * @author dev.asor
 * @since 16.march.2022
 */
public class AlunoDaoHelper
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
