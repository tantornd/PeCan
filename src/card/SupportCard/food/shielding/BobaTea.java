package card.SupportCard.food.shielding;

import javafx.scene.image.Image;

public class BobaTea extends ShieldingFood {
    public BobaTea(){
        super(2,2);
    }
    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("BobaTea.png").toString());
    }
}
