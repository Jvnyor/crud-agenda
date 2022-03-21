package com.Jvnyor.agenda;

import java.util.Date;
import java.util.Scanner;

import com.Jvnyor.agenda.controller.ContatoController;
import com.Jvnyor.agenda.model.Contato;

public class AgendaApp {

	private static final ContatoController contatoController = new ContatoController();
	
	public static void main(String args[]){
		
		
		Scanner in = new Scanner(System.in);
		Scanner inputToSave = new Scanner(System.in);
		Scanner inputToUpdate = new Scanner(System.in);
		Scanner inputToRemove = new Scanner(System.in);
		 int i = 0;
		 do {
			System.out.println("CRUD de agenda de contatos");
			System.out.println("\nClique 1 para listar todos os contatos"
								+ "\nClique 2 para salvar um contato"
								+ "\nClique 3 para alterar um contato"
								+ "\nClique 4 para remover um contato"
								+ "\nClique 5 para sair"
								+ "\n");
			i = in.nextInt();
			switch (i) {
				case 1:
					contatoController.listarContatos();
					break;
				case 2:
					
					String nomeToSave = null;
					int idadeToSave = 0;
					System.out.print("\nDigite o nome do contato: ");
					nomeToSave = inputToSave.nextLine();
					System.out.print("\nDigite a idade do contato: ");
					idadeToSave = inputToSave.nextInt();

					Contato contatoToSave = new Contato(nomeToSave,idadeToSave,new Date());
					contatoController.salvarContato(contatoToSave);
					break;
				case 3:
					
					int idToUpdate = 0;
					String nomeToUpdate = null;
					int idadeToUpdate = 0;
					System.out.print("\nDigite o id do contato que irá alterar: ");
					idToUpdate = inputToUpdate.nextInt();
					System.out.print("\nDigite o nome do contato: ");
					nomeToUpdate = inputToUpdate.nextLine();
					nomeToUpdate = inputToUpdate.nextLine();
					System.out.print("\nDigite a idade do contato: ");
					idadeToUpdate = inputToUpdate.nextInt();

					Contato contatoToAlter = new Contato(idToUpdate,nomeToUpdate,idadeToUpdate,new Date());
					contatoController.atualizarContato(contatoToAlter);
					break;
				case 4:
					int idToRemove = 0;
					
					System.out.print("\nDigite o id do contato que quer remover: ");
					idToRemove = inputToRemove.nextInt();
	
					
					contatoController.removerContatoPorId(idToRemove);
					break;
				case 5:
					System.out.println("Programa finalizado.");
					inputToSave.close();
					inputToUpdate.close();
					inputToRemove.close();
					in.close();
					break;
				default:
					System.out.println("Número inválido!");
					break;
				}

		} while (i!=5);
		 
	}
}