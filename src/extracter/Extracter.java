package extracter;

import com.tableausoftware.TableauException;
import com.tableausoftware.DataExtract.*;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


public class Extracter {
	
	private File file;
	private String[] headingArray;
	
	public void getFile() throws FileNotFoundException {
		if(!file.exists()){
			File file = new File("CSVTest.csv");
			}
	}

	
	/**public void Parser(){
		try {
			getFile();
			Reader in = new FileReader("file");
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
			for (CSVRecord record : records) {
			    String lastName = record.get("Last Name");
			    String firstName = record.get("First Name");
			}
			
			
		} catch (FileNotFoundException ex ){
			ex.printStackTrace();
		} catch (IOException ex){
			ex.printStackTrace();
		}
		
	}
			
	public List<String> getTableDef(){
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			List<String> lines = new ArrayList<>();
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			System.out.println(lines.get(0));
			return lines;
		} catch (FileNotFoundException ex ){
			ex.printStackTrace();
		} catch (IOException ex){
			ex.printStackTrace();
		}
		return null;


		
	}*/
	
	public String[] getHeaders(int columnCount){
		Scanner sc = new Scanner(System.in);
		headingArray = new String[columnCount];
		String heading = "";
		for(int i = 0; i < columnCount; i++){
			System.out.println("Enter header title");
			headingArray[i] = sc.next();
		}
		return headingArray;
		
	}

	public static void main(String[] args){
		Extracter ex = new Extracter();
		ex.run();
	}
	
	public void run(){
		getHeaders(4);
		
	}
}
