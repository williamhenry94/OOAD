package chapter10;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class Test4 {

	@Test
	public void test() {
		try {
        	SubwayLoader loader = new SubwayLoader();
			Subway objectville = loader.loadFromFile(new File("C:/william/workspace/Subway/src/chapter10/ObjectvilleSubway.txt"));
			boolean x= objectville.hasStation("xcxc");
			assertEquals(false, x);
			objectville.addStation("xcxc");
			boolean a=objectville.hasStation("xcxc");
			assertEquals(true, a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
