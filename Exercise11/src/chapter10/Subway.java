package chapter10;



import java.util.*;

public class Subway
{
    private List stations;
    private List connections;
    private Map network;
   
    
    public Subway() {
        this.stations = new LinkedList();
        this.connections = new LinkedList();
        this.network = new HashMap();
        
    }
    
    public boolean addStation(String stationName) {
        if (!this.hasStation(stationName)) {
            Station station = new Station(stationName);
            if(station.getStatus()==true)
            	stations.add(station);
            	return true;
        }
        return false;
    }
    
    public boolean hasStation(String stationName) {
        return stations.contains(new Station(stationName));
    }
    
    // Method addConnection is missing
    // TODO: Create Method addConnection
    
    private void addToNetwork(Station station1, Station station2) {
    	List connectingStations;
    	if(station1.getStatus()==true && station2.getStatus()==true){
	        if (network.keySet().contains(station1)) {
	            connectingStations = (List) network.get(station1);
	            if (!connectingStations.contains(station2)) {
	                connectingStations.add(station2);
	                
	            }
	            
	        } else {
	            connectingStations = new LinkedList();
	            connectingStations.add(station2);
	            network.put(station1, connectingStations);
	          
	        }
    	}
        
//        System.out.println(connectingStations);
    }
    
    public List getDirections(String startStationName, String endStationName) {
        if (!this.hasStation(startStationName) || !this.hasStation(endStationName))
        {
            throw new RuntimeException("Stations entered do not exist on this subway");
            
        }
        
        Station start = new Station(startStationName);
        Station end = new Station(endStationName);
        List route = new LinkedList();
        List reachableStations = new LinkedList();
//        System.out.println(reachableStations);
        Map previousStations = new HashMap();
        List neighbors = (List)network.get(start);
//        System.out.println(neighbors);
//        System.out.println(neighbors);
//        System.out.println("net"+network.keySet());
        Set<Station> set=network.keySet();
//        for (Station s: set){
//        	System.out.println(s.getName());
//        	System.out.println(s.getStatus());
//        }
        Station startCheck=getStation(startStationName);
        if(startCheck.equals(start)){
        	start.setStatus(startCheck.getStatus());
        }
        
//        System.out.println(stations);
//        System.out.println(connections);
//        System.out.println("start"+start.getStatus());
        if(start.getStatus()==true){
	        for (Iterator i = neighbors.iterator(); i.hasNext(); ) {
	            Station station = (Station) i.next();
	            if(station.getStatus()==true){
	//	            System.out.println(station.getName());
		            if (station.equals(end)) {
		            	if(getConnection(start,end).getStatus()==true){
		            		route.add(getConnection(start, end));
		            		return route;
		            	}
		            } else {
	//	            	if(getConnection(start, station).getStatus()==true){
		            		reachableStations.add(station);
		            		previousStations.put(station, start);
	//	            	}
		            	
		            }
		        }
	        }
	        List nextStations = new LinkedList();
	        for (Iterator i = neighbors.iterator(); i.hasNext(); ) {
	            Station station = (Station) i.next();
	            if(station.getStatus()==true){
	            	 nextStations.add(station);
	            }
	        }
	       
	        Station currentStation = start;
	        
	        searchLoop:
	        for (int i = 1; i < stations.size(); i++) {
	            List tmpNextStations = new LinkedList();
	            for (Iterator j = nextStations.iterator(); j.hasNext(); ) {
	            	
	                Station station = (Station) j.next();
	                if(station.getStatus()==true ){
		                reachableStations.add(station);
		                currentStation = station;
		                List currentNeighbors = (List) network.get(currentStation);
		                for (Iterator k = currentNeighbors.iterator(); k.hasNext(); ) {
		                    Station neighbor = (Station) k.next();
	//	                    System.out.println(neighbor.getName());
		                    if(neighbor.getStatus()==true){
			                    if(getConnection(currentStation, neighbor).getStatus()==true){
				                    if (neighbor.equals(end)) {
				                        reachableStations.add(neighbor);
				                        previousStations.put(neighbor, currentStation);
				                        break searchLoop;
				                    } else if (!reachableStations.contains(neighbor) ) {
				                        reachableStations.add(neighbor);
				                        tmpNextStations.add(neighbor);
				                        previousStations.put(neighbor, currentStation);
				                    }
		                    }
	                    }
	                }
	            }
	        }
	            nextStations = tmpNextStations;
	        }
	        
	        //We've found the path now!
	        boolean keepLooping = true;
	        Station keyStation = end;
	        Station station;
	        
	        while (keepLooping) {
	            station = (Station) previousStations.get(keyStation);
	//            System.out.println(station.getName());
	//            System.out.println(nextStations);
	//            System.out.println(neighbors);
	            
	            if(getConnection(station, keyStation)!=null && getConnection(station, keyStation).getStatus()==true){
	            	route.add(0, getConnection(station, keyStation));
	            }else{
	            	keepLooping=false;
	            }
	            
		        if (start.equals(station)) {
		        	keepLooping = false;
		        }
		        keyStation = station;
	            
	        }
	    }
        
        return route;
    }
    
