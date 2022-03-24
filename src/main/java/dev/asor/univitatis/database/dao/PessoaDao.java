package dev.asor.univitatis.database.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.enums.EntityEnum;
import dev.asor.univitatis.database.dao.helper.GenericDao;
import dev.asor.univitatis.database.dao.helper.PessoaDaoHelper;
import dev.asor.univitatis.database.dao.interfaces.CrudObjectInterface;
import dev.asor.univitatis.database.dao.interfaces.GenericConnectorInterface;
import dev.asor.univitatis.database.exceptions.PessoaException;
import dev.asor.univitatis.database.exceptions.errors.GenericErrors;
import dev.asor.univitatis.database.exceptions.errors.PessoaExceptionMessages;
import dev.asor.univitatis.model.Pessoa;

/**
 * @author dev.asor
 * @since 17.march.2022
 */
public class PessoaDao extends GenericDao implements CrudObjectInterface<Pessoa>
{
    
	public PessoaDao(DatabaseConnector connector)
    {
        setConnector(connector);
    }
	
	@Override
	public Integer insert(Pessoa pessoa, Boolean debug) 
	{
        try
        {
            String sql = PessoaDaoHelper.createInsertPessoaPreparedStatement();
	        PreparedStatement stmtPessoa = getConnector().getConnection()
						                                 .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmtPessoa.setString(1, pessoa.getPrenome());
			stmtPessoa.setString(2, pessoa.getNome());
			stmtPessoa.setString(3, pessoa.getSobrenome());
			stmtPessoa.setString(4, pessoa.getTelefone());
			stmtPessoa.setString(5, pessoa.getCpf());
			
			super.setGeneratedId(stmtPessoa.executeUpdate());
        }
        catch(SQLException e)
        {
        	throw new PessoaException(PessoaExceptionMessages.ERROR_INSERT_PESSOA.getMessage());
        }
        finally
        {
        	try
        	{
        		if(debug)
            	{
        			getConnector().getConnection().rollback();
            	}
        		else
        		{
        			getConnector().getConnection().close();
        		}
        	}
        	catch(SQLException e)
        	{
        		e.printStackTrace();
//        		throw new PessoaException(PessoaExceptionMessages.ERROR_ROLLBACK.getMessage());
        	}
        }
        
        return getGeneratedId();
	}

	@Override
	public Pessoa fetchById(Integer id) 
	{
	    Pessoa pessoa = null;
	    
		try 
		{
			String sql = PessoaDaoHelper.createSelectPessoaByIdPreparedStatement();
			PreparedStatement statement = getConnector().getConnection()
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
			throw new PessoaException(PessoaExceptionMessages.ERRRO_FETCH_BY_ID.getMessage());
		}
		finally
		{
			try 
			{
				getConnector().getConnection().close();
			} 
			catch (SQLException e) 
			{
			    throw new PessoaException(GenericErrors.ERROR_CLOSE_CONNECTION.getMessage());
			}
		}
		
		return pessoa;
	}
	
   @Override
    public Integer getLastUsedId()
    {
       Integer id = null;
       String sql = PessoaDaoHelper.getLastUsedIdStatement(EntityEnum.PESSOAS);
       try
       {
           PreparedStatement statement = getConnector().getConnection()
                                                       .prepareStatement(sql);
           
           ResultSet result = statement.executeQuery();
           while(result.next())
           {
               id = result.getInt(1);
           }
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
       
       return id;
    }

    @Override
    public Integer getNextId()
    {
        Integer id = null;
        String sql = PessoaDaoHelper.getNextIdStatement(EntityEnum.PESSOAS);
        try
        {
            PreparedStatement statement = getConnector().getConnection()
                                                        .prepareStatement(sql);
            
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
                id = result.getInt(1);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return id;
    }
}
