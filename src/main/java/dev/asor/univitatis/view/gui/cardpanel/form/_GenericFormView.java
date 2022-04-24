package dev.asor.univitatis.view.gui.cardpanel.form;

import javax.swing.JPanel;

public class _GenericFormView extends JPanel
{
    private static final long serialVersionUID = 1L;
    
    private boolean isShowing;
    
    _GenericFormView()
    {
        isShowing = false;
    }
    
    public boolean isShowing()
    {
        return isShowing;
    }
    
    public void changeShowingState()
    {
        if(isShowing)
        {
            isShowing = false;
        }
        else
        {
            isShowing = true;
        }
    }
}
