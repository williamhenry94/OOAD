package chapter10;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Test;

public class Test16 {

	

	@Test
	public void test() {

        try {
        	SubwayLoader loader = new SubwayLoader();
			Subway objectville = loader.loadFromFile(new File("C:/william/workspace/Subway/src/chapter10/ObjectvilleSubway.txt"));
			loader.brokeStation("Infinite Circle");
			Station station=objectville.getStation("Infinite Circle");
			assertEquals(false, station.getStatus());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}

}
