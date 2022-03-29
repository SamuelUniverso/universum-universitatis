package dev.asor.univitatis.database.dao;

import java.util.List;

import org.junit.Test;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.model.Aluno;
import dev.asor.univitatis.model.Pessoa;
import dev.asor.univitatis.model.Professor;

/**
 * Teste de CRUD na entidade de Professor
 * 
 * @author dev.asor
 * @since 17.mar.2022
 */
public class ProfessorDaoTest 
{
    @Test
	public void insertProfessorThrowException()
	{
	    ProfessorDao dao = new ProfessorDao(DatabaseConnector.getInstance());
	    
	    Professor professor = new Professor();
	    dao.insert(professor);
	}
    
    @Test
    public void insertProfessor()
    {
        ProfessorDao dao = new ProfessorDao(DatabaseConnector.getInstance());
        
        Professor professor = new Professor(new Pessoa());
        professor.getPessoa().setPrenome("Magnus");
        professor.getPessoa().setNome("Doctorem");
        professor.getPessoa().setSobrenome("Lectionarum");
        professor.getPessoa().setCpf("77722116683");
        professor.getPessoa().setTelefone("5551123456789");
        professor.setMatriculaFuncionario("166-777-221");        
        
        dao.insert(professor);
    }
    
    @Test
    public void fetchProfessorById()
    {
        ProfessorDao dao = new ProfessorDao(DatabaseConnector.getInstance());
        
        Professor professor = dao.fetchById(2);
        System.out.print(professor);
    }
    
    @Test
    public void fetchAll()
    {
        ProfessorDao dao = new ProfessorDao(DatabaseConnector.getInstance());
        
        List<Professor> professores = dao.fetchAll();
        System.out.print(professores);
    }    
}
