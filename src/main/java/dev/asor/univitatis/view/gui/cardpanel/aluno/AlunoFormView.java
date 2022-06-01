package dev.asor.univitatis.view.gui.cardpanel.aluno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.AlunoDao;
import dev.asor.univitatis.model.Aluno;
import dev.asor.univitatis.model.Pessoa;
import dev.asor.univitatis.utils.InputMaskHandler;
import dev.asor.univitatis.utils.Valitations;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.awt.event.ActionEvent;

/**
 * @author dev.asor
 * @since march.2022
 */
public class AlunoFormView extends JPanel 
{
    private static final long serialVersionUID = 1L;
    
    private static final String EDIT    = "Editar";
    private static final String EXCLUDE = "Excluir";
    private static final String SAVE    = "Salvar";
    private static final String UPDATE  = "Atualizar";
    
    private Integer selectedId;
    private boolean editingRow;
    private boolean failedEditAttempt;
    
    private JLabel titleLabel;
    
    private MaskFormatter cpfMask = null;
    private MaskFormatter phoneMask = null;
    private MaskFormatter matriculaMask = null;
    
    private JLabel prenomeLabel;
    private JLabel nomeLabel;
    private JLabel sobrenomeLabel;
    private JLabel cpfLabel;
    private JLabel telefoneLabel;
    private JLabel matriculaLabel;
    
    private JTextField prenomeField;
    private JTextField nomeField;
    private JTextField sobrenomeField;
    private JFormattedTextField cpfField;
    private JFormattedTextField telefoneField;
    private JFormattedTextField matriculaField;
    
    private JButton saveButton;
    private JButton deleteButtton;
    private JButton editButton;
    
    private AlunoTable alunoTable;
    private JScrollPane scrollPane;

    public AlunoFormView() 
    {
        setLayout(new MigLayout("wrap", "[77px,grow][86px,grow][46px][23px][86px][117.00px][38.00]", "[20px][][][][][][][grow][]"));
        
        createForm();          /* formulario */
        createFormatters();    /* formatadores */
        createActionButtons(); /* botoes de acao */
        createTableList();     /* inserir dados na tabela */
    }
    
