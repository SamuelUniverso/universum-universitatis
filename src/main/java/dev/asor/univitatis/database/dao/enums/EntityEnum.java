package dev.asor.univitatis.database.dao.enums;

/**
 * Este 'enumerador' contem o nome de todas as entidades da base de dados
 * 
 * enum EntityEnum
 * @author dev.asor
 * @since march.2022
 */
public enum EntityEnum
{
      ALUNOS        ("alunos")
    , CONTRATOS     ("contratos")
    , CURSOS        ("cursos")
    , DISCIPLINAS   ("disciplinas")
    , MATRICULAS    ("matriculas")
    , PERIODOS      ("periodos")
    , PESSOAS       ("pessoas")
    , PROFESSORES   ("professores")
    , TURMAS        ("turmas")
    ;

    private String entity;
    
    EntityEnum(String entity)
    {
       this.entity = entity;
    }
    
    public String getEntityName()
    {
        return this.entity;
    }
}
