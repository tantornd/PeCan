package card.SupportCard.food.healing;

import card.SupportCard.food.healing.HealingFood;
import javafx.scene.image.Image;

public class Pizza extends HealingFood {
    public Pizza() {
        super(1, 2);
    }

    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("Pizza.png").toString());
    }
}
