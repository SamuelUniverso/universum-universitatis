package dev.asor.univitatis.database.dao;

import org.junit.Test;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.model.Aluno;
import dev.asor.univitatis.model.Pessoa;

/**
 * @class PessoaDaoTest
 * @author dev.asor
 * @since 17.march.2022
 */
public class PessoaDaoTest 
{
	@Test
	public void insertPessoa()
	{
        PessoaDao dao = new PessoaDao(DatabaseConnector.getInstance());
        
        Pessoa pessoa = new Pessoa();
        pessoa.setPrenome("Prenome");
        pessoa.setNome("Nome");
        pessoa.setSobrenome("Sobrenome");
        pessoa.setCpf("00000000009");
        pessoa.setTelefone("5551987654321");
        
        dao.insert(pessoa);
        
        dao.getConnector().closeConnection();
	}
	
	@Test
	public void fetchPessoaById()
	{
	    PessoaDao dao = new PessoaDao(DatabaseConnector.getInstance());

	    Pessoa pessoa = null;
		pessoa = dao.fetchById(2);
		if(pessoa != null)
		{
		    System.out.println(pessoa);
		}
	}
	
	@Test
	public void getNextId()
	{
	    PessoaDao dao = new PessoaDao(DatabaseConnector.getInstance());
	    Integer id = dao.getNextId();
	    
	    System.out.println("Next ID: " + id);
	}
	
   @Test
    public void getLastUsedId()
    {
        PessoaDao dao = new PessoaDao(DatabaseConnector.getInstance());
        Integer id = dao.getLastUsedId();
        
        System.out.println("Last ID: " + id);
    }
}
