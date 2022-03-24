package dev.asor.univitatis.database.dao.helper;

import dev.asor.univitatis.database.dao.enums.EntityEnum;

/**
 * @author dev.asor
 * @since 16.march.2022
 */
public class AlunoDaoHelper
{
    private final static EntityEnum entity = EntityEnum.ALUNOS;
    
    public static String createPreparedStatementAluno()
    {
        StringBuilder sqlAluno = new StringBuilder();
            
        sqlAluno.append("INSERT INTO " + getEntity().getEntityName());
        sqlAluno.append(" (fk_pessoa, matricula_aluno) ");
        sqlAluno.append(" VALUES (?1, ?2) ");
        
        return sqlAluno.toString();
    }
    
    private static EntityEnum getEntity()
    {
        return entity;
    }
}
