package dev.asor.univitatis.database.dao;

import java.util.List;

import org.junit.Test;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.model.Aluno;
import dev.asor.univitatis.model.Pessoa;

/**
 * Teste de CRUD na entidade de Aluno
 * 
 * @class AlunoDaoTest
 * @author dev.asor
 * @since 17.march.2022
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
        
        Aluno aluno = new Aluno(new Pessoa());
        aluno.getPessoa().setPrenome("Nobilis");
        aluno.getPessoa().setNome("Discipullum");
        aluno.getPessoa().setSobrenome("Honorarium");
        aluno.getPessoa().setCpf("22177716683");
        aluno.getPessoa().setTelefone("5551987654321");
        aluno.setMatriculaAluno("221-777-166");        
        
        dao.insert(aluno);
    }
    
    @Test
    public void fetchAlunoById()
    {
        AlunoDao dao = new AlunoDao(DatabaseConnector.getInstance());
        
        Aluno aluno = dao.fetchById(1);
        System.out.print(aluno);
    }
    
    @Test
    public void fetchAll()
    {
        AlunoDao dao = new AlunoDao(DatabaseConnector.getInstance());
        
        List<Aluno> alunos = dao.fetchAll();
        System.out.print(alunos);
    }
}
