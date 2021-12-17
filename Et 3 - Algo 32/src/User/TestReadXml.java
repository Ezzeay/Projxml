package src.User;

import src.ES.XMLReader;
import src.ES.XMLWriter;

import java.io.IOException;
import java.util.List;

public  class TestReadXml {
    public static void main(String[] argvs) throws IOException {
        XMLReader reader = null;
        IFactory factory = new ClientFactory();
        IFactory factory1 = new FournFactory();
        List<Igenerable> c = reader.readXml("src/xml/clients.xml",factory);
        List<Igenerable> f = reader.readXml("src/xml/fournisseurs.xml",factory1);
        List<Decoup> d = Decoup.DecoupALL(c,f);
        List<Decoup> dAlg3 = Decoup.DecoupALL32(c,f);
        XMLWriter.writeXML("src/xml/Decoup.xml",d);
        XMLWriter.writeXML("src/xml/DecoupAlg3.xml",dAlg3);
        System.out.println("File Decoup has been generated to --> /src/xml/Decoup.xml");
        System.out.println("File SVG with Algo Part 2 has been generated to --> /src/Decoup");
        System.out.println("File SVG with Algo Part 3 has been generated to --> /src/Decoup");

    }
}
