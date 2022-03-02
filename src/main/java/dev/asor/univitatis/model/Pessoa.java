package dev.asor.univitatis.model;

/**
 * @author dev.asor
 * @since 23.feb.2022
 */
public abstract class Pessoa
{
    private String nomeCompleto;
    private String cpf;
    
    public String getNomeCompleto()
    {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto)
    {
        this.nomeCompleto = nomeCompleto;
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
