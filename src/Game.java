/**
 * Esta classe eh que eh a do Jogo
 * Esta cria um tabuleiro e colaca pecas nele
 * E gere as jogadas
 */
public class Game {

    private Board board;

    public Game(int level) {
        board = Utilities.loadLevel(level);
    }


}
