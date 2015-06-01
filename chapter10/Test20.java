package chapter10;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Test;

public class Test20 {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		try {
        	SubwayLoader loader = new SubwayLoader();
//        	new BufferedReader(new FileReader(subwayFile));
        	BufferedReader x=new BufferedReader(new FileReader(new File("C:/william/workspace/Subway/src/chapter10/ObjectvilleSubway.txt")));
        	Subway subway=new Subway();
        	loader.loadStations(subway, x);
        	String lineName=x.readLine();
        	Subway objectville = null;
        	while ((lineName != null) && (lineName.length() > 0)) {
                objectville=loader.loadLine(subway, x, lineName);
                lineName = x.readLine();
                
                
            }
        	assertNotNull(objectville);
//        	Subway objectville = loader.loadLine(new Subway(),x,"Green Line");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
