package game;

import card.CharacterCard.BaseCharacterCard;
import card.CharacterCard.GetCharacterType;
import card.SupportCard.BaseSupportCard;
import card.SupportCard.food.GetAllFood;
import card.SupportCard.weapons.BowCard;
import card.SupportCard.weapons.GrimoireCard;
import card.SupportCard.weapons.SwordCard;
import util.Randomizer;

import java.util.ArrayList;
import java.util.Collections;

public class GameLogic {
    private final ArrayList<BaseSupportCard> deck;
    private final ArrayList<ArrayList<BaseSupportCard>> playerHands;
    private ArrayList<ArrayList<BaseCharacterCard>> characterCards;
    private ArrayList<Integer> dice;
    private ArrayList<CarryOnDamage> carryOnDamage; //IF NONE, ARRAYLIST HOLDS NULL
    private ArrayList<Buff> buff;
    private int currentPlayer;
    private static GameLogic instance;
    private static boolean gameEnd;
    private static boolean win;
    private GameLogic() {
        this.deck = new ArrayList<>();
        this.playerHands = new ArrayList<>(2);
        this.characterCards = new ArrayList<>(2);
        this.dice = new ArrayList<>(2);
        this.carryOnDamage = new ArrayList<>(2);
        this.buff = new ArrayList<>(2);
        gameEnd = false;
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

        for (int i = 0; i < 3; i++) {
            deck.add(new BowCard());
            deck.add(new GrimoireCard());
            deck.add(new SwordCard());
        }
        for (int i = 0; i < 3; i++){
            deck.addAll(GetAllFood.getAll());
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
        if (gameEnd){
            endGame();
        }
        else {
            draw(0, 1);
            draw(1, 1);
            resetDice();
            resetFull();
            for(int i = 0; i < 2; i++){
                if (buff.get(i) != null){
                    for (BaseCharacterCard e: characterCards.get(i)){
                        e.setBaseAttack(e.getBaseAttack() + buff.get(i).getAmount());
                    }
                }
            }

            //TODO: ADD JAVA FX!!!!!!!!!!!!!!!!!! มนจว่าต้องมีไหม

            currentPlayer = (currentPlayer + 1) % 2;
            nextPlayerTurn();
        }

    }
    public void endRound(){
        takeCarryOnDamage();
        for (Buff e: buff){
            if (e != null){
                e.decrementRounds();
                if (e.getRounds() <= 0){
                    e = null;
                }
            }
        }

         //TODO: ADD JAVA FX!!!!!!!!!!!!!!!!!

        initRound();
    }
    public void nextPlayerTurn(){
        currentPlayer = (currentPlayer + 1) % 2;
        //TODO TANTORN: ADD BOT COMMAND HERE

        //TODO: ADD JAVA FX FOR PLAYER

        if (characterCards.get(currentPlayer).isEmpty()) {
            if (currentPlayer == 1) win = true;
            gameEnd = true;
            endGame();
        }
        else{
            if (!canAttack(0) && !canAttack(1)) {
                if (!isHandPlayable(0) && !isHandPlayable(1)) endRound();
                else if (!isHandPlayable(currentPlayer)) nextPlayerTurn();
                //IF CURRENT PLAYER CANNOT PLAY CARD IN HAND GO TO NEXT PLAYER
                //IF HAND IS PLAYABLE DO NOTHING
            }
            else if (!canAttack(currentPlayer)) nextPlayerTurn();
        }

    }
    public ArrayList<BaseCharacterCard> getOpponentChar(){
        return characterCards.get((currentPlayer + 1) % 2);
    }
    public boolean canAttack(int idx){
        ArrayList<BaseCharacterCard> player = characterCards.get(idx);
        boolean not_found = true;
        int i = 0;
        while (not_found && i < player.size()){
            BaseCharacterCard temp = player.get(i);
            i += 1;
            if (temp.canAttack()){
                not_found = false;
            }
        }
        return !not_found;
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
        characterCards.get(1).add(Randomizer.getRandomElement(GetCharacterType.getDmgType()));
        BaseCharacterCard temp = Randomizer.getRandomElement(GetCharacterType.getDmgType());
        while(temp == characterCards.get(1).get(0)) temp = Randomizer.getRandomElement(GetCharacterType.getDmgType());
        characterCards.get(1).add(temp);
        characterCards.get(1).add(Randomizer.getRandomElement(GetCharacterType.getSupportType()));
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
        dice.set(0, 10);
        dice.set(1, 10);
    }
    public void resetFull(){
        for (int i = 0; i < 2; i++){
            for (BaseCharacterCard e: characterCards.get(i)){
                e.setFull(false);
            }
        }
    }
    public BaseCharacterCard getActiveChara(ArrayList<BaseCharacterCard> characterCards){
        for (BaseCharacterCard e: characterCards){
            if (e.getActive()) return e;
        }
        return null;
    }
    public void useDice(int amount){
        setDice(getCurrentPlayer(), getDice().get(currentPlayer) - amount);
    }
    public void takeCarryOnDamage(){
        for (int i = 0; i < 2; i++){
            if (carryOnDamage.get(i) == null) continue;
            if (carryOnDamage.get(i).getAttackAll()){
                for (BaseCharacterCard b: characterCards.get(i)){
                    b.setHp(b.getHp() - carryOnDamage.get(i).getDamage());
                    if (!b.isAlive()){
                        characterCards.get(i).remove(b);
                    }
                }
                carryOnDamage.get(i).decrementRounds();
                //may have an error if no carry on dmg in arraylist
            }
            else{
                getActiveChara(characterCards.get(i)).setHp(getActiveChara(characterCards.get(i)).getHp()
                        - carryOnDamage.get(i).getDamage());
                if (!getActiveChara(characterCards.get(i)).isAlive()){
                    characterCards.remove(getActiveChara(characterCards.get(i)));
                }
                carryOnDamage.get(i).decrementRounds();
            }
            if (carryOnDamage.get(i).getRounds() == 0){
                carryOnDamage.set(i, null);
            }
        }
    }

    public ArrayList<ArrayList<BaseCharacterCard>> getCharacterCards() {
        return characterCards;
    }

    public ArrayList<ArrayList<BaseSupportCard>> getPlayerHands() {
        return playerHands;
    }

    public ArrayList<BaseSupportCard> getDeck() {
        return deck;
    }

    public ArrayList<CarryOnDamage> getCarryOnDamage() {
        return carryOnDamage;
    }

    public ArrayList<Integer> getDice() {
        return dice;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCarryOnDamage(ArrayList<CarryOnDamage> carryOnDamage) {
        this.carryOnDamage = carryOnDamage;
    }

    public void setCharacterCards(ArrayList<ArrayList<BaseCharacterCard>> characterCards) {
        this.characterCards = characterCards;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setDice(int idx, int amount) {
        this.dice.set(idx, amount);
    }

    public static void setGameEnd(boolean isGameEnd) {
        GameLogic.gameEnd = isGameEnd;
    }

    public ArrayList<Buff> getBuff() {
        return buff;
    }
}
