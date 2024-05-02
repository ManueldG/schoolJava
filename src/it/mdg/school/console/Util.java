package it.mdg.school.console;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Util {
	
	public static final String PATTERN_EMAIL = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	public static final String PATTERN_DATE = "^\\d{1,2}/\\d{1,2}/\\d{4}$";
	public static final String PATTERN_CF =  "^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$";
	
	
	public Util() {
		
	}
	
	public static boolean check(String field, String regexPattern){
		
	    return Pattern.compile(regexPattern)
	      .matcher(field)
	      .matches();
	    
	}
	
	public static String convertToCSV(String[] data) {
	    return Stream.of(data)
	      .map(Util::escapeSpecialCharacters)
	      .collect(Collectors.joining(","));
	}
	
	public static String escapeSpecialCharacters(String data) {
	    if (data == null) {
	        throw new IllegalArgumentException("Input data cannot be null");
	    }
	    String escapedData = data.replaceAll("\\R", " ");
	    if (data.contains(",") || data.contains("\"") || data.contains("'")) {
	        data = data.replace("\"", "\"\"");
	        escapedData = "\"" + data + "\"";
	    }
	    return escapedData;
	}
	
	public static void writeToFile(String line, String file) throws IOException {
		
		try {
			
			BufferedWriter br = new BufferedWriter(new FileWriter(file,true));	
						
			br.write(line);			
			
			br.close();
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}
	
	public static void resetFile( String file) throws IOException {
		
		try {
			
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			
			br.write("");
			
			br.close();
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}
	
	public static <K> void saveEntity(List<K> list) {		
		
		String file = list.get(0).getClass().getSimpleName() + ".txt";
		
		try {
			resetFile(file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		for(K elem : list) {
			
			try {
				
				Object classs = elem.getClass().cast(elem);
				Util.writeToFile( classs.toString(), file );
				
			}
			catch (IOException e) {
				
				System.out.println(e.getCause().getMessage());
				
				e.printStackTrace();
			}
			
		}
			
		
	}
	
	
}
