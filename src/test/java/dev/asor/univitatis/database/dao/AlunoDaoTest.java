package dev.asor.univitatis.database.dao;

import org.junit.Test;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.model.Aluno;

/**
 * Teste de CRUD na entidade de Aluno
 * 
 * @author dev.asor
 * @since 17.mar.2022
 */
public class AlunoDaoTest 
{
    @Test
	public void insertAlunoThrowException()
	{
	    AlunoDao dao = new AlunoDao(DatabaseConnector.getInstance());
	    
	    Aluno aluno = new Aluno();
	    dao.insert(aluno);
	}
    
    @Test
    public void insertAluno()
    {
        AlunoDao dao = new AlunoDao(DatabaseConnector.getInstance());
        
        Aluno aluno = new Aluno();
        aluno.getPessoa().setPrenome("Prenome");
        aluno.getPessoa().setNome("Nome");
        aluno.getPessoa().setSobrenome("Sobrenome");
        aluno.getPessoa().setCpf("00000000000");
        aluno.getPessoa().setTelefone("5551987654321");
        aluno.setMatriculaAluno("000-000-000");        
        
        dao.insert(aluno);
    }
}
