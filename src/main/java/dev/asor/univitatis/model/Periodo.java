package dev.asor.univitatis.model;

import dev.asor.univitatis.model.interfaces.DatabaseObjectInterface;

/**
 * @class Periodo
 * @author dev.asor
 * @since march.2022
 */
public class Periodo implements DatabaseObjectInterface<Periodo>
{
    private Integer id;
    
    private String periodoLetivo;

    public Periodo() {}

    public Periodo(Integer id)
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

    public String getPeriodoLetivo()
    {
        return periodoLetivo;
    }

    public void setPeriodoLetivo(String periodoLetivo)
    {
        this.periodoLetivo = periodoLetivo;
    }

    /**
     * Retorna o objeto da do banco se o ID estiver definido
     * 
     * @method getObject
     * @return Periodo
     */
    @Override
    public Periodo getObject()
    {
        if (getId() != null)
        {
            return new Periodo();
        } else
        {
            return null;
        }
    }
}
