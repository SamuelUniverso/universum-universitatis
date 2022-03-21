package dev.asor.univitatis.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            String sql = PessoaDaoHelper.createInsertPessoaPreparedStatement();
	        PreparedStatement stmtPessoa = getConector().getConexao()
						                       .prepareStatement(sql);

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
	    Pessoa pessoa = null;
	    
		try 
		{
			String sql = PessoaDaoHelper.createSelectPessoaByIdPreparedStatement();
			PreparedStatement statement = getConector().getConexao()
												       .prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
			    pessoa = new Pessoa(resultSet.getInt(1));
			    pessoa.setPrenome(resultSet.getString(2));
			    pessoa.setNome(resultSet.getString(3));
			    pessoa.setSobrenome(resultSet.getString(4));
			    pessoa.setTelefone(resultSet.getString(5));
			    pessoa.setCpf(resultSet.getString(6));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				getConector().getConexao().close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return pessoa;
	}
	
}
