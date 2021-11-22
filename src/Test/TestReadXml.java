package src.Test;


import src.Algo.Comparable;
import src.Materiel.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TestReadXml implements src.Algo.Comparable {
    public static void main(String[] argvs)
    {
        List<Planche> ClientCommand = new ArrayList<>();
        List<Panneau> FourCommands = new ArrayList<>();
        FileInputStream file = null;
        try {
            file = new FileInputStream("src/xml/clients.xml");
            XMLInputFactory xmlInFact = XMLInputFactory.newInstance();
            XMLStreamReader reader = xmlInFact.createXMLStreamReader(file);
            Planche MyPlanche = Comparable.ReaderPlanche();

            Panneau MyPanneau = Comparable.ReaderPanneaux();
            boolean test = MyPanneau.isValid();
            System.out.println("Check this " + test);

            ClientCommand.add(MyPlanche);
            FourCommands.add(MyPanneau);
            float pricePanneau = MyPanneau.getPrice();
            float pricePlanche = MyPlanche.getPrice();

            Boolean checkP = ClientCommand.isValid();

            if(reader.hasNext()) {

                reader.next(); // On regarde la liste des clients

                reader.nextTag(); //On regarde le premier client
                reader.nextTag(); //On regarde la première commande de planche demandée

                String commande = "Commande n°" + reader.getAttributeValue(0) + " de " + reader.getAttributeValue(1) + " planches à livrer pour le " + reader.getAttributeValue(2) + " au prix maximal de " +reader.getAttributeValue(3);
                System.out.println(commande);
                System.out.println("This Planche Price :" + pricePlanche + "And Panneau price : " + pricePanneau );
            }
        }
        catch(IOException exc) {

            System.out.print("Erreur IO: " + exc.toString());
        }
        catch(XMLStreamException exc) {
            System.out.print("Erreur XML: " + exc.toString());

        }
    }


}
