/**
 * Classe q tem o main
 */
public class RunGame {

    public static void main(String[] args) {
    	
    	/*if (direction.equals("right")){
			move = new Point(upperl.x+1, upperl.y);
		}else if (direction.equals("left")){
			move = new Point(upperl.x-1, upperl.y);
		}else if (direction.equals("up")){
			move = new Point(upperl.x, upperl.y-1);
		}else if (direction.equals("down")){
			move = new Point(upperl.x, upperl.y+1);
		}*/
    	
    	Board board=new Board(5, 4);
    	
    	Point onePoint=new Point(1, 0);
    	Point twoPoint=new Point(2, 1);
    	Piece piece=new Piece(onePoint, twoPoint);
    	
    	Point onePoint1=new Point(3, 2);
    	Point twoPoint1=new Point(3, 3);
    	Piece piece1=new Piece(onePoint1, twoPoint1);
        
    	Point onePoint2=new Point(0, 0);
    	Point twoPoint2=new Point(0, 0);
    	Piece piece2=new Piece(onePoint2, twoPoint2);
    	
    	board.insertPieceBoard(piece);
    	board.insertPieceBoard(piece1);
    	board.insertPieceBoard(piece2);
    	
    	System.out.println("--------------------------------------------------------------------------------------------------");
    	
    	System.out.println("Peça_0");
    	System.out.println(piece.getPieceType());
    	System.out.println(piece.toString());
    	
    	System.out.println("--------------------------------------------------------------------------------------------------");
    	
    	System.out.println("Peça_1");
    	System.out.println(piece1.getPieceType());
    	System.out.println(piece1.toString());
    	
    	System.out.println("--------------------------------------------------------------------------------------------------");
    	
    	System.out.println("Peça_2");
    	System.out.println(piece2.getPieceType());
    	System.out.println(piece2.toString());
    	
    	System.out.println("--------------------------------------------------------------------------------------------------");
    	
    	System.out.println(board.toString());
    	
    	
    	
    	
    	

    }
}
