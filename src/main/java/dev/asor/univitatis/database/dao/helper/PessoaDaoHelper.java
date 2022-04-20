package dev.asor.univitatis.database.dao.helper;

/**
 * Metodos auxiliares para a classe PessoaDao
 * 
 * @class PessoaDaoHelper
 * @author dev.asor
 * @since march.2022
 */
public class PessoaDaoHelper extends GenericHelper
{
	/**
	 * Gera o Statement para inserir uma nova Pessoa
	 * @method createInsertPessoaPreparedStatement
	 * @return String
	 */
    public static String createInsertPessoaPreparedStatement()
    {
        StringBuilder sql = new StringBuilder();
        
        sql.append("INSERT INTO pessoas ");
        sql.append("       (id, prenome, nome, sobrenome, telefone, cpf)");
        sql.append("VALUES (?1, ?2, ?3, ?4, ?5, ?6) ");
        
        return sql.toString();
    }
    
    /**
     * Gera o Statement para selecionar uma Pessoa por Id
     * @method createSelectPessoaByIdPreparedStatement
     * @return String
     */
    public static String createSelectPessoaByIdPreparedStatement()
    {
    	StringBuilder sql = new StringBuilder();
    	
    	sql.append("SELECT pessoa.*");
    	sql.append("  FROM pessoas pessoa");
    	sql.append(" WHERE pessoa.id = ?1 ");
    	
    	 return sql.toString();
    }
}
