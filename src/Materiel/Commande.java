package src.Materiel;

import src.Algo.isValid;


public abstract class Commande implements isValid {

    public int id;
    public int nombre;
    public Date date;
    public Price price;
    public float L;
    public float l;

    public Commande(int id, int nombre, String datetime, float price, float L, float l){
        this.id = id;
        this.nombre = nombre;
        this.date = new Date(datetime);
        this.price = new Price(price);
        this.L = L;
        this.l = l;

    }

    public float getPrice() {
        return this.price.getValue();
    }
    public float getL(){
        return this.L;
    }
    public float getLong(){
        return this.l;
    }
    public int getId(){
        return this.id;
    }
    public int getNombre(){
        return this.nombre;
    }



        @Override
        public Boolean isValid()
        {
            return this.L>this.l;
        }




}
