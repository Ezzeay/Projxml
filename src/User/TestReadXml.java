package src.User;

import src.ES.XMLReader;

import java.util.List;

public  class TestReadXml {
    public static void main(String[] argvs) {
        XMLReader reader = null;
        IFactory factory = new ClientFactory();
        IFactory factory1 = new FournFactory();
        List<Igenerable> c = reader.readXml("src/xml/clients.xml",factory);
        List<Igenerable> f = reader.readXml("src/xml/fournisseurs.xml",factory1);

    }
}
