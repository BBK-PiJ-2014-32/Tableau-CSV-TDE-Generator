package extracter;

import com.tableausoftware.TableauException;
import com.tableausoftware.extract.*;
import com.tableausoftware.common.*;

import com.opencsv.*;

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
	private Type[] typeArray;
	private int columnCount;
	private String path;
	private CSVReader reader;
	
	
	public Extracter(int cc, String[] headingList, Type[] typeList, String filePath){
		try{
			columnCount = cc;
			headingArray = headingList;
			typeArray = typeList;
			path = filePath;
		} catch (NullPointerException ex){
			ex.printStackTrace();
		}
	}
	
	
	public void getFile() throws FileNotFoundException {
		//if(!file.exists()){
			file = new File(path);
			
			//}
	}

	
	public TableDefinition makeTableDef() throws TableauException {
        TableDefinition tableDef = new TableDefinition();
        tableDef.setDefaultCollation(Collation.EN_GB);
        for(int i = 0; i < columnCount; i++){
        	tableDef.addColumn(headingArray[i], typeArray[i]);
        }
        return tableDef;
        
       
	}
    
	public static void printTableDefinition(TableDefinition tableDef) throws TableauException {
        int numColumns = tableDef.getColumnCount();
        for ( int i = 0; i < numColumns; ++i ) {
            Type type = tableDef.getColumnType(i);
            String name = tableDef.getColumnName(i);

            System.err.format("Column %d: %s (%#06x)\n", i, name, type.getValue());
        }
    }
	
	public void csvReader(){
		try {
			getFile();
			reader = new CSVReader(new FileReader(file));
		    List<String[]> csvIn = reader.readAll();
			
			
		} catch (FileNotFoundException ex ){
			ex.printStackTrace();
		} catch (IOException ex){
			ex.printStackTrace();
		}
		
	}
			
	/**public List<String> getTableDef(){
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
	
	public void insertData(TableDefinition tableDef){
		int i = 0;
		Row row = new Row(tableDef);
		switch(getType(i)){
		case boolean : row.setBoolean(, i);
		
		
		
		}
	}
	
	public int getColumnCount(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter header title");
		columnCount = sc.nextInt();
		return columnCount;
	}
	
	public String[] getHeaders(int columnCount){
		Scanner sc = new Scanner(System.in);
		headingArray = new String[columnCount];
		String heading = "";
		for(int i = 0; i < columnCount; i++){
			System.out.println("Enter header title");
			headingArray[i] = sc.next();
		}
		sc.close();
		return headingArray;
		
	}
	
	public String getType(int column){
		
		return null;
	}


}
