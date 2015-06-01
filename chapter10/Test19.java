package chapter10;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Test;

public class Test19 {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		try {
        	SubwayLoader loader = new SubwayLoader();
//        	new BufferedReader(new FileReader(subwayFile));
        	boolean objectville = loader.loadStations(new Subway(),new BufferedReader(new FileReader(new File("C:/william/workspace/Subway/src/chapter10/ObjectvilleSubway.txt"))));
			assertEquals(true,objectville);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
