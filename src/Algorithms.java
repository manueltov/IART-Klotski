import java.util.*;
import java.util.Queue;

public class Algorithms {

	private Board originalBoard; //original starting board
	private Board currentBoard; //the board we have just taken out of the fringe
	private Queue<Node>nodes;
	private HashSet<Board> boardSeen; //hashset of all repeat boards
	private Node temp;
	private int moveCount;
	private int numBoard;
	private long startTime;
	private long stopTime;
	private float time;
	Stack<Node> stack;
	private PriorityQueue<Node> prioQ;

	long mem;

	public Algorithms (Board stardBoard) {
		this.originalBoard=stardBoard;
		this.currentBoard=stardBoard;

		this.numBoard=0;
		this.startTime=0;
		this.stopTime=0;
		this.time=0;

		boardSeen = new HashSet<Board>();
		boardSeen.add(stardBoard);

		nodes=new LinkedList<Node>();
		nodes.add(new Node(originalBoard,0));
		stack=new Stack<Node>();
		stack.push(new Node(originalBoard,0));
		prioQ= new PriorityQueue<Node>(1000, new NodeComparator());
		prioQ.add(new Node(originalBoard, 0));
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
					Node n = new Node(possibleBoard,this.calculateManhattan(possibleBoard));
					nodes.add(n);
					stack.push(n);
					prioQ.add(n);
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

	public Board getCurrBoard() {
		return currentBoard;
	}

	public Queue<Node>getNodes(){
		return this.nodes;
	}

	public  HashSet<Board> getseeB(){
		return this.boardSeen;
	}

	public boolean isSolved(){
		if(currentBoard.getboardMap().containsValue(currentBoard.getGoalPiece())) {
			return true;
		}
		return false;
	}

	private class NodeComparator implements Comparator<Node>{
		@Override //compares the manhattan distance between two objects for our priority queue
		public int compare(Node obj1, Node obj2){
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
		Point uppointGoalPoint=new Point(1, 3);
		Point downPointGoalPoint=new Point(2, 4);
		Piece goalPicePosition= new Piece(uppointGoalPoint,downPointGoalPoint);
		int sumdistance = 0; //calculates distance between  piece in current board and goal board
		for (Piece i: board.getPieces()){
			if (goalPicePosition.getPieceType().equals(i.getPieceType())){
				sumdistance += Math.abs((i.getUpperPoint().getX() - goalPicePosition.getUpperPoint().getX()));
				sumdistance += Math.abs((i.getUpperPoint().getY() - goalPicePosition.getUpperPoint().getY()));
			}
		}
		return sumdistance;
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

	public void bfsSolver(){
		long finalmem;
		mem=Runtime.getRuntime().freeMemory();
		startTime = System.currentTimeMillis();
		moveCount = 0;
		while (!nodes.isEmpty()){
			this.findAllPossibleMoves();
			if(isSolved()) {
				break;
			}
			temp =nodes.remove(); //takes out board from list
			currentBoard = temp.getBoard();

			moveCount++;
		}
		stopTime = System.currentTimeMillis();
		time=(float)(stopTime - startTime)/1000;
		finalmem=Runtime.getRuntime().freeMemory();

		System.out.println("+---------------------------------+");
		System.out.println("| Solve whit Breadth First Search |");
		System.out.println("+---------------------------------+");
		System.out.println("move count: " + moveCount);
		System.out.println("number of boards added to nodes:" + numBoard);
		System.out.println("final time : " + time+" seconds\n");
		System.out.println("Breadth First Search Find Solution");
		System.out.println(currentBoard.toString());

		/*System.out.println("Short Moves to Goal State :\n");
		System.out.println("Moves :"+currentBoard.getMoves().size());
		System.out.println("(x y)to(x y)\n");
		System.out.println(currentBoard.displayMoves());
		System.out.println("Free memory: " +mem);
		System.out.println("Free final memory: " +finalmem);*/
	}

	public void dfsSolver() {

		long finalmem;
		mem=Runtime.getRuntime().freeMemory();

		startTime = System.currentTimeMillis();
		moveCount = 0;

		while (!stack.isEmpty()){
			this.findAllPossibleMoves();
			if(isSolved()) {
				break;
			}
			temp =stack.pop(); //takes out board from list
			currentBoard = temp.getBoard();

			moveCount++;
		}
		stopTime = System.currentTimeMillis();
		time=(float)(stopTime - startTime)/1000;
		finalmem=Runtime.getRuntime().freeMemory();

		System.out.println("+---------------------------------+");
		System.out.println("| Solve whit Deep First Search    |");
		System.out.println("+---------------------------------+");
		System.out.println("move count: " + moveCount);
		System.out.println("number of boards added to nodes:" + numBoard);
		System.out.println("final time : " + time+" seconds\n");
		System.out.println("Deep First Search Find Solution");
		System.out.println(currentBoard.toString());

		/*System.out.println("Short Moves to Goal State :\n");
		System.out.println("Moves :"+currentBoard.getMoves().size());
		System.out.println("(x y)to(x y)\n");
		System.out.println(currentBoard.displayMoves());
		System.out.println("Free memory: " +mem);
		System.out.println("Free final memory: " +finalmem);*/
	}

	public void greedySolver() {

		long finalmem;
		mem=Runtime.getRuntime().freeMemory();

		startTime = System.currentTimeMillis();
		moveCount = 0;

		while (!prioQ.isEmpty()){
			this.findAllPossibleMoves();
			if(isSolved()) {
				break;
			}
			temp =prioQ.remove(); //takes out board from list
			currentBoard = temp.getBoard();

			moveCount++;
		}
		stopTime = System.currentTimeMillis();
		time=(float)(stopTime - startTime)/1000;
		finalmem=Runtime.getRuntime().freeMemory();

		System.out.println("+---------------------------------+");
		System.out.println("|    Solve whit Greedy Search     |");
		System.out.println("+---------------------------------+");
		System.out.println("move count: " + moveCount);
		System.out.println("number of boards added to nodes:" + numBoard);
		System.out.println("final time : " + time+" seconds\n");
		System.out.println("Greedy Search Find Solution");
		System.out.println(currentBoard.toString());

		/*System.out.println("Short Moves to Goal State :\n");
		System.out.println("Moves :"+currentBoard.getMoves().size());
		System.out.println("(x y)to(x y)\n");
		System.out.println(currentBoard.displayMoves());
		System.out.println("Free memory: " +mem);
		System.out.println("Free final memory: " +finalmem);*/
	}
}
