package dev.asor.univitatis.model;

/**
 * @author dev.asor
 * @since 23.feb.2022
 */
public abstract class Pessoa
{
    private Integer id;
    private String prenome;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String cpf;

    public Pessoa()
    {
    }

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
}
