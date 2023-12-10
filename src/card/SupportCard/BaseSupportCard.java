package card.SupportCard;

public abstract class BaseSupportCard {
    private int cost;
    public BaseSupportCard(int cost){
        setCost(cost);
    }
    public void setCost(int cost){
        if (cost <= 0) cost = 0;
        this.cost = cost;
    }
    public int getCost(){
        return cost;
    }
    public abstract void play();
    public abstract boolean isPlayable();
}
