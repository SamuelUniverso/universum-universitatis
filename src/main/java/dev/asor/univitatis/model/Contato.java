package dev.asor.univitatis.model;

/**
 * @author dev.asor
 * @since 23.feb.2022
 */
public class Contato extends Pessoa
{
    private String telefone;

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }
}

