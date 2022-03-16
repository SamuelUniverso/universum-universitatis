package dev.asor.univitatis.model;

import java.util.Date;

import dev.asor.univitatis.model.interfaces.DatabaseObjectInterface;

/**
 * @author dev.asor
 * @since 15.mar.2022
 */
public class Contrato implements DatabaseObjectInterface<Contrato>
{
    private Integer id;
    private Aluno aluno;
    private Curso curso;
    private Date dataAtivacao;
    private Date dataDesativacao;

    public Contrato()
    {
    }

    public Contrato(Integer id)
    {
        setId(id);
    }

    public Integer getId()
    {
        return id;
    }

    private void setId(Integer id)
    {
        this.id = id;
    }

    public Aluno getAluno()
    {
        return aluno;
    }

    public void setAluno(Aluno aluno)
    {
        this.aluno = aluno;
    }

    public Curso getCurso()
    {
        return curso;
    }

    public void setCurso(Curso curso)
    {
        this.curso = curso;
    }

    public Date getDataAtivacao()
    {
        return dataAtivacao;
    }

    public void setDataAtivacao(Date dataAtivacao)
    {
        this.dataAtivacao = dataAtivacao;
    }

    public Date getDataDesativacao()
    {
        return dataDesativacao;
    }

    public void setDataDesativacao(Date dataDesativacao)
    {
        this.dataDesativacao = dataDesativacao;
    }

    /**
     * Retorna o objeto da do banco se o ID estiver definido
     * 
     * @method getObject
     * @return Contrato
     */
    @Override
    public Contrato getObject()
    {
        if (getId() != null)
        {
            return new Contrato();
        } else
        {
            return null;
        }
    }
}
