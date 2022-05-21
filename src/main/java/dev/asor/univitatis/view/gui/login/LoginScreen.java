package dev.asor.univitatis.view.gui.login;

import javax.swing.JDialog;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * @author dev.asor
 * @since may.2022
 */
public class LoginScreen
{
    private JDialog loginScreen = null;
    private JPanel panelScreen = null;
    
    private boolean isAuthenticated = false;
    private JTextField usuarioInput;
    private JTextField senhaInput;
    
    public LoginScreen()
    {
        buildLoginScreen();
    }
    
    public void buildLoginScreen()
    {
        loginScreen = new JDialog();
        panelScreen = new JPanel();
        
        loginScreen.getContentPane().add(panelScreen);
        panelScreen.setLayout(new MigLayout("", "[][][grow]", "[][][][][]"));
        
        JLabel usuarioLabel = new JLabel("Usuário:");
        panelScreen.add(usuarioLabel, "cell 0 1,alignx trailing");
        
        usuarioInput = new JTextField();
        panelScreen.add(usuarioInput, "cell 2 1,growx");
        usuarioInput.setColumns(10);
        
        JLabel senhaLabel = new JLabel("Senha:");
        panelScreen.add(senhaLabel, "cell 0 2,alignx right");
        
        senhaInput = new JTextField();
        panelScreen.add(senhaInput, "cell 2 2,growx");
        senhaInput.setColumns(10);
        
        JButton loginButton = new JButton("Ingressar");
        panelScreen.add(loginButton, "cell 2 4,alignx right");

//        loginScreen.pack();
        loginScreen.setLocationRelativeTo(null);
        loginScreen.setVisible(true);
    }
    
    public boolean isAuthenticated()
    {
        return this.isAuthenticated;
    }
}
