package dev.asor.univitatis.view.gui.cardpanel.professor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.ProfessorDao;
import dev.asor.univitatis.model.Pessoa;
import dev.asor.univitatis.model.Professor;
import dev.asor.univitatis.utils.Valitations;
import net.miginfocom.swing.MigLayout;

/**
 * @author dev.asor
 * @since march.2022
 */
public class ProfessorFormView extends JPanel 
{
    private static final long serialVersionUID = 1L;
    
    private Integer selectedId;
    private boolean editingRow;
    
    private JLabel titleLabel;
    
    private JLabel prenomeLabel;
    private JLabel nomeLabel;
    private JLabel sobrenomeLabel;
    private JLabel cpfLabel;
    private JLabel telefoneLabel;
    private JLabel matriculaLabel;
    
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField telefoneField;
    private JTextField prenomeField;
    private JTextField sobrenomeField;
    private JTextField matriculaField;
    
    private JButton saveButton;
    private JButton deleteButtton;
    private JButton editButton;
    
    private ProfessorTable professorTable;
    private JScrollPane scrollPane;

    public ProfessorFormView() 
    {
        setLayout(new MigLayout("wrap", "[77px,grow][86px,grow][46px][23px][86px][117.00px][38.00]", "[20px][][][][][][][grow][]"));
        
        createForm();          /* formulario */
        createActionButtons(); /* botoes de acao */
        createTableList();     /* inserir dados na tabela */
    }
    
    private void createForm()
    {
        titleLabel = new JLabel("Cadastro de professores:");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(titleLabel, "cell 0 0 2 1");
        
        /* prenome - label */
        prenomeLabel = new JLabel("Prenome:");
        prenomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(prenomeLabel, "cell 4 2,alignx trailing");
        /* prenome - field */
        prenomeField = new JTextField();
        add(prenomeField, "cell 5 2,growx");
        prenomeField.setColumns(10);
        
        /* nome - label */
        nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(nomeLabel, "cell 0 2,alignx right");
        /* prenome - field */
        nomeField = new JTextField();
        add(nomeField, "cell 1 2 2 1,growx");
        
        /* sobrenome - label */
        sobrenomeLabel = new JLabel("Sobrenome:");
        sobrenomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(sobrenomeLabel, "cell 0 3,alignx trailing");
        /* sobrenome - field */
        sobrenomeField = new JTextField();
        add(sobrenomeField, "cell 1 3 2 1,growx");
        sobrenomeField.setColumns(10);
        
        /* cpf - label */
        cpfLabel = new JLabel("CPF:");
        cpfLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(cpfLabel, "cell 4 3,alignx right");
        /* cpf - field */
        cpfField = new JTextField();
        cpfField.setColumns(14);
        add(cpfField, "cell 5 3,growx");
        
        /* telefone - label */
        telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(telefoneLabel, "cell 0 4,alignx right");
        /* telefone - field */
        telefoneField = new JTextField();
        telefoneField.setColumns(10);
        add(telefoneField, "cell 1 4 2 1,growx");
        
        /* matricula - label */
        matriculaLabel = new JLabel("Matrícula:");
        matriculaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(matriculaLabel, "cell 0 5,alignx right");
        /* matricula - field */
        matriculaField = new JTextField();
        add(matriculaField, "cell 1 5,growx");
        matriculaField.setColumns(10);
    }
    
