package src.User;

import src.ES.XMLWriter;

import java.io.IOException;
import java.util.*;

public class Decoup {
    int idf;
    int idPanneau;
    int nbPanneau;
    int idc;
    int idPlanche;
    int wrappingH;
    int wrappingV;
    int nbPlanche;
    float PlancheL;
    float Planchel;
    float PanneauL;
    float Panneaul;
    float posdecx;
    float posdecy;

    Decoup(int idf, int idPanneau,float PanneauL,float Panneaul,int nbPanneau, int idc, int idPlanche,float PlancheL,float Planchel,int nbPlanche, float posdecx, float posdecy,int wrappingV,int wrappingH) {
        this.idf = idf;
        this.idPanneau = idPanneau;
        this.nbPanneau = nbPanneau;
        this.idc = idc;
        this.idPlanche = idPlanche;
        this.nbPlanche = nbPlanche;
        this.PlancheL = PlancheL;
        this.Planchel = Planchel;
        this.PanneauL = PanneauL;
        this.Panneaul = Panneaul;
        this.posdecx = posdecx;
        this.posdecy = posdecy;
        this.wrappingH = wrappingH;
        this.wrappingV = wrappingV;
    }


    static List<Decoup> DecoupALL(List<Igenerable> p, List<Igenerable> f) throws IOException {
        List<Decoup> d = new ArrayList<>();
        Decoup dec;
        List<Panneau> pn = sortbyLPN(f);
        List<Planche> pl = sortbyLPL(p);
        int tiles;
        int plsize = 0,pnsize = 0;
        float Lpl,Lpn,lpl,lpn;
        int nbpn,nb = 0,nbP;
        while (pnsize < pn.size() && plsize < pl.size()){
            Lpn = pn.get(pnsize).getL();
            lpn = pn.get(pnsize).getLong();
            nbpn = pn.get(pnsize).getNombre();
            Lpl = pl.get(plsize).getL();
            lpl = pl.get(plsize).getLong();
            nb  = pl.get(plsize).getNombre();
            float offsetx,offsety;
            nbP = 0;
            int idF = getidPN(f,pn.get(pnsize).getId(),nbpn);
            int idC = getidPL(p,pl.get(plsize).getId(),nb);
            if (idF == -1 || idC == -1) {
                throw new ArithmeticException("Materiel not found");
            }
            if (Lpn > Lpl && lpn > lpl) {

                if (nbP < nbpn) {
                    int wrappingV = (int) (Lpn / Lpl);
                    int wrappingH = (int) (lpn / lpl);
                    tiles = wrappingH * wrappingV;
                    if (nbpn * tiles > nb) {
                        nbP++;
                        int pru = (nb / tiles) + 1 ;
                        if (wrappingH > nb){
                             offsetx = nb * Lpl;
                             offsety = 1 * Lpl;
                        }
                        else
                        {
                             offsetx = (nb % wrappingH) * lpl;
                             offsety = ((nb / wrappingH) + 1) * Lpl;
                        }
                        dec = new Decoup(idC,pn.get(pnsize).getId(),pn.get(pnsize).getL(),pn.get(pnsize).getl(),pru,idC,pl.get(plsize).getId(),pl.get(plsize).getL(),pl.get(plsize).getl(),nb,offsetx,offsety,wrappingV,wrappingH);
                        d.add(dec);
                        String filename = "src/Decoup/ID CL :" + pl.get(plsize).getId() +".svg";
                        XMLWriter.writeSVG(filename,dec,pl.get(plsize),pn.get(pnsize));
                        nbpn = nbpn - pru;
                        pn.get(pnsize).setNombre(nbpn);
                        plsize++;
                    }
                    else {
                        pnsize++;
                    }
                }
                else {
                    pnsize++;
                }
            }
        }
        return d;
    }
    static List<Decoup> DecoupALL31(List<Igenerable> p, List<Igenerable> f) throws IOException {
        List<Decoup> d = new ArrayList<>();
        Decoup dec;
        List<Panneau> pn = sortbyLPN31(f);
        List<Planche> pl = sortbyLPL31(p);
        int pnsize = 0,plsize = 0;
        float Lpl,Lpn,lpl,lpn;
        int nbpn,nb,nbP;
        float offsetx = 0;
        int idF = 0,idC = 0;
        while (plsize < pl.size()) {
            Lpn = pn.get(pnsize).getL();
            lpn = pn.get(pnsize).getLong();
            nbpn = pn.get(pnsize).getNombre();
            Lpl = pl.get(plsize).getL();
            lpl = pl.get(plsize).getLong();
            nb  = pl.get(plsize).getNombre();
            idF = getidPN(f,pn.get(pnsize).getId(),nbpn);
            idC = getidPL(p,pl.get(plsize).getId(),nb);
            if (idF == -1 || idC == -1) {
                throw new ArithmeticException("Materiel not found");
            }
            int nbPl = 0;
            //Nombre de planche utilisé
            while (offsetx < Lpn - lpl && nbPl < nb){

                offsetx = offsetx + Lpl;
                nbPl++;
            }
            if (nbPl != 0){
                dec = new Decoup(idC,pn.get(pnsize).getId(),pn.get(pnsize).getL(),pn.get(pnsize).getl(),1,idC,pl.get(plsize).getId(),pl.get(plsize).getL(),pl.get(plsize).getl(),nbPl,0,0,0,0);
                d.add(dec);
                plsize++;
            }
            if (nbPl == 0){
                plsize++;
            }
        }
        String filename = "src/Decoup/Alg III.I Four ID :" + idF + "Panneau ID :" + pn.get(pnsize).getId() +".svg";
        XMLWriter.writeSVG3(filename,d);
        return d;

    }
    private static List<Planche> sortbyLPL31(List<Igenerable> f) {
        List<Planche> pl2;
        List<Planche> pl = new ArrayList<>();
        for (int i = 0; i < f.size(); i++) {
            pl2 = f.get(i).getListPLanche();
            if (pl2 == null){
                throw new ArithmeticException("NO MATERIEL");
            }
            pl.addAll((pl2));
        }
        Collections.sort(pl);
        return pl;

    }

