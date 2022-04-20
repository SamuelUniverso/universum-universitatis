package dev.asor.univitatis.messages.exceptions.dao;

/**
 * @class GenericDaoException
 * @author dev.asor
 * @since march.2022
 */
public class GenericDaoException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public GenericDaoException(String message)
    {
        super(message);
    }
}
