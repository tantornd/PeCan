package card.SupportCard.weapons;

import card.CharacterCard.BaseCharacterCard;
import card.SupportCard.TargetSelectable;
import game.GameLogic;
import game.WeaponType;

public class GrimoireCard extends WeaponCard implements TargetSelectable {
    public GrimoireCard() {super();}

    @Override
    public void play() {
        //TODO: CHECK IF IS PLAYABLE
        //TODO: SELECT TARGET
        //TODO: INCREASE TARGET'S ATTACK BY 1 USING CHARACTERCARDS.GET(selected character) AND METHODS FROM CHARACTERCARD CLASS
        //NOTE: NO NEED TO NEXT PLAYER TURN, PLAYERS CAN KEEP USING SUPPORT CARDS
    }

    @Override
    public boolean isPlayable() {
        GameLogic game = GameLogic.getInstance();
        for (BaseCharacterCard e: game.getCharacterCards().get(game.getCurrentPlayer())){
            if (e.getWeaponType() == WeaponType.GRIMOIRE) return true;
        }
        return false;
    }

    @Override
    public void selectTarget() {
        //TODO: SELECT TARGETS THAT CAN EQUIP THIS WEAPON (ON CLICK EVENT)
        //TODO: HANDLE IF TARGET"S WEAPON TYPE DOESN'T MATCH
    }
}
