package game;

import card.SupportCard.BaseSupportCard;

import java.util.ArrayList;

public class GameLogic {
    private final ArrayList<BaseSupportCard> deck;
    private final ArrayList<ArrayList<BaseSupportCard>> playerHands;
    private int currentPlayer;
    private static GameLogic instance;
    private GameLogic() {
        this.deck = new ArrayList<>();
        this.playerHands = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ArrayList<BaseSupportCard> hand = new ArrayList<>();
            playerHands.add(hand);
        }
        this.currentPlayer = 0;
    }
    public static GameLogic getInstance(){
        if (instance == null){
            instance = new GameLogic();
        }
        return instance;
    }
    public static void clearInstance() {instance = null;}
}
