package src.ES;


import src.User.*;

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
    public static List<Igenerable> readXml(String filename,IFactory factory)
    {
        System.out.println("Extracting Data from file :/" + filename);
        List<Igenerable> c = new ArrayList<>();
        try
        {
            FileInputStream file = new FileInputStream(filename);
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(file);
            while(reader.hasNext())
            {

                if(reader.next() == XMLStreamConstants.START_ELEMENT)
                {
                    if (reader.getAttributeCount() == 1){
                        c.add(readIGenerable(reader,factory));
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

    return c;
    }


    static Igenerable readIGenerable(XMLStreamReader reader,IFactory factory ) throws XMLStreamException
    {
        int id = -1;
        List<Data> d = new ArrayList<>();
        List<Igenerable> Ig = new ArrayList<>();
        if (reader.getAttributeCount() == 1){
            id = Integer.parseInt(reader.getAttributeValue(0));
            reader.nextTag();
            while (reader.getAttributeCount() == 4){
                Data doodo = readData(reader);
                d.add(doodo);
                reader.nextTag();
                reader.nextTag();
                reader.nextTag();
                if (reader.isEndElement()){
                    break;
                }
            }
            }
        return factory.generate(id,d);
    }



    static Data readData(XMLStreamReader reader) throws XMLStreamException
    {
        List<String> list = new ArrayList<>();
            list.add(reader.getAttributeValue(0));
            list.add(reader.getAttributeValue(1));
            list.add(reader.getAttributeValue(2));
            list.add(reader.getAttributeValue(3));
            reader.nextTag();
            list.add(reader.getAttributeValue(0));
            list.add(reader.getAttributeValue(1));
            Data data = new Data(list);
            return data;
    }









}
