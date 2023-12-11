package card.SupportCard.food;

import card.SupportCard.BaseSupportCard;
import card.SupportCard.food.healing.MieangPlaPao;
import card.SupportCard.food.healing.Pizza;
import card.SupportCard.food.healing.Salad;
import card.SupportCard.food.healing.Spaghetti;
import card.SupportCard.food.shielding.BananaShake;
import card.SupportCard.food.shielding.BobaTea;
import card.SupportCard.food.shielding.CrabCakes;
import card.SupportCard.food.shielding.SpringRolls;

import java.util.ArrayList;

public class GetAllFood {
    public static ArrayList<BaseSupportCard> getAll(){
        ArrayList<BaseSupportCard> out = new ArrayList<>();
        out.add(new MieangPlaPao());
        out.add(new Pizza());
        out.add(new Salad());
        out.add(new Spaghetti());
        out.add(new BananaShake());
        out.add(new BobaTea());
        out.add(new CrabCakes());
        out.add(new SpringRolls());
        return out;
    }
}
