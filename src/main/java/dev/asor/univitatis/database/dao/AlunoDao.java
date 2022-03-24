package dev.asor.univitatis.database.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.helper.AlunoDaoHelper;
import dev.asor.univitatis.database.dao.helper.GenericDao;
import dev.asor.univitatis.database.dao.interfaces.CrudObjectInterface;
import dev.asor.univitatis.database.exceptions.AlunoException;
import dev.asor.univitatis.database.exceptions.PessoaException;
import dev.asor.univitatis.database.exceptions.errors.AlunoExceptionMessages;
import dev.asor.univitatis.database.exceptions.errors.PessoaExceptionMessages;
import dev.asor.univitatis.model.Aluno;

/**
 * @author dev.asor
 * @since 17.march.2022
 */
public class AlunoDao extends GenericDao implements CrudObjectInterface<Aluno>
{
    public AlunoDao(DatabaseConnector connector)
    {
        setConnector(connector);
    }

	@Override
	public Integer insert(Aluno aluno, Boolean debug) 
	{
	    PessoaDao pessoaDao = new PessoaDao(getConnector());
	    
	    try
	    {
	        if(aluno.getPessoa() == null)
	        {
	            throw new AlunoException(AlunoExceptionMessages.ERROR_ALUNO_NOT_DEFINED.getMessage());
	        }
	        
	        pessoaDao.insert(aluno.getPessoa(), debug);
	         
	        String sql = AlunoDaoHelper.createPreparedStatementAluno();
            PreparedStatement stmtAluno = getConnector().getConnection()
                                                        .prepareStatement(sql);
            
            stmtAluno.setInt   (1, aluno.getPessoa().getId());
            stmtAluno.setString(2, aluno.getMatriculaAluno());
            
            setGeneratedId(stmtAluno.executeUpdate());
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
        		throw new PessoaException(PessoaExceptionMessages.ERROR_ROLLBACK.getMessage());
        	}
        }
	    
	    return getGeneratedId();
	}

	@Override
	public Aluno fetchById(Integer id) 
	{
	    // TODO Auto-generated method stub
		return null;
	}

    @Override
    public Integer getNextId()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer getLastUsedId()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
