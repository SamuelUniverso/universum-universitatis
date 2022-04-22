package dev.asor.univitatis.view.gui.cardpanel.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class PanelAluno extends JPanel
{
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    public PanelAluno() {
        setLayout(new MigLayout("", "[77px][86px,grow][46px][23px][86px][86px]", "[20px][][][][][]"));
        
        JLabel lblNewLabel = new JLabel("Cadastro de alunos:");
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(lblNewLabel, "cell 0 0 2 1");
        
        JLabel labelNomeCompleto = new JLabel("Nome completo:");
        labelNomeCompleto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(labelNomeCompleto, "cell 0 2,alignx right");
        
        textField = new JTextField();
        textField.setColumns(10);
        add(textField, "cell 1 2 4 1,growx");
        
        JLabel labelCpf = new JLabel("CPF:");
        add(labelCpf, "cell 0 3,alignx right");
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        add(textField_1, "cell 1 3,growx");
        
        JLabel labelTelefone = new JLabel("Telefone:");
        add(labelTelefone, "cell 0 4,alignx right");
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        add(textField_2, "cell 1 4 2 1,growx");}

}
