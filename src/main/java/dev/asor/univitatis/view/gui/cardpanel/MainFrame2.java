package dev.asor.univitatis.view.gui.cardpanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import dev.asor.univitatis.utils.PictureHandler;
import dev.asor.univitatis.view.gui.cardpanel.aluno.AlunoFormView;
import dev.asor.univitatis.view.gui.cardpanel.professor.ProfessorFormView;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;

/**
 * @class MainView
 * @author dev.asor
 * @since february.2022
 */
public class MainFrame2 extends JFrame 
{
    private static final long serialVersionUID = 1L;
    private static final String imagemLogoUni = "univates-logo.jpg";
	
	private JPanel containerPanel;
	private JPanel leftMenuSection;
	private JLayeredPane formGroup;
	
	private JPanel formAluno;
	private JPanel formProfessor;
	
	public MainFrame2(Integer width, Integer height) 
	{
		configureView(width, height);
		
		addTitleToView();
		addLeftMenuToView();
		addFormCardToView();
	}
	
	/**
	 * Inicializa configuracoes basicas do Painel base do Frame
	 */
	private void configureView(Integer width, Integer height)
	{
		setBounds(100, 100, width, height);
		containerPanel = new JPanel();
		containerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(containerPanel);
		setLocationRelativeTo(null);
	}
	
	/**
	 * Adiciona a barra de titulo na View
	 */
	private void addTitleToView()
	{
	    PictureHandler picHandler = new PictureHandler();
	    ImageIcon logoIcon = picHandler.resizeIcon(72, 72, imagemLogoUni);
      
        containerPanel.setLayout(new MigLayout("", "[98px,left][14px,left][511px,grow,left][left]", "[86px][402px,grow]"));
	        
		JPanel titleSection = new JPanel();
		titleSection.setBackground(UIManager.getColor("Button.light"));
		titleSection.setLayout(new MigLayout("", "[299px][72px][][][][][][][][][]", "[72px]"));
		
		JLabel labelTitulo = new JLabel(" UNIVITATIS - Universum Universitatis");
		labelTitulo.setIcon(logoIcon);
		labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 17));
		titleSection.add(labelTitulo, "cell 0 0 11 1,alignx left,growy");
		
		containerPanel.add(titleSection, "cell 0 0 3 1,growx,aligny top");
	}
	
	/**
	 * Adiciona menu esquerdo na View
	 */
	public void addLeftMenuToView()
	{
	    leftMenuSection = new JPanel();
        leftMenuSection.setBackground(UIManager.getColor("Button.light"));
        containerPanel.add(leftMenuSection, "cell 0 1 2 1,alignx left,growy");
        leftMenuSection.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][][]"));
        
        JButton btnAlunos = new JButton("Alunos");
        btnAlunos.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                 repaintPanel("formAluno", formAluno);
            }
        });
        btnAlunos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        leftMenuSection.add(btnAlunos, "cell 0 1,growx");
        
        JButton btnProfessores = new JButton("Professores");
        btnProfessores.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                repaintPanel("formProfessor", formProfessor);
            }
        });
        btnProfessores.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        leftMenuSection.add(btnProfessores, "cell 0 2,growx");
        
        JButton btnMatriculas = new JButton("Matículas");
        btnMatriculas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        leftMenuSection.add(btnMatriculas, "cell 0 3,growx");
        
        JButton btnContratos = new JButton("Contratos");
        btnContratos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        leftMenuSection.add(btnContratos, "cell 0 5,growx");
        
        JButton btnTurmas = new JButton("Turmas");
        btnTurmas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        leftMenuSection.add(btnTurmas, "cell 0 7,growx");
        
        JButton btnDisciplinas = new JButton("Disciplinas");
        btnDisciplinas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        leftMenuSection.add(btnDisciplinas, "cell 0 8,growx");
        
        JButton btnPeriodos = new JButton("Períodos");
        btnPeriodos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        leftMenuSection.add(btnPeriodos, "cell 0 9,growx");
        
        JButton btnSair = new JButton("Sair");
        btnSair.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnSair.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(DO_NOTHING_ON_CLOSE);
            }
        });
        leftMenuSection.add(btnSair, "cell 0 13,growx");
	}
	
	public void addFormCardToView()
	{
	    formGroup = new JLayeredPane();
	    containerPanel.add(formGroup, "flowx,cell 2 1,alignx left,growy");
	    formGroup.setLayout(new CardLayout(0, 0)); 
	    
	    /* Instancia os paineis do CardPanel */
	    formAluno = new AlunoFormView();
	    formProfessor = new ProfessorFormView();
	}
	
	/**
	 * Realiza a alternancia entre os paineis do CardPanel
	 * @param name
	 * @param panel
	 */
	private void repaintPanel(String name, JPanel panel)
	{
	    if(!panel.isShowing())
	    {
	        formGroup.removeAll();
	        formGroup.add(panel, name);
	        formGroup.repaint();
	        formGroup.revalidate();
	        panel.setVisible(panel.isVisible() ? true : false);
	    }
	    else
	    {
            formGroup.removeAll();
            formGroup.repaint();
            formGroup.revalidate();
            panel.setVisible(panel.isVisible() ? true : false);
	    }
	}
}
