package dev.asor.univitatis.model;

import dev.asor.univitatis.model.interfaces.DatabaseObjectInterface;

/**
 * @author dev.asor
 * @since 15.mar.2022
 */
public class Curso implements DatabaseObjectInterface<Curso>
{
    private Integer id;
    
    private String nome;

    public Curso() {}

    public Curso(Integer id)
    {
        setId(id);
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    /**
     * Retorna o objeto da do banco se o ID estiver definido
     * 
     * @method getObject
     * @return Curso
     */
    @Override
    public Curso getObject()
    {
        if (getId() != null)
        {
            return new Curso();
        } else
        {
            return null;
        }
    }
}
