package dev.asor.univitatis.view.gui.login;

import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dev.asor.univitatis.UnivitatisApp;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;

/**
 * @author dev.asor
 * @since may.2022
 */
public class LoginScreen extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;

    private JPanel panelScreen = null;
    
    private JTextField usuarioInput;
    private JTextField senhaInput;

    private JButton loginButton;
    
    public LoginScreen()
    {
        buildLoginScreen();
    }
       
    public void buildLoginScreen()
    {
        panelScreen = new JPanel();
        panelScreen.setLayout(new MigLayout("", "[][][][grow][]", "[][][][][][]"));
        getContentPane().add(panelScreen);
        
        JLabel usuarioLabel = new JLabel("Usuário:");
        usuarioLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panelScreen.add(usuarioLabel, "cell 1 1,alignx right");
        
        usuarioInput = new JTextField();
        panelScreen.add(usuarioInput, "cell 3 1,growx");
        usuarioInput.setColumns(10);
        
        Component verticalStrut = Box.createVerticalStrut(20);
        panelScreen.add(verticalStrut, "cell 0 2");
        
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panelScreen.add(senhaLabel, "cell 1 2,alignx right");
        
        senhaInput = new JTextField();
        panelScreen.add(senhaInput, "cell 3 2,growx");
        senhaInput.setColumns(10);
        
        loginButton = new JButton("Ingressar");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        loginButton.addActionListener(this);
        panelScreen.add(loginButton, "cell 3 4,alignx right");
  
        //this.pack();
        this.setSize(331, 166);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    /**
     * Validar o ingresso de usuario no sistema
     */
    public void authenticate()
    {
        if(true)
        {
            dispose();
            /* call on the Main class */
            UnivitatisApp.afterLogin();
        }
    }
    
    /**
     * Escuta para as acoes no botao de ingresso
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        authenticate();
    }
}
