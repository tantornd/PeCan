package card.SupportCard.event;

import java.util.ArrayList;

public class GetAllEvent{
    public static ArrayList<EventCard> getAll(){
        ArrayList<EventCard> temp = new ArrayList<>();
        temp.add(new AfterShock());
        temp.add(new Devour());
        temp.add(new DivineGrace());
        temp.add(new DoubleDraw());
        temp.add(new PerfectBarrier());
        temp.add(new StimBeacon());
        temp.add(new Weaken());
        return temp;
    }
}
