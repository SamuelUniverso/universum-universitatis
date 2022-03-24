package dev.asor.univitatis.database.exceptions;

/**
 * Excecoes customizadas para o DAO de Aluno
 * 
 * @author dev.asor
 * @since 17.march.2022
 */
public class AlunoException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public AlunoException(String message)
    {
        super(message);
    }
}
