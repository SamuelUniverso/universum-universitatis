package dev.asor.univitatis.model;

/**
 * @author dev.asor
 * @since 23.feb.2022
 */
public class Contato extends Pessoa
{
    private String telefone;
    
    public Contato(){}
    
    public Contato(String nome, String cpf, String telefone)
    {
    	setNomeCompleto(nome);
    	setCpf(cpf);
    	setTelefone(telefone);
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }
}
