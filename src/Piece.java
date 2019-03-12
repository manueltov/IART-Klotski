/**
 * Esta classe define uma Peça
 */
public class Piece {
	
	private  Point upperLeft;
	private  Point lowRight;
	private String  pieceType;
	
	
	
	
	public Piece(Point fristPoint,Point secondPoint) {
		fristPoint.validatePoint();
		secondPoint.validatePoint();
		
		if(fristPoint.getX()>secondPoint.getX() || fristPoint.getY()>secondPoint.getY()) {
			throw new IllegalArgumentException("Points are not UpperLeft and LowerRight"); 
		}
		
		this.upperLeft=fristPoint;
		this.lowRight=secondPoint;
		this.pieceType=Integer.toString(getHeight()) + "x" + Integer.toString(getWidth()) ; 
		
		
	}
	
	
	public int getHeight() { 
		return ((this.lowRight.getY() - this.upperLeft.getY()) + 1); 
	} 

	public int getWidth() { 
		return ((this.lowRight.getX() - this.upperLeft.getX()) + 1); 
	} 
	
	public String getPieceType() {
		return this.pieceType;
	}
	
	
	
	public Piece copyPiece() { //returns a copy  this Piece
		return new Piece(getUpperPoint(), getLowePoint()); 
	}
	
	public int hashCode(){ 
		return upperLeft.getX() * 3 + upperLeft.getY() * 11 + lowRight.getX() * 19 +lowRight.getY() * 17; 
	} 
	
	
	public boolean equals(Object o){
		Piece piece = (Piece) o;
		return piece.upperLeft.equals(upperLeft) && piece.lowRight.equals(lowRight);
	}
	
	public void changeOrientation(Point fristPoint, Point seconPoint) { //moves the piece from one place to another whit different _hascode();

		Piece temp = new Piece(fristPoint,seconPoint); 

		if (temp.getPieceType()!= this.getPieceType()) { // check is the same type of piece
			throw new IllegalArgumentException("Piece size can not change diferente type of piece"); 
		} 

		this.upperLeft=fristPoint; 
		this.lowRight= seconPoint; 
	} 
	
	public String toString(){
		return " (" + this.upperLeft + this.lowRight + ") ";
	}
	
	public Point getUpperPoint() {
		return this.upperLeft;
	}
	
	public Point getLowePoint() {
		return this.lowRight;
	}
	
	public void settUpperPoint( Point newPoint) {
		this.upperLeft=newPoint;
	}
	
	public void  setLowePoint(Point newPoint) {
		this.lowRight=newPoint;
	}
	
	


    // ////////////////////////
    // Variables

    /*      TYPES
    -> a -> blank_space
    -> b -> 1 x 1
    -> c -> 1 x 2
    -> d -> 2 x 1
    -> e -> 2 x 2       */

    // Type
   // private char type;

    // Coordinates
    //private int x;
    //private int y;

    // ////////////////////////
    // Constructor
    /*public Piece(char type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }*/

    // ////////////////////////
    // Getters and Setters

    /*public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }*/
}