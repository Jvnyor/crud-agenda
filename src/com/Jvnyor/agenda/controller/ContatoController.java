package com.Jvnyor.agenda.controller;

import com.Jvnyor.agenda.dao.ContatoDAO;
import com.Jvnyor.agenda.model.Contato;

public class ContatoController {

	private ContatoDAO contatoDAO = new ContatoDAO();
	
	public void salvarContato(Contato contato) {
		contatoDAO.save(contato);
		System.out.println("Contato salvo com sucesso!\n"+contato);
	}
	
	public void removerContatoPorId(int id) {
		contatoDAO.removeById(id);
		System.out.println("Contato removido com sucesso!");
	}
	
	public void atualizarContato(Contato contato) {
		contatoDAO.update(contato);
		System.out.println("Contato atualizado com sucesso!\n"+contato);
	}
	
	public void listarContatos(){
		for (Contato c : contatoDAO.getContatos()) {
			System.out.println(c);
		}
		System.out.println("Contatos listados com sucesso!");
	}
}