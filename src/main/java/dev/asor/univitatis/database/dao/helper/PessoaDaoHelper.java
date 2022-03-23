package dev.asor.univitatis.database.dao.helper;

/**
 * Metodos auxiliares para a classe PessoaDao
 * 
 * @author dev.asor
 * @since 17.march.2022
 */
public class PessoaDaoHelper extends GenericDao
{
    public static String createInsertPessoaPreparedStatement()
    {
        StringBuilder sql = new StringBuilder();
        
        sql.append("INSERT INTO pessoas ");
        sql.append("       (prenome, nome, sobrenome, telefone, cpf)");
        sql.append("VALUES (?1, ?2, ?3, ?4, ?5) ");
        
        return sql.toString();
    }
    
    public static String createSelectPessoaByIdPreparedStatement()
    {
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT pessoa.*");
    	sql.append("  FROM pessoas pessoa");
    	sql.append(" WHERE pessoa.id = ?1 ");
    	
    	 return sql.toString();
    }
}