    private void createForm()
    {
        titleLabel = new JLabel("Cadastro de alunos:");
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
        cpfField = new JFormattedTextField(cpfMask);
        cpfField.setColumns(14);
        add(cpfField, "cell 5 3,growx");
        
        /* telefone - label */
        telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(telefoneLabel, "cell 0 4,alignx right");
        /* telefone - field */
        telefoneField = new JFormattedTextField(phoneMask);
        telefoneField.setColumns(10);
        add(telefoneField, "cell 1 4 2 1,growx");
        
        /* matricula - label */
        matriculaLabel = new JLabel("Matrícula:");
        matriculaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(matriculaLabel, "cell 0 5,alignx right");
        /* matricula - field */
        matriculaField = new JFormattedTextField();
        add(matriculaField, "cell 1 5,growx");
        matriculaField.setColumns(10);
    }
    
    
    /**
     * Instancia os formatadores para o fomulario
     */
    public void createFormatters()
    {
        try
        {
            cpfMask = new MaskFormatter("###.###.###-##");
            cpfMask.setValueContainsLiteralCharacters(false);
            cpfMask.setValidCharacters("1234567890");
            cpfMask.install(cpfField);
            
            phoneMask = new MaskFormatter("(##) #####-####");
            phoneMask.setValidCharacters("1234567890");
            phoneMask.install(telefoneField);
            
            matriculaMask = new MaskFormatter("###-###-###");
            matriculaMask.setValidCharacters("1234567890");
            matriculaMask.install(matriculaField);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
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
    
    private void createActionButtons()
    {
        createSaveButton();
        createDeleteButton();
        createEditbutton();
    }
    
    private void createSaveButton()
    {
        /* save */
        saveButton = new JButton(SAVE);
        saveButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                InputMaskHandler cpfMaskHandler = new InputMaskHandler(); 
                InputMaskHandler phoneMaskHandler = new InputMaskHandler(); 
                InputMaskHandler matriculaMaskHandler = new InputMaskHandler(); 

                String unmaskedCpf = cpfMaskHandler.removeMaskFromFormattedText(cpfMask, cpfField);
                String unmaskedPhone = phoneMaskHandler.removeMaskFromFormattedText(phoneMask, telefoneField);
                String unmaskedMatricula = matriculaMaskHandler.removeMaskFromFormattedText(matriculaMask, matriculaField);
                
                if(validateForm())
                {
                    nomeField.setBackground(Color.WHITE);
                    sobrenomeField.setBackground(Color.WHITE);
                    telefoneField.setBackground(Color.WHITE);
                    
                    Aluno aluno = new Aluno(new Pessoa());
                    aluno.getPessoa().setPrenome(prenomeField.getText());
                    aluno.getPessoa().setNome(nomeField.getText());
                    aluno.getPessoa().setSobrenome(sobrenomeField.getText());
                    aluno.getPessoa().setCpf(unmaskedCpf);
                    aluno.getPessoa().setTelefone(unmaskedPhone);
                    aluno.setMatriculaAluno(unmaskedMatricula);
                    
                    AlunoDao dao = new AlunoDao(DatabaseConnector.getInstance());
                    dao.insert(aluno);
                   
                    alunoTable.addElement(aluno);
                   
                    clearInputs();
                }
            }
        });
        saveButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(saveButton, "flowx,cell 5 5,alignx right");
    }
    
    private void createDeleteButton()
    {
        /* delete */
        deleteButtton = new JButton(EXCLUDE);
        deleteButtton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
               int choice = JOptionPane.showInternalConfirmDialog(null, "Deseja remover esse registro?");
               if(choice == 0) /* yes */
               {
                   int id = (Integer) alunoTable.getValueAt(alunoTable.getSelectedRow(), 0);
                   AlunoDao dao = new AlunoDao(DatabaseConnector.getInstance());
                   
                   if(dao.deleteById(id +1)) /* rowcount begins at 0 */
                   {
                       alunoTable.removeElement(alunoTable.getSelectedRow());
                       JOptionPane.showMessageDialog(null, "Registro aluno deletado com sucesso.");
                   }
                   else 
                   {
                       JOptionPane.showMessageDialog(null, "Falha ao deletar registro.");
                   }
               }
               
               clearInputs();
            }
        });
        add(deleteButtton, "cell 6 5,growy");
    }
    
    private void createEditbutton()
    {
        /* edit */
        editButton = new JButton(EDIT);
        editButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(!isEditingRow()) /* loads table to form */ 
                {
                    setIsEditingRow(true);
                    
                    Integer id
                        = Integer.parseInt(alunoTable.getModel().getValueAt(alunoTable.getSelectedRow(), 0).toString());
                    
                    String[] nomeCompleto 
                        = alunoTable.getModel().getValueAt(alunoTable.getSelectedRow(), 1).toString().split(" ");
                    
                    String prenome   = nomeCompleto[0];
                    String nome      = nomeCompleto[1];
                    String sobrenome = nomeCompleto[2];
                    
                    String cpf 
                        = alunoTable.getModel()
                                    .getValueAt(alunoTable.getSelectedRow(), 2).toString();
                    
                    String telefone 
                        = alunoTable.getModel()
                                    .getValueAt(alunoTable.getSelectedRow(), 3).toString().substring(1);
                    
                    String matricula
                        = alunoTable.getModel()
                                    .getValueAt(alunoTable.getSelectedRow(), 4).toString();
                    
                    setSelectedId(id);
                    prenomeField.setText(prenome);
                    nomeField.setText(nome);
                    sobrenomeField.setText(sobrenome);
                    telefoneField.setText(telefone);
                    cpfField.setText(cpf);
                    matriculaField.setText(matricula);

                    editButton.setText(UPDATE);
               }
               else if(validateForm()) /* writes change to database */
               {
                   AlunoDao dao = new AlunoDao(DatabaseConnector.getInstance());
                   
                   Aluno aluno = new Aluno(new Pessoa(getSelectedId()));
                   aluno.getPessoa().setPrenome(prenomeField.getText());
                   aluno.getPessoa().setNome(nomeField.getText());
                   aluno.getPessoa().setSobrenome(sobrenomeField.getText());
                   aluno.getPessoa().setTelefone(telefoneField.getText());
                   aluno.getPessoa().setCpf(cpfField.getText());
                   aluno.setMatriculaAluno(matriculaField.getText());
                   
                   dao.update(aluno);
                   
                   /* update table row */
                   alunoTable.updateElement(alunoTable.getSelectedRow(), aluno);
                   
                   if(isEditingRow()) 
                   {
                       setIsEditingRow(false);
                       editButton.setText(EDIT);
                   }
               }
               else if(isFailedEditAttempt())
               {
                   setIsEditingRow(false);
                   editButton.setText(EDIT);  
               }
            }
        });
        add(editButton, "cell 5 5,growy");
    }
    
    /**
     * Validacao dos campos do formulario
     */
    private boolean validateForm() 
    {
        try
        {
            InputMaskHandler cpfMaskHandler = new InputMaskHandler(); 
            String unmaskedCpf = cpfMaskHandler.removeMaskFromFormattedText(cpfMask, cpfField);
            
            InputMaskHandler phoneMaskHandler = new InputMaskHandler(); 
            String unmaskedPhone = phoneMaskHandler.removeMaskFromFormattedText(phoneMask, telefoneField);
            
            if(!cpfField.getText().equals("")) 
            {
                if(!Valitations.validarCPF(unmaskedCpf)) 
                {
                    JOptionPane.showMessageDialog(null,
                        "O CPF " + cpfField.getText() + " é inválido."
                    );
                    
                    setFailedEditAttempt(true);
                    
                    return false;
                }
            }

            if(!telefoneField.getText().equals("")) 
            {
                if(!Valitations.validarTelefone(unmaskedPhone)) 
                {
                    JOptionPane.showMessageDialog(null,
                        "O Telefone " + telefoneField.getText() + " é inválido."
                    );
                    
                    setFailedEditAttempt(true);
                    
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
            
            setFailedEditAttempt(true);
            
            return false;
        }
        
        return true;
    }
    
    private void createTableList() 
    {
        alunoTable = new AlunoTable(); /* to be able to change JFrame from inside JTable */
        alunoTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        scrollPane = new JScrollPane(alunoTable);
        add(scrollPane, "cell 0 7 7 2,grow");
        
        alunoTable.fetchDataFromDatabase();
    }
    
    public boolean isEditingRow()
    {
        return editingRow;
    }
    private void setIsEditingRow(boolean status)
    {
        this.editingRow = status;
    }
    
    public boolean isFailedEditAttempt()
    {
        return failedEditAttempt;
    }
    private void setFailedEditAttempt(boolean failedEditAttempt)
    {
        this.failedEditAttempt = failedEditAttempt;
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
