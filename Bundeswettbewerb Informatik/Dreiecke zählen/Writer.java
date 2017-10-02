import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {

	private String pathout;
	private ArrayList<String> Output;
	
	public Writer(String pathout){
		
		this.pathout = pathout;
		Output = new ArrayList<String>();
		
	}
	
	public void addLine(String line){
		
		Output.add(line);
		
	}
	
	public void writefile(){
		
		try {
			
			FileWriter filewriter = new FileWriter(pathout);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			
			for(String line : Output){
				
				bufferedwriter.write(line);
				bufferedwriter.newLine();
				
			}
			
			bufferedwriter.close();
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
