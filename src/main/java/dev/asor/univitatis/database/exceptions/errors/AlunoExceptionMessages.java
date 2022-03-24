package dev.asor.univitatis.database.exceptions.errors;

public enum AlunoExceptionMessages
{
    ERROR_INSERT_ALUNO  ("Erro ao inserir Aluno!")
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
