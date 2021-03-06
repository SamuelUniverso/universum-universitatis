package dev.asor.univitatis.view.gui.login;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dev.asor.univitatis.UnivitatisApp;
import dev.asor.univitatis.control.LoginHandler;
import dev.asor.univitatis.utils.PictureHandler;

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
    
    private static final String imagemLogoUni = "univates-logo.jpg";

    private JPanel panelScreen;
    
    private JTextField usuarioInput;
    private JTextField senhaInput;

    private JButton loginButton;
    private JLabel lblNewLabel;
    private Component horizontalStrut;
    private Component verticalStrut_1;
    private Component horizontalStrut_1;
    
    public LoginScreen()
    {
        buildLoginScreen();
    }
       
    public void buildLoginScreen()
    {
        PictureHandler picHandler = new PictureHandler();
        this.setIconImage(picHandler.resizeImage(72, 72, imagemLogoUni));
        
        panelScreen = new JPanel();
        panelScreen.setLayout(new MigLayout("", "[][][][grow][]", "[][][][][][][]"));
        getContentPane().add(panelScreen);
        
        lblNewLabel = new JLabel("UNIVERSUM UNIVERSITATIS");
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panelScreen.add(lblNewLabel, "cell 1 0 3 1");
        
        horizontalStrut = Box.createHorizontalStrut(20);
        panelScreen.add(horizontalStrut, "cell 0 1");
        
        JLabel usuarioLabel = new JLabel("Usuário:");
        usuarioLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panelScreen.add(usuarioLabel, "cell 1 2,alignx right");
        
        usuarioInput = new JTextField();
        panelScreen.add(usuarioInput, "cell 3 2,growx");
        usuarioInput.setColumns(10);
        
        verticalStrut_1 = Box.createVerticalStrut(20);
        panelScreen.add(verticalStrut_1, "cell 4 2");
        
        Component verticalStrut = Box.createVerticalStrut(20);
        panelScreen.add(verticalStrut, "cell 0 3");
        
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panelScreen.add(senhaLabel, "cell 1 3,alignx right");
        
        senhaInput = new JPasswordField();
        panelScreen.add(senhaInput, "cell 3 3,growx");
        senhaInput.setColumns(10);
        
        loginButton = new JButton("Ingressar");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        loginButton.addActionListener(this);
        
        horizontalStrut_1 = Box.createHorizontalStrut(20);
        panelScreen.add(horizontalStrut_1, "cell 4 3");
        panelScreen.add(loginButton, "cell 3 5,alignx right");
  
        //this.pack();
        this.setSize(331, 183);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    /**
     * Validar o ingresso de usuario no sistema
     */
    public void authenticate()
    {
        LoginHandler login = new LoginHandler(usuarioInput.getText(), senhaInput.getText());
        if(login.isLoginAllowed())
        {
            dispose();
            UnivitatisApp.afterLogin(); /* call on the Main GUI */
        }
        else
        {
            JOptionPane.showMessageDialog(
                    null, 
                    "Autenticação falhou!\r\nTente novamente."
            );
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
