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
        int maxLevel = 1;
        int level = 0;
        Scanner sc = new Scanner(System.in);
        while (level < 1 | level > maxLevel) {
            System.out.println("Chose a level between 1 and " + maxLevel + ":");
            String strlevel = sc.nextLine();
            level = Integer.parseInt(strlevel);
        }
        sc.close();
        
        
        Board board = Utilities.loadLevel(level);
        Algorithms a= new Algorithms(board);


     
        System.out.println("Start Board"); 
        System.out.println(board.toString()); 
        
        //a.bfsSolver();
        //a.dfsSolver();
        a.greedySolver();
        
        
        /*for(Node s : a.getNodes()) { 
        	  System.out.println(s.getBoard().toString()); 
        	}*/
    }
}
