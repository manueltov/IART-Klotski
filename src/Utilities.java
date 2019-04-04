import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta classe tem metodos uteis para as restantes classes
 */
public class Utilities {

    /**
     * Este metodo apos ler ficheiro vai carregar as varias pecas desse nivel
     * para um tabueleiro e devolve esse tabuleiro jah com as pecas
     * @param levelnum - nivel a carregar
     * @return devolve um tabuleiro com as peças nas posição inicial desse nivel
     */
    public static Board loadLevel(int levelnum) {
        String fileName = "level" + levelnum + ".txt";
        int[] nums = fileToNumVector(fileName);
        Point firstPoint = new Point(nums[4], nums[5]);
        Point secondPoint = new Point(nums[6], nums[7]);
        Piece goalPiece = new Piece(firstPoint,secondPoint);
        Board board = new Board(nums[0],nums[1], goalPiece);
        for (int i = 8; i < nums.length ; i++){
            Point onePoint = new Point(nums[i],nums[++i]);
            Point twoPoint = new Point(nums[++i], nums[++i]);
            Piece piece = new Piece(onePoint, twoPoint);
            board.insertPieceBoard(piece);
        }
        return board;
    }

    /**
     * Metodo auxiliar que recebe um ficheiro com as coordenadas das
     * peças e devolve um vetor com as peças
     * @param fileName - nome do ficheiro que vai ser lido
     * @return vector de interios proveniente do ficheiro
     */
    private static int[] fileToNumVector (String fileName){
        ArrayList<String> arrString1 = new ArrayList<>();
        ArrayList<Integer> arrString2 = new ArrayList<>();
        try{
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine())
                arrString1.add(sc.nextLine());
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String str: arrString1) {
            String[] vec = str.split(" ");
            for (String str2 : vec)
                arrString2.add(Integer.parseInt(str2));
        }
        int[] numbers = new int[arrString2.size()];
        int i = 0;
        for (int num : arrString2)
            numbers[i++] = num;
        return numbers;
    }
    
    public static int levelUserInterface() {
		int level = 0;
		int maxLevel = 50;
		Scanner sc = new Scanner(System.in);
		while (level < 1 | level > maxLevel) {
			System.out.println("Chose a level between 1 and " + maxLevel + ":");
			String strlevel = sc.nextLine();
			level = Integer.parseInt(strlevel);
		}
		sc.close();
		return level;
	}

    // --------------------------------
    //  BFS
    // --------------------------------
    public static void writeFilesBFS () throws IOException {
    	BufferedWriter writermoveCount = new BufferedWriter(new FileWriter("BFSmoveCount.txt"));
        BufferedWriter writernumOfBoards = new BufferedWriter(new FileWriter("BFSnumOfBoards.txt"));
        BufferedWriter writermemoryUsage = new BufferedWriter(new FileWriter("BFSmemoryUsage.txt"));
        BufferedWriter writertime = new BufferedWriter(new FileWriter("BFStime.txt"));
    	for (int i = 1 ; i <= 46 ; i++){
        	System.out.println("level " + i);
            Board board = Utilities.loadLevel(i);
            BreadFristSearch bfs = new BreadFristSearch(board);
            bfs.solver();
            writeFileAuxBFS("BFSmoveCount.txt", writermoveCount, bfs);
            writeFileAuxBFS("BFSnumOfBoards.txt", writernumOfBoards, bfs);
            writeFileAuxBFS("BFSmemoryUsage.txt", writermemoryUsage, bfs);
            writeFileAuxBFS("BFStime.txt", writertime, bfs);
        }
    	writermoveCount.close();
    	writernumOfBoards.close();
    	writermemoryUsage.close();
    	writertime.close();
    }
    
    private static void writeFileAuxBFS (String fileName, BufferedWriter writer, BreadFristSearch bfs) throws IOException {
    	switch (fileName) {
    		case "BFSmoveCount.txt":
    			writer.append(bfs.getMoveCount() + "\n");
    	        break;
	    	
    		case "BFSnumOfBoards.txt":
    			writer.append(bfs.getNumBoard() + "\n");
    	        break;
    		
    		case "BFSmemoryUsage.txt":
    			writer.append(bfs.getActualMemUsed() + "\n");
    	        break;
    		
    		case "BFStime.txt":
    			writer.append(bfs.getTime() + "\n");
		        break;
    	}
    }
	
	// --------------------------------
    //  DFS
    // --------------------------------
    public static void writeFilesDFS () throws IOException {
    	BufferedWriter writermoveCount = new BufferedWriter(new FileWriter("DFSmoveCount.txt"));
        BufferedWriter writernumOfBoards = new BufferedWriter(new FileWriter("DFSnumOfBoards.txt"));
        BufferedWriter writermemoryUsage = new BufferedWriter(new FileWriter("DFSmemoryUsage.txt"));
        BufferedWriter writertime = new BufferedWriter(new FileWriter("DFStime.txt"));
    	for (int i = 1 ; i <= 46 ; i++){
        	System.out.println("level " + i);
            Board board = Utilities.loadLevel(i);
            DepthFristSearch dfs=new DepthFristSearch(board);
            dfs.solver();
            writeFileAuxDFS("DFSmoveCount.txt", writermoveCount, dfs);
            writeFileAuxDFS("DFSnumOfBoards.txt", writernumOfBoards, dfs);
            writeFileAuxDFS("DFSmemoryUsage.txt", writermemoryUsage, dfs);
            writeFileAuxDFS("DFStime.txt", writertime, dfs);
        }
    	writermoveCount.close();
    	writernumOfBoards.close();
    	writermemoryUsage.close();
    	writertime.close();
    }
    
    private static void writeFileAuxDFS (String fileName, BufferedWriter writer, DepthFristSearch dfs) throws IOException {
    	switch (fileName) {
    		case "DFSmoveCount.txt":
    			writer.append(dfs.getMoveCount() + "\n");
    	        break;
	    	
    		case "DFSnumOfBoards.txt":
    			writer.append(dfs.getNumBoard() + "\n");
    	        break;
    		
    		case "DFSmemoryUsage.txt":
    			writer.append(dfs.getActualMemUsed() + "\n");
    	        break;
    		
    		case "DFStime.txt":
    			writer.append(dfs.getTime() + "\n");
		        break;
    	}
    }
    
    
    // --------------------------------
    //  Greedy
    // --------------------------------
    public static void writeFilesGreedy () throws IOException {
    	BufferedWriter writermoveCount = new BufferedWriter(new FileWriter("GreedymoveCount.txt"));
        BufferedWriter writernumOfBoards = new BufferedWriter(new FileWriter("GreedynumOfBoards.txt"));
        BufferedWriter writermemoryUsage = new BufferedWriter(new FileWriter("GreedymemoryUsage.txt"));
        BufferedWriter writertime = new BufferedWriter(new FileWriter("Greedytime.txt"));
    	for (int i = 1 ; i <= 46 ; i++){
        	System.out.println("level " + i);
            Board board = Utilities.loadLevel(i);
            GreedySearch greedy = new GreedySearch(board);
            greedy.solver();
            writeFileAuxGreedy("GreedymoveCount.txt", writermoveCount, greedy);
            writeFileAuxGreedy("GreedynumOfBoards.txt", writernumOfBoards, greedy);
            writeFileAuxGreedy("GreedymemoryUsage.txt", writermemoryUsage, greedy);
            writeFileAuxGreedy("Greedytime.txt", writertime, greedy);
        }
    	writermoveCount.close();
    	writernumOfBoards.close();
    	writermemoryUsage.close();
    	writertime.close();
    }
    
    private static void writeFileAuxGreedy (String fileName, BufferedWriter writer, GreedySearch greedy) throws IOException {
    	switch (fileName) {
    		case "GreedymoveCount.txt":
    			writer.append(greedy.getMoveCount() + "\n");
    	        break;
	    	
    		case "GreedynumOfBoards.txt":
    			writer.append(greedy.getNumBoard() + "\n");
    	        break;
    		
    		case "GreedymemoryUsage.txt":
    			writer.append(greedy.getActualMemUsed() + "\n");
    	        break;
    		
    		case "Greedytime.txt":
    			writer.append(greedy.getTime() + "\n");
		        break;
    	}
    }
    

    // --------------------------------
    //  AstarSearch
    // --------------------------------
    public static void writeFilesAstarSearch () throws IOException {
    	BufferedWriter writermoveCount = new BufferedWriter(new FileWriter("AstarSearchmoveCount.txt"));
        BufferedWriter writernumOfBoards = new BufferedWriter(new FileWriter("AstarSearchnumOfBoards.txt"));
        BufferedWriter writermemoryUsage = new BufferedWriter(new FileWriter("AstarSearchmemoryUsage.txt"));
        BufferedWriter writertime = new BufferedWriter(new FileWriter("AstarSearchtime.txt"));
    	for (int i = 1 ; i <= 46 ; i++){
        	System.out.println("level " + i);
            Board board = Utilities.loadLevel(i);
    		AStarSearch astar = new AStarSearch(board);
    		astar.solver();
    		writeFileAuxAStarSearch("AstarSearchmoveCount.txt", writermoveCount, astar);
    		writeFileAuxAStarSearch("AstarSearchnumOfBoards.txt", writernumOfBoards, astar);
    		writeFileAuxAStarSearch("AstarSearchmemoryUsage.txt", writermemoryUsage, astar);
    		writeFileAuxAStarSearch("AstarSearchtime.txt", writertime, astar);
        }
    	writermoveCount.close();
    	writernumOfBoards.close();
    	writermemoryUsage.close();
    	writertime.close();
    }
    
    private static void writeFileAuxAStarSearch (String fileName, BufferedWriter writer, AStarSearch astar) throws IOException {
    	switch (fileName) {
    		case "AstarSearchmoveCount.txt":
    			writer.append(astar.getMoveCount() + "\n");
    	        break;
	    	
    		case "AstarSearchnumOfBoards.txt":
    			writer.append(astar.getNumBoard() + "\n");
    	        break;
    		
    		case "AstarSearchmemoryUsage.txt":
    			writer.append(astar.getActualMemUsed() + "\n");
    	        break;
    		
    		case "AstarSearchtime.txt":
    			writer.append(astar.getTime() + "\n");
		        break;
    	}
    }
}