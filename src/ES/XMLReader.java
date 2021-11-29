package src.ES;

import src.ES.IReader;

import src.Materiel.*;


import src.User.ClientFactory;
import src.User.FournFactory;
import src.User.IFactory;
import src.User.Igenerable;

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
    public static void readXml(String filename,IFactory factory)
    {
        try
        {
            FileInputStream file = new FileInputStream(filename);
            List<Igenerable> c = new ArrayList<>();

            List<Igenerable> f=new ArrayList<>();
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(file);
            while(reader.hasNext())
            {
                if(reader.next() == XMLStreamConstants.START_ELEMENT)
                {
                    if(reader.getName().toString() == "client")
                    {

                        c.addAll(readIGenerable(reader,factory));


                    }
                    else if (reader.getName().toString() == "fournisseur"){
                       f.addAll(readIGenerable(reader,factory));
                    }
                }
            }
            System.out.println(c.size());
            if (f.isEmpty()){
                for(int i = 0; i < c.size(); i++) {
                    System.out.println(c.get(i));
                }


            }
            else if(c.isEmpty()){
                for(int i=0; i< f.size();i++){
                    System.out.println(f.get(i).isValid());

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
    /*
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
    */

    static List<Igenerable> readIGenerable(XMLStreamReader reader,IFactory factory ) throws XMLStreamException
    {
        int id = Integer.parseInt(reader.getAttributeValue(0));

        List<Planche> listPlanche = new ArrayList<>();
        List<Panneau> listPanneau = new ArrayList<>();
        List<Igenerable> Ig = new ArrayList<>();
        while(reader.hasNext())
        {
            if(reader.next() == XMLStreamConstants.START_ELEMENT)
            {
                if(reader.getName().toString() == "panneau" )
                {
                    Panneau p = readPanneau(reader);
                    listPanneau.add(p);
                    Ig.add(factory.generatec(id,listPlanche));
                }
                if(reader.getName().toString() == "planche")
                {
                    Planche p = readPlanche(reader);
                    listPlanche.add(p);
                    Ig.add(factory.generatef(id,listPanneau));

                }


            }
        }

        return Ig;

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

        System.out.println("Added Planche with id : " + MyPlanche.id + " "+ "Height :" + MyPlanche.L);
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
        System.out.println("Added Panneau with id : " + MyPanneau.id + " "+ "Height :" + MyPanneau.L);
        return MyPanneau;
    }






}
