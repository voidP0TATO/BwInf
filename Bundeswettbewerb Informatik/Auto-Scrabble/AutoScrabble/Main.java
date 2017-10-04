package AutoScrabble;

public class Main {
	String path = "D:/Downloads/Bundeswettbewerb Informatik/Auto-Scrabble/kuerzelliste.txt";
	String[] cities;
	
	public static void main(String[] args){
		
		new Main();
		
	}
	
	public Main(){
		
		Reader reader = new Reader();
		cities = reader.loadFile(path);
		System.out.println(getpart("FFRS"));
		
	}
	
	public String[] getlicensepaltes(String word){
		
		
		
	}
	
	public String getpart(String part){
		
		String city;
		
		switch(part.length()){
		
		case 0:
		case 1:
			return "";	
		case 2:
			city = part.substring(0, 1);
			break;
		case 3:	
			city = part.substring(0, 2);
			break;
		default:
			city = part.substring(0, 3);
			
		}
		
		
		
		
		for(int i = 0; i < cities.length; i++){
			
			if(cities[i].contentEquals(city)){
				
				part = part.substring(cities[i].length(), part.length());
				
				return cities[i] + "-" + part;
				
			}
			
		}
		
		return "";
		
	}
	
}
