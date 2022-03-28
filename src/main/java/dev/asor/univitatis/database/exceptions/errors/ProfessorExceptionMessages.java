package dev.asor.univitatis.database.exceptions.errors;

/**
 * @enum ProfessorExceptionMessages
 * @author dev.asor
 * @since 17.march.2022
 */
public enum ProfessorExceptionMessages
{
      ERROR_INSERT_PROFESSOR        ("Erro ao inserir Professor!")
    , ERROR_PROFESSOR_NOT_DEFINED	  ("Professor não possui uma Pessoa definida!")
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
