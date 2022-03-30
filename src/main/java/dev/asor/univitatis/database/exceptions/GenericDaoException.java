package dev.asor.univitatis.database.exceptions;

/**
 * @class GenericDaoException
 * @author dev.asor
 * @since 17.march.2022
 */
public class GenericDaoException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public GenericDaoException(String message)
    {
        super(message);
    }
}
