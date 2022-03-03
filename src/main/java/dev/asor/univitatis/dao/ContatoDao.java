package dev.asor.univitatis.dao;

import java.util.ArrayList;
import java.util.List;

import dev.asor.univitatis.model.Contato;

/**
 * @author dev.asor
 * @since 23.feb.2022
 */
public class ContatoDao 
{
	private List<Contato> contatos;
	
	public ContatoDao()
	{
		setContatos(new ArrayList<Contato>());
	}
	
	public ContatoDao(List<Contato> contatos)
	{
		setContatos(contatos);
	}
	

	public List<Contato> getContatos() {
		return contatos;
	}

	private void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

}
