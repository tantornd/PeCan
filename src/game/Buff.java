package game;

public class Buff {
    private int rounds;
    private int amount;
    public Buff(int rounds, int amount){
        this.rounds = rounds;
        this.amount = amount;
    }
    public void decrementRounds(){
        if (rounds > 0){
            rounds--;
        }
    }
    public int getRounds(){
        return rounds;
    }

    public int getAmount() {
        return amount;
    }
}
