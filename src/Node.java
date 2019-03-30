public class Node {

	private Board myBoard;
	private boolean visited;
	private int manhatdis;

	public Node(Board b,int ms){
		myBoard = b;
		visited=false;
		manhatdis=ms;
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

	public int getMath() {

		return this.manhatdis;
	}

	public void setVisited(boolean isVisited) {

		this.visited=isVisited;
	}
}