    private static List<Panneau> sortbyLPN31(List<Igenerable> p) {
        List<Panneau> pl2;
        List<Panneau> pl = new ArrayList<>();
        for (int i = 0; i < p.size(); i++) {
            pl2 = p.get(i).getListPanneau();
            pl.addAll(pl2);
        }
        Collections.sort(pl);
        return pl;
    }

    public static List<Planche> sortbyLPL(List<Igenerable> f){
        List<Planche> pl2 = new ArrayList<>();
        List<Planche> pl = new ArrayList<>();
        for (int i = 0; i < f.size(); i++) {
            pl2 = f.get(i).getListPLanche();
            if (pl2 == null){
                throw new ArithmeticException("C");
            }
            Collections.sort(pl2);
            pl.addAll((pl2));
        }
        return pl;
    }
    public static List<Panneau> sortbyLPN(List<Igenerable> p){
        List<Panneau> pl2;
        List<Panneau> pl = new ArrayList<>();
        for (int i = 0; i < p.size(); i++) {
            pl2 = p.get(i).getListPanneau();
            Collections.sort(pl2);
            pl.addAll(pl2);
        }
        return pl;
    }

    public static int getidPN(List<Igenerable> p, int id, int nb){

        List<Panneau> pl2;
        for (int i = 0; i < p.size(); i++) {
            pl2 = p.get(i).getListPanneau();
            for (int z = 0; z < pl2.size(); z++) {
                if (pl2.get(z).getNombre() == nb && pl2.get(z).getId() == id){
                    return p.get(i).getId();
                }
            }
        }
        return -1;
    }

    public static int getidPL(List<Igenerable> p, int id, int nb){
        List<Planche> pl ;
        for (int i = 0; i < p.size(); i++) {
            pl = p.get(i).getListPLanche();
            for (int z = 0; z < pl.size(); z++) {
                if (pl.get(z).getNombre() == nb && pl.get(z).getId() == id){
                    return p.get(i).getId();
                }
        }

    }
        return -1;
}

    public int getIdf() {
        return this.idf;
    }
    public int getIdc(){
        return this.idc;
    }
    public int getIdPanneau(){
        return this.idPanneau;
    }
    public int getIdPlanche(){
        return this.idPlanche;
    }
    public float getPosdecx(){
        return this.posdecx;
    }
    public float getPosdecy(){
        return this.posdecy;
    }
    public int getNbPlanche(){return this.nbPlanche;}
    public int getNbPanneau(){return this.idPanneau;}
    public int getWrappingH(){return this.wrappingH;}
    public int getWrappingV(){return this.wrappingV;}
    public float getPll(){return this.Planchel;}
    public float getPlL(){return this.PlancheL;}
    public float getPnL(){return this.PanneauL;};
    public float getPnl(){return this.Panneaul;};
}

    



