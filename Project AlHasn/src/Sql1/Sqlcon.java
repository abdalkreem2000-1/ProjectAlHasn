package Sql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Sqlcon {

	private final Connection connection;
	private final Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;
	private boolean connectedDatabase = false;
	
	public Sqlcon(String url, String username, String password) throws SQLException {
		// TODO Auto-generated constructor stub
		//System.out.println("Here");
		connection = DriverManager.getConnection(url, username, password);
		statement = connection.createStatement();
		connectedDatabase = true;
	
		
	}

	public void testConnectedDatabase(){
		if (!connectedDatabase) {
			throw new IllegalStateException("Not Connected Database, Open Connection and Try again");
		}
	}
	public Connection getConnection() {
		return connection;
	}
	public void disconnect() {
		if (connectedDatabase) {
			try {
				
				//resultSet.close();
				statement.close();
				connection.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();				
			}finally {
				connectedDatabase=false;
			}
		}
	}
	public int runUpdate(String sql) {
		try {
			return statement.executeUpdate(sql);
		} catch (SQLException e) {
		
	           JOptionPane.showMessageDialog(null, e.getMessage());
	           return 0;
		}
	}
	
	public ResultSet runSelect(String sql)
    {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
           return null;
        }
        
    
    }


}
