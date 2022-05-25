package dev.asor.univitatis.view.gui.cardpanel.professor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.AlunoDao;
import dev.asor.univitatis.database.dao.ProfessorDao;
import dev.asor.univitatis.model.Aluno;
import dev.asor.univitatis.model.Professor;
import dev.asor.univitatis.view.gui.interfaces.FormTableInterface;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author dev.asor
 * @since may.2022
 */
public class ProfessorTable extends JTable implements FormTableInterface<Professor>
{
    private static final long serialVersionUID = 1L;

    private static final String HEADER_ID        = "Código";
    private static final String HEADER_NOME      = "Nome";
    //private static final String HEADER_PRENOME   = "Prenome";
    //private static final String HEADER_SOBRENOME = "Sobrenome";
    private static final String HEADER_CPF       = "CPF";
    private static final String HEADER_TELEFONE  = "Telefone";
    private static final String HEADER_MATRICULA = "Matrícula";

    private DefaultTableModel modelo;
    
    public ProfessorTable(ProfessorFormView jTable) 
    {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) 
            {
                List<Object> values = new ArrayList<Object>();
                
                for(int i = 0; i < getColumnCount(); i++) {
                    values.add(getValueAt(getSelectedRow(), i));
                }
            }
        });
    }

    @Override
    public void generateTable()
    {
        if(modelo == null)
        {
            modelo = new DefaultTableModel();
        }

        modelo.addColumn(HEADER_ID);
        //modelo.addColumn(HEADER_PRENOME);
        modelo.addColumn(HEADER_NOME);
        //modelo.addColumn(HEADER_SOBRENOME);
        modelo.addColumn(HEADER_CPF);
        modelo.addColumn(HEADER_TELEFONE);
        modelo.addColumn(HEADER_MATRICULA);
    }

    @Override
    public void addElement(Professor professor)
    {
        if(modelo == null)
        {
            generateTable();
        }
        
        /* adicionando elementos no modelo */
        Object[] objeto = new Object[] {  
                professor.getId()
            , professor.getPessoa().getPrenome() 
                + " "  + professor.getPessoa().getNome() 
                + " " + professor.getPessoa().getSobrenome() 
            , professor.getPessoa().getCpf()
            , "+" + professor.getPessoa().getTelefone()
            , professor.getMatriculaFuncionario() 
        };  
        objeto[0] = modelo.getRowCount() +1; /* incrementando 'rowcount' da tabela */
        modelo.addRow(objeto);
    }
    
    public void removeElement(Integer rowNumber) 
    {
        if(modelo != null) {
            modelo.removeRow(rowNumber);
        }
    }

    @Override
    public void addDataOnTable(List<Professor> professores)
    {
        //this.setPreferredSize(new Dimension(500, 250));
        
        professores.forEach((aluno) -> { 
            addElement(aluno); 
        });
        
        if(modelo != null) {
            this.setModel(modelo);
        }
        
        /* configurando proporcoes entre colunas */
        this.getColumn(getColumnName(0)).setPreferredWidth(0);
        this.getColumn(getColumnName(1)).setPreferredWidth(221);
        this.getColumn(getColumnName(2)).setPreferredWidth(50);
        this.getColumn(getColumnName(3)).setPreferredWidth(70);
        this.getColumn(getColumnName(4)).setPreferredWidth(40);
    }
    
    /**
     * Busca os dados do banco de dados
     * @method fetchDataFromDatabase
     */
    public void fetchDataFromDatabase()
    {
        ProfessorDao dao = new ProfessorDao(DatabaseConnector.getInstance());
        
        List<Professor> professores = dao.fetchAll();
        this.addDataOnTable(professores);
        
        dao.closeConnection();
    }
}
