package dev.asor.univitatis.model;

import dev.asor.univitatis.database.dao.enums.EntityEnum;
import dev.asor.univitatis.model.interfaces.DatabaseObjectInterface;
import dev.asor.univitatis.model.interfaces.PessoaInterface;

/**
 * @class Aluno
 * @author dev.asor
 * @since march.2022
 */
public class Aluno implements PessoaInterface
                            , DatabaseObjectInterface<Aluno>
{
    private final EntityEnum entity = EntityEnum.ALUNOS;
    
    private Integer id;
    
    private Pessoa pessoa;
    private String matriculaAluno;

    public Aluno() {}
    
    public Aluno(Integer id)
    {
        setPessoa(new Pessoa(id));
        setId(id);
    }
    public Aluno(Pessoa pessoa)
    {
        setPessoa(pessoa);
        setId(pessoa.getId());
    }

    public Integer getId()
    {
        return id;
    }
    private void setId(Integer id)
    {
        this.id = id;
    }

    public Pessoa getPessoa()
    {
        return this.pessoa;
    }
    private void setPessoa(Pessoa pessoa)
    {
        this.pessoa = pessoa;
    }

    public String getMatriculaAluno()
    {
        return matriculaAluno;
    }
    public void setMatriculaAluno(String matriculaAluno)
    {
        this.matriculaAluno = matriculaAluno;
    }

    public EntityEnum getEntity()
    {
        return entity;
    }

    /**
     * Retorna o objeto da do banco se o ID estiver definido
     * 
     * @method getObject
     * @return Aluno
     */
    @Override
    public Aluno getObject()
    {
        if (getId() != null)
        {
            return new Aluno();
        } 
        else
        {
            return null;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();

        str.append("["                                                 );
        str.append("id: "           + getId()                    + ", ");
        str.append("prenome: "      + getPessoa().getPrenome()   + ", ");
        str.append("nome: "         + getPessoa().getNome()      + ", ");
        str.append("sobrenome: "    + getPessoa().getSobrenome() + ", ");
        str.append("cpf: "          + getPessoa().getCpf()       + ", ");
        str.append("cd_matricula: " + getMatriculaAluno()              );
        str.append("]"                                                 );

        return str.toString();
    }
}
