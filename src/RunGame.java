import java.util.ArrayList;

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


        Point onePoint9 = new Point(1, 3);
        Point twoPoint9 = new Point(1, 3);
        Piece piece9 = new Piece(onePoint9, twoPoint9);


        Point onePoint10 = new Point(2, 3);
        Point twoPoint10 = new Point(2, 3);
        Piece piece10 = new Piece(onePoint10, twoPoint10);

        Point onePoint11 = new Point(0, 4);
        Point twoPoint11 = new Point(0, 4);
        Piece piece11 = new Piece(onePoint11, twoPoint11);

        Point onePoint12 = new Point(3, 4);
        Point twoPoint12 = new Point(3, 4);
        Piece piece12 = new Piece(onePoint12, twoPoint12);

<<<<<<<HEAD

                =======
        //Só para exemplo (1x2)
        Point onePoint13 = new Point(1, 4);
        Point twoPoint13 = new Point(2, 4);
        Piece piece13 = new Piece(onePoint13, twoPoint13);




>>>>>>>2d 3134 b5b3d9461f2e1f47f512f98d508b705f3c

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
<<<<<<<HEAD
        ///////////////////////////////////////////////////////////////////////////


        //bfs=new BFS(board,board);
        //System.out.println(board.toString());
        //Point po=new Point(0,4);
        //System.out.println(board.getboardMap().get(po).toString());

        // bfs.tryMoveDirection(po,"right");
        //bfs.tryMoveDirection(po,"left");
        //bfs.findAllPossibleMoves();
        /*System.out.println("--------------------------------------------------------------------------------------------------");
        //exemplo
       
=======
        //exemplo
        board.insertPieceBoard(piece13);
>>>>>>> 2d3134b5b3d9461f2e1f47f512f98d508b705f3c
    	
    	System.out.println("--------------------------------------------------------------------------------------------------");
    	
    	System.out.println("Peça_tipo_1x1");
    	System.out.println(piece12.getPieceType());
    	System.out.println(piece12.toString());
    	
    	System.out.println("--------------------------------------------------------------------------------------------------");
    	
        System.out.println("Peça_tipo 2x1");
        System.out.println(piece5.getPieceType());
        System.out.println(piece5.toString());
        
        System.out.println("--------------------------------------------------------------------------------------------------");

<<<<<<< HEAD
 
=======
    	System.out.println("Peça_tipo 1x2");
    	System.out.println(piece13.getPieceType());
    	System.out.println(piece13.toString());
    	
    	System.out.println("--------------------------------------------------------------------------------------------------");
>>>>>>> 2d3134b5b3d9461f2e1f47f512f98d508b705f3c
    	
    	System.out.println("Peça_tipo 2x2");
    	System.out.println(piece2.getPieceType());
    	System.out.println(piece2.toString());
    	
    	System.out.println("--------------------------------------------------------------------------------------------------");

<<<<<<< HEAD
    	
=======
>>>>>>> 2d3134b5b3d9461f2e1f47f512f98d508b705f3c
    	System.out.println(board.toString());
    	//System.out.println(board.displayMoves());
    	System.out.println(bfs.getCurrBoard().toString());*/

        BFS bfs = new BFS(board, board);
        
        /*System.out.println(board.toString());
        
        
     
        Point po=new Point(0,4);
        bfs.tryMoveDirection(po,"right");
        System.out.println(bfs.getCurrBoard().toString());
        
        
        Point po1=new Point(1,4);
        bfs.tryMoveDirection(po1,"right");
        System.out.println(bfs.getCurrBoard().toString());
       
        
        Point po2=new Point(2,4);
        bfs.tryMoveDirection(po2,"left");
        System.out.println(bfs.getCurrBoard().toString());*/

        bfs.findAllPossibleMoves();


        //System.out.println(board.getboardMap().get(po).toString());


    }
}
