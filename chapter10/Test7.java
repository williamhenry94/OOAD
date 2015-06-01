package chapter10;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class Test7 {

	@Test
	public void test() {
		try {
        	SubwayLoader loader = new SubwayLoader();
        	Subway objectville = loader.loadFromFile(new File("C:/william/workspace/Subway/src/chapter10/ObjectvilleSubway.txt"));
			Connection s=objectville.addConnection("XHTML Expressway", "Servlet Springs", "JORR Expressway");
			assertNotNull(s);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
