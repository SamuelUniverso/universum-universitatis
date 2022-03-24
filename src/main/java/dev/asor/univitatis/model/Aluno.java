package dev.asor.univitatis.model;

import dev.asor.univitatis.database.dao.enums.EntityEnum;
import dev.asor.univitatis.model.interfaces.DatabaseObjectInterface;
import dev.asor.univitatis.model.interfaces.PessoaInterface;

/**
 * @author dev.asor
 * @since 15.mar.2022
 */
public class Aluno implements PessoaInterface,
                              DatabaseObjectInterface<Aluno>
{
    private final EntityEnum entity = EntityEnum.ALUNOS;
    
    private Integer id;
    private Pessoa pessoa;
    private String matriculaAluno;

    public Aluno() 
    {
        setPessoa(new Pessoa());
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
    
    public EntityEnum getEntity()
    {
        return entity;
    }

    @Override
    public Integer getNextId()
    {
        return null;
    }

    @Override
    public Integer getLastOccupiedId()
    {
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
        } 
        else
        {
            return null;
        }
    }
}
