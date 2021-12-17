package src.User;

import src.Algo.isValid;

class Planche extends Commande implements isValid {
     Planche(Data d){
        super(d);
    }
    @Override
    public boolean isValid() {

        return super.isValid();
    }

    float getl() {
        return super.getLong();
    }


}
