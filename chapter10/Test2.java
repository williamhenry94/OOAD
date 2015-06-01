package chapter10;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class Test2 {

	@Test
	public void test() {
		 try {
	        	SubwayLoader loader = new SubwayLoader();
				Subway objectville = loader.loadFromFile(new File("C:/william/workspace/Subway/src/chapter10/ObjectvilleSubway.txt"));
				boolean x= objectville.hasConnection("XHTML Expressway", "Infinite Circle", "Rumbaugh Line");
				assertEquals(true, x);
				boolean y= objectville.hasConnection("XHTML Expressway", "Infinite Loop", "Rumbaugh Line");
				assertEquals(false, y);
				
				boolean z= objectville.hasConnection("XHTML Expressway", "Infinite Circle", "Rumbaugh");
				assertEquals(false, z);
				boolean a= objectville.hasConnection("XHTML Expressway", "Infinite Circle", "LSP Lane");
				assertEquals(false, a);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
