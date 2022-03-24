package dev.asor.univitatis.database.dao;

import java.sql.PreparedStatement;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.helper.AlunoDaoHelper;
import dev.asor.univitatis.database.dao.interfaces.CrudObjectInterface;
import dev.asor.univitatis.database.exceptions.AlunoException;
import dev.asor.univitatis.model.Aluno;

/**
 * @author dev.asor
 * @since 17.march.2022
 */
public class AlunoDao implements CrudObjectInterface<Aluno>
{
    private DatabaseConnector connector;
    
    public AlunoDao(DatabaseConnector connector)
    {
        setConnector(connector);
    }
    
    private DatabaseConnector getConnector()
    {
        return connector;
    }
    private void setConnector(DatabaseConnector connector)
    {
        this.connector = connector;
    }

	@Override
	public void insert(Aluno aluno) 
	{
	    PessoaDao pessoaDao = new PessoaDao(getConnector());
	    
	    try
	    {
	        if(aluno.getPessoa() == null)
	        {
	            throw new AlunoException("Aluno não possui uma Pessoa definida!");
	        }
	        
	        pessoaDao.insert(aluno.getPessoa());
	         
	        String sql = AlunoDaoHelper.createPreparedStatementAluno();
            PreparedStatement stmtAluno = getConnector().getConnection()
                                                        .prepareStatement(sql);
            
            stmtAluno.setInt   (1, aluno.getPessoa().getId());
            stmtAluno.setString(2, aluno.getMatriculaAluno());
            
            stmtAluno.executeQuery();
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
