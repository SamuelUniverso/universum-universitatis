package dev.asor.univitatis.io;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

/**
 * @author dev.asor
 * @since 23.feb.2022
 */
public class CSVFileParser
{

	/**
	 * Gera uma string CSV a partir de um Map
	 * @method generateCSVFromMap
	 * @param dados : Map<Integer, ArrayList<String>>
	 * @throws ParseException 
	 */
	public static List<String> generateCSVListFromMap(Map< Integer, List<String> > map) 
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
	 */
	public static void writeCSVStringToFile(List<String> csvList)
	{
		try
		{
			Arquivo arquivo = new Arquivo("contatos.csv");
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
}
