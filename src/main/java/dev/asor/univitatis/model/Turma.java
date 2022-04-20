package dev.asor.univitatis.model;

import dev.asor.univitatis.model.interfaces.DatabaseObjectInterface;

/**
 * @class Turma
 * @author dev.asor
 * @since march.2022
 */
public class Turma implements DatabaseObjectInterface<Turma>
{
    private Integer id;
    
    private Professor professor;
    private Disciplina disciplina;
    private Periodo perido;

    public Turma() {}

    public Turma(Integer id)
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

    public Professor getProfessor()
    {
        return professor;
    }

    public void setProfessor(Professor professor)
    {
        this.professor = professor;
    }

    public Disciplina getDisciplina()
    {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina)
    {
        this.disciplina = disciplina;
    }

    public Periodo getPerido()
    {
        return perido;
    }

    public void setPerido(Periodo perido)
    {
        this.perido = perido;
    }

    /**
     * Retorna o objeto da do banco se o ID estiver definido
     * 
     * @method getObject
     * @return Turma
     */
    @Override
    public Turma getObject()
    {
        if (getId() != null)
        {
            return new Turma();
        } else
        {
            return null;
        }
    }
}
