package src.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import src.Algo.*;
import src.Materiel.*;

public class Fournisseur<E> extends User<E> implements isValid{
    List<Planche> FourCommands = new ArrayList<Planche>();


    @Override
    public Boolean isValid() {
        List<Boolean> validFourniCommand = new ArrayList<>();
        for (int tmp = 0; tmp < FourCommands.size();tmp++) {
            validFourniCommand.add(FourCommands.get(tmp).date.isValid() || FourCommands.get(tmp).price.isValid() || FourCommands.get(tmp).isValid());
            System.out.println("Test Index" + tmp + "is equal to" + validFourniCommand.get(tmp));
            if (!validFourniCommand.get(tmp)) {
                return validFourniCommand.get(tmp);
            }

        }
        return true;
    }
}
