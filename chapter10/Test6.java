package chapter10;

import static org.junit.Assert.*;

import java.io.File;
import java.util.*;
import java.io.IOException;

import org.junit.Test;

public class Test6 {

	@Test
	public void test() {
		try {
        	SubwayLoader loader = new SubwayLoader();
			Subway objectville = loader.loadFromFile(new File("C:/william/workspace/Subway/src/chapter10/ObjectvilleSubway.txt"));
			List a= (LinkedList) objectville.getDirections("XHTML Expressway", "JSP Junction");
			assertNotNull(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
