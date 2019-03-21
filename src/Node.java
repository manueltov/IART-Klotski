



public class Node {

	private Board myBoard;
	private boolean visited;




	public Node(Board b){
		myBoard = b;
		visited=false;
	}


	public Board getBoard() {

		return this.myBoard;
	}


	public void setBoard(Board board) {

		this.myBoard=board;
	}
	

	public boolean getVisited() {

		return this.visited;
	}
	
	public void setVisited(boolean isVisited) {

		this.visited=isVisited;
	}




}
