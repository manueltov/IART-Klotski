public class Node {

	private Board myBoard;
	private int manhatdis,gx,fx;

	public Node(Board b){
		myBoard = b;
<<<<<<< refs/remotes/origin/master
		visited=false;
		manhatdis=ms;
		gx=1;
=======
		manhatdis=0;
		gx=0;
>>>>>>> update
		fx=0;
	}

	public Board getBoard() {

		return this.myBoard;
	}

	public void setBoard(Board board) {

		this.myBoard=board;
	}

	public void setMath(int manth) {

		this.manhatdis=manth;
	}
	public int getMath() {

		return this.manhatdis;
	}


	public void setGx(int g) {
		this.gx=g;
	}

	public int getGx() {
		return myBoard.getG();
	}
<<<<<<< refs/remotes/origin/master
	
=======

>>>>>>> update
	public void setFx(int f) {
		this.fx=f;
	}

	public int getFx() {
		return fx;
	}
}
