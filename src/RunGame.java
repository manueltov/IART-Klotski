import java.lang.reflect.Array;
import java.util.ArrayList;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

/**
 * Classe q tem o main
 */
public class RunGame {

    public static void main(String[] args) {

        Board board = new Board(5, 4);

        Point onePoint = new Point(0, 0);
        Point twoPoint = new Point(0, 0);
        Piece piece = new Piece(onePoint, twoPoint);

        Point onePoint1 = new Point(0, 1);
        Point twoPoint1 = new Point(0, 1);
        Piece piece1 = new Piece(onePoint1, twoPoint1);

        Point onePoint2 = new Point(1, 0);
        Point twoPoint2 = new Point(2, 1);
        Piece piece2 = new Piece(onePoint2, twoPoint2);


        Point onePoint3 = new Point(3, 0);
        Point twoPoint3 = new Point(3, 0);
        Piece piece3 = new Piece(onePoint3, twoPoint3);

        Point onePoint4 = new Point(3, 1);
        Point twoPoint4 = new Point(3, 1);
        Piece piece4 = new Piece(onePoint4, twoPoint4);

        Point onePoint5 = new Point(0, 2);
        Point twoPoint5 = new Point(0, 3);
        Piece piece5 = new Piece(onePoint5, twoPoint5);

        Point onePoint6 = new Point(1, 2);
        Point twoPoint6 = new Point(1, 2);
        Piece piece6 = new Piece(onePoint6, twoPoint6);


        Point onePoint7 = new Point(2, 2);
        Point twoPoint7 = new Point(2, 2);
        Piece piece7 = new Piece(onePoint7, twoPoint7);


        Point onePoint8 = new Point(3, 2);
        Point twoPoint8 = new Point(3, 3);
        Piece piece8 = new Piece(onePoint8, twoPoint8);



    	
        board.insertPieceBoard(piece);
    	board.insertPieceBoard(piece1);
    	board.insertPieceBoard(piece2);
        board.insertPieceBoard(piece3);
        board.insertPieceBoard(piece4);
        board.insertPieceBoard(piece5);
        board.insertPieceBoard(piece6);
        board.insertPieceBoard(piece7);
        board.insertPieceBoard(piece8);
        board.insertPieceBoard(piece9);
        board.insertPieceBoard(piece10);
        board.insertPieceBoard(piece11);
        board.insertPieceBoard(piece12);

   ///////////////////////////////////////////////////////////////////////////
        
       
        BFS bfs=new BFS(board,board);
        
      
        bfs.findAllPossibleMoves();
        //bfs.solve();
        
        
        /*for(Node s : bfs.getNodes()) { 
        	  System.out.println(s.getBoard().toString()); 
        	}*/
        
       
      
        
        
        
        
        
    	
    	
    	
    	
    	
    	


    }
}
