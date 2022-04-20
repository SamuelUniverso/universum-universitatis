package dev.asor.univitatis.database.dao.helper;

import dev.asor.univitatis.database.dao.enums.EntityEnum;

/**
 * @class AlunoDaoHelper
 * @author dev.asor
 * @since march.2022
 */
public class AlunoDaoHelper extends GenericHelper
{
    private final static EntityEnum entity = EntityEnum.ALUNOS;
    
    public static String createPreparedStatementInsertAluno()
    {
        StringBuilder sql = new StringBuilder();
            
        sql.append("INSERT INTO " + getEntity().getEntityName());
        sql.append("   (fk_pessoa, codigo_matricula)          ");
        sql.append(" VALUES (?1, ?2)                          ");
        
        return sql.toString();
    }
    
    public static String createPreparedStatementSelectAluno(Boolean all)
    {
        StringBuilder sql = new StringBuilder();
            
        sql.append(" SELECT pessoa.id              as id1                      ");
        sql.append("      , pessoa.prenome         as prenome2                 ");
        sql.append("      , pessoa.nome            as nome3                    ");
        sql.append("      , pessoa.sobrenome       as sobrenome4               ");
        sql.append("      , pessoa.cpf             as cpf5                     ");
        sql.append("      , pessoa.telefone        as telefone6                ");
        sql.append("      , aluno.fk_pessoa        as fk_pessoa7               ");
        sql.append("      , aluno.codigo_matricula as cd_matricula8            ");
        sql.append("   FROM pessoas pessoa                                     ");
        sql.append("  INNER JOIN alunos aluno ON (aluno.fk_pessoa = pessoa.id) ");
        if(!all)
        {
            sql.append("  WHERE pessoa.id = ?1                                  ");
        }
        
        return sql.toString();  
    }
    
    private static EntityEnum getEntity()
    {
        return entity;
    }
}
