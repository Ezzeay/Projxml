package src.User;

import src.Algo.isValid;

class Panneau extends Commande implements isValid  {




     Panneau(Data d){
         super(d);

     }

     float getl(){
         return super.getLong();
     }

    @Override
    public boolean isValid() {

        return super.isValid();
    }



}
