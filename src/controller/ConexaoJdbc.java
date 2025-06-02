/*package controller;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJdbc {
	
	private Connection con = null;
	
	private String nomeHost = null;
	private String usuario = null;
	private String senha = null;
	private String url = null;
	private String jdbcDriver = null;
	private String nomeBanco = null;
	private String portaBanco = null;
	private String outrasConfiguracoes = null;
	String dbPath = new File("src\\resources\\bdclientes.db").getAbsolutePath();
	
	public ConexaoJdbc () {
		
		//nomeHost = "localhost";
		//usuario = "postgres";
		//senha = "Eusei2202@";
		jdbcDriver = "org.sqlite.JDBC";
		//nomeBanco = "app-orcamento";
		url = "jdbc:sqlite:";
		//portaBanco = "5432/";
		
		//url = prefixBanco + nomeHost + ":" + portaBanco + nomeBanco;
		
	}

	public Connection getConnection() {
		
		try {
			
			if (con == null) {
				
				Class.forName(jdbcDriver);
				//con = DriverManager.getConnection(url, usuario, senha);
				con = DriverManager.getConnection(url + dbPath);

				
			} else if (con.isClosed()){
				
				con = null;
				return getConnection();
				
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
			//Colocar sistema de log
			
		} catch (SQLException e) {
			
			System.out.println("Erro ao conectar com o banco de dados" + e.getMessage());
			
			//colocar sistema de log
			
		}
		
		return con;
	}
	
	public void closeConnection () {
		
		if (con != null)  {
			
			try {
				
				con.close();
				
			} catch (SQLException e) {
				
				System.out.println("Erro ao fechar a conexão" + e.getMessage());
				//Colocar sistema de log
			}
			
		}
		
	}
}
*/

package controller;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJdbc {
    
    private Connection con = null;
    
    private String jdbcDriver = "org.sqlite.JDBC";
    private String url = "jdbc:sqlite:";
    private File dbFile;

    public ConexaoJdbc() {
        try {
            // Extrai o banco do .jar e salva em um diretório temporário
            dbFile = extractDatabaseFile();
        } catch (IOException e) {
            System.err.println("Erro ao extrair o banco de dados: " + e.getMessage());
        }
    }

    private File extractDatabaseFile() throws IOException {
        // Obtém o arquivo dentro do .jar
        InputStream input = getClass().getClassLoader().getResourceAsStream("resources/bdclientes.db");
        
        if (input == null) {
            throw new FileNotFoundException("Banco de dados não encontrado dentro do .jar.");
        }

        // Cria um arquivo temporário para armazená-lo
        File tempFile = File.createTempFile("bdclientes", ".db");
        tempFile.deleteOnExit(); // Garantir que o arquivo seja removido ao fechar o programa

        try (FileOutputStream out = new FileOutputStream(tempFile);
             BufferedOutputStream bufferOut = new BufferedOutputStream(out)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                bufferOut.write(buffer, 0, bytesRead);
            }
        }

        return tempFile;
    }

    public Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                Class.forName(jdbcDriver);
                con = DriverManager.getConnection(url + dbFile.getAbsolutePath());
                System.out.println("Conexão estabelecida com SQLite!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
        return con;
    }

    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexão fechada.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