    private void createActionButtons()
    {
        /* save */
        saveButton = new JButton("Salvar");
        saveButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(validateForm())
                {
                    nomeField.setBackground(Color.WHITE);
                    sobrenomeField.setBackground(Color.WHITE);
                    telefoneField.setBackground(Color.WHITE);
                    
                    Professor professor = new Professor(new Pessoa());
                    professor.getPessoa().setPrenome(prenomeField.getText());
                    professor.getPessoa().setNome(nomeField.getText());
                    professor.getPessoa().setSobrenome(sobrenomeField.getText());
                    professor.getPessoa().setCpf(cpfField.getText());
                    professor.getPessoa().setTelefone(telefoneField.getText());
                    professor.setMatriculaFuncionario(matriculaField.getText());;
                    
                   ProfessorDao dao = new ProfessorDao(DatabaseConnector.getInstance());
                   dao.insert(professor);
                   
                   professorTable.addElement(professor);
                   
                   clearInputs();
               }
            }
        });
        saveButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(saveButton, "flowx,cell 5 5,alignx right");
        
        /* delete */
        deleteButtton = new JButton("Excluir");
        deleteButtton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
               int choice = JOptionPane.showInternalConfirmDialog(null, "Deseja remover esse registro?");
               if(choice == 0) /* yes */
               {
                   int id = (Integer) professorTable.getValueAt(professorTable.getSelectedRow(), 0);
                   ProfessorDao dao = new ProfessorDao(DatabaseConnector.getInstance());
                   
                   if(dao.deleteById(id +1)) /* rowcount begins at 0 */
                   {
                       professorTable.removeElement(professorTable.getSelectedRow());
                       JOptionPane.showMessageDialog(null, "Registro aluno deletado com sucesso.");
                   }
                   else {
                       JOptionPane.showMessageDialog(null, "Falha ao deletar registro.");
                   }
               }
            }
        });
        add(deleteButtton, "cell 6 5");
        
        /* edit */
        editButton = new JButton("Editar");
        editButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(!isEditingRow()) /* loads table to form */ 
                {
                    setIsEditingRow(true);
                    
                    Integer id
                        = Integer.parseInt(professorTable.getModel().getValueAt(professorTable.getSelectedRow(), 0).toString());
                    
                    String[] nomeCompleto 
                        = professorTable.getModel().getValueAt(professorTable.getSelectedRow(), 1).toString().split(" ");
                    
                    String prenome   = nomeCompleto[0];
                    String nome      = nomeCompleto[1];
                    String sobrenome = nomeCompleto[2];
                    
                    String cpf 
                        = professorTable.getModel()
                                    .getValueAt(professorTable.getSelectedRow(), 2).toString();
                    
                    String telefone 
                        = professorTable.getModel()
                                    .getValueAt(professorTable.getSelectedRow(), 3).toString().substring(1);
                    
                    String matricula
                        = professorTable.getModel()
                                    .getValueAt(professorTable.getSelectedRow(), 4).toString();
                    
                    setSelectedId(id);
                    prenomeField.setText(prenome);
                    nomeField.setText(nome);
                    sobrenomeField.setText(sobrenome);
                    telefoneField.setText(telefone);
                    cpfField.setText(cpf);
                    matriculaField.setText(matricula);

                    editButton.setText("Atualizar");
               }
               else /* writes change to database */
               {
                   ProfessorDao dao = new ProfessorDao(DatabaseConnector.getInstance());
                   
                   Professor professor = new Professor(new Pessoa(getSelectedId()));
                   professor.getPessoa().setPrenome(prenomeField.getText());
                   professor.getPessoa().setNome(nomeField.getText());
                   professor.getPessoa().setSobrenome(sobrenomeField.getText());
                   professor.getPessoa().setTelefone(telefoneField.getText());
                   professor.getPessoa().setCpf(cpfField.getText());
                   professor.setMatriculaFuncionario(matriculaField.getText());;
                   
                   dao.update(professor);
                   
                   professorTable.updateElement(professorTable.getSelectedRow(), professor);
                   
                   if(isEditingRow()) 
                   {
                       setIsEditingRow(false);
                       editButton.setText("Editar");
                   }
               }
            }
        });
        add(editButton, "cell 5 5");
    }
    
    private boolean validateForm()
    {
        try
        {
            if(!cpfField.getText().equals(""))
            {
                if(!Valitations.validarCPF(cpfField.getText())) 
                {
                    JOptionPane.showMessageDialog(null,
                            "O CPF " + cpfField.getText() + " é inválido."
                    );
                    return false;
                }
            }
            if(!telefoneField.getText().equals(""))
            {
                if(!Valitations.validarTelefone(telefoneField.getText())) 
                {
                    JOptionPane.showMessageDialog(null,
                            "O Telefone " + telefoneField.getText() + " é inválido."
                    );
                    return false;
                }
            }
            if(  nomeField.getText().equals("")
              || sobrenomeField.getText().equals("")
              || cpfField.getText().equals("") )
            {
                nomeField.setBackground(Color.GRAY);
                nomeField.setForeground(Color.WHITE);
                
                sobrenomeField.setBackground(Color.GRAY);
                sobrenomeField.setForeground(Color.WHITE);
                
                cpfField.setBackground(Color.GRAY);
                cpfField.setForeground(Color.WHITE);
                
                throw new IllegalArgumentException("Formulário incompleto! \r\n Confira os dados e tente novamente.");
            }
        }
        catch(IllegalArgumentException exception) 
        {
            clearInputs();
            JOptionPane.showMessageDialog(null, exception.getMessage());
            
            return false;
        }
        
        return true;
    }
    
    /**
     * Esvazia todos os campos de Input do cadastro
     * @method clearInputs
     * @return void
     */
    private void clearInputs()
    {
        prenomeField.setText(null);
        nomeField.setText(null);
        sobrenomeField.setText(null);
        cpfField.setText(null);
        telefoneField.setText(null);
        matriculaField.setText(null);
    }
    
    private void createTableList()
    {
        professorTable = new ProfessorTable(this); /* to be able to change JFrame from inside JTable */
        professorTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        scrollPane = new JScrollPane(professorTable);
        add(scrollPane, "cell 0 7 7 2,grow");
        
        professorTable.fetchDataFromDatabase();
    }
    
    public boolean isEditingRow()
    {
        return editingRow;
    }
    private void setIsEditingRow(boolean status)
    {
        this.editingRow = status;
    }
    
    public Integer getSelectedId()
    {
        return selectedId;
    }
    private void setSelectedId(Integer id)
    {
        this.selectedId = id;
    }
}
