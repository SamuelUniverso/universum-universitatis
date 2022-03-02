package dev.asor.univitatis.view;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dev.asor.univitatis.model.Contato;
import dev.asor.univitatis.view.tables.TabelaPessoas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author dev.asor
 * @since 23.feb.2022
 */
@SuppressWarnings("serial")
public class MainView extends JFrame 
{
	private static final String LOGO_PATH = "/images/univates_logo.jpg";
	
	private JPanel painelPrincipal;
	private TabelaPessoas tabelaPessoas;
	
	private JLabel labelNomeCompleto;
	private JLabel labelCpf;
	private JLabel labelTelefone;
	
	private JTextField inputNomeCompleto;
	private JTextField inputCpf;
	private JTextField inputTelefone;

	public MainView() 
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
		try
		{
	        BufferedImage img = null;
	        img = ImageIO.read(new File(getClass().getResource(LOGO_PATH).getFile()));
	        Image dimg = img.getScaledInstance(72, 72, Image.SCALE_SMOOTH);
	        labelLogo.setIcon(new ImageIcon(dimg));
	        labelLogo.setBounds(559, 11, 72, 72);
	        labelLogo.setText(null);
       	}
        catch (IOException e)
        {
            e.printStackTrace();
        }
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
		
		tabelaPessoas = new TabelaPessoas();
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
				contato.setNomeCompleto(inputNomeCompleto.getText());
				contato.setCpf(inputCpf.getText());
				contato.setTelefone(inputTelefone.getText());
				
				tabelaPessoas.adicionarContato(contato);
			}
		});
		buttonSalvar.setBounds(523, 364, 89, 23);
		painelCadastro.add(buttonSalvar);
	}
}
