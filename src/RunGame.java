import java.io.IOException;
import java.util.Scanner;

/**
 * Classe q tem o main
 */
public class RunGame {

<<<<<<< refs/remotes/origin/master
    /**
     * Metodo main
     * Pergunta que nivel o client pretende jogar e de seguida cria um tabuleiro
     * com as peças correspondentes ao nivel pedido e vai jogado esse nivel com cada algoritmo
     * @param args
     */
    public static void main(String[] args) {
        int maxLevel = 26;
        int level = 0;
        Scanner sc = new Scanner(System.in);
        while (level < 1 | level > maxLevel) {
            System.out.println("Chose a level between 1 and " + maxLevel + ":");
            System.out.println("[ ATENTION!!! ]  Don't chose odd level between 12 and " + maxLevel + "  [ ATENTION!!! ]");
            String strlevel = sc.nextLine();
            level = Integer.parseInt(strlevel);
        }
        sc.close();
        
        
        
        
        
        
        

        Board board = Utilities.loadLevel(level);
        BreadFristSearch bfs= new BreadFristSearch(board);
        DeepFristSearch dfs=new DeepFristSearch(board);
        GreedySearch greedy=new GreedySearch(board);
        AStartSearch astart=new AStartSearch(board);

        System.out.println("Start Board");
        System.out.println(board.toString());
        //bfs.solver();
       // dfs.solver();
       greedy.solver();
        //astart.solver();

      
    }

    */
    }
}
=======
	/**
	 * Metodo main
	 * Pergunta que nivel o client pretende jogar e de seguida cria um tabuleiro
	 * com as peças correspondentes ao nivel pedido e vai jogado esse nivel com cada algoritmo
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//TO GENERATE FILES
		
		//Utilities.writeFilesBFS();
		//Utilities.writeFilesDFS();
		//Utilities.writeFilesGreedy();
		//Utilities.writeFilesAStartSearch();
		
		/*
		//TO USE THE USER INTERFACE
		int level = Utilities.levelUserInterface();	
		
		Board board = Utilities.loadLevel(level);
		BreadFristSearch bfs= new BreadFristSearch(board);
		DeepFristSearch dfs=new DeepFristSearch(board);
		GreedySearch greedy=new GreedySearch(board);
		AStartSearch astart=new AStartSearch(board);

		System.out.println("Start Board");
		System.out.println(board.toString());
	
		bfs.solver();
		//dfs.solver();
		//greedy.solver();
		//astart.solver();
      	
      	*/
      	}
<<<<<<< refs/remotes/origin/master

		
	
}
>>>>>>> update
=======
}
>>>>>>> update
