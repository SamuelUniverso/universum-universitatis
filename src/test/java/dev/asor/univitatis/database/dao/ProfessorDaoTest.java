package dev.asor.univitatis.database.dao;

import org.junit.Test;

import dev.asor.univitatis.database.connector.DatabaseConnector;
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
	    dao.insert(professor, true);
	}
    
    @Test
    public void insertProfessor()
    {
        ProfessorDao dao = new ProfessorDao(DatabaseConnector.getInstance());
        
        Professor professor = new Professor(new Pessoa());
        professor.getPessoa().setPrenome("Prenome");
        professor.getPessoa().setNome("Nome");
        professor.getPessoa().setSobrenome("Sobrenome");
        professor.getPessoa().setCpf("00000000005");
        professor.getPessoa().setTelefone("5551987654321");
        professor.setMatriculaFuncionario("000-000-000");        
        
        dao.insert(professor, false);
    }
}
