package chapter10;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class Test8 {

	@Test
	public void test() {
		try {
        	SubwayLoader loader = new SubwayLoader();
        	Subway objectville = loader.loadFromFile(new File("C:/william/workspace/Subway/src/chapter10/ObjectvilleSubway.txt"));
			assertNotNull(objectville);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
