import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class GreedySearch {
	
	private Board originalBoard; //original starting board
	private Board currentBoard; //the board we have just taken out of the fringe
	private PriorityQueue<Node> nodes;
	private HashSet<Board> boardSeen; //hashset of all repeat boards
	private Node temp;
	private int moveCount;
	private int numBoard;
	private long startTime;
	private long stopTime;
	private float time;
	private float actualMemUsed;

	public GreedySearch(Board stardBoard) {
		this.originalBoard=stardBoard;
		this.currentBoard=stardBoard;

		this.numBoard=0;
		this.startTime=0;
		this.stopTime=0;
		this.time=0;

		boardSeen = new HashSet<Board>();
		
		boardSeen.add(stardBoard);
		

		nodes= new PriorityQueue<Node>(10000, new NodeComparator());
		nodes.add(new Node(originalBoard));

	}
	

	private class NodeComparator implements Comparator<Node>{
		@Override //compares the manhattan distance between two objects for our priority queue
		public int compare(Node obj1, Node obj2){
			
			//System.out.println(obj1.getMath());
			//System.out.println();
			if (obj1.getMath() > obj2.getMath()){
				return 1;
			}else if (obj1.getMath() < obj2.getMath()){
				return -1;
			}else{
				return 0;
			}
		}
	}
	
	
	private int calculateManhattan(Board board){

		Piece goalPicePosition= board.getGoalPiece();

		int sumdistance = 0; //calculates distance between  piece in current board and goal
		for (Piece i: board.getPieces()){
			if ((goalPicePosition.getPieceType().equals(i.getPieceType()))){
				sumdistance += Math.abs((i.getUpperPoint().getX() - goalPicePosition.getUpperPoint().getX()));
				sumdistance += Math.abs((i.getUpperPoint().getY() - goalPicePosition.getUpperPoint().getY()));
			}
		}
		return sumdistance;
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
					//System.out.println("new piece positions in board to be searched: " + "\n" + possibleBoard);
					
					Node n = new Node(possibleBoard);
					n.setMath(possibleBoard.calculateManhattan());
	

					nodes.add(n);

					boardSeen.add(possibleBoard);
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


	public boolean isSolved(){
		if(currentBoard.getboardMap().containsValue(currentBoard.getGoalPiece())) {
			return true;
		}
		return false;
	}



	public void solver(){
		
		startTime = System.currentTimeMillis();
		moveCount = 0;
		long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

		while (!nodes.isEmpty()){
			
			this.findAllPossibleMoves();
			
			if(isSolved()) {
				break;
			}
					
			temp =nodes.remove(); //takes out board from list
			currentBoard = temp.getBoard();

			moveCount++;
		}		
		
		long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		stopTime = System.currentTimeMillis();
		time=(float)(stopTime - startTime)/1000;
		actualMemUsed = afterUsedMem-beforeUsedMem;	
		
		System.out.println("+---------------------------------+");
		System.out.println("| Solve whit Greedy First Search  |");
		System.out.println("+---------------------------------+\n");
		System.out.println("move count: " + moveCount);
		System.out.println("number of boards added to nodes: " + numBoard);
		System.out.println("menory usage: "+actualMemUsed/1024/1024+" MB");
		System.out.println("final time : " + time+" seconds\n");
		
		
		System.out.println("Find Solution");
		System.out.println("Short Moves to Goal State : "+currentBoard.getMoves().size());
		System.out.println(currentBoard.toString());
		
	}

	public Board getCurrBoard() {
		return currentBoard;
	}

	public Queue<Node>getNodes(){
		return this.nodes;
	}

	public  HashSet<Board> getseeB(){
		return this.boardSeen;
	}

	public int getMoveCount() {
		return moveCount;
	}

	public int getNumBoard() {
		return numBoard;
	}

	public float getActualMemUsed() {
		return actualMemUsed;
	}

	public float getTime() {
		return time;
	}
}
