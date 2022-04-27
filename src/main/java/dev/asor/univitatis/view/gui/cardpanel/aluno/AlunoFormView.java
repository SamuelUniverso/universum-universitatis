package dev.asor.univitatis.view.gui.cardpanel.aluno;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class AlunoFormView extends JPanel 
{
    private static final long serialVersionUID = 1L;
    
    private JTextField nomeCompletoField;
    private JTextField cpfField;
    private JTextField telefoneField;
    private JTextField textField;
    private JTextField sobrenomeField;
    private JTextField matriculaField;

    public AlunoFormView() 
    {
        setLayout(new MigLayout("wrap", "[77px,grow][86px,grow][46px][23px][86px][117.00px][38.00]", "[20px][][][][][][][grow][]"));
        
        JLabel titleLabel = new JLabel("Cadastro de alunos:");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(titleLabel, "cell 0 0 2 1");
        
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(nomeLabel, "cell 0 2,alignx right");
        
        nomeCompletoField = new JTextField();
        nomeCompletoField.setColumns(10);
        add(nomeCompletoField, "cell 1 2 2 1,growx");
        
        JLabel prenomeLabel = new JLabel("Prenome:");
        add(prenomeLabel, "cell 4 2,alignx trailing");
        
        textField = new JTextField();
        add(textField, "cell 5 2,growx");
        textField.setColumns(10);
        
        JLabel sobrenomeLabel = new JLabel("Sobrenome:");
        add(sobrenomeLabel, "cell 0 3,alignx trailing");
        
        sobrenomeField = new JTextField();
        add(sobrenomeField, "cell 1 3 2 1,growx");
        sobrenomeField.setColumns(10);
        
        JLabel cpfLabel = new JLabel("CPF:");
        add(cpfLabel, "cell 4 3,alignx right");
        
        cpfField = new JTextField();
        cpfField.setColumns(14);
        add(cpfField, "cell 5 3,growx");
        
        JLabel telefoneLabel = new JLabel("Telefone:");
        add(telefoneLabel, "cell 0 4,alignx right");
        
        telefoneField = new JTextField();
        telefoneField.setColumns(10);
        add(telefoneField, "cell 1 4 2 1,growx");
        
        JLabel matriculaLabel = new JLabel("Matrícula:");
        add(matriculaLabel, "cell 0 5,alignx right");
        
        matriculaField = new JTextField();
        add(matriculaField, "cell 1 5,growx");
        matriculaField.setColumns(10);
        
        JButton btnNewButton = new JButton("Salvar");
        add(btnNewButton, "cell 5 5");
        
        JScrollPane previewList = new JScrollPane();
        add(previewList, "cell 0 7 7 2,grow");
    }
}
