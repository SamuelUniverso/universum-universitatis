package dev.asor.univitatis.messages.exceptions.dao.errors;

/**
 * @enum AlunoExceptionMessages
 * @author dev.asor
 * @since march.2022
 */
public enum AlunoExceptionMessages
{
      ERROR_INSERT_ALUNO  	    ("Erro ao inserir Aluno!")
    , ERROR_ALUNO_NOT_DEFINED   ("Aluno não possui uma Pessoa definida!")
    , ERROR_ALUNO_NOT_FOUND     ("Aluno não foi encontrado!")
    ;
    
    private String message;
    
    AlunoExceptionMessages(String message)
    {
        this.message = message;
    }
    
    public String getMessage()
    {
        return this.message;
    }
}
