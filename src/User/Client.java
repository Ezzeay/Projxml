package src.User;

import src.Algo.isValid;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;


public class Client implements Igenerable, isValid {
    List<Planche> ClientCommand = new ArrayList<>();
    int id;

    Client(int id, List<Data> listPlanche) {
        this.id = id;
        for (int i = 0; i < listPlanche.size(); i++) {
            this.ClientCommand.add(new Planche(listPlanche.get(i)));
        }
    }
    @Override
    public int getId(){
        return this.id;
    }

    @Override
    public int getSize() {
        return this.ClientCommand.size();
    }



    @Override
    public boolean isValid() {
        boolean bp = true;
        for (int i = 0; i < this.ClientCommand.size(); i++) {
            Planche p = this.ClientCommand.get(i);
            boolean tmp =  p.isValid();
            bp = bp && tmp;
        }
        if (bp == false){
            System.out.println("Client -> Planche : NOT VALID");
        }

        return bp;
    }




}
