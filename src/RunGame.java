import java.io.IOException;

/**
 * Classe q tem o main
 */
public class RunGame {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//TO USE THE "USER INTERFACE"
		
		/*
		int level = Utilities.levelUserInterface();	
		
		Board board = Utilities.loadLevel(level);
		BreadFristSearch bfs = new BreadFristSearch(board);
		DepthFristSearch dfs = new DepthFristSearch(board);
		GreedySearch greedy = new GreedySearch(board);
		AStarSearch astar = new AStarSearch(board);

		System.out.println("star Board");
		System.out.println(board.toString());
	
		bfs.solver();
		dfs.solver();
		greedy.solver();
		astar.solver();
		*/
		
		
		//TO GENERATE FILES
		
		/*
		Utilities.writeFilesBFS();
		Utilities.writeFilesDFS();
		Utilities.writeFilesGreedy();
		Utilities.writeFilesAstarSearch();
		*/
		
	}
}