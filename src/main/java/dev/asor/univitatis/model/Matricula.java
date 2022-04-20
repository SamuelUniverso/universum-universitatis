package dev.asor.univitatis.model;

import java.math.BigDecimal;
import java.util.Date;

import dev.asor.univitatis.model.interfaces.DatabaseObjectInterface;

/**
 * @class Matricula
 * @author dev.asor
 * @since march.2022
 */
public class Matricula implements DatabaseObjectInterface<Matricula>
{
    private Integer id;
    
    private Contrato contrato;
    private Turma turma;
    private Date dataMatricula;
    private Date dataEncerrameto;
    private BigDecimal nota1;
    private BigDecimal nota2;
    private BigDecimal nota3;
    private BigDecimal notaFinal;

    public Matricula() {}

    public Matricula(Integer id)
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

    public Contrato getContrato()
    {
        return contrato;
    }

    public void setContrato(Contrato contrato)
    {
        this.contrato = contrato;
    }

    public Turma getTurma()
    {
        return turma;
    }

    public void setTurma(Turma turma)
    {
        this.turma = turma;
    }

    public Date getDataMatricula()
    {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula)
    {
        this.dataMatricula = dataMatricula;
    }

    public Date getDataEncerrameto()
    {
        return dataEncerrameto;
    }

    public void setDataEncerrameto(Date dataEncerrameto)
    {
        this.dataEncerrameto = dataEncerrameto;
    }

    public BigDecimal getNota1()
    {
        return nota1;
    }

    public void setNota1(BigDecimal nota1)
    {
        this.nota1 = nota1;
    }

    public BigDecimal getNota2()
    {
        return nota2;
    }

    public void setNota2(BigDecimal nota2)
    {
        this.nota2 = nota2;
    }

    public BigDecimal getNota3()
    {
        return nota3;
    }

    public void setNota3(BigDecimal nota3)
    {
        this.nota3 = nota3;
    }

    public BigDecimal getNotaFinal()
    {
        return notaFinal;
    }

    public void setNotaFinal(BigDecimal notaFinal)
    {
        this.notaFinal = notaFinal;
    }

    /**
     * Retorna o objeto da do banco se o ID estiver definido
     * 
     * @method getObject
     * @return Matricula
     */
    @Override
    public Matricula getObject()
    {
        if (getId() != null)
        {
            return new Matricula();
        } else
        {
            return null;
        }
    }
}
