package dev.asor.univitatis.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.enums.EntityEnum;
import dev.asor.univitatis.database.dao.helper.AlunoDaoHelper;
import dev.asor.univitatis.database.dao.helper.PessoaDaoHelper;
import dev.asor.univitatis.database.dao.interfaces.CrudObjectInterface;
import dev.asor.univitatis.messages.exceptions.dao.AlunoException;
import dev.asor.univitatis.messages.exceptions.dao.GenericDaoException;
import dev.asor.univitatis.messages.exceptions.dao.PessoaException;
import dev.asor.univitatis.messages.exceptions.dao.ProfessorException;
import dev.asor.univitatis.messages.exceptions.dao.errors.AlunoExceptionMessages;
import dev.asor.univitatis.messages.exceptions.dao.errors.GenericErrors;
import dev.asor.univitatis.messages.exceptions.dao.errors.PessoaExceptionMessages;
import dev.asor.univitatis.model.Aluno;
import dev.asor.univitatis.model.Pessoa;

/**
 * @class AlunoDao
 * @author dev.asor
 * @since march.2022
 */
public class AlunoDao extends GenericDao implements CrudObjectInterface<Aluno>
{
    private final EntityEnum entity = EntityEnum.ALUNOS;
    
    public AlunoDao(DatabaseConnector connector)
    {
        setConnector(connector);
    }

    /**
     * Insere um novo Aluno na Base
     * @method insert
     * @param Aluno aluno
     * @return void
     */
	@Override
	public void insert(Aluno aluno) 
	{
	    PessoaDao pessoaDao = new PessoaDao(getConnector());
	    
	    try
	    {
	        if(aluno.getPessoa() == null) /* Aluno precisa conter Pessoa */
	        {
	            throw new IllegalArgumentException(AlunoExceptionMessages.ERROR_ALUNO_NOT_DEFINED.getMessage());
	        }
	        pessoaDao.insert(aluno.getPessoa());
	         
	        String sql = AlunoDaoHelper.createPreparedStatementInsertAluno();
            PreparedStatement statement = getConnector().getConnection()
                                                        .prepareStatement(sql);
            
            statement.setInt   (1, pessoaDao.getLastUsedId()); /* aluno.fk_pessoa */
            statement.setString(2, aluno.getMatriculaAluno());
            
            statement.executeUpdate();
            
            getConnector().getConnection().commit();
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
	            getConnector().getConnection().close();
	        }
	        catch(SQLException e)
	        {
	            e.printStackTrace();
	            throw new AlunoException(GenericErrors.ERROR_CLOSE_CONNECTION.getMessage());
	        }
	    }
	}

    /**
     * Busca um Aluno pelo Id especifico
     * @method fetchById
     * @param Integer id
     * @return Aluno
     */
	@Override
	public Aluno fetchById(Integer id) 
	{
	   Aluno aluno = null;
	   try
	   {
	       if(id == null)
	       {
	           throw new IllegalArgumentException(AlunoExceptionMessages.ERROR_ALUNO_NOT_FOUND.getMessage());
	       }
	       
	       String sql = AlunoDaoHelper.createPreparedStatementSelectAluno(false);
	       PreparedStatement statement = getConnector().getConnection().prepareStatement(sql);
	       
	       statement.setInt(1, id);
	       
	       ResultSet result = statement.executeQuery();
	       while(result.next())
	       {
	           aluno = new Aluno(new Pessoa(result.getInt(1)));
	           aluno.getPessoa().setPrenome    (result.getString(2));
	           aluno.getPessoa().setNome       (result.getString(3));
	           aluno.getPessoa().setSobrenome  (result.getString(4));
	           aluno.getPessoa().setCpf        (result.getString(5));
	           aluno.getPessoa().setTelefone   (result.getString(6));
	           aluno.setMatriculaAluno         (result.getString(8));
	       }
	   }
	   catch(SQLException e)
	   {
	       e.printStackTrace();
	   }
	   finally
	   {
	        try
	        {
	            getConnector().getConnection().close();
	        }
	        catch(SQLException e)
	        {
	            e.printStackTrace();
	            throw new AlunoException(GenericErrors.ERROR_CLOSE_CONNECTION.getMessage());
	        }
	   }
	   
	   return aluno;
	}
	
    /**
     * Retorna a lista de todos os Alunos
     * @method fetchAll
     * @return List<Aluno>
     */
    @Override
    public List<Aluno> fetchAll() 
    {
       List<Aluno> alunos = new ArrayList<Aluno>(); 
       try
       {
           String sql = AlunoDaoHelper.createPreparedStatementSelectAluno(true);
           PreparedStatement statement = getConnector().getConnection().prepareStatement(sql);
           
           ResultSet result = statement.executeQuery();
           while(result.next())
           {
               Aluno aluno = new Aluno(new Pessoa(result.getInt(1)));
               aluno.getPessoa().setPrenome      (result.getString(2));
               aluno.getPessoa().setNome         (result.getString(3));
               aluno.getPessoa().setSobrenome    (result.getString(4));
               aluno.getPessoa().setCpf          (result.getString(5));
               aluno.getPessoa().setTelefone     (result.getString(6));
               aluno.setMatriculaAluno           (result.getString(8));
               
               alunos.add(aluno);
           }
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
       finally
       {
           try
           {
               getConnector().getConnection().close();
           }
           catch(SQLException e)
           {
               e.printStackTrace();
               throw new AlunoException(GenericErrors.ERROR_CLOSE_CONNECTION.getMessage());
           }
       }
       
       return alunos;
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
