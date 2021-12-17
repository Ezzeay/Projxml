package src.User;

import java.util.List;

public class FournFactory implements IFactory {


    @Override
    public Igenerable generate(int id, List<Data> d) {
        Fournisseur f = new Fournisseur(id,d);
        try {
            if (f.isValid() == false){
                throw new ArithmeticException("Data is Invalid for USER ID : \\" + id);

            }
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
        return f;
    }


}


