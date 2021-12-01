package src.User;

import src.Algo.isValid;

import java.util.ArrayList;
import java.util.List;



class Fournisseur  implements Igenerable, isValid {
    List<Panneau> FourCommands = new ArrayList<>();
    int id;

    Fournisseur(int id, List<Data> d){
        this.id = id;
        for (int i = 0; i < d.size(); i++) {
            this.FourCommands.add(new Panneau(d.get(i)));
        }
    }
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getSize() {
        return this.FourCommands.size();
    }



    @Override
    public boolean isValid() {
        boolean bp = true;
        for (int i = 0; i < this.FourCommands.size(); i++) {
            Panneau p = this.FourCommands.get(i);
            boolean tmp =  p.isValid();
            bp = bp && tmp;
        }
        if (bp == false){
            System.out.println("Client -> Planche : NOT VALID");
        }

        return bp;
    }



}
