package src.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import src.Algo.*;
import src.Materiel.*;

class Fournisseur  implements Igenerable{
    List<Panneau> FourCommands = new ArrayList<Panneau>();
    int id;
    Fournisseur(int id, List<Panneau> ListPanneau){
        this.id = id;
        this.FourCommands = ListPanneau;

    }
    Fournisseur(){
        this.id = -1;
        this.FourCommands = new ArrayList<Panneau>();
    }

    @Override
    public boolean isValid() {
        List<Boolean> validFourniCommand = new ArrayList<>();
        for (int tmp = 0; tmp < FourCommands.size();tmp++) {
            validFourniCommand.add(FourCommands.get(tmp).date.isValid() || FourCommands.get(tmp).price.isValid() || FourCommands.get(tmp).isValid());
            //System.out.println("Test Index" + tmp + "is equal to" + validFourniCommand.get(tmp));
            if (!validFourniCommand.get(tmp)) {
                return validFourniCommand.get(tmp);
            }

        }
        return true;
    }
}
