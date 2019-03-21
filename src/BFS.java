import java.io.*;
import java.util.*;
import java.util.Queue;

public class BFS {

public class BFS {


	private Board originalBoard; //original starting board
	private Board goalBoard; // end game 
	private Board currentBoard; //the board we have just taken out of the fringe
	private Queue<Node>nodes;
	private HashSet<Board> boardSeen; //hashset of all repeat boards
	private Node temp;
	private int moveCount; 
	private int boardMove;
	private int numBoard;
	private long startTime;
	private long stopTime;


	public BFS (Board stardBoard , Board goalBoard) {

		this.originalBoard=stardBoard;
		this.goalBoard=goalBoard;
		this.currentBoard=stardBoard;

		this.boardMove=0;
		this.boardMove=0;
		this.numBoard=0;
		this.startTime=0;
		this.startTime=0;

		boardSeen = new HashSet<Board>();
		boardSeen.add(stardBoard);

		nodes=new LinkedList<Node>();
		nodes.add(new Node(originalBoard));
		
	}

	public  boolean tryMoveDirection(Point point,String direction) {

		HashMap<Point ,Piece> currentboardMap=currentBoard.getboardMap();
		Board possibleBoard;


		if(currentboardMap.containsKey(point)){
			Point upperLeftPoint=currentboardMap.get(point).getUpperPoint();
			Point movePoint= new Point(-1, -1);
			switch (direction) {

			case "left": movePoint=new Point(upperLeftPoint.getX()-1, upperLeftPoint.getY());



			break;

			case "right": movePoint=new Point(upperLeftPoint.getX()+1, upperLeftPoint.getY());
			break;

			case "up": movePoint=new Point(upperLeftPoint.getX(), upperLeftPoint.getY()-1);

			break;

			case "down": movePoint=new Point(upperLeftPoint.getX(), upperLeftPoint.getY()+1);
			break;
			}

			try {

				possibleBoard=currentBoard.makeMove(currentboardMap.get(point),movePoint);

				try{
					possibleBoard.isOK(); 
				}catch (IllegalStateException e){
					System.out.println(e.getMessage()); 
				}


				if (!boardSeen.contains(possibleBoard)){
					numBoard++;
					System.out.println("new block positions in board: " + "\n" + possibleBoard);
					Node n = new Node(possibleBoard);
					nodes.add(n);
					boardSeen.add(possibleBoard);
					boardMove++;
				}



			}catch(IllegalStateException e){
				return false;
			}

		}else {
			return false;
		}

		return true;


	}








	public void findAllPossibleMoves(){

		HashMap<Point,Piece> currTray = currentBoard.getboardMap(); //our board implementation


		for (int i=0; i < currentBoard.getWidth(); i++){
			for(int j=0; j < currentBoard.getHeight(); j++){


				if (!currTray.containsKey(new Point(i,j))){ //looks for empty spaces until it finds one

					if (i-1 >= 0){ //tries moving piece from the left right down and up of that empty space
						this.tryMoveDirection(new Point(i-1, j), "right");

					}

					if(i+1 < currentBoard.getWidth()){
						this.tryMoveDirection(new Point(i+1, j), "left");


					}

					if(j-1 >= 0){
						this.tryMoveDirection(new Point(i, j-1), "down");




					}
					if(j+1 < currentBoard.getHeight()){
						this.tryMoveDirection(new Point(i, j+1), "up");


					}

				}
			}
		}


	}

	public Board getCurrBoard() {
		return currentBoard;

	}

	public Queue<Node>getNodes(){
		return this.nodes;
	}


	public boolean isSolved(){

		for (Piece i: goalBoard.getPieces()){ //checks to see if all blocks in goal board are in same position in current board
			if (!currentBoard.getPieces().contains(i)) 
				return false; 
		} 
		return true; 
	}


	
	// o codigo nao funciona da forma esperada ainda 
	public void solve(){

		moveCount = 0;

		while ( !this.nodes.isEmpty()){ //  ja implementado  issolved depois e para meter aqui 
			boardMove = 0;
			this.findAllPossibleMoves(); //see below code

			temp =nodes.remove(); //takes out board from list
			currentBoard = temp.getBoard();

			moveCount++;
		}

	}


}




