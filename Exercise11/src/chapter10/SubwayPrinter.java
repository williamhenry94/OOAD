package chapter10;

import java.io.*;
import java.util.*;

public class SubwayPrinter
{
    private PrintWriter out;
    
    public SubwayPrinter(PrintWriter out) {
        this.out = new PrintWriter(out);
    }
    
    public void printDirections(List route) {
        Connection connection = (Connection) route.get(0);
//        try{
	        String currentLine = connection.getLineName();
	        String previousLine = currentLine;
	        
	        out.println("Start out at " + connection.getStation1().getName() + "."+"<br>");
	        out.println("Get on the " + currentLine + " heading towards " + connection.getStation2().getName() + "."+"<br>");
	        
	        for (int i = 1; i < route.size(); i++) {
	            connection = (Connection) route.get(i);
	            currentLine = connection.getLineName();
	            if (currentLine.equals(previousLine)) {
	                out.println("  Continue past  " + connection.getStation1().getName() + "..."+"<br>");
	            }
	            else {
	                out.println("When you get to " + connection.getStation1().getName() + ", get off the " + previousLine + "."+"<br>");
	                out.println("Switch over to the " + currentLine + ", heading towards " + connection.getStation2().getName() + "."+"<br>");
	                previousLine = currentLine;
	            }
	        }
	        out.println("Get off at " + connection.getStation2().getName() + " and enjoy yourself!"+"<br>");
//	    }catch(Exception e){
//	    	System.out.println("Line is unavailable");
//	    }
    }
}
