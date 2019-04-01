import java.util.Scanner;

/**
 * Classe q tem o main
 */
public class RunGame {

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
        Algorithms a= new Algorithms(board);

        System.out.println("Start Board");
        System.out.println(board.toString());

        //a.bfsSolver();
       // a.dfsSolver();
        //a.greedySolver();
        a.aStartSolver();

        /*for(Board s : bfs.getseeB()) { 
        	  System.out.println(s.toString()); 
        	}*/

/*
        /// GENERATE OUTPUT

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        for (int i = 1 ; i < 12 ; i++){
            Board board = Utilities.loadLevel(i);
            Algorithms a= new Algorithms(board);
            writer.write("Level: " + i + "\n");
            writer.write("BFS Solver: \n");
            a.bfsSolver();
            writer.write("move count: \n");
            writer.write(a.getMoveCount() + "\n");
            writer.write("number of boards added to nodes: \n");
            writer.write(a.getNumBoard() + "\n");
            writer.write("final time: \n");
            writer.write(a.getTime() + "\n");
        }
        writer.close();
    }

    */
    }
}
