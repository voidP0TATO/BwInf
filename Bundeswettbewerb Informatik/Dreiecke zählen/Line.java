
public class Line {

	float x1, x2, y1, y2, m, t; 
	
	public Line(float x1, float x2, float y1, float y2){
		
		if(x1 > x2){ //to make sure m*x + t is correct
			
			float xs = x1;
			x1 = x2;
			x2 = xs;
			float ys = y1;
			y1 = y2;
			y2 = ys;
			
			
		}
		
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		m = (y2-y1)/(x2-x1);
		t = y1;
		if(!((m*x1) != (m*x1))){//if m*x1 is infinity t is still y1
			
			t -= m*x1;
			
		}
		
	}
	
}
