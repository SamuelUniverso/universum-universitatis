package dev.asor.univitatis.view.gui.main.pessoas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dev.asor.univitatis.model.Contato;

/**
 * @class TabelaPessoas
 * @author dev.asor
 * @since february.2022
 */
@SuppressWarnings("serial")
public class TablePessoas extends JTable
{
	private static final String HEADER_CODIGO = "Código";
	private static final String HEADER_NOME = "Nome completo";
	private static final String HEADER_CPF = "CPF";
	private static final String HEADER_TELEFONE = "Telefone";
	
	private DefaultTableModel modelo;
	
	public TablePessoas(List<Contato> contatos)
	{
		carregarConteudoNaTabela(contatos);
	}
	
	public TablePessoas()
	{
		gerarTabela();
//		gerarDadosManequim();
	}
	
	/**
	 * Cria a estrutura padrao da tabela
	 * @method gerarTabela
	 * @return void
	 */
	private void gerarTabela()
	{
		if(modelo == null)
		{
			modelo = new DefaultTableModel();
		}
		
		modelo.addColumn(HEADER_CODIGO);
		modelo.addColumn(HEADER_NOME);
		modelo.addColumn(HEADER_CPF);
		modelo.addColumn(HEADER_TELEFONE);
	}
	
	/**
	 * Adiciona um contato na Tabela
	 * @method adicionarContato 
	 * @param contato
	 * @return void
	 */
	public void adicionarContato(Contato contato)
	{
		if(modelo == null)
		{
			gerarTabela();
		}
			
		Object[] objeto = new Object[] { null
									   , contato.getNome()
									   , contato.getCpf()
									   , contato.getTelefone()
									   };
		objeto[0] = modelo.getRowCount() +1; /* incrementando 'generated_id' da tabela */
		
		modelo.addRow(objeto);
	}
	
   /**
    * Gera dados de amostra para inserir na tabela
    * @notice apenas para fins de testes
    * @method gerarDadosManequim
    * @return void
    */
	@SuppressWarnings("unused")
	private void gerarDadosManequim()
	{
		ArrayList<Contato> contatos = new ArrayList<Contato>();
		contatos.add(new Contato("Sicrano"  , "77777777777" , "55519876554321"));
		contatos.add(new Contato("Fulano"   , "11111111111" , "55519876554321"));
		contatos.add(new Contato("Beltrano" , "99999999999" , "55519876554321"));
		
		for(Contato contato : contatos)
		{
			adicionarContato(contato);
		}
		
		setModel(modelo);
		getColumnModel().getColumn(0).setPreferredWidth(7);
	}
	
	private void carregarConteudoNaTabela(List<Contato> contatos)
	{
		contatos.forEach(contato -> {
			adicionarContato(contato);
		});
		
		setModel(modelo);
		getColumnModel().getColumn(0).setPreferredWidth(7);
	}
}
