package dev.asor.univitatis.messages.exceptions.utils.errors;

/**
 * @enum PictureHandlerExceptionEnum
 * @author dev.asor
 * @since april.2022
 */
public enum PictureHandlerExceptionEnum
{
      ERROR_IMAGE_NOT_FOUND ("Imagem não encontrada")
    , ERROR_LOADING_IMAGE   ("Erro ao carregar imagem")
    ; 
    
    private String message;
    
    PictureHandlerExceptionEnum(String message)
    {
        this.message = message;
    }
    
    public String getMessage()
    {
        return this.message;
    }
}
