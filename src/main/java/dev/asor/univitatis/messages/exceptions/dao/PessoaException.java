package dev.asor.univitatis.messages.exceptions.dao;

/**
 * Excecoes customizadas para o DAO de Pessoa
 * 
 * @class PessoaException
 * @author dev.asor
 * @since march.2022
 */
public class PessoaException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public PessoaException(String message)
    {
        super(message);
    }
}
