package src.User;

import java.util.ArrayList;
import java.util.List;
import src.Algo.*;
import src.Materiel.Planche;


public class Client<E> extends User<E> implements isValid {
    List<Planche> ClientCommand = new ArrayList<>();


    @Override
    public Boolean isValid() {
        List<Boolean> validClientCommand = new ArrayList<>();
        for (int tmp = 0; tmp < ClientCommand.size();tmp++) {
            validClientCommand.add(ClientCommand.get(tmp).date.isValid() || ClientCommand.get(tmp).price.isValid() || ClientCommand.get(tmp).isValid());
            System.out.println("Test Index" + tmp + "is equal to" + validClientCommand.get(tmp));
            if (!validClientCommand.get(tmp)) {
                return validClientCommand.get(tmp);
            }
        }
        return true;
    }
}
