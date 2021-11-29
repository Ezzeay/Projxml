package src.Test;


import src.ES.XMLReader;
import src.User.ClientFactory;
import src.User.FournFactory;
import src.User.IFactory;
import src.User.Igenerable;


public class TestReadXml {
    public static void main(String[] argvs) {
        XMLReader reader = null;
        IFactory factory = new ClientFactory();
        IFactory factory1 = new FournFactory();
        reader.readXml("src/xml/clients.xml",factory);
        reader.readXml("src/xml/fournisseurs.xml",factory1);

    }
}

