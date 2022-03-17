package dev.asor.univitatis.database.dao;

import java.sql.PreparedStatement;

import dev.asor.univitatis.database.connector.ConectorBanco;
import dev.asor.univitatis.database.dao.helper.AlunoDAOHelper;
import dev.asor.univitatis.database.dao.helper.PessoaDAOHelper;
import dev.asor.univitatis.database.dao.interfaces.AlunoDAOInterface;
import dev.asor.univitatis.model.Aluno;

public class AlunoDAO implements AlunoDAOInterface
{
    private ConectorBanco conector;
    
    public AlunoDAO()
    {
        setConector(ConectorBanco.getInstance());
    }
    
    public void gravaPessoa()
    {
        
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
    public void gravaAluno(Aluno aluno) 
    {
        try
        {
            PreparedStatement stmtPessoa 
                                = getConector().getConexao()
                                               .prepareStatement(PessoaDAOHelper.createPreparedStatementPessoa());
            
            stmtPessoa.setString(1, aluno.getPessoa().getPrenome());
            stmtPessoa.setString(2, aluno.getPessoa().getNome());
            stmtPessoa.setString(3, aluno.getPessoa().getSobrenome());
            stmtPessoa.setString(4, aluno.getPessoa().getTelefone());
            stmtPessoa.setString(5, aluno.getPessoa().getCpf());
            
            stmtPessoa.executeQuery();
            
            PreparedStatement stmtAluno 
                                = getConector().getConexao()
                                               .prepareStatement(AlunoDAOHelper.createPreparedStatementAluno());
            
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
    public Aluno buscaAluno()
    {
        return null;
    }
    
}
