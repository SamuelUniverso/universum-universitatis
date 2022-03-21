package dev.asor.univitatis.database.dao;

import java.sql.PreparedStatement;

import dev.asor.univitatis.database.connector.ConectorBanco;
import dev.asor.univitatis.database.dao.helper.AlunoDaoHelper;
import dev.asor.univitatis.database.dao.interfaces.DaoObjectInterface;
import dev.asor.univitatis.model.Aluno;

/**
 * @author dev.asor
 * @since 17.march.2022
 */
public class AlunoDao implements DaoObjectInterface<Aluno>
{
    private ConectorBanco conector;
    
    public AlunoDao()
    {
        setConector(ConectorBanco.getInstance());
    }
    
    private ConectorBanco getConector()
    {
        return conector;
    }
    private void setConector(ConectorBanco conector)
    {
        this.conector = conector;
    }

	@Override
	public void insert(Aluno aluno) 
	{
	     try
	     {
            PreparedStatement stmtAluno 
                                = getConector().getConexao()
                                               .prepareStatement(AlunoDaoHelper.createPreparedStatementAluno());
            
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
		return null;
	}
}
