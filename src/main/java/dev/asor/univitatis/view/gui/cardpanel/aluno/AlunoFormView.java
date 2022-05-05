package dev.asor.univitatis.view.gui.cardpanel.aluno;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author dev.asor
 * @since march.2022
 */
public class AlunoFormView extends JPanel 
{
    private static final long serialVersionUID = 1L;
    
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
    
    private AlunoTable alunoTable;
    private JScrollPane scrollPane;

    public AlunoFormView() 
    {
        setLayout(new MigLayout("wrap", "[77px,grow][86px,grow][46px][23px][86px][117.00px][38.00]", "[20px][][][][][][][grow][]"));
        
        createForm();          /* formulario */
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
            }
        });
        add(deleteButtton, "cell 6 5");
        
        /* edit */
        editButton = new JButton("Editar");
        editButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            }
        });
        add(editButton, "cell 5 5");
    }
    
    private void createTableList()
    {
        alunoTable = new AlunoTable();
        alunoTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        scrollPane = new JScrollPane(alunoTable);
        add(scrollPane, "cell 0 7 7 2,grow");
        
        alunoTable.fetchDataFromDatabase();
    }
}
