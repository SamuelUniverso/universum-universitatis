package dev.asor.univitatis.database.dao;

import dev.asor.univitatis.model.Aluno;

/**
 * Teste de CRUD na entidade de Aluno
 * @author dev.asor
 * @since 17.mar.2022
 */
public class AlunoDaoTest 
{
	
	public void insertAluno()
	{
		Aluno aluno = new Aluno();
		aluno.setPrenome("Prenome");
		aluno.setNome("Nome");
		aluno.setSobrenome("Sobrenome");
		aluno.setCpf("00000000000");
		aluno.setTelefone("5551987654321");
		aluno.setMatriculaAluno("000-000-000");
		
	}
	
}
