package dev.asor.univitatis.database.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.enums.EntityEnum;
import dev.asor.univitatis.database.dao.helper.PessoaDaoHelper;
import dev.asor.univitatis.database.dao.interfaces.CrudObjectInterface;
import dev.asor.univitatis.database.dao.interfaces.GenericConnectorInterface;
import dev.asor.univitatis.database.exceptions.AlunoException;
import dev.asor.univitatis.database.exceptions.GenericDaoException;
import dev.asor.univitatis.database.exceptions.PessoaException;
import dev.asor.univitatis.database.exceptions.errors.GenericErrors;
import dev.asor.univitatis.database.exceptions.errors.PessoaExceptionMessages;
import dev.asor.univitatis.model.Pessoa;

/**
 * @class PessoaDao
 * @author dev.asor
 * @since 17.march.2022
 */
public class PessoaDao extends GenericDao implements CrudObjectInterface<Pessoa>
{
    private final EntityEnum entity = EntityEnum.PESSOAS;
    
	public PessoaDao(DatabaseConnector connector)
    {
        setConnector(connector);
    }
	
    /**
     * Insere uma nova Pessoa na base
     * @method insert
     * @param Pessoa pessoa
     * @param Boolean rollback : nao grava alteracoes
     * @return void
     */
	@Override
	public void insert(Pessoa pessoa, Boolean rollback) 
	{
        try
        {
            String sql = PessoaDaoHelper.createInsertPessoaPreparedStatement();
	        PreparedStatement statement = getConnector().getConnection()
						                                .prepareStatement(sql);
	        
	        statement.setInt   (1, getNextId(pessoa.getEntity()));
			statement.setString(2, pessoa.getPrenome());
			statement.setString(3, pessoa.getNome());
			statement.setString(4, pessoa.getSobrenome());
			statement.setString(5, pessoa.getTelefone());
			statement.setString(6, pessoa.getCpf());
			
			statement.executeUpdate();
        }
        catch(SQLException e)
        {
        	e.printStackTrace();
        	throw new PessoaException(PessoaExceptionMessages.ERROR_INSERT_PESSOA.getMessage());
        }
        finally
        {
            try
            {
                if(!rollback)
                {
                    getConnector().getConnection().commit();
                }
                else
                {
                    getConnector().getConnection().rollback();
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                throw new AlunoException(GenericErrors.ERROR_END_TRANSACTION.getMessage());
            } 
        }
	}

	/**
	 * Busca Pessoa pelo Id
	 * @method fetchById
	 * @param Integer id
	 * @return Pessoa
	 */
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
			    
			    pessoa.setPrenome    (resultSet.getString(2));
			    pessoa.setNome       (resultSet.getString(3));
			    pessoa.setSobrenome  (resultSet.getString(4));
			    pessoa.setTelefone   (resultSet.getString(5));
			    pessoa.setCpf        (resultSet.getString(6));
			}
		} 
		catch (SQLException e) 
		{
			throw new PessoaException(PessoaExceptionMessages.ERRRO_FETCH_BY_ID.getMessage());
		}
		
		return pessoa;
	}
	
    @Override
    public List<Pessoa> fetchAll()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer getNextId()
    {
        return super.getNextId(this.getEntity());
    }

    @Override
    public Integer getLastUsedId()
    {
        return super.getLastUsedId(this.getEntity());
    }
    
    @Override
    public EntityEnum getEntity()
    {
        return entity;
    }
}
