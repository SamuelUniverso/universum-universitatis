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
}