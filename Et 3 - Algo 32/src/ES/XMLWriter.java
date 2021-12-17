package src.ES;

import src.User.Decoup;



import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLWriter {

    public static void writeSVG(String filename,List<Decoup> d) throws IOException {
        try {
            FileWriter filewriter = new FileWriter(filename);
            filewriter.write("<svg version=\"1.1\"\n" +
                    "     baseProfile=\"full\"\n" +
                    "     width=\""+d.get(0).getPnl()*10+"\" height=\""+d.get(0).getPnL()*10+"\"\n" +
                    "     xmlns=\"http://www.w3.org/2000/svg\"" +
                    ">\n" +
                    "\n" +
                    "  <rect width=\"100%\" height=\"100%\" fill=\"peru\" />\n" +
                    "\n"
            );

            float offsetx = 0;
            int offsety = 0;
            for (int i = 0; i < d.size(); i++) {
                    if(offsetx < d.get(i).getPnL()*10 && d.get(i).getNbPlanche() > 0 ){
                        float width = d.get(i).getPlL() * 10;
                        float height = d.get(i).getPll()*10;
                        float posx = d.get(i).getPosdecx()*10;
                        float posy = d.get(i).getPosdecy()*10;
                        if (posx == 0){
                            offsetx = 0;
                        }
                        filewriter.write("<rect x=\""+ posx +"\" y=\""+posy+"\" width=\""+width+"\" height=\""+height+"\" style=\"fill:rgb(255,255,255);stroke:black;stroke-width:2;fill-opacity:0.1;stroke-opacity:0.9\" />\n"
                        );
                        offsetx = offsetx + width;




                }
            }
            filewriter.write("  <text x=\" 00%\" y=\"50%\" font-size=\"40\" text-anchor=\"left\" fill=\"BLACK\">ID Panneau " + d.get(0).getIdPanneau() + " Size L = " + d.get(0).getPnL() + " Size l = " + d.get(0).getPnl() + "</text>\n" +
                    "\n");
            filewriter.write("</svg>\n");
            filewriter.close();
        }catch (IOException c){
            c.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void writeXML(String filename, List<Decoup> d) throws IOException {
        try{

            FileWriter filewriter = new FileWriter(filename);
            filewriter.write("<decoupes> \n");
            for (int i = 0; i < d.size(); i++) {
                filewriter.write("<decoupe> \n");

                filewriter.write("<client id = ");
                filewriter.write(Integer.toString(d.get(i).getIdc()));
                filewriter.write(" planche = ");

                filewriter.write(Integer.toString(d.get(i).getIdPlanche()));
                filewriter.write(":");
                filewriter.write(Integer.toString(d.get(i).getNbPlanche()));
                filewriter.write(" /> \n");
                filewriter.write("<fournisseur id = " );
                filewriter.write(Integer.toString(d.get(i).getIdf()));
                filewriter.write(" panneau = ");
                filewriter.write(Integer.toString(d.get(i).getIdPanneau()));
                filewriter.write(":");
                filewriter.write(Integer.toString(d.get(i).getNbPanneau()));
                filewriter.write("\\> \n");
                filewriter.write("<position ");

                filewriter.write("x= ");
                filewriter.write(Float.toString(d.get(i).getPosdecx()));
                filewriter.write(" y = ");
                filewriter.write(Float.toString(d.get(i).getPosdecy()));
                filewriter.write(" /> \n");
                filewriter.write("</decoupe> \n");
            }
            filewriter.write("</decoupes> \n");
            filewriter.close();


        }catch(IOException c){
            c.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
