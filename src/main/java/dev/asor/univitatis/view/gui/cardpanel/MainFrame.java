package dev.asor.univitatis.view.gui.cardpanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import dev.asor.univitatis.io.CSVFileParser;
import dev.asor.univitatis.model.Contato;
import dev.asor.univitatis.utils.PictureHandler;
import dev.asor.univitatis.view.gui.cardpanel.form.alunoFormView;
import dev.asor.univitatis.view.gui.cardpanel.form.professorFormView;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.Component;
import javax.swing.Box;

/**
 * @class MainView
 * @author dev.asor
 * @since february.2022
 */
public class MainFrame extends JFrame 
{
    private static final long serialVersionUID = 1L;
    private static final String imagemLogoUni = "univates_logo.jpg";
	
	private JPanel containerPanel;
	private JPanel leftMenuSection;
	
	private JPanel panelAluno;
	private JPanel panelProfessor;
	private JLayeredPane formSection;
	
	public static void main(String args[])
	{
	    new MainFrame();
	}

	public MainFrame() 
	{
		configureView();
		
		addTitleToView();
		addLeftMenuToView();
		addFormSectionToView();
		addFormCardToView();
	}
	
	/**
	 * Inicializa configuracoes basicas do Painel
	 * @method configurarView
	 * @return void
	 */
	private void configureView()
	{
		setBounds(100, 100, 663, 565);
		containerPanel = new JPanel();
		containerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(containerPanel);
	}
	
	/**
	 * Adiciona o titulo na View
	 * @method addTitle
	 * @reutrn void
	 */
	private void addTitleToView()
	{
	    PictureHandler picHandler = new PictureHandler();
	    ImageIcon logoIcon = picHandler.resizeIcon(72, 72, imagemLogoUni);
      
        containerPanel.setLayout(new MigLayout("", "[98px,left][14px,left][511px,left][left]", "[86px][402px]"));
	        
		JPanel titleSection = new JPanel();
		titleSection.setBackground(UIManager.getColor("Button.light"));
		titleSection.setLayout(new MigLayout("", "[299px][72px][][][][][][][][][]", "[72px]"));
		
		JLabel labelTitulo = new JLabel(" UNIVITATIS - Universum Universitatis");
		labelTitulo.setIcon(logoIcon);
		labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 17));
		titleSection.add(labelTitulo, "cell 0 0 11 1,alignx left,growy");
		
		containerPanel.add(titleSection, "cell 0 0 3 1,growx,aligny top");
	}
	
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
                formSection.removeAll();
                formSection.add(panelAluno, "panelAluno");
                formSection.repaint();
                formSection.revalidate();
            }
        });
        btnAlunos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        leftMenuSection.add(btnAlunos, "cell 0 1,growx");
        
        JButton btnProfessores = new JButton("Professores");
        btnProfessores.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                formSection.removeAll();
                formSection.add(panelProfessor, "panelProfessor");
                formSection.repaint();
                formSection.revalidate();
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
	    formSection = new JLayeredPane();
        containerPanel.add(formSection, "cell 2 1,alignx left,growy");
        formSection.setLayout(new CardLayout(0, 0));
	}
	
	public void addFormSectionToView()
	{
        panelAluno = new alunoFormView();
        panelProfessor = new professorFormView();
	}

	/**
	 * Grava os dados vindos da JTable num CSV
	 * @method gravarEmCSV
	 * @param modelo : TableModel
	 */
	@Deprecated
	private void gravarCSV(TableModel modelo)
	{
		Map<Integer, List<String>> mapaTabela = new HashMap<>();
		for(int i = 0; i < modelo.getRowCount(); i++)
		{
			ArrayList<String> linha = new ArrayList<String>();
			linha.add(modelo.getValueAt(i, 0).toString());
			linha.add(modelo.getValueAt(i, 1).toString());
			linha.add(modelo.getValueAt(i, 2).toString());
			linha.add(modelo.getValueAt(i, 3).toString());
			
			mapaTabela.put(i, linha);
		}
		
		List<String> conteudoCSV = CSVFileParser.generateCSVListFromMap(mapaTabela);
		CSVFileParser.writeCSVStringToFile(conteudoCSV);
		
		JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");
	}
	
	@Deprecated
	private List<Contato> carregarDadosCSV()
	{
		List<String> contatosArquivo = CSVFileParser.loadCSVStringFromFile();

		List<Contato> contatosTabela = new ArrayList<>();
		contatosArquivo.forEach(contato -> { 
			
			Contato novoContato = new Contato();
			String[] novo = contato.split(";");
			
			novoContato.setNome(novo[1].trim());
			novoContato.setCpf(novo[2].trim());
			novoContato.setTelefone(novo[3].trim());
			
			contatosTabela.add(novoContato);
		});
		
		return contatosTabela;
	}
}
