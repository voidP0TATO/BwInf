import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	
	FileReader fr;
	
	@SuppressWarnings("resource")
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
			reader.close();
			return finish;
			
		} catch (IOException e) {
	
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	public Line[] loadLines(String[] linesstring){
		
		Line[] lines;
		String k = linesstring[0];
		int index  = Integer.valueOf(k);
		lines = new Line[index];
		
		System.out.println("found " + k + " lines");
		
		for(int i = 1; i <= index; i++){
			
			String[] segments = linesstring[i].split(" ");
			float x1,x2,y1,y2;
			x1 = Float.parseFloat(segments[0]);
			y1 = Float.parseFloat(segments[1]);
			x2 = Float.parseFloat(segments[2]);
			y2 = Float.parseFloat(segments[3]);
			
			lines[i-1] = new Line(x1, x2, y1, y2);
			
		}
		
		System.out.println("splitted strings to Lines[]");
		return lines;
	}
	
}
