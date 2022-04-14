package dev.asor.univitatis.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.enums.EntityEnum;
import dev.asor.univitatis.database.dao.helper.AlunoDaoHelper;
import dev.asor.univitatis.database.dao.helper.ProfessorDaoHelper;
import dev.asor.univitatis.database.dao.interfaces.CrudObjectInterface;
import dev.asor.univitatis.messages.exceptions.dao.AlunoException;
import dev.asor.univitatis.messages.exceptions.dao.ProfessorException;
import dev.asor.univitatis.messages.exceptions.dao.errors.GenericErrors;
import dev.asor.univitatis.messages.exceptions.dao.errors.ProfessorExceptionMessages;
import dev.asor.univitatis.model.Aluno;
import dev.asor.univitatis.model.Pessoa;
import dev.asor.univitatis.model.Professor;

/**
 * @class ProfessorDao
 * @author dev.asor
 * @since 17.march.2022
 */
public class ProfessorDao extends GenericDao implements CrudObjectInterface<Professor>
{
    private final EntityEnum entity = EntityEnum.ALUNOS;
    
    public ProfessorDao(DatabaseConnector connector)
    {
        setConnector(connector);
    }

    /**
     * Insere um novo Professor na Base
     * @method insert
     * @param Professor professor
     * @return void
     */
    @Override
    public void insert(Professor professor)
    {
        PessoaDao pessoaDao = new PessoaDao(getConnector());
        
        try
        {
            if(professor.getPessoa() == null) /* Professor precisa conter Pessoa */
            {
                throw new ProfessorException(ProfessorExceptionMessages.ERROR_PROFESSOR_NOT_DEFINED.getMessage());
            }
            pessoaDao.insert(professor.getPessoa());
             
            String sql = ProfessorDaoHelper.createPreparedStatementInsertProfessor();
            PreparedStatement statement = getConnector().getConnection()
                                                        .prepareStatement(sql);
            
            statement.setInt   (1, pessoaDao.getLastUsedId()); /* professor.fk_pessoa */
            statement.setString(2, professor.getMatriculaFuncionario());
            
            statement.executeUpdate();
            
            getConnector().getConnection().commit();
        }
        catch(SQLException e)
        {
            try
            {
                getConnector().getConnection().rollback();
            }
            catch(SQLException e1)
            {
                e1.printStackTrace();
                throw new ProfessorException(GenericErrors.ERROR_ROLLBAK_CONNECTION.getMessage());
            }
        }
        finally
        {
            try
            {
                getConnector().getConnection().close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                throw new ProfessorException(GenericErrors.ERROR_CLOSE_CONNECTION.getMessage());
            }
        }
    }

    /**
     * Busca um Professor pelo Id especifico
     * @method fetchById
     * @param Integer id
     * @return Professor
     */
    @Override
    public Professor fetchById(Integer id) 
    {
        Professor professor = null;
        try
        {
            if(id == null)
            {
                throw new IllegalArgumentException(ProfessorExceptionMessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());
            }
            
            String sql = ProfessorDaoHelper.createPreparedStatementSelectProfessor(false);
            PreparedStatement statement = getConnector().getConnection().prepareStatement(sql);
            
            statement.setInt(1, id);
            
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
                professor = new Professor(new Pessoa(result.getInt(1)));
                professor.getPessoa().setPrenome    (result.getString(2));
                professor.getPessoa().setNome       (result.getString(3));
                professor.getPessoa().setSobrenome  (result.getString(4));
                professor.getPessoa().setCpf        (result.getString(5));
                professor.getPessoa().setTelefone   (result.getString(6));
                professor.setMatriculaFuncionario   (result.getString(8));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                getConnector().getConnection().close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                throw new ProfessorException(GenericErrors.ERROR_CLOSE_CONNECTION.getMessage());
            }
        }
        
        return professor;
    }
    
    /**
     * Retorna a lista de todos os Professores
     * @method fetchAll
     * @return List<Professor>
     */
    @Override
    public List<Professor> fetchAll()
    {
        List<Professor> profesores = new ArrayList<Professor>(); 
        try
        {
            String sql = ProfessorDaoHelper.createPreparedStatementSelectProfessor(true);
            PreparedStatement statement = getConnector().getConnection().prepareStatement(sql);
            
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
                Professor professor = new Professor(new Pessoa(result.getInt(1)));
                professor.getPessoa().setPrenome      (result.getString(2));
                professor.getPessoa().setNome         (result.getString(3));
                professor.getPessoa().setSobrenome    (result.getString(4));
                professor.getPessoa().setCpf          (result.getString(5));
                professor.getPessoa().setTelefone     (result.getString(6));
                professor.setMatriculaFuncionario     (result.getString(8));
                
                profesores.add(professor);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                getConnector().getConnection().close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                throw new ProfessorException(GenericErrors.ERROR_CLOSE_CONNECTION.getMessage());
            }
        }
        
        return profesores;
    }    

    @Override
    public Integer getNextId()
    {
        return super.getNextId(this.getEntity());
    }

    @Override
    public Integer getLastUsedId()
    {
        return super.getLastUsedId(this.getEntity());
    }

    @Override
    public EntityEnum getEntity()
    {
        return this.entity;
    }
}
