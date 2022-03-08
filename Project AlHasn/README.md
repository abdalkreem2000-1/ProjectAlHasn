
# Al-Hasn

Tourist visit management system to Al-Hasn


## Authors

- [@abdalkreem2000-1](https://github.com/abdalkreem2000-1)


## Deployment

To deploy this project run

```bash
  you'r need to download Eclipse
```
```bash
  include the database into myphpAdmin(al_husn.sql)
```
```bash
  add project on eclipse
```


## 🚀 About Me
I'm a full stack developer...


## 🛠 Skills
c++,java....


## Usage/Examples
This code logs the tourist out and calculates 
the number of hours he stayed in

```java
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
```

