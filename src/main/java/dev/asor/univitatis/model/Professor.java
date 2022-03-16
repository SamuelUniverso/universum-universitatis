package dev.asor.univitatis.model;

import dev.asor.univitatis.model.interfaces.DatabaseObjectInterface;
import dev.asor.univitatis.model.interfaces.PessoaInterface;

/**
 * @author dev.asor
 * @since 15.mar.2022
 */
public class Professor extends Pessoa
        implements PessoaInterface, DatabaseObjectInterface<Professor>
{
    private Integer id;
    private String matriculaFuncionario;
    private PessoaInterface pessoa;

    public Professor()
    {
    }

    public Professor(Integer id)
    {
        setId(id);
    }

    public Professor(PessoaInterface pessoa)
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

    public PessoaInterface getPessoa()
    {
        return this.pessoa;
    }

    private void setPessoa(PessoaInterface pessoa)
    {
        this.pessoa = pessoa;
    }

    public String getMatriculaFuncionario()
    {
        return matriculaFuncionario;
    }

    public void setMatriculaFuncionario(String matriculaFuncionario)
    {
        this.matriculaFuncionario = matriculaFuncionario;
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
     * @return Professor
     */
    @Override
    public Professor getObject()
    {
        if (getId() != null)
        {
            return new Professor();
        } else
        {
            return null;
        }
    }
}
