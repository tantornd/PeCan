package card.CharacterCard;

import java.util.ArrayList;

public class GetType { //Used in GameLogic
    public static ArrayList<BaseCharacterCard> getDmgType(){
        ArrayList<BaseCharacterCard> out = new ArrayList<>();
        out.add(new AssassinCard());
        out.add(new FlameArcherCard());
        out.add(new KnightCard());
        out.add(new PalladinCard());
        out.add(new MageCard());
        return out;
    }
    public static ArrayList<BaseCharacterCard> getSupportType(){
        ArrayList<BaseCharacterCard> out = new ArrayList<>();
        out.add(new BardCard());
        out.add(new PriestCard());
        return out;
    }
}
