package card.SupportCard.weapons;

import card.SupportCard.TargetSelectable;

public class SwordCard extends WeaponCard implements TargetSelectable {
    public SwordCard() {
        super();
    }
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
