package src.User;

import src.Algo.isValid;

import java.util.List;


import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;


public class Commande implements isValid {

    public int id;
    public int nombre;
    public Date date;
    public Price price;
    public float L;
    public float l;
    final int ATTR = 6;

    public Commande(int id, int nombre, String datetime, float price, float L, float l){
        this.id = id;
        this.nombre = nombre;
        this.date = new Date(datetime);
        this.price = new Price(price);
        this.L = L;
        this.l = l;

    }

    public Commande(Data d){
            List<String> data = Data.getDataString(d);
            for (int j = 0; j < data.size(); j++) {
                this.id = parseInt(data.get(0));
                this.nombre = parseInt(data.get(1));
                this.date = new Date(data.get(2));
                this.price = new Price(parseFloat(data.get(3)));
                this.L = parseFloat(data.get(4));
                this.l = parseFloat(data.get(5));
            }
    }
    public String getDate(){
        return this.date.getDate();
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
        public boolean isValid()
        {


            return this.L>this.l && this.date.isValid() && this.price.isValid();
        }




}
