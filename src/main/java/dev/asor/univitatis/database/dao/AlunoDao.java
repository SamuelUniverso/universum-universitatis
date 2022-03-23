package dev.asor.univitatis.database.dao;

import java.sql.PreparedStatement;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.helper.AlunoDaoHelper;
import dev.asor.univitatis.database.dao.interfaces.CrudObjectInterface;
import dev.asor.univitatis.model.Aluno;

/**
 * @author dev.asor
 * @since 17.march.2022
 */
public class AlunoDao implements CrudObjectInterface<Aluno>
{
    private DatabaseConnector conector;
    
    public AlunoDao()
    {
        setConector(DatabaseConnector.getInstance());
    }
    
    private DatabaseConnector getConector()
    {
        return conector;
    }
    private void setConector(DatabaseConnector conector)
    {
        this.conector = conector;
    }

	@Override
	public void insert(Aluno aluno) 
	{
	     try
	     {
	        String sql = AlunoDaoHelper.createPreparedStatementAluno();
            PreparedStatement stmtAluno 
                                = getConector().getConnection()
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
	    // TODO
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
