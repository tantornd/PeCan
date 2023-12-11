package card.SupportCard.weapons;

import card.CharacterCard.BaseCharacterCard;
import card.SupportCard.TargetSelectable;
import game.GameLogic;
import game.WeaponType;

public class SwordCard extends WeaponCard{
    public SwordCard() {
        super();
    }
    @Override
    public void play() {
        //TODO: CHECK IF IS PLAYABLE
        //TODO: SELECT TARGET
        //TODO: INCREASE TARGET'S ATTACK BY 1 USING CHARACTERCARDS.GET(selected character) AND METHODS FROM CHARACTERCARD CLASS
        //TODO: USEDICE(GETCOST)
        //NOTE: NO NEED TO NEXT PLAYER TURN, PLAYERS CAN KEEP USING SUPPORT CARDS
    }

    @Override
    public boolean isPlayable() {
        GameLogic game = GameLogic.getInstance();
        if (game.getDice().get(game.getCurrentPlayer()) < getCost()) return false;
        for (BaseCharacterCard e: game.getCharacterCards().get(game.getCurrentPlayer())){
            if (e.getWeaponType() == WeaponType.SWORD) return true;
        }
        return false;
    }
}
