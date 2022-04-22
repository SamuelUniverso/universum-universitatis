package dev.asor.univitatis.view.gui.main.pessoas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

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

/**
 * @class MainView
 * @author dev.asor
 * @since february.2022
 */
@SuppressWarnings("serial")
public class FramePessoas extends JFrame 
{
	private static final String imagemLogoUni = "univates_logo.jpg";
	
	private JPanel painelPrincipal;
	private TablePessoas tabelaPessoas;
	
	private JLabel labelNomeCompleto;
	private JLabel labelCpf;
	private JLabel labelTelefone;
	
	private JTextField inputNomeCompleto;
	private JTextField inputCpf;
	private JTextField inputTelefone;

	public FramePessoas() 
	{
		configurarView();
		adicionarConteudo();
	}
	
	/**
	 * Esvazia todos os campos de Input do cadastro
	 * @method limparInputs
	 * @return void
	 */
	private void limparInputs()
	{
		inputNomeCompleto.setText(null);
		inputCpf.setText(null);
		inputTelefone.setText(null);
	}
	
	/**
	 * Inicializa configuracoes basicas do Painel
	 * @method configurarView
	 * @return void
	 */
	private void configurarView()
	{
		setBounds(100, 100, 663, 555);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);	
	}
	
	/**
	 * Adiciona os elementos visuais ao Painel
	 * @method adicionarConteudo
	 * @reutrn void
	 */
	private void adicionarConteudo()
	{
		/* Conteudo carregado na tabela pelo construtor de na TabelaPessoas */
		tabelaPessoas = new TablePessoas(carregarDadosCSV());
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBounds(10, 11, 627, 57);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel labelTitulo = new JLabel("UNIVITATIS - Universum Universitatis");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 17));
		painelTitulo.add(labelTitulo);
		
		
		JLabel labelLogo = new JLabel("LOGO");
		labelLogo.setHorizontalAlignment(SwingConstants.RIGHT);

		PictureHandler picHandler = new PictureHandler();
	    labelLogo.setIcon(picHandler.resizeIcon(72, 72, imagemLogoUni));
        labelLogo.setBounds(559, 11, 72, 72);
        labelLogo.setText(null);
        
		painelTitulo.add(labelLogo);
		
		
		JTabbedPane painelTabulado = new JTabbedPane(JTabbedPane.TOP);
		painelTabulado.setBounds(10, 79, 627, 426);
		painelPrincipal.add(painelTabulado);
		
		JPanel painelLista = new JPanel();
		painelLista.setLayout(null);
		painelTabulado.addTab("Listagem", null, painelLista, null);
		
		JScrollPane painelRolagem = new JScrollPane();
		painelRolagem.setBounds(0, 0, 622, 353);
		painelLista.add(painelRolagem);
		
		painelRolagem.setViewportView(tabelaPessoas);
		
		JButton buttonExcluir = new JButton("Excluir");
		buttonExcluir.setBounds(533, 364, 89, 23);
		painelLista.add(buttonExcluir);
		
		JButton buttonEditar = new JButton("Editar");
		buttonEditar.setEnabled(false);
		buttonEditar.setBounds(434, 364, 89, 23);
		painelLista.add(buttonEditar);
		
		JPanel painelCadastro = new JPanel();
		painelCadastro.setLayout(null);
		painelTabulado.addTab("Cadastro", null, painelCadastro, null);
		
		labelNomeCompleto = new JLabel("Nome completo:");
		labelNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelNomeCompleto.setBounds(10, 30, 92, 14);
		painelCadastro.add(labelNomeCompleto);
		
		inputNomeCompleto = new JTextField();
		inputNomeCompleto.setBounds(112, 27, 221, 20);
		painelCadastro.add(inputNomeCompleto);
		inputNomeCompleto.setColumns(10);
		
		labelTelefone = new JLabel("Telefone:");
		labelTelefone.setBounds(10, 111, 67, 14);
		painelCadastro.add(labelTelefone);
		
		labelCpf = new JLabel("CPF:");
		labelCpf.setBounds(10, 71, 46, 14);
		painelCadastro.add(labelCpf);
		
		inputCpf = new JTextField();
		inputCpf.setBounds(112, 68, 221, 20);
		painelCadastro.add(inputCpf);
		inputCpf.setColumns(10);
		
		inputTelefone = new JTextField();
		inputTelefone.setBounds(112, 108, 221, 20);
		painelCadastro.add(inputTelefone);
		inputTelefone.setColumns(10);
		
		JButton buttonSalvar = new JButton("Salvar");
		/* clicar no botao 'Salvar' */
		buttonSalvar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					if(    inputNomeCompleto.getText().equals("") 
					    || inputCpf.getText().equals("") 
					    || inputTelefone.getText().equals("")
					   )
					{
						inputNomeCompleto.setBackground(Color.GRAY);
						inputNomeCompleto.setForeground(Color.WHITE);
						
						inputCpf.setBackground(Color.GRAY);
						inputCpf.setForeground(Color.WHITE);
						
						inputTelefone.setBackground(Color.GRAY);
						inputTelefone.setForeground(Color.WHITE);
						
						throw new IllegalArgumentException("Formulário incompleto! \r\n Confira os dados e tente novamente.");
					}
				}
				catch(IllegalArgumentException exception) 
				{
					limparInputs();
					JOptionPane.showMessageDialog(null, exception.getMessage());
					
					return;
				}
				
				inputNomeCompleto.setBackground(Color.WHITE);
				inputCpf.setBackground(Color.WHITE);
				inputTelefone.setBackground(Color.WHITE);
				
				Contato contato = new Contato();
				contato.setNome(inputNomeCompleto.getText());
				contato.setCpf(inputCpf.getText());
				contato.setTelefone(inputTelefone.getText());
				
				tabelaPessoas.adicionarContato(contato);
				
				/* gravar em CSV */
				gravarCSV(tabelaPessoas.getModel());
			}
		});
		buttonSalvar.setBounds(523, 364, 89, 23);
		painelCadastro.add(buttonSalvar);
	}
	
	/**
	 * Grava os dados vindos da JTable num CSV
	 * @method gravarEmCSV
	 * @param modelo : TableModel
	 */
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
		 
		limparInputs();
	}
	
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
