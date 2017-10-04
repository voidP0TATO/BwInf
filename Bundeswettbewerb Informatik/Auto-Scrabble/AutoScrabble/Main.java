package AutoScrabble;

import java.util.ArrayList;

public class Main {
	String path = "D:/Downloads/Bundeswettbewerb Informatik/Auto-Scrabble/kuerzelliste.txt";
	String[] cities;
	
	public static void main(String[] args){
		
		new Main();
		
	}
	
	public Main(){
		
		Reader reader = new Reader();
		cities = reader.loadFile(path);
		getlicenseplates("VERKEHRSWEGEPLANUNGSBESCHLEUNIGUNGSGESETZ");
		
	}
	
	public void getlicenseplates(String word){
		
		String original = word;
		String rest;
		String[] finish;
		
		for(int k = 2; k <= original.length() && k <= 5; k++){
		
			word = original.substring(0,k);
			finish = getlicenseplate(word);
			rest = original.substring(k);
			
			if(rest.length() == 0 ){
				
				for(int i = 0; i < finish.length; i++ ){
					
					System.out.println(finish[i]);
				
				}
				
			}else for(int i = 0; i < finish.length; i++ ){
			
				getpart(finish[i], rest);
			
			}
		}
		
	}
	
	public void getpart(String plates, String rest){
		
		String original = rest;
		String nextrest;
		String[] finish;
		
		for(int k = 2; k <= original.length() && k <= 5; k++){
		
			rest = original.substring(0,k);
			finish = getlicenseplate(rest);
			nextrest = original.substring(k);
			
			if(nextrest.length() == 0){
				
				for(int i = 0; i < finish.length; i++ ){
					
					System.out.println(plates + " + " + finish[i]);
				
				}
				
			}else for(int i = 0; i < finish.length; i++ ){
			
				getpart(plates + " + " + finish[i], nextrest);
			
			}
		}
		
		
	}
 	
	public String[] getlicenseplate(String part){
		
		String original = part;
		ArrayList<String> re = new ArrayList<String>();
		String city = "----";
		
		switch(part.length()){
	
		case 2:
			city = part.substring(0, 1);
			break;
		case 3:	
			city = part.substring(0, 2);
			break;
		default:
			city = part.substring(0, 3);
			
		}
		
		int found = 0;
		
		for(int i = 0; i < cities.length; i++){
			
			if(city.contains(cities[i]) && city.startsWith(String.valueOf(cities[i].charAt(0)))){
				
				part = original.substring(cities[i].length(), original.length());
				
				if(part.length() <= 2){
					
					re.add(cities[i] + "-" + part);
					found++;
					
				}
				
			}
			
		}
		
		String[] ret = new String[found];
		
		for(String finish : re){
			
			ret[found-1] = finish;
			//System.out.println(finish);
			found--;
			
		}
		
		return ret;
		
	}
	
}
