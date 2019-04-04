public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public  boolean equals(Object point){
		if(this==point) {
			return true;
		}
		Point point2=(Point)point;
		return point2.x==this.x && point2.y==this.y;
	}

	public String toString() {
		return "(" + this.x+","+this.y+")";
	}

	public void validatePoint(){
		if (this.x < 0 || this.y < 0) {
			throw new IllegalArgumentException("Negative Point");
		}
	}

	@Override
	public int hashCode(){
		return (Integer.toString(x) + "," + Integer.toString(y)).hashCode();
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x=x;
	}

	public void setY(int y) {
		this.y=y;
	}
}
