package chapter10;

public class Connection {
	private Station station1;
	private Station station2;
	private String lineName;
	private boolean status=true;
	public Connection (Station station1,Station station2, String lineName){
		this.station1=station1;
		this.station2=station2;
		this.lineName=lineName;
//		this.status=true;
	}
	public Station getStation1(){
		return station1;
	}
	public Station getStation2(){
		return station2;
	}
	public String getLineName(){
		return lineName;
	}
	public void setStatus(boolean status){
		this.status=status;
	}
	public boolean getStatus(){
		return status;
	}
		
	
}
