package card.SupportCard;

public abstract class BaseSupportCard {
    private int cost;
    private  String name;
    public BaseSupportCard(String name, int cost){
        setCost(cost);
        setName(name);
    }
    public void setCost(int cost){
        if (cost <= 0) cost = 0;
        this.cost = cost;
    }
    public int getCost(){
        return cost;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public abstract void play();
    public abstract boolean isPlayable();
}
