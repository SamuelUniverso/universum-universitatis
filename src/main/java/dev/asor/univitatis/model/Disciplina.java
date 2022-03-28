package dev.asor.univitatis.model;

import dev.asor.univitatis.model.interfaces.DatabaseObjectInterface;

/**
 * @author dev.asor
 * @since 15.mar.2022
 */
public class Disciplina implements DatabaseObjectInterface<Disciplina>
{
    private Integer id;
    
    private String nome;

    public Disciplina() {}

    public Disciplina(Integer id)
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
     * @return Disciplina
     */
    @Override
    public Disciplina getObject()
    {
        if (getId() != null)
        {
            return new Disciplina();
        } else
        {
            return null;
        }
    }
}
