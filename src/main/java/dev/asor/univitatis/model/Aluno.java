package dev.asor.univitatis.model;

import dev.asor.univitatis.model.interfaces.DatabaseObjectInterface;
import dev.asor.univitatis.model.interfaces.PessoaInterface;

/**
 * @author dev.asor
 * @since 15.mar.2022
 */
public class Aluno extends Pessoa
        implements PessoaInterface, DatabaseObjectInterface<Aluno>
{
    private Integer id;
    private String matriculaAluno;
    private Pessoa pessoa;

    public Aluno()
    {
    }

    public Aluno(Integer id)
    {
        setId(id);
    }

    public Aluno(Pessoa pessoa)
    {
        setPessoa(pessoa);
    }

    public Integer getId()
    {
        return id;
    }

    private void setId(Integer id)
    {
        this.id = id;
    }

    public Pessoa getPessoa()
    {
        return this.pessoa;
    }

    private void setPessoa(Pessoa pessoa)
    {
        this.pessoa = pessoa;
    }

    public String getMatriculaAluno()
    {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno)
    {
        this.matriculaAluno = matriculaAluno;
    }

    @Override
    public Integer getNextId()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer getLastOccupiedId()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Retorna o objeto da do banco se o ID estiver definido
     * 
     * @method getObject
     * @return Aluno
     */
    @Override
    public Aluno getObject()
    {
        if (getId() != null)
        {
            return new Aluno();
        } else
        {
            return null;
        }
    }
}
