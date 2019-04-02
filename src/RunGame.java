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
