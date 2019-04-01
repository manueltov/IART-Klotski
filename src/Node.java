public class Node {

	private Board myBoard;
	private boolean visited;
	private int manhatdis,gx,fx;

	public Node(Board b,int ms){
		myBoard = b;
		visited=false;
		manhatdis=ms;
		gx=0;
		fx=0;
		
		
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
	
	public void setGx(int g) {
		this.gx=this.gx+g;
	}
	
	public int getGx() {
		return gx;
	}
	
	public void setFx(int f) {
		this.fx=f;
	}
	
	public int getFx() {
		return fx;
	}
}
