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
    
    /**
     * Cria PreparedStatement para buscar Professor no Banco de Dados
     * @method createPreparedStatementSelectProfessor
     * @param Boolean all : determina se devera selecionar tudos os elementos da entidade
     * @return String
     */
    public static String createPreparedStatementSelectProfessor(Boolean all)
    {
        StringBuilder sql = new StringBuilder();
            
        sql.append(" SELECT pessoa.id                  as id1                               ");
        sql.append("      , pessoa.prenome             as prenome2                          ");
        sql.append("      , pessoa.nome                as nome3                             ");
        sql.append("      , pessoa.sobrenome           as sobrenome4                        ");
        sql.append("      , pessoa.cpf                 as cpf5                              ");
        sql.append("      , pessoa.telefone            as telefone6                         ");
        sql.append("      , professor.fk_pessoa        as fk_pessoa7                        ");
        sql.append("      , professor.codigo_matricula as cd_matricula8                     ");
        sql.append("   FROM pessoas pessoa                                                  ");
        sql.append("  INNER JOIN professores professor ON (professor.fk_pessoa = pessoa.id) ");
        if(!all)
        {
            sql.append("  WHERE pessoa.id = ?1                                              ");
        }
        
        return sql.toString();  
    }    
    
    private static EntityEnum getEntity()
    {
        return entity;
    }
}
