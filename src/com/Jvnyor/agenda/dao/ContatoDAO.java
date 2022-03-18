package com.Jvnyor.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Jvnyor.agenda.factory.ConnectionFactory;
import com.Jvnyor.agenda.model.Contato;

public class ContatoDAO {

	public void save(Contato contato) {
		/*
		 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
		 * na base de dados
		 */
		
		String sql = "INSERT INTO contatos(nome,idade,dataCadastro)"+" VALUES(?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySql();
			
			//Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			//Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, contato.getNome());
			
			//Adicionar o valor do segundo parâmetro da sql
			pstm.setInt(2, contato.getIdade());
			
			//Adiciona o valor do terceiro parâmetro da sql
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			//Executa a sql para inserção dos dados
			pstm.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		try {
			pstm.close();
			
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void removeById(int id) {
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySql();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			pstm.close();
			
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void update(Contato contato) {
		
		String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ?" +
				 " WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySql();
			
			//Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			//Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, contato.getNome());
			
			//Adicionar o valor do segundo parâmetro da sql
			pstm.setInt(2, contato.getIdade());
			
			//Adicionar o valor do terceiro parâmetro da sql
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			pstm.setInt(4, contato.getId());
			
			//Executa a sql para inserção dos dados
			pstm.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//Fecha as conexões
		
		try {
			pstm.close();
			
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public List<Contato> getContatos() {
		String sql = "SELECT * FROM contatos";
		
		List<Contato> contatos = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			//Enquanto existir dados no banco de dados, faça
			while(rset.next()){
			 
			Contato contato = new Contato();
			 
			//Recupera o id do banco e atribui ele ao objeto
			contato.setId(rset.getInt("id"));
			 
			//Recupera o nome do banco e atribui ele ao objeto
			contato.setNome(rset.getString("nome"));
			 
			//Recupera a idade do banco e atribui ele ao objeto
			contato.setIdade(rset.getInt("idade"));
			 
			//Recupera a data do banco e atribui ela ao objeto
			contato.setDataCadastro(rset.getDate("dataCadastro"));
			 
			//Adiciono o contato recuperado, a lista de contatos
			contatos.add(contato);
			 }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			if(rset != null){
				 
			   rset.close();
			}
			
			if(pstm != null){
				 
			   pstm.close();
			}
				 
			if(conn != null){
			   conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return contatos;
	}
}