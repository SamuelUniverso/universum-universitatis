package dev.asor.univitatis.view.tables;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TabelaPessoas extends JTable
{
	public TabelaPessoas()
	{
		gerarManequim();
	}
	
	private void gerarManequim()
	{
        /* !!apenas para testes!! */
        /* !!dados devem vir de arquivo .txt!! */
        Object[][] dados =
            {
              { "Sicrano"  , "77777777777" , "55519876554321" }
            , { "Fulano"   , "11111111111" , "55519876554321" }
            , { "Beltrano" , "99999999999" , "55519876554321" }
            };

        this.setModel(new DefaultTableModel(
                dados,
            new String[] {"Nome completo", "CPF", "Telefone"}
        ));
	}
}
