package src.Materiel;

public abstract class Commande {

    public int id;
    public int nombre;
    public String date;
    public int price;
    public int L;
    public int l;

    public Commande(int id, int nombre, String date, int price, int L, int l){
        this.id = id;
        this.nombre = nombre;
        this.date = date;
        this.price = price;
        this.L = L;
        this.l = l;

    }


}
