package extracter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.*;

public class CSVTestReader {

	public static void main(String[] args){
		
		File file = new File("/Users/philhannant/Documents/TEST.csv");
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			CSVIterator it = new CSVIterator(reader);
			while(it.hasNext()){
				System.out.println(Arrays.toString(it.next()));
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
