package chapter10;

public class Station {
	private String name;
	private boolean status=true;
	public Station(String name){
		this.name=name;
		
	}
	public String getName(){
		return name;
	}
	public boolean equals (Object obj){
		if(obj instanceof Station){
			Station otherStation=(Station) obj;
			if(otherStation.getName().equalsIgnoreCase(name)){
				return true;
			}
		}
		return false;
	}
	public int hashCode(){
		return name.toLowerCase().hashCode();
	}
	public void setStatus(boolean status){
		this.status=status;
	}
	public boolean getStatus(){
		return status;
	}
}
