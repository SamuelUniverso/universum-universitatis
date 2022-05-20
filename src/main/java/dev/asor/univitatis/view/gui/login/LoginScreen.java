package dev.asor.univitatis.view.gui.login;

import javax.swing.JDialog;

/**
 * @author dev.asor
 * @since may.2022
 */
public class LoginScreen
{
    private JDialog loginScreen = null;
    
    private boolean isAuthenticated = false;
    
    public LoginScreen()
    {
        buildLoginScreen();
    }
    
    public void buildLoginScreen()
    {
        loginScreen = new JDialog();

        loginScreen.pack();
        loginScreen.setLocationRelativeTo(null);
        loginScreen.setVisible(true);
    }
    
    public boolean isAuthenticated()
    {
        return this.isAuthenticated;
    }
}