    public Connection getConnection(Station station1, Station station2) {
        for (Iterator i = connections.iterator(); i.hasNext(); ) {
            Connection connection = (Connection) i.next();
//            System.out.println(connection.getLineName());
            boolean status=connection.getStatus();
//            System.out.println(connection.getStatus());
            Station one = connection.getStation1();
            Station two = connection.getStation2();
            try{
            	if ((station1.equals(one)) && station2.equals(two)) {
            		return connection;
            	}
            }catch(Exception e){
            	
            }
        }
        return null;
    }
        
    
    public boolean hasConnection(String station1Name, String station2Name, String lineName) {
        Station station1 = new Station(station1Name);
        Station station2 = new Station(station2Name);
        for (Iterator i = connections.iterator(); i.hasNext(); ) {
            Connection connection = (Connection) i.next();
            if (connection.getLineName().equalsIgnoreCase(lineName)) {
                if ((connection.getStation1().equals(station1)) &&
                    (connection.getStation2().equals(station2)))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public Connection addConnection(String station1Name,String station2Name,
			String lineName){
		if((this.hasStation(station1Name))&& (this.hasStation(station2Name))){
			Station station1=new Station(station1Name);
			Station station2=new Station(station2Name);
			
			Connection connection=new Connection(station1,station2,lineName);
			if(connection.getStatus()==true)
				connections.add(connection);
				connections.add(new Connection(station2, station1, connection.getLineName()));
				if(station1.getStatus()==true && station2.getStatus()==true){
					addToNetwork(station1, station2);
					addToNetwork(station2, station1);
				}
			return connection;
		}else{
			throw new RuntimeException("Invalid connection!");
			
		}
		
	}
    public void removeStation(String station){
//    	System.out.println(connections);
		for (int i=0; i<stations.size(); i++){
			
			if(((Station)stations.get(i)).getName().equals(station)){
				Station stationR=(Station)stations.get(i);
				stationR.setStatus(false);
//				
				
				
				Set<Station> set=network.keySet();
				
				for(Station s: set){
					List tempList=(List)network.get(s);
					for (int j=0;j<tempList.size();j++){
						Station stationTemp=(Station)tempList.get(j);
						if(stationTemp.getName().equals(station)){
							stationTemp.setStatus(false);
						}
							
					}
					
				}
				List x=(List) network.get(stationR);
				network.remove(stationR);
				stationR.setStatus(false);
				network.put(stationR,x);
				System.out.println(((Station)stations.get(i)).getName());
				System.out.println(((Station)stations.get(i)).getStatus());
				
			}
			
			
		}
//		for(int j=0; j<connections.size();j++){
//    		if(((Connection)connections.get(j)).getStation1().getName().equals(station)
//    				||((Connection)connections.get(j)).getStation2().getName().equals(station)){
////				System.out.println(((Connection)connections.get(j)).getStation1().getName());
//				connections.remove(j);
//				
//			}
//    	}
		
	}
    public void removeLine(String name){
    	for(int i=0; i<connections.size();i++){
    		if(((Connection)connections.get(i)).getLineName().equals(name)){
				Connection conn=(Connection)connections.get(i);
				conn.setStatus(false);
//    			System.out.println(conn.getLineName());
//    			System.out.println(conn.getStatus());
//				return conn;
			}
    	}
//    	return null;
    }
    public Station getStation(String station){
    	for (int i=0; i<stations.size();i++){
    		if(((Station)stations.get(i)).getName().equals(station)){
    			return (Station)stations.get(i);
    		}
    	}return null;
    }
  
    
                
}
