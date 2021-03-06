package dev.asor.univitatis.io;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

/**
 * @class CSVFileParser
 * @author dev.asor
 * @since february.2022
 */
public class CSVFileParser
{
	/**
	 * Gera uma string CSV a partir de um Map
	 * @method generateCSVFromMap
	 * @param Map<Integer, ArrayList<String>> map
	 * @throws ParseException 
	 * @return List<String>
	 */
	public static List<String> generateCSVListFromMap(Map<Integer, List<String>> map) 
	{
		List<String> csvOutput = new ArrayList<>();
		try
		{
			map.entrySet().forEach(row -> 
			{
				String line = row.getValue().toString();
				csvOutput.add(line.substring(1, line.length() -1));
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao gerar conteúdo CSV a partir do Map");
		}
		
		return csvOutput;
	}
		
	/**
	 * Grava o conteudo de uma String em arquivo CSV
	 * @method writeCSVToFile
	 * @param csvList : List<String>
	 * @return void
	 */
	public static void writeCSVStringToFile(List<String> csvList, String filepath)
	{
		try
		{
			Arquivo arquivo = new Arquivo(filepath); // 'folder/output.csv'
			arquivo.abrirEscrita();
			
			csvList.forEach(csv -> {
				arquivo.escreverLinha(csv);
			});
			
			arquivo.fecharArquivo();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo de dados CSV");
		}
	}
	
	/**
	 * Carrega o conteudo de um arquivo CSV
	 * @method loadCSVStringFromFile
     * @return List<String>
	 */
	public static List<String> loadCSVStringFromFile()
	{
		List<String> csvList = new ArrayList<String>();

		try
		{
			Arquivo arquivo = new Arquivo("contatos.csv");
			arquivo.abrirLeitura();

			String linha = arquivo.lerLinha();
			while(linha != null)
			{
				csvList.add(linha);
				linha = arquivo.lerLinha();
			}
			arquivo.fecharArquivo();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao carregar dados do arquivo CSV");
		}
		
		return csvList;
	}
}
