package dev.asor.univitatis.model;

import dev.asor.univitatis.database.dao.enums.EntityEnum;
import dev.asor.univitatis.model.interfaces.DatabaseObjectInterface;
import dev.asor.univitatis.model.interfaces.PessoaInterface;

/**
 * @class Professor
 * @author dev.asor
 * @since 15.march.2022
 */
public class Professor extends Pessoa implements PessoaInterface
                                               , DatabaseObjectInterface<Professor>
{
    private final EntityEnum entity = EntityEnum.PROFESSORES;
    
    private Integer id;
    
    private String matriculaFuncionario;
    private Pessoa pessoa;

    public Professor() {}

    public Professor(Integer id)
    {
        setPessoa(new Pessoa(id));
        setId(id);
    }
    public Professor(Pessoa pessoa)
    {
        setPessoa(pessoa);
        setId(pessoa.getId());
    }

    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
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

    public String getMatriculaFuncionario()
    {
        return matriculaFuncionario;
    }
    public void setMatriculaFuncionario(String matriculaFuncionario)
    {
        this.matriculaFuncionario = matriculaFuncionario;
    }
    
    @Override
    public EntityEnum getEntity()
    {
        return entity;
    }

    /**
     * Retorna o objeto da do banco se o ID estiver definido
     * 
     * @method getObject
     * @return Professor
     */
    @Override
    public Professor getObject()
    {
        if (getId() != null)
        {
            return new Professor();
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
        str.append("cd_matricula: " + getMatriculaFuncionario()        );
        str.append("]"                                                 );

        return str.toString();
    }
}
