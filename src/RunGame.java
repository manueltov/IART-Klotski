/**
 * Classe q tem o main
 */
public class RunGame {

    public static void main(String[] args) {
    	Point onePoint=new Point(1, 0);
    	Point twoPoint=new Point(2, 1);
    	
    	Piece piece=new Piece(onePoint, twoPoint);
        
    	
    	System.out.println(piece.getPieceType());
    	
    	System.out.println(onePoint.hashCode());
    	System.out.println(twoPoint.hashCode());
    	System.out.println(piece.toString());
    	
    	

    }
}
