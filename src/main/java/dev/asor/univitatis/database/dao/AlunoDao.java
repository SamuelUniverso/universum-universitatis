package dev.asor.univitatis.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.enums.EntityEnum;
import dev.asor.univitatis.database.dao.helper.AlunoDaoHelper;
import dev.asor.univitatis.database.dao.helper.PessoaDaoHelper;
import dev.asor.univitatis.database.dao.interfaces.CrudObjectInterface;
import dev.asor.univitatis.database.exceptions.AlunoException;
import dev.asor.univitatis.database.exceptions.GenericDaoException;
import dev.asor.univitatis.database.exceptions.PessoaException;
import dev.asor.univitatis.database.exceptions.errors.AlunoExceptionMessages;
import dev.asor.univitatis.database.exceptions.errors.GenericErrors;
import dev.asor.univitatis.database.exceptions.errors.PessoaExceptionMessages;
import dev.asor.univitatis.model.Aluno;

/**
 * @class AlunoDao
 * @author dev.asor
 * @since 17.march.2022
 */
public class AlunoDao extends GenericDao implements CrudObjectInterface<Aluno>
{
    private final EntityEnum entity = EntityEnum.ALUNOS;
    
    public AlunoDao(DatabaseConnector connector)
    {
        setConnector(connector);
    }

    /**
     * Insere um novo Aluno na base
     * @method insert
     * @param Aluno aluno
     * @param Boolean rollback : nao grava alteracoes
     * @return void
     */
	@Override
	public void insert(Aluno aluno, Boolean rollback) 
	{
	    PessoaDao pessoaDao = new PessoaDao(getConnector()); /* passa conector do AlunoDao para PessoaDao */
	    
	    try
	    {
	        if(aluno.getPessoa() == null) /* Aluno precisa conter Pessoa */
	        {
	            throw new AlunoException(AlunoExceptionMessages.ERROR_ALUNO_NOT_DEFINED.getMessage());
	        }
	        pessoaDao.insert(aluno.getPessoa(), rollback);
	         
	        String sql = AlunoDaoHelper.createPreparedStatementAluno();
            PreparedStatement stmtAluno = getConnector().getConnection()
                                                        .prepareStatement(sql);
            
            stmtAluno.setInt   (1, pessoaDao.getLastUsedId()); /* aluno.fk_pessoa */
            stmtAluno.setString(2, aluno.getMatriculaAluno());
            
            stmtAluno.executeUpdate();
        }
        catch(SQLException e)
        {
            try
            {
                getConnector().getConnection().rollback();
            }
            catch(SQLException e1)
            {
                e1.printStackTrace();
                throw new AlunoException(GenericErrors.ERROR_ROLLBAK_CONNECTION.getMessage());
            }
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
	    	    
	    	    getConnector().getConnection().close();
	    	}
	    	catch(SQLException e)
	    	{
	    	    e.printStackTrace();
	    	    throw new AlunoException(GenericErrors.ERROR_CLOSE_CONNECTION.getMessage());
	    	}
		}
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
        return this.entity;
    }
}
