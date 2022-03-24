package dev.asor.univitatis.database.exceptions.errors;

public enum AlunoExceptionMessages
{
      ERROR_INSERT_ALUNO  		("Erro ao inserir Aluno!")
    , ERROR_ALUNO_NOT_DEFINED	("Aluno não possui uma Pessoa definida!")
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
