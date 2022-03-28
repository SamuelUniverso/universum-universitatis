package dev.asor.univitatis.database.dao.helper;

import dev.asor.univitatis.database.dao.enums.EntityEnum;

/**
 * @class ProfessorDaoHelper
 * @author dev.asor
 * @since 16.march.2022
 */
public class ProfessorDaoHelper extends GenericHelper
{
    private final static EntityEnum entity = EntityEnum.PROFESSORES;
    
    public static String createPreparedStatementProfessor()
    {
        StringBuilder sql = new StringBuilder();
            
        sql.append("INSERT INTO " + getEntity().getEntityName());
        sql.append(" (fk_pessoa, codigo_matricula) ");
        sql.append(" VALUES (?1, ?2) ");
        
        return sql.toString();
    }
    
    private static EntityEnum getEntity()
    {
        return entity;
    }
}
