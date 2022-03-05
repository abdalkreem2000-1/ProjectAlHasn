package classes;

import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

public class A_tour_guide {
	private int id;
	private String nameguide;
	private String numberguide;
	private days_work Days_of_work;
	private double The_cost_of_the_guide;
	
	

	public A_tour_guide(int id, String nameguide, days_work days_of_work,String numberguide,  double the_cost_of_the_guide) {
		super();
		this.id = id;
		this.nameguide = nameguide;
		numberguide = numberguide;
		Days_of_work = days_of_work;
		The_cost_of_the_guide = the_cost_of_the_guide;
	}
	public A_tour_guide(String nameguide,days_work days_of_work, String numberguide,  double the_cost_of_the_guide) {
		super();
		this.nameguide = nameguide;
		numberguide = numberguide;
		Days_of_work = days_of_work;
		The_cost_of_the_guide = the_cost_of_the_guide;
	}
	public String getNameguide() {
		return nameguide;
	}
	public void setNameguide(String nameguide) {
		this.nameguide = nameguide;
	}
	public String getnumberguide() {
		return numberguide;
	}
	public void setnumberguide(String numberguide) {
		numberguide = numberguide;
	}
	
	
	public days_work getDays_of_work() {
		return Days_of_work;
	}
	public void setDays_of_work(days_work days_of_work) {
		Days_of_work = days_of_work;
	}
	public int getId() {
		return id;
	}
	public double getThe_cost_of_the_guide() {
		return The_cost_of_the_guide;
	}
	public void setThe_cost_of_the_guide(double the_cost_of_the_guide) {
		The_cost_of_the_guide = the_cost_of_the_guide;
	}
	@Override
	public String toString() {
		return "Days_of_work" ;
	}

}
