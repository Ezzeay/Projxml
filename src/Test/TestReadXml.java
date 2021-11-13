package src.Algo;

import src.Materiel.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

interface Comparable {
    public static Planche ReaderPlanche() {
        Planche MyPlanche = null;
        FileInputStream file = null;

            try

        {
            file = new FileInputStream("src/xml/clients.xml");
        } catch(
        FileNotFoundException e)

        {
            e.printStackTrace();
        }

        XMLInputFactory xmlInFact = XMLInputFactory.newInstance();
        XMLStreamReader reader = null;
            try

        {
            reader = xmlInFact.createXMLStreamReader(file);
        } catch(
        XMLStreamException e)

        {
            e.printStackTrace();
        }

                try

        {
            if (reader.hasNext()) {
                try {
                    reader.next(); // On regarde la liste des clients
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
                try {
                    reader.nextTag(); //On regarde le premier client
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
                try {
                    reader.nextTag(); //On regarde la première commande de planche demandée
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
                int id = Integer.parseInt(reader.getAttributeValue(0));
                int nombre = Integer.parseInt(reader.getAttributeValue(1));
                String date = reader.getAttributeValue(2);
                int price = Integer.parseInt(reader.getAttributeValue(3));
                int L = Integer.parseInt(reader.getAttributeValue(4));
                int l = Integer.parseInt(reader.getAttributeValue(5));
                String commande = "Commande n°" + reader.getAttributeValue(0) + " de " + reader.getAttributeValue(1) + " planches à livrer pour le " + reader.getAttributeValue(2) + " au prix maximal de " + reader.getAttributeValue(3);
                System.out.println(commande);
                MyPlanche= new Planche(id, nombre, date, price, L, l);

            }
        } catch(
        XMLStreamException e)

        {
            e.printStackTrace();
        }
        return MyPlanche;
    }
    public static Panneau ReaderPanneaux() {
        Panneau MyPanneau = null;
        FileInputStream file = null;

        try {
            file = new FileInputStream("src/xml/fournisseurs.xml");
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        XMLInputFactory xmlInFact = XMLInputFactory.newInstance();
        XMLStreamReader reader = null;
        try {
            reader = xmlInFact.createXMLStreamReader(file);
        } catch (
                XMLStreamException e) {
            e.printStackTrace();
        }

        try {
            if (reader.hasNext()) {
                try {
                    reader.next(); // On regarde la liste des clients
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
                try {
                    reader.nextTag(); //On regarde le premier client
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
                try {
                    reader.nextTag(); //On regarde la première commande de planche demandée
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
                int id = Integer.parseInt(reader.getAttributeValue(0));
                int nombre = Integer.parseInt(reader.getAttributeValue(1));
                String date = reader.getAttributeValue(2);
                int price = Integer.parseInt(reader.getAttributeValue(3));
                int L = Integer.parseInt(reader.getAttributeValue(4));
                int l = Integer.parseInt(reader.getAttributeValue(5));
                String commande = "Commande n°" + reader.getAttributeValue(0) + " de " + reader.getAttributeValue(1) + " planches à livrer pour le " + reader.getAttributeValue(2) + " au prix maximal de " + reader.getAttributeValue(3);
                System.out.println(commande);
                MyPanneau = new Panneau(id, nombre, date, price, L, l);


            }
        } catch (
                XMLStreamException e) {
            e.printStackTrace();
        }
        return MyPanneau;

    }
