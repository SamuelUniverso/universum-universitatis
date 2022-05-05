package dev.asor.univitatis.view.gui.cardpanel.aluno;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.AlunoDao;
import dev.asor.univitatis.model.Aluno;
import dev.asor.univitatis.view.gui.interfaces.FormTableInterface;

/**
 * @author dev.asor
 * @since may.2022
 */
public class AlunoTable extends JTable implements FormTableInterface<Aluno>
{
    private static final long serialVersionUID = 1L;

    private static final String HEADER_ID        = "Código";
    private static final String HEADER_NOME      = "Nome";
    private static final String HEADER_PRENOME   = "Prenome";
    private static final String HEADER_SOBRENOME = "Sobrenome";
    private static final String HEADER_CPF       = "CPF";
    private static final String HEADER_TELEFONE  = "Telefone";
    private static final String HEADER_MATRICULA = "Matrícula";

    private DefaultTableModel modelo;
    
    public AlunoTable() {}

    @Override
    public void generateTable()
    {
        if(modelo == null)
        {
            modelo = new DefaultTableModel();
        }

        modelo.addColumn(HEADER_ID);
        modelo.addColumn(HEADER_PRENOME);
        modelo.addColumn(HEADER_NOME);
        modelo.addColumn(HEADER_SOBRENOME);
        modelo.addColumn(HEADER_CPF);
        modelo.addColumn(HEADER_TELEFONE);
        modelo.addColumn(HEADER_MATRICULA);
    }

    @Override
    public void addElement(Aluno aluno)
    {
        if(modelo == null)
        {
            generateTable();
        }
        
        Object[] objeto = new Object[] { aluno.getId()
                                       , aluno.getPessoa().getPrenome()
                                       , aluno.getPessoa().getNome()
                                       , aluno.getPessoa().getSobrenome()
                                       , aluno.getPessoa().getCpf()
                                       , aluno.getPessoa().getTelefone()
                                       , aluno.getMatriculaAluno() 
                                       };
        objeto[0] = modelo.getRowCount() +1; /* incrementando 'rowcount' da tabela */
        modelo.addRow(objeto);
    }

    @Override
    public void addDataOnTable(List<Aluno> alunos)
    {
        alunos.forEach((aluno) -> { 
                                      addElement(aluno); 
                                  });
        this.setModel(modelo);
        // this.getColumnModel().getColumn(0).setPreferredWidth(5);
    }
    
    /**
     * Busca os dados do banco de dados
     * @method fetchDataFromDatabase
     */
    public void fetchDataFromDatabase()
    {
        AlunoDao dao = new AlunoDao(DatabaseConnector.getInstance());
        
        List<Aluno> alunos = dao.fetchAll();
        this.addDataOnTable(alunos);
        
        dao.closeConnection();
    }
}
