package dev.asor.univitatis.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * @author dev.asor
 * @since 23.feb.2022
 */
@SuppressWarnings("serial")
public class MainView extends JFrame 
{
	private JPanel painelPrincipal;
	private JTextField inputNome;
	private JTextField inputTelefone;

	public MainView() 
	{
		setBounds(100, 100, 663, 555);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
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
	        img = ImageIO.read(new File(getClass().getResource("/images/univates_logo.jpg").getFile()));
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
		
		JPanel painelCadastro = new JPanel();
		painelCadastro.setLayout(null);
		painelTabulado.addTab("Cadastro", null, painelCadastro, null);
		
		JLabel labelNomeCompleto = new JLabel("Nome completo:");
		labelNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelNomeCompleto.setBounds(10, 30, 92, 14);
		painelCadastro.add(labelNomeCompleto);
		
		inputNome = new JTextField();
		inputNome.setBounds(112, 27, 221, 20);
		painelCadastro.add(inputNome);
		inputNome.setColumns(10);
		
		JLabel labelTelefone = new JLabel("Telefone:");
		labelTelefone.setBounds(10, 61, 46, 14);
		painelCadastro.add(labelTelefone);
		
		inputTelefone = new JTextField();
		inputTelefone.setBounds(112, 58, 221, 20);
		painelCadastro.add(inputTelefone);
		inputTelefone.setColumns(10);
		
		JButton buttonSalvar = new JButton("Salvar");
		buttonSalvar.setBounds(523, 364, 89, 23);
		painelCadastro.add(buttonSalvar);
	}
}
