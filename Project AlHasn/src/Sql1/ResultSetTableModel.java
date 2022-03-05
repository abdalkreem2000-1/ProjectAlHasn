package Sql1;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import classes.Visitor;

public class ResultSetTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private final Connection connection;
	private final PreparedStatement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;
	//private boolean connectedDatabase = false;

	public ResultSetTableModel(String query, Connection connection) throws SQLException {
		// TODO Auto-generated constructor stub
		
		
		statement = connection.prepareStatement(query);
		//connectedDatabase = true;
		setQuery(query);
		
		
		
	}

	
	public void setQuery(String query) throws SQLException {
		// TODO Auto-generated method stub
		resultSet = statement.executeQuery(query);
		metaData= resultSet.getMetaData();
		
		resultSet.last();
		numberOfRows= resultSet.getRow();
		fireTableStructureChanged();
		
	}
	
	public Class getColumnClass(int column) {
		try {
			String className = metaData.getColumnClassName(column+1);
			return Class.forName(className);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Object.class;
	}

	public String getColumnName(int column) {
		try {
			return metaData.getColumnName(column +1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		try {
			return metaData.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return numberOfRows;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		try {
			resultSet.absolute(rowIndex+1);
			return resultSet.getObject(columnIndex+1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	

}
