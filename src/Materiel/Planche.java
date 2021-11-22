package src.Materiel;

public class Planche extends Commande {
    public Planche(int id, int nombre, String date, float price, float L, float l){
        super(id,nombre,date,price,L,l);
    }

    @Override
    public Boolean isValid() {
        return super.isValid();
    }
}
