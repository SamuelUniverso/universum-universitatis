package dev.asor.univitatis.database.dao;

import org.junit.Test;

import dev.asor.univitatis.model.Pessoa;

/**
 * @author dev.asor
 * @since 17.march.2022
 */
public class PessoaDaoTest 
{
	@Test
	public void fetchPessoaById()
	{
	    PessoaDao dao = new PessoaDao();

	    Pessoa pessoa = null;
		pessoa = dao.fetchById(1);
		if(pessoa != null)
		{
		    System.out.println(pessoa);
		}
	}
	
	@Test
	public void getNextId()
	{
	    PessoaDao dao = new PessoaDao();
	    Integer id = dao.getNextId();
	    
	    System.out.println("Next ID: " + id);
	}
	
   @Test
    public void getLastUsedId()
    {
        PessoaDao dao = new PessoaDao();
        Integer id = dao.getLastUsedId();
        
        System.out.println("Last ID: " + id);
    }
}
