package dev.asor.univitatis.database.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dev.asor.univitatis.database.dao.helper.PessoaDaoHelper;
import dev.asor.univitatis.database.dao.interfaces.DaoObjectInterface;
import dev.asor.univitatis.database.dao.util.GenericConnector;
import dev.asor.univitatis.model.Pessoa;

/**
 * @author dev.asor
 * @since 17.march.2022
 */
public class PessoaDao extends GenericConnector implements DaoObjectInterface<Pessoa>
{
	
	public PessoaDao()
	{
	}
	
	@Override
	public void insert(Pessoa pessoa) 
	{
        try
        {
	        PreparedStatement stmtPessoa 
						        = getConector().getConexao()
						                       .prepareStatement(PessoaDaoHelper.createInsertPessoaPreparedStatement());

			stmtPessoa.setString(1, pessoa.getPrenome());
			stmtPessoa.setString(2, pessoa.getNome());
			stmtPessoa.setString(3, pessoa.getSobrenome());
			stmtPessoa.setString(4, pessoa.getTelefone());
			stmtPessoa.setString(5, pessoa.getCpf());
			
			stmtPessoa.executeQuery();
        }
        catch(SQLException e)
        {
        	e.printStackTrace();
        }
	}

	@Override
	public Pessoa fetchById(Integer id) 
	{
		
		try 
		{
			PreparedStatement stmt = getConector().getConexao()
												  .prepareStatement(PessoaDaoHelper.createSelectPessoaByIdPreparedStatement());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
