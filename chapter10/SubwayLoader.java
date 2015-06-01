package chapter10;

import java.io.File;
import java.io.*;

public class SubwayLoader
{
    private Subway subway;
    private boolean subBool;
    private boolean lineBool;
    
    public SubwayLoader() {
        this.subway = new Subway();
        this.subBool=true;
        this.lineBool=true;
    }
    
    public Subway loadFromFile(File subwayFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(subwayFile));
        loadStations(subway, reader);
        String lineName = reader.readLine();
        while ((lineName != null) && (lineName.length() > 0)) {
            loadLine(subway, reader, lineName);
            lineName = reader.readLine();
        }
        return subway;
    }
    
    public boolean loadStations(Subway subway, BufferedReader reader) throws IOException {
        String currentLine;
        currentLine = reader.readLine();
        while (currentLine.length() > 0) {
            subway.addStation(currentLine);
            currentLine = reader.readLine();
        }
        return true;
    }
    
    public void loadLine(Subway subway, BufferedReader reader, String lineName) throws IOException {
        String station1Name, station2Name;
        station1Name = reader.readLine();
        station2Name = reader.readLine();
        while ((station2Name != null) && (station2Name.length() > 0)) {
            subway.addConnection(station1Name, station2Name, lineName);
         
            station1Name = station2Name;
            station2Name = reader.readLine();
        }
    }
    public void brokeStation(String station){
    	subway.removeStation(station);
    }
//    public void fixStation(String station){
//    	Station s=subway.getStation(station);
//    	if(s!=null){
//    		s.setStatus(true);
//    	}
//    }
    public void brokeLine(String name){
    	subway.removeLine(name);
    }
//    public void fixLine(String station1,String station2){
//    	Connection conn=subway.getConnection(new Station (station1), new Station(station2));
//    	if(conn!=null){
//    		conn.setStatus(true);
//    	}
//    }
}
