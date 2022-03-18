package com.Jvnyor.agenda;

import java.util.Date;
import java.util.Scanner;

import com.Jvnyor.agenda.controller.ContatoController;
import com.Jvnyor.agenda.model.Contato;

public class AgendaApp {

	public static void main(String args[]){
		
		ContatoController contatoController = new ContatoController();
		
		 int i = 0;
		 while (i!=5) {
			System.out.println("CRUD de agenda de contatos");
			System.out.println("\nClique 1 para listar todos os contatos"
					+ "\nClique 2 para salvar um contato"
					+ "\nClique 3 para alterar um contato"
					+ "\nClique 4 para remover um contato"
					+ "\nClique 5 para sair"
					+ "\n");
			Scanner in = new Scanner(System.in);
			i = in.nextInt();
			switch (i) {
			case 1:
				contatoController.listarContatos();
				break;
			case 2:
				Scanner inputToSave = new Scanner(System.in);
				System.out.print("\nDigite o nome do contato: ");
				String nomeToSave = inputToSave.nextLine();
				System.out.print("\nDigite a idade do contato: ");
				int idadeToSave = inputToSave.nextInt();
				Contato contatoToSave = new Contato(nomeToSave,idadeToSave,new Date());
				contatoController.salvarContato(contatoToSave);
				inputToSave.close();
				break;
			case 3:
				Scanner inputToUpdate = new Scanner(System.in);
				System.out.print("\nDigite o id do contato que irá alterar: ");
				int idToUpdate = inputToUpdate.nextInt();
				System.out.print("\nDigite o nome do contato: ");
				String nomeToUpdate = inputToUpdate.nextLine();
				System.out.print("\nDigite a idade do contato: ");
				int idadeToUpdate = inputToUpdate.nextInt();
				Contato contatoToAlter = new Contato(idToUpdate,nomeToUpdate,idadeToUpdate,new Date());
				contatoController.atualizarContato(contatoToAlter);
				inputToUpdate.close();
				break;
			case 4:
				Scanner inputToRemove = new Scanner(System.in);
				System.out.print("\nDigite o id do contato que quer remover");
				int idToRemove = inputToRemove.nextInt();
				contatoController.removerContatoPorId(idToRemove);
				inputToRemove.close();
				break;
			case 5:
				System.out.println("Programa finalizado.");
				in.close();
				break;
			default:
				System.out.println("Número inválido!");
				break;
			}
			
		}
		 
	}
}