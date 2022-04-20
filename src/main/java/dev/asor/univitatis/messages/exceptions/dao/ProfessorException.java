package dev.asor.univitatis.messages.exceptions.dao;

/**
 * Excecoes customizadas para o DAO de Professor
 * 
 * @class ProfessorException
 * @author dev.asor
 * @since march.2022
 */
public class ProfessorException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public ProfessorException(String message)
    {
        super(message);
    }
}
