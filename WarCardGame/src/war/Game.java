/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package war;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * @author Benson Li, Xavier Faria, Joshua Faria, John Paua
 */

/**
 * This class runs the execution of the War card game.
 */
public class Game {

    /**
     * Field Variables
     */
    private final Deck deck;
    private final Player player1;
    private final Player player2;
    private int roundNo;

    /**
     * Constructor
     */
    public Game() {
        this.deck = new Deck();
        this.player1 = new Player();
        this.player2 = new Player();
        this.roundNo = 1;
    }

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Game game = new Game();
        try {
            GameManager.Instance().startPrompt(game.player1, game.player2);
            GameManager.Instance().runGame(game.player1, game.player2, game.deck, game.roundNo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
