package dev.asor.univitatis.view.gui.cardpanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import dev.asor.univitatis.io.CSVFileParser;
import dev.asor.univitatis.model.Contato;
import dev.asor.univitatis.utils.PictureHandler;
import dev.asor.univitatis.view.gui.main.pessoas.TablePessoas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;

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
	
	public static void main(String args[])
	{
	    new MainFrame();
	}

	public MainFrame() 
	{
		configureView();
		
		addTitleToView();
		addLeftMenuToView();
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
		JPanel titleSection = new JPanel();
		titleSection.setBackground(UIManager.getColor("Button.light"));
		titleSection.setLayout(new MigLayout("", "[303px][][302px]", "[72px]"));
		
		JLabel labelTitulo = new JLabel("UNIVITATIS - Universum Universitatis");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 17));
		titleSection.add(labelTitulo, "cell 0 0,grow");

		PictureHandler picHandler = new PictureHandler();
	    containerPanel.setLayout(new MigLayout("", "[98px,grow][14px][511px]", "[86px][402px,grow]"));
		
		containerPanel.add(titleSection, "cell 0 0 3 1,growx,aligny top");
		
		JLabel labelLogo = new JLabel("LOGO");
		labelLogo.setIcon(picHandler.resizeIcon(72, 72, imagemLogoUni));
		labelLogo.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLogo.setBounds(559, 11, 72, 72);
		labelLogo.setText(null);
		
		titleSection.add(labelLogo, "cell 2 0,alignx right,growy");
	}
	
	public void addLeftMenuToView()
	{
        
        JPanel leftMenuSection = new JPanel();
        leftMenuSection.setBackground(UIManager.getColor("Button.light"));
        containerPanel.add(leftMenuSection, "cell 0 1 2 1,grow");
        
        JPanel formSection = new JPanel();
        formSection.setBackground(UIManager.getColor("Button.light"));
        containerPanel.add(formSection, "cell 2 1,grow");
        formSection.setLayout(new MigLayout("", "[]", "[]"));
	}
	
	/**
     * Limpa todos os campos de Input do cadastro
     * @method clearInputs
     * @return void
     */
    private void clearInputs()
    {
        //inputNomeCompleto.setText(null);
        //inputCpf.setText(null);
        //inputTelefone.setText(null);
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
		 
		clearInputs();
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
