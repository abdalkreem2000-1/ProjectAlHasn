package classes;

import javax.swing.JList;

public class days_work {
	private int id;
	private boolean Sunday=false;
	private boolean Monday=false ;
	private boolean Tuesday=false ;
	private boolean Wednesday=false ;
	private boolean Thursday=false ;
	private boolean Friday=false ;
	private boolean Saturday=false;
	public days_work(int id, boolean sunday, boolean monday, boolean tuesday, boolean wednesday, boolean thursday,
			boolean friday, boolean saturday) {
		super();
		this.id = id;
		Sunday = sunday;
		Monday = monday;
		Tuesday = tuesday;
		Wednesday = wednesday;
		Thursday = thursday;
		Friday = friday;
		Saturday = saturday;
	}
	public days_work(boolean sunday, boolean monday, boolean tuesday, boolean wednesday, boolean thursday,
			boolean friday, boolean saturday) {
		super();
		Sunday = sunday;
		Monday = monday;
		Tuesday = tuesday;
		Wednesday = wednesday;
		Thursday = thursday;
		Friday = friday;
		Saturday = saturday;
	}
	public boolean isSunday() {
		return Sunday;
	}
	public void setSunday(boolean sunday) {
		Sunday = sunday;
	}
	public boolean isMonday() {
		return Monday;
	}
	public void setMonday(boolean monday) {
		Monday = monday;
	}
	public boolean isTuesday() {
		return Tuesday;
	}
	public void setTuesday(boolean tuesday) {
		Tuesday = tuesday;
	}
	public boolean isWednesday() {
		return Wednesday;
	}
	public void setWednesday(boolean wednesday) {
		Wednesday = wednesday;
	}
	public boolean isThursday() {
		return Thursday;
	}
	public void setThursday(boolean thursday) {
		Thursday = thursday;
	}
	public boolean isFriday() {
		return Friday;
	}
	public void setFriday(boolean friday) {
		Friday = friday;
	}
	public boolean isSaturday() {
		return Saturday;
	}
	public void setSaturday(boolean saturday) {
		Saturday = saturday;
	}
	public int getId() {
		return id;
	}
	public void days_work_g(JList left) {
		for(int i = 0; i< left.getModel().getSize();i++){
			switch (left.getModel().getElementAt(i).toString()) {
			case "Sunday":Sunday=true;
				
				break;
			case "Monday":Monday=true;
			
			break;
			case "Tuesday":Tuesday=true;
			
			break;
			case "Wednesday":Wednesday=true;
			
			break;
			case "Thursday":Thursday=true;
			
			break;
			case "Friday":Friday=true;
			
			break;
			case "Saturday":Saturday=true;
			
			break;

			default:System.out.print("Erorr");
				break;}
	}
	}

}
