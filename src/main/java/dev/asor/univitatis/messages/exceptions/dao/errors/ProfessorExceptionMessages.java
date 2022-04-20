package dev.asor.univitatis.messages.exceptions.dao.errors;

/**
 * @enum ProfessorExceptionMessages
 * @author dev.asor
 * @since march.2022
 */
public enum ProfessorExceptionMessages
{
      ERROR_INSERT_PROFESSOR        ("Erro ao inserir Professor!")
    , ERROR_PROFESSOR_NOT_DEFINED	  ("Professor não possui uma Pessoa definida!")
    , ERROR_PROFESSOR_NOT_FOUND     ("Professor não foi encontrado!")    
    ;
    
    private String message;
    
    ProfessorExceptionMessages(String message)
    {
        this.message = message;
    }
    
    public String getMessage()
    {
        return this.message;
    }
}
