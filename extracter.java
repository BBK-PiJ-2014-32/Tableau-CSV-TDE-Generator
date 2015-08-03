
import com.tableausoftware.TableauException;
import com.tableausoftware.DataExtract.*;

import org.apache.commons.csv.*;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class extracter {
	
	private File file;
	
	
	public void getFile() throws FileNotFoundException {
		if(!file.exists()){
			File file = new File("CSVTest.csv");
			}
	}

	
	public void Parser(){
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


		
	}

	
}
