package classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JList;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Visitor    {
	private int id;
	private String NameVisitor;
	private String A_tour;
	private String Kov;
	private double kovcost;
	private double Bill;
	private Date Time_In;
	private Date Time_Out;
	
	public Visitor(String nameVisitor, String a_tour, String kov, double kovcost, double bill, Date time_In) {
		super();
		NameVisitor = nameVisitor;
		A_tour = a_tour;
		Kov = kov;
		this.kovcost = kovcost;
		Bill = bill;
		Time_In = time_In;
	}







	public Visitor(int id, String kov, double kovcost) {
		super();
		this.id = id;
		Kov = kov;
		this.kovcost = kovcost;
	}







	public Visitor(String a_tour, String kov, double kovcost, double bill) {
		super();
		A_tour = a_tour;
		Kov = kov;
		this.kovcost = kovcost;
		Bill = bill;
	}







	public Visitor(int id, String nameVisitor, String a_tour, String kov, double kovcost, double bill, Date time_In,
			Date time_Out) {
		super();
		this.id = id;
		NameVisitor = nameVisitor;
		A_tour = a_tour;
		Kov = kov;
		this.kovcost = kovcost;
		Bill = bill;
		Time_In = time_In;
		Time_Out = time_Out;
	}







	public Visitor(String nameVisitor, String a_tour, String kov, double kovcost, double bill) {
		super();
		NameVisitor = nameVisitor;
		A_tour = a_tour;
		Kov = kov;
		this.kovcost = kovcost;
		Bill = bill;
	}




	public double getKovcost() {
		return kovcost;
	}



	public void setKovcost(double kovcost) {
		this.kovcost = kovcost;
	}



	public String getKov() {
		return Kov;
	}

	public void setKov(String kov) {
		Kov = kov;
	}

	public String getA_tour() {
		return A_tour;
	}

	public void setA_tour(String a_tour) {
		A_tour = a_tour;
	}

	public String getNameVisitor() {
		return NameVisitor;
	}

	public void setNameVisitor(String nameVisitor) {
		NameVisitor = nameVisitor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBill() {
		return Bill;
	}

	public void setBill(double bill) {
		Bill = bill;
	}



	public Date getTime_In() {
		return Time_In;
	}



	public void setTime_In(Date time_In) {
		Time_In = time_In;
	}



	public Date getTime_Out() {
		return Time_Out;
	}



	public void setTime_Out(Date time_Out) {
		Time_Out = time_Out;
	}
     
	
	public static String getDayStringOld(Date date, Locale locale) {
	    DateFormat formatter = new SimpleDateFormat("EEEE", locale);
	    return formatter.format(date);
	}
	
	
}
	
	
	
	


