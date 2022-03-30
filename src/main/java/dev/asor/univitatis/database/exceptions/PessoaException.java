package dev.asor.univitatis.database.exceptions;

/**
 * Excecoes customizadas para o DAO de Pessoa
 * 
 * @class PessoaException
 * @author dev.asor
 * @since 17.march.2022
 */
public class PessoaException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public PessoaException(String message)
    {
        super(message);
    }
}
