package dev.asor.univitatis.database.dao.interfaces;

import dev.asor.univitatis.model.Aluno;

public interface AlunoDAOInterface
{
    public void gravaAluno(Aluno aluno);
    
    public Aluno buscaAluno();
}
