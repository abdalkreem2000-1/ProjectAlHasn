package GUI;

import java.awt.EventQueue;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.RowFilter;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.util.*;
import java.awt.ScrollPane;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.imageio.ImageIO;
import javax.jws.soap.SOAPBinding.Use;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Sql1.Sqlcon;
import classes.A_tour_guide;

import classes.Visitor;
import classes.days_work;
import Sql1.ResultSetTableModel;

import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.cj.util.StringUtils;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;
public class APP1 {
    
	private JFrame frmAlhusnManaggementSystem;
	private JTextField NameV;
	private JTextField nameGuide;
	private JTable Show_Visitor;
	private JTable table_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
private static final String DATABASE_URL= "jdbc:mysql://localhost/al_husn?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";        
    private int day=0;
	private static final String USERNAME = "root";
	private static final String PASSWORD ="";
	private static Sqlcon dbc;
	days_work d;
	Visitor V;
	A_tour_guide a;
	private JTextField Catch;
	private JTextField phone;
	private boolean Sunday=false ;
	private boolean Monday=false ;
	private boolean Tuesday=false ;
	private boolean Wednesday=false ;
	private boolean Thursday=false ;
	private boolean Friday=false ;
	private boolean Saturday=false ;
	private int daycount=0;
	private static final String DEFAULT_Query = "SELECT * FROM visitor";
	private static final String DEFAULT_Query1 = "SELECT * FROM visitor";
	private static final String DEFAULT_Query2 = "SELECT DAY(`Time_OUT`) as Day,SUM(`Bill`) as Income FROM visitor GROUP by DAY(`Time_OUT`)";
	private static ResultSetTableModel tableModel ;
	private static ResultSetTableModel tableModel1 ;
	private static ResultSetTableModel tableModel2 ;
	private JTextField textFieldFilter;
	private JTextField cost;
	private JTextField id;
	private JTable table;
	private int i=1;
	private int idtouer=0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APP1 window = new APP1();
					window.frmAlhusnManaggementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public APP1() {
		
		try {
			dbc=new Sqlcon(DATABASE_URL, USERNAME, PASSWORD);
			tableModel = new ResultSetTableModel(DEFAULT_Query, dbc.getConnection());
			tableModel1= new ResultSetTableModel(DEFAULT_Query1, dbc.getConnection());
			tableModel2= new ResultSetTableModel(DEFAULT_Query2, dbc.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlhusnManaggementSystem = new JFrame();
		frmAlhusnManaggementSystem.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				System.out.println("Good Bye");
				dbc.disconnect();
			}
			@Override
			public void windowOpened(WindowEvent arg0) {
				try {
					tableModel.setQuery(DEFAULT_Query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frmAlhusnManaggementSystem.setTitle("Al-Husn Managgement System");
		
		frmAlhusnManaggementSystem.setBounds(100, 100, 511, 350);
		frmAlhusnManaggementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlhusnManaggementSystem.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("Add");
		tabbedPane.setBounds(10, 11, 475, 289);
		frmAlhusnManaggementSystem.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		tabbedPane.addTab("Add Visitor", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		NameV = new JTextField();
		NameV.setBounds(220, 8, 110, 20);
		panel.add(NameV);
		NameV.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Kind Of Visit :");
		lblNewLabel_1.setBounds(10, 66, 96, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox Kind = new JComboBox();
		Kind.setModel(new DefaultComboBoxModel(new String[] {"Photography Session", "Round", "Both Of Them"}));
		Kind.setBounds(220, 63, 110, 20);
		panel.add(Kind);
		
		JButton btnAdd = new JButton("Add");
		
		btnAdd.setBounds(347, 212, 89, 23);
		panel.add(btnAdd);
		
		JLabel label = new JLabel("A Tour Gride :");
		label.setBounds(10, 146, 96, 14);
		panel.add(label);
		
		JComboBox tour = new JComboBox();
		tour.setBounds(127, 143, 147, 20);
		panel.add(tour);
		
		
		JButton button = new JButton("Update");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					
					
					tour.removeAllItems();
			     String sql2="SELECT a.Name FROM a_tour_gride a,days d where a.DAYS_WORK=d.Days_work and persistent=0 ;";
			     ResultSet rs=dbc.runSelect(sql2);
			        	
							while(rs.next()) {
					
								tour.addItem(rs.getString("Name"));
							}
						} catch (SQLException e) {
							
							e.printStackTrace();
							System.out.println("Erorr");

						}
			}
		});
		button.setBounds(307, 142, 89, 23);
		panel.add(button);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Locale locale=new Locale("en");
				SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			    Date date = new Date(System.currentTimeMillis());
				double bill = 0;
				double costdouble=100.0;
				boolean p=false;
				int iddays=0;
				String sql1="Select id,persistent,DAYS_WORK from a_tour_gride where Name='"+tour.getSelectedItem().toString()+"'";

			 ResultSet rs=dbc.runSelect(sql1);
			 try {
				if(rs.next()) {
					idtouer=rs.getInt("id");
					//p=rs.getBoolean("persistent");
					iddays=rs.getInt("DAYS_WORK");	
				}
			} catch (HeadlessException | SQLException e) {
				e.printStackTrace();
			}

				V=new Visitor(NameV.getText(), tour.getSelectedItem().toString(), Kind.getSelectedItem().toString(), costdouble,bill,date);
			       //String sql3="UPDATE a_tour_gride SET persistent="+1+" WHERE Name ='"+tour.getSelectedItem().toString()+"';";  dbc.runUpdate(sql3);
			       String d= V.getDayStringOld(date,locale);
			       String sql7="Select "+d+" from days where Days_work="+iddays+" ";
			       ResultSet rs1=dbc.runSelect(sql7);
			       try {
					if(rs1.next())
					 p= rs1.getBoolean(d);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			       if(p) {
					    String sql="INSERT INTO visitor(id,Name,A_Tour_Gride,Kind_of_visit,Bill,kindcost,Time_IN,idtour) VALUES(default,'"+V.getNameVisitor()+"','"+V.getA_tour()+"','"+V.getKov()+"',"+V.getBill()+","+V.getKovcost()+",'"+formatter.format(V.getTime_In())+"',"+idtouer+")";

		        dbc.runUpdate(sql);
		        JOptionPane.showMessageDialog(null, "Visitor Added Successfully");}
			       else
			    	   JOptionPane.showMessageDialog(null, "The Tour is not here");
			       
		        
			}
		});
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Exit check", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel lblName = new JLabel("id :");
		lblName.setBounds(10, 11, 46, 14);
		panel_6.add(lblName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(118, 8, 133, 20);
		panel_6.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnExit = new JButton("Exit From Al-Husn");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
				  Date date = new Date(System.currentTimeMillis());
				  
				
				  
				   
		        String sql2="UPDATE visitor SET  Time_OUT='"+formatter.format(date)+"' WHERE id ='"+textField_2.getText()+"';";
				 dbc.runUpdate(sql2);
				 String sql3="SELECT v.kindcost,TIMESTAMPDIFF(MINUTE,v.Time_IN,v.Time_OUT) AS H,a.cost FROM visitor v,a_tour_gride a where v.idtour=a.Id and v.id='"+textField_2.getText()+"' ";
				 ResultSet rs= dbc.runSelect(sql3);
				// String sql4="SELECT `cost` FROM `a_tour_gride` where id='"+textField_2.getText()+"' ";ResultSet rs1= dbc.runSelect(sql4);
				 try {
					 double cost=0;
					 while (rs.next()) {
						
						 cost=(rs.getInt("H"))*(rs.getDouble("kindcost")+rs.getDouble("cost"));
						
						 
		
						
						 
					 }
					 String sql4 ="UPDATE visitor SET  Bill='"+cost+"' where id ='"+textField_2.getText()+"' ;";
						dbc.runUpdate(sql4);

						
	                       JOptionPane.showMessageDialog(null, "Visitor Bill has updata Successfully");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				try {
					tableModel1.setQuery("SELECT * from visitor where id="+Integer.parseInt(textField_2.getText())+"");
					table.setRowSorter(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			        JOptionPane.showMessageDialog(null, "Visitor Exit Successfully");
			}
		});
		btnExit.setBounds(282, 201, 147, 23);
		panel_6.add(btnExit);
		
		JLabel lblNewLabel_6 = new JLabel("Result :");
		lblNewLabel_6.setBounds(10, 55, 46, 14);
		panel_6.add(lblNewLabel_6);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(118, 39, 342, 135);
		panel_6.add(scrollPane_3);
		
		table = new JTable(tableModel1);
		scrollPane_3.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add Guide", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("The guide's name :");
		lblNewLabel_2.setBounds(10, 11, 114, 14);
		panel_1.add(lblNewLabel_2);
		
		nameGuide = new JTextField();
		nameGuide.setBounds(124, 8, 96, 20);
		panel_1.add(nameGuide);
		nameGuide.setColumns(10);
		
		JLabel lblAge = new JLabel("phone Namber :");
		lblAge.setBounds(10, 61, 114, 14);
		panel_1.add(lblAge);
		
		JLabel lblDaysWork = new JLabel("Day's Work :");
		lblDaysWork.setBounds(10, 114, 79, 14);
		panel_1.add(lblDaysWork);
		
		
		JButton btnAdd_1 = new JButton("Add");
		
	
		btnAdd_1.setBounds(340, 201, 89, 23);
		panel_1.add(btnAdd_1);
		
		JLabel lblNewLabel_3 = new JLabel("Catch an hour :");
		lblNewLabel_3.setBounds(10, 205, 96, 14);
		panel_1.add(lblNewLabel_3);
		
		Catch = new JTextField();
		Catch.setBounds(124, 202, 96, 20);
		panel_1.add(Catch);
		Catch.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(124, 58, 96, 20);
		panel_1.add(phone);
		phone.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(124, 89, 96, 84);
		panel_1.add(scrollPane);
		
		JList right = new JList();
		scrollPane.setViewportView(right);
		
		
		
		
		right.setModel(new AbstractListModel() {
			String[] values = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JButton btnNewButton_1 = new JButton("Move");
		
		btnNewButton_1.setBounds(246, 110, 79, 23);
		panel_1.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(340, 89, 89, 84);
		panel_1.add(scrollPane_1);
		
		JList Left = new JList();
		scrollPane_1.setViewportView(Left);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Left.setListData(right.getSelectedValues());
				
			}
		});
		btnAdd_1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				
				 int Id=0;
				d=new days_work( ++daycount,Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday);
				d.days_work_g(Left);
				String sql2="SELECT `Days_work` FROM `days` WHERE Sunday="+d.isSunday()+" AND Monday="+d.isMonday()+" AND Tuesday="+d.isTuesday()+" AND Thursday="+d.isThursday()+" AND `Friday`="+d.isFriday()+" AND Saturday="+d.isSaturday()+" AND  Thursday="+d.isThursday()+"";	
		a=new A_tour_guide(nameGuide.getText(), d, phone.getText(),  Double.parseDouble(Catch.getText()));
        String sql1="INSERT INTO days VALUES(default,"+d.isSunday()+","+d.isMonday()+","+d.isTuesday()+","+d.isWednesday()+","+d.isThursday()+","+d.isFriday()+","+d.isSaturday()+")";
         dbc.runUpdate(sql1);
         ResultSet rs3= dbc.runSelect(sql2);
        try {
			if(rs3.next())
				Id=rs3.getInt("Days_work");
			System.out.print(Id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        String sql="INSERT INTO a_tour_gride VALUES(default,'"+a.getNameguide()+"','"+Id+"','"+ phone.getText()+"',"+a.getThe_cost_of_the_guide()+",default)";
       
       dbc.runUpdate(sql);
       
      //  comboBox.addItem(runSelect("select *from a_tour_gride "));
        JOptionPane.showMessageDialog(null, "A tour guide Added Successfully");
        

			}
		});
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Show", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 11, 450, 239);
		panel_2.add(tabbedPane_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("Visiting records", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton btnShow_2 = new JButton("Show");
		btnShow_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					tableModel.setQuery(DEFAULT_Query);
					Show_Visitor.setRowSorter(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
			
		});
		btnShow_2.setBounds(346, 177, 89, 23);
		panel_3.add(btnShow_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 425, 155);
		panel_3.add(scrollPane_2);
		

	        Show_Visitor = new JTable(tableModel);
	        scrollPane_2.setViewportView(Show_Visitor);
	        
	        JButton btnFilter = new JButton("Filter");
	        btnFilter.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
					Show_Visitor.setRowSorter(sorter);
					sorter.setRowFilter(RowFilter.regexFilter(textFieldFilter.getText()));

	        	}
	        });
	        btnFilter.setBounds(10, 177, 89, 23);
	        panel_3.add(btnFilter);
	        
	        textFieldFilter = new JTextField();
	        textFieldFilter.setBounds(109, 178, 86, 20);
	        panel_3.add(textFieldFilter);
	        textFieldFilter.setColumns(10);
	        
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Daily income", null, panel_4, null);
		panel_4.setLayout(null);
		
		JButton btnShow = new JButton("Show");
		
		btnShow.setBounds(327, 177, 108, 23);
		panel_4.add(btnShow);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 11, 425, 155);
		panel_4.add(scrollPane_4);
		
		table_1 = new JTable(tableModel2);
		scrollPane_4.setViewportView(table_1);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					tableModel2.setQuery(DEFAULT_Query2);
					table_1.setRowSorter(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Archaeological sites", null, panel_7, null);
		panel_7.setLayout(null);
		
		JLabel imagelabel = new JLabel("");
		imagelabel.setBounds(10, 11, 450, 183);
		panel_7.add(imagelabel);
		imagelabel.setForeground(Color.LIGHT_GRAY);
		imagelabel.setBackground(Color.WHITE);
		
		JButton btnNewButton_3 = new JButton("Next");
		btnNewButton_3.setBounds(371, 210, 89, 23);
		panel_7.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("previous");
		btnNewButton.setBounds(10, 205, 89, 23);
		panel_7.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(i>0) {
				String sql="select * from image where id="+i--+"";
				 ResultSet  rs =dbc.runSelect(sql);
				//List<String> lb=new ArrayList<String>();
			     try {
					if(rs.next())
						//lb.add(rs.getString("Image"));
					imagelabel.setIcon(new ImageIcon(rs.getString("Image")));
				} catch (SQLException e) {

					e.printStackTrace();
				}
			    // imagelabel.setIcon(new ImageIcon(lb.get(i)));
			
			
			}else   JOptionPane.showMessageDialog(null, "this is first  Image");
				}
			
			
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				String sql="select * from image where id="+i+"";
				 ResultSet  rs =dbc.runSelect(sql);
				//List<String> lb=new ArrayList<String>();
			     try {
					if(rs.next())
					{
					imagelabel.setIcon(new ImageIcon(rs.getString("Image")));
					}else JOptionPane.showMessageDialog(null, "this is List  Image");
				} catch (SQLException e) {

					e.printStackTrace();
				}
			    // imagelabel.setIcon(new ImageIcon(lb.get(i)));
			i++;
			
			}
		});
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("Mengment", null, panel_8, null);
		panel_8.setLayout(null);
		
		JButton button_1 = new JButton("Delate");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql="DELETE FROM visitor WHERE id='"+Integer.parseInt(id.getText())+"';";
		        dbc.runUpdate(sql);
		        JOptionPane.showMessageDialog(null, "Visitor DELETE Successfully");
			}
		});
		button_1.setBounds(306, 7, 76, 23);
		panel_8.add(button_1);
		
		JButton button_2 = new JButton("Edit");
		
		button_2.setBounds(371, 215, 89, 23);
		panel_8.add(button_2);
		
		JLabel label_1 = new JLabel("cost of the visit is per hour :");
		label_1.setBounds(10, 128, 160, 14);
		panel_8.add(label_1);
		
		cost = new JTextField();
		cost.setColumns(10);
		cost.setBounds(177, 125, 110, 20);
		panel_8.add(cost);
		
		JLabel lblName_1 = new JLabel("ID:");
		lblName_1.setBounds(10, 11, 46, 14);
		panel_8.add(lblName_1);
		
		id = new JTextField();
		id.setBounds(177, 8, 110, 20);
		panel_8.add(id);
		id.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Photography Session", "Round", "Both Of Them"}));
		comboBox.setBounds(177, 70, 110, 20);
		panel_8.add(comboBox);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				V=new Visitor(Integer.parseInt(id.getText()), comboBox.getSelectedItem().toString(), Double.parseDouble( cost.getText()));
			
		       String sql="UPDATE visitor SET Kind_of_visit ='"+V.getKov()+"', kindcost="+V.getKovcost()+" WHERE id ='"+V.getId()+"';";
		       dbc.runUpdate(sql);
		        JOptionPane.showMessageDialog(null, "Visitor Edit Successfully");
			}
		});
		JLabel label_2 = new JLabel("Kind Of Visit :");
		label_2.setBounds(10, 73, 96, 14);
		panel_8.add(label_2);
	}
}
