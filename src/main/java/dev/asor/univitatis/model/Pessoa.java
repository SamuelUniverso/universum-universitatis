package dev.asor.univitatis.model;

import dev.asor.univitatis.database.dao.enums.EntityEnum;
import dev.asor.univitatis.model.interfaces.PessoaInterface;

/**
 * @class Pessoa
 * @author dev.asor
 * @since february.2022
 */
public class Pessoa implements PessoaInterface
{
    private final EntityEnum entity = EntityEnum.PESSOAS;
    
    private Integer id;
    
    private String prenome;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String cpf;

    public Pessoa() {}

    public Pessoa(Integer id)
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

    public String getPrenome()
    {
        return prenome;
    }
    public void setPrenome(String prenome)
    {
        this.prenome = prenome;
    }

    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getSobrenome()
    {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome)
    {
        this.sobrenome = sobrenome;
    }

    public String getTelefone()
    {
        return telefone;
    }
    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public String getCpf()
    {
        return cpf;
    }
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    @Override
    public EntityEnum getEntity()
    {
        return entity;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        
        str.append("["                                       );
        str.append("id: "           + getId()          + ", ");
        str.append("prenome: "      + getPrenome()     + ", ");
        str.append("nome: "         + getNome()        + ", ");
        str.append("sobrenome: "    + getSobrenome()   + ", ");
        str.append("cpf: "          + getCpf()               );
        str.append("]"                                       );

        return str.toString();
    }
}
