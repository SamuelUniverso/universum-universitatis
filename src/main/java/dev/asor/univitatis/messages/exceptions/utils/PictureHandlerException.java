package dev.asor.univitatis.messages.exceptions.utils;

/**
 * Excecoes customizadas para PictureHandlerException
 * 
 * @class PictureHandlerException
 * @author dev.asor
 * @since april.2022
 */
public class PictureHandlerException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public PictureHandlerException(String message)
    {
        super(message);
    }
}
