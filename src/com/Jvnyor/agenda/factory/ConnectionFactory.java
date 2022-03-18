package com.Jvnyor.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//Nome do usu·rio root do mysql
	private static final String USERNAME = "root";
	
	//Senha do usu·rio root do mysql
	private static final String PASSWORD = "root";
	
	//Dados de caminho, porta e nome da base de dados que ir· ser feita a conex√£o
	private static final String DATABASE_URL = "jdbc:mysql://192.168.99.100:3306/agenda";
//	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	 /**
	   * Cria uma conex„o com o banco de dados MySQL utilizando o nome de usu·rio e senha fornecidos
	   * @param username
	   * @param senha
	   * @return uma conex„o com o banco de dados
	   * @throws Exception
	   */
	
	public static Connection createConnectionToMySql() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Cria a conex„o com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		
		//Recupera uma conex„o com o banco de dados
		Connection con = createConnectionToMySql();
		
		//Testa se a conex„o È nula
		if (con != null) {
			System.out.println("Conex√£o obtida com sucesso! "+con);
			con.close();
		}
	}
}