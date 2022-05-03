package dev.asor.univitatis.view.gui.cardpanel.aluno;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dev.asor.univitatis.model.Aluno;
import dev.asor.univitatis.view.gui.interfaces.FormTableInterface;

/**
 * @author dev.asor
 * @since may.2022
 */
public class AlunoTable extends JTable implements FormTableInterface<Aluno>
{
    private static final long serialVersionUID = 1L;
    
    private static final String HEADER_NOME = "Nome";
    private static final String HEADER_PRENOME = "Prenome";
    private static final String HEADER_SOBRENOME = "Sobrenome";
    private static final String HEADER_CPF = "CPF";
    private static final String HEADER_TELEFONE = "Telefone";
    private static final String HEADER_MATRICULA = "Matrícula";
    
    private DefaultTableModel modelo;

    @Override
    public void generateTable()
    {
        if(modelo == null)
        {
            modelo = new DefaultTableModel();
        }
        
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
            
        Object[] objeto = new Object[] { null
                                       , aluno.getPessoa().getPrenome()
                                       , aluno.getPessoa().getNome()
                                       , aluno.getPessoa().getSobrenome()
                                       , aluno.getPessoa().getCpf()
                                       , aluno.getPessoa().getTelefone()
                                       , aluno.getMatriculaAluno()
                                       };
        objeto[0] = modelo.getRowCount() +1; /* incrementando 'generated_id' da tabela */
        
        modelo.addRow(objeto);
    }

    @Override
    public void loadDataOnTable(List<Aluno> alunos)
    {
        alunos.forEach(aluno -> 
        {
            addElement(aluno);
        });
      
        setModel(modelo);
        getColumnModel().getColumn(0).setPreferredWidth(7);
    }
}
