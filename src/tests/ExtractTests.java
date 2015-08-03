package tests;

import extracter.Extracter;
import static org.junit.Assert.*;

import org.junit.Test;

public class ExtractTests {

	@Test
	public void getHeadrerTest() {
		Extracter ex = new Extracter();
		String[] ArrayTest = {"test1", "test2", "test3", "test4"};
		ex.getHeaders(4);
	
	}

}
