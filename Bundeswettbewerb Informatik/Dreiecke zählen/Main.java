import java.util.ArrayList;
import java.util.List;

public class Main {

	private Line[] lines;
	private List<Triangle> triangles;
	private int linecount,trianglecount;
	private String pathin = "D:/Downloads/Bundeswettbewerb Informatik/Dreiecke zählen/dreiecke1.txt";
	private String pathout = "D:/Downloads/Bundeswettbewerb Informatik/Dreiecke zählen/dreiecke1lösung.txt";
	
	public static void main(String[] args){
		
		new Main();
		
	}
	
	public Main(){
		
		importfile();
		findtriangles();
		
	}
	
	private void importfile(){
		
		System.out.println("started importing");
		
		Reader r = new Reader();
		
		String[] linesstring = r.loadFile(pathin);
		
		lines = r.loadLines(linesstring);
		
		linecount = lines.length;
		 
		System.out.println("finished Importing");
		
	}
	
	private void findtriangles(){
		
		Writer w = new Writer(pathout);
		
		System.out.println("searching for triangles");
		trianglecount = 0;
		triangles = new ArrayList<Triangle>();
		
		for(int a = 0; a < linecount - 2;a++){
			for(int b = a +1; b < linecount - 1;b++){
				for(int c = b + 1; c < linecount;c++ ){
					Triangle t = findTriangle(lines[a], lines[b], lines[c]);
					if(t != null){
						triangles.add(t);
						System.out.println("Triangle: " + a + " " + b + " "+ c);
						w.addLine("(" + t.x1 + "|" + t.y1 + ") (" + t.x2 + "|" + t.y2 + ") (" + t.x3 + "|" + t.y3 + ")");
						trianglecount++;
					}
				}
			}
		}
		
		System.out.println("found " + trianglecount + " triangles");
		w.addLine(String.valueOf(trianglecount));
		w.writefile();
	}
	
	private Triangle findTriangle(Line l1, Line l2, Line l3){
		
		Intersection i1,i2,i3;
		i1 = findIntersection(l1, l2);
		i2 = findIntersection(l1, l3);
		i3 = findIntersection(l2, l3);
		
		if(i1.inbounds && i2.inbounds && i3.inbounds){
			
			return new Triangle(i1.x, i2.x, i3.x, i1.y, i2.y, i3.y);
			
		}
		
		return null;
		
	}
	
	private Intersection findIntersection(Line l1, Line l2){
		
		if(l1 == l2){
			
			return new Intersection(true, 0f, 0f);
			
		}
		
		if(l1.m == l2.m){
			
			return new Intersection(false, 0f, 0f);
			
		}
		
		float h = (l2.t - l1.t)*1000000; // tp prevent round issues
		float g = (l1.m - l2.m)*1000000;
		
		float x = h/g;
		float y = (l1.m * x) + l1.t;
		if( y != y){
			
			y = (l2.m * x) + l2.t;
			
		}
		boolean inbounds  = (x >= l1.x1 && x <= l1.x2 && x >= l2.x1 && x <= l2.x2 )&&(((y >= l1.y1 && y <= l1.y2)||(y >= l1.y2 && y <= l1.y1))&&((y >= l2.y1 && y <= l2.y2)||(y >= l2.y2 && y <= l2.y1)));
		
		return new Intersection(inbounds, x, y);
	}
	
}
