package dev.asor.univitatis.database.exceptions;

/**
 * Excecoes customizadas para o DAO de Professor
 * 
 * @class ProfessorException
 * @author dev.asor
 * @since 17.march.2022
 */
public class ProfessorException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public ProfessorException(String message)
    {
        super(message);
    }
}
