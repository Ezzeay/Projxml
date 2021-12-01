package src.User;


import java.util.List;

public class ClientFactory implements IFactory{

    @Override
    public Igenerable generate(int id,List<Data> d) {
        Client c = new Client(id,d);
        try {
            if (c.isValid() == false){
                throw new ArithmeticException("Data is Invalid for client ID : \\" + id);

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return c;
    }


}
