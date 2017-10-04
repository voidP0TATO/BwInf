package AutoScrabble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

	public String[] loadFile(String path){
		
		File file = new File(path);
		
		System.out.println("loaded file");
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
		
			List<String> lines = new ArrayList<String>();
			String line = null;
			int index = 0;
		
		
			while((line = reader.readLine()) != null){
				
				lines.add(line);
				index++;
				
			}
			
			String[] finish = new String[index];
			
			int i = 0;
			
			for(String linefinish : lines){
				
				finish[i] = linefinish;
				i++;
				
			}
			
			System.out.println("loaded lines");
			return finish;
			
		} catch (IOException e) {
	
			e.printStackTrace();
			
		}
		
		return null;
	}
	
}
