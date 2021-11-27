package src.ES;

import src.ES.IReader;
import src.User.Client;
import src.Materiel.*;
import src.User.Fournisseur;
import src.User.IGenerable;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLReader implements IReader
{
    public static void readXml(String filename)
    {
        try
        {
            FileInputStream file = new FileInputStream(filename);
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(file);
            while(reader.hasNext())
            {
                if(reader.next() == XMLStreamConstants.START_ELEMENT)
                {
                    if(reader.getName().toString() == "client")
                    {
                        Client c = readClient(reader);
                    }
                    if(reader.getName().toString() == "fournisseur"){
                        Fournisseur f = readFournisseur(reader);
                    }
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (XMLStreamException e)
        {
            e.printStackTrace();
        }
    }
    static Client readClient(XMLStreamReader reader) throws XMLStreamException
    {
        int id = Integer.parseInt(reader.getAttributeValue(0));
        List<Planche> listPlanche = new ArrayList<>();
        while(reader.hasNext())
        {
            if(reader.next() == XMLStreamConstants.START_ELEMENT)
            {
                if(reader.getName().toString() == "planche")
                {
                    Planche p = readPlanche(reader);
                    listPlanche.add(p);
                }

            }
        }
        return new Client(id,listPlanche);
    }
    static IGenerable readIGenerable(XMLStreamReader reader) throws XMLStreamException
    {
        int id = Integer.parseInt(reader.getAttributeValue(0));
        List<Panneau> listPanneau = new ArrayList<>();
        while(reader.hasNext())
        {
            if(reader.next() == XMLStreamConstants.START_ELEMENT)
            {
                if(reader.getName().toString() == "panneau")
                {
                    Panneau p = readPanneau(reader);
                    listPanneau.add(p);
                }

            }
        }
        return new Fournisseur(id,listPanneau);
    }

    static Planche readPlanche(XMLStreamReader reader) throws XMLStreamException
    {
        int id = Integer.parseInt(reader.getAttributeValue(0));
        int nombre = Integer.parseInt(reader.getAttributeValue(1));
        String date = reader.getAttributeValue(2);
        float price = Float.parseFloat(reader.getAttributeValue(3));

        try{
            reader.nextTag();
        } catch(XMLStreamException e){
            e.printStackTrace();
        }
        float L = Float.parseFloat(reader.getAttributeValue(0));
        float l = Float.parseFloat(reader.getAttributeValue(1));
        Planche MyPlanche = new Planche(id, nombre, date, price, L, l);

        return MyPlanche;
    }

    static Panneau readPanneau(XMLStreamReader reader) throws XMLStreamException
    {
        int id = Integer.parseInt(reader.getAttributeValue(0));
        int nombre = Integer.parseInt(reader.getAttributeValue(1));
        String date = reader.getAttributeValue(2);
        float price = Float.parseFloat(reader.getAttributeValue(3));

        try{
            reader.nextTag();
        } catch(XMLStreamException e){
            e.printStackTrace();
        }
        float L = Float.parseFloat(reader.getAttributeValue(0));
        float l = Float.parseFloat(reader.getAttributeValue(1));
        Panneau MyPanneau = new Panneau(id, nombre, date, price, L, l);

        return MyPanneau;
    }

    @Override
    public List<IGenerabe> readGenerable(String filename, IFactory Factory) {
        return null;
    }
}
