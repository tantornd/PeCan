package game;

import card.CharacterCard.BaseCharacterCard;
import card.CharacterCard.GetType;
import card.SupportCard.BaseSupportCard;
import card.SupportCard.BowCard;
import card.SupportCard.Grimoire;
import card.SupportCard.SwordCard;
import util.Randomizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class GameLogic {
    private final ArrayList<BaseSupportCard> deck;
    private final ArrayList<ArrayList<BaseSupportCard>> playerHands;
    private ArrayList<ArrayList<BaseCharacterCard>> characterCards;
    private ArrayList<Integer> dice;
    private ArrayList<CarryOnDamage> carryOnDamage;
    private int currentPlayer;
    private static GameLogic instance;
    private static boolean isGameEnd;
    private static boolean win;
    private GameLogic() {
        this.deck = new ArrayList<>();
        this.playerHands = new ArrayList<>(2);
        this.characterCards = new ArrayList<>(2);
        this.dice = new ArrayList<>(2);
        this.carryOnDamage = new ArrayList<>(2);
        isGameEnd = false;
        win = false;
        for (int i = 0; i < 2; i++) {
            ArrayList<BaseSupportCard> hand = new ArrayList<>();
            playerHands.add(hand);
            characterCards.add(new ArrayList<>());//ADD EMPTY ARRAYLIST TO ADD CHARACTERS IN
            dice.add(8);
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
    public void initGame() {

        //TODO: ADD JAVA FX!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        //Waiting for constructors and adding support card
        for (int i = 0; i < 2; i++) {
            deck.add(new BowCard());
            deck.add(new Grimoire());
            deck.add(new SwordCard());
        }
        // Shuffle and hand out 5 cards to each player
        Collections.shuffle(deck);
        for (int i = 0; i < 10; i++) {
            BaseSupportCard card = deck.remove(0);
            playerHands.get(i % 2).add(card);
        }
        newEnemyCharacters(); //Add enemy characters
    }
    public void endGame(){
        //TODO: ADD JAVA FX!!!!!
        //TODO: IF WIN GO TO WIN SCENE IF LOSE GO TO LOSE SCENE
    }
    public void initRound(){
        if (isGameEnd){
            endGame();
        }
        else {
            draw(0, 1);
            draw(1, 1);
            resetDice();

            //TODO: ADD JAVA FX!!!!!!!!!!!!!!!!!!
        }

    }
    public void endRound(){
        takeCarryOnDamage();

         //TODO: ADD JAVA FX!!!!!!!!!!!!!!!!!

        initRound();
    }
    public void nextPlayerTurn(){
        currentPlayer = (currentPlayer + 1) % 2;

        //TODO: ADD JAVA FX??????????????????
        //TODO TANTORN CHECK IF ALL ALIVE AND GO TO ENDGAME
        if (!isHandPlayable(0) && !isHandPlayable(1)) endRound();
        if (!isHandPlayable(currentPlayer)) nextPlayerTurn();//IF CURRENT PLAYER CANNOT PLAY GO TO NEXT PLAYER
    }
    public boolean isHandPlayable(int idx){
        ArrayList<BaseSupportCard> player = playerHands.get(idx);
        boolean not_found = true;
        int i = 0;
        while (not_found && i < player.size()){
            BaseSupportCard temp = player.get(i);
            i += 1;
            if (temp.isPlayable()){
                not_found = false;
            }
        }
        return !not_found;
    }
    public void newEnemyCharacters(){
        characterCards.get(1).add(Randomizer.getRandomElement(GetType.getDmgType()));
        BaseCharacterCard temp = Randomizer.getRandomElement(GetType.getDmgType());
        while(temp == characterCards.get(1).get(0)) temp = Randomizer.getRandomElement(GetType.getDmgType());
        characterCards.get(1).add(temp);
        characterCards.get(1).add(Randomizer.getRandomElement(GetType.getSupportType()));
    }
    public ArrayList<BaseSupportCard> draw(int player, int amount){
        if (amount > deck.size()){
            amount = deck.size();
        }
        ArrayList<BaseSupportCard> out = new ArrayList<>();
        for (int i = 0; i < amount; i++){
            out.add(deck.get(deck.size()-1)); //Card Drawn
            playerHands.get(player).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
        return out;
    }
    public void resetDice(){
        dice.set(0, 8);
        dice.set(1, 8);
    }
    public BaseCharacterCard getActiveChara(ArrayList<BaseCharacterCard> characterCards){
        for (BaseCharacterCard e: characterCards){
            if (e.getActive()) return e;
        }
        return null;
    }
    public void takeCarryOnDamage(){
        for (int i = 0; i < 2; i++){
            if (carryOnDamage.get(i) == null || carryOnDamage.get(i).getRounds() == 0) continue;
            if (carryOnDamage.get(i).getAttackAll()){
                for (BaseCharacterCard b: characterCards.get(i)){
                    b.takeDamage(carryOnDamage.get(i).getDamage());
                }
                carryOnDamage.get(i).decrementRounds();
                //may have an error if no carry on dmg in arraylist
            }
            else{
                getActiveChara(characterCards.get(i)).takeDamage(carryOnDamage.get(i).getDamage());
            }
        }
    }
}
