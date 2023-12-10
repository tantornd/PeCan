package card.SupportCard.weapons;

import card.SupportCard.TargetSelectable;

public class GrimoireCard extends WeaponCard implements TargetSelectable {
    public GrimoireCard() {super();}

    @Override
    public void play() {

    }

    @Override
    public boolean isPlayable() {
        return false;
    }

    @Override
    public void selectTarget() {

    }
}
