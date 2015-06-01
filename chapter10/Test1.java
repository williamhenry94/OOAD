package chapter10;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class Test1 {

	@Test
	public void test() {
		
         try {
        	SubwayLoader loader = new SubwayLoader();
			Subway objectville = loader.loadFromFile(new File("C:/william/workspace/Subway/src/chapter10/ObjectvilleSubway.txt"));
			assertEquals(true, objectville.hasStation("JSP Junction"));
			assertEquals(false, objectville.hasStation("Head First Pub"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}

}
