package dev.asor.univitatis.view.gui.cardpanel.form;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.text.Format;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import javax.swing.Box;

public class alunoFormView extends JPanel
{
    private static final long serialVersionUID = 1L;
    private JTextField nomeCompletoField;
    private JTextField cpfField;
    private JTextField telefoneField;

    public alunoFormView() 
    {
        setLayout(new MigLayout("wrap", "[77px][86px][46px][23px][86px][86px]", "[20px][][][][][]"));
        
        JLabel titleLabel = new JLabel("Cadastro de alunos:");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(titleLabel, "cell 0 0 2 1");
        
        JLabel nomeCompletoLabel = new JLabel("Nome completo:");
        nomeCompletoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(nomeCompletoLabel, "cell 0 2,alignx right");
        
        nomeCompletoField = new JTextField();
        nomeCompletoField.setColumns(10);
        add(nomeCompletoField, "cell 1 2 4 1,growx");
        
        JLabel cpfLabel = new JLabel("CPF:");
        add(cpfLabel, "cell 0 3,alignx right");
        
        MaskFormatter cpfMask = null;
        try
        {
            cpfMask = new MaskFormatter("###.###.###-##");
        } 
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        cpfField = new JTextField();
        cpfField.setColumns(14);
        add(cpfField, "cell 1 3,growx");
        
        JLabel telefoneLabel = new JLabel("Telefone:");
        add(telefoneLabel, "cell 0 4,alignx right");
        
        telefoneField = new JTextField();
        telefoneField.setColumns(10);
        add(telefoneField, "cell 1 4 2 1,growx");
    }
}
