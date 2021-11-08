package Test;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;


public class TestReadXml {
    public static void main(String[] argvs)
    {
        FileInputStream file = null;
        try {
            file = new FileInputStream("src/xml/clients.xml");
            XMLInputFactory xmlInFact = XMLInputFactory.newInstance();
            XMLStreamReader reader = xmlInFact.createXMLStreamReader(file);
            if(reader.hasNext()) {

                reader.next(); // On regarde la liste des clients

                reader.nextTag(); //On regarde le premier client
                reader.nextTag(); //On regarde la première commande de planche demandée

                String commande = "Commande n°" + reader.getAttributeValue(0) + " de " + reader.getAttributeValue(1) + " planches à livrer pour le " + reader.getAttributeValue(2) + " au prix maximal de " +reader.getAttributeValue(3);
                System.out.println(commande);
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
