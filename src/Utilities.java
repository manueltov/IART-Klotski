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
<<<<<<< refs/remotes/origin/master
}





=======

    public static void writeFiles () throws IOException {
    	BufferedWriter writermoveCount = new BufferedWriter(new FileWriter("moveCount.txt"));
        BufferedWriter writernumOfBoards = new BufferedWriter(new FileWriter("numOfBoards.txt"));
        BufferedWriter writermemoryUsage = new BufferedWriter(new FileWriter("memoryUsage.txt"));
        BufferedWriter writertime = new BufferedWriter(new FileWriter("time.txt"));
    	for (int i = 1 ; i <= 50 ; i++){
        	System.out.println("level " + i);
            Board board = Utilities.loadLevel(i);
            BreadFristSearch bfs = new BreadFristSearch(board);
            bfs.solver();
            writeFileAux("moveCount.txt", writermoveCount, bfs);
            writeFileAux("numOfBoards.txt", writernumOfBoards, bfs);
            writeFileAux("memoryUsage.txt", writermemoryUsage, bfs);
            writeFileAux("time.txt", writertime, bfs);
        }
    	writermoveCount.close();
    	writernumOfBoards.close();
    	writermemoryUsage.close();
    	writertime.close();
    }
    
    private static void writeFileAux (String fileName, BufferedWriter writer, BreadFristSearch bfs) throws IOException {
    	switch (fileName) {
    		case "moveCount.txt":
    			writer.append(bfs.getMoveCount() + "\n");
    	        break;
	    	
    		case "numOfBoards.txt":
    			writer.append(bfs.getNumBoard() + "\n");
    	        break;
    		
    		case "memoryUsage.txt":
    			writer.append(bfs.getNumBoard() + "\n");
    	        break;
    		
    		case "time.txt":
    			writer.append(bfs.getActualMemUsed() + "\n");
		        break;
    	}
    }
}
>>>>>>> update
