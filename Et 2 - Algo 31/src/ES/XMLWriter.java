package src.ES;

import src.User.Commande;
import src.User.Decoup;
import src.User.Panneau;
import src.User.Planche;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLWriter {

    public static void writeSVG3(String filename,List<Decoup> d) throws IOException {
        try {
            FileWriter filewriter = new FileWriter(filename);
            filewriter.write("<svg version=\"1.1\"\n" +
                    "     baseProfile=\"full\"\n" +
                    "     width=\""+d.get(0).getPnL()*10+"\" height=\""+d.get(0).getPnl()*10+"\"\n" +
                    "     xmlns=\"http://www.w3.org/2000/svg\"" +
                    ">\n" +
                    "\n" +
                    "  <rect width=\"100%\" height=\"100%\" fill=\"peru\" />\n" +
                    "\n"
            );

            float offsetx = 0;
            for (int i = 0; i < d.size(); i++) {
                System.out.println((d.get(i).getNbPlanche()));
                float width = d.get(i).getPlL() * 10;
                float height = d.get(i).getPll()*10;
                for (int j = 0; j < d.get(i).getNbPlanche(); j++) {
                    if(offsetx < d.get(i).getPnL()*10 - width){
                        System.out.println("Check offset " + offsetx);
                        System.out.println("Check NBPL " + d.get(i).getNbPlanche());
                        System.out.println("Check width " + width);
                        System.out.println("Check height " + height);
                        filewriter.write("<rect x=\""+ offsetx +"\" width=\""+width+"\" height=\""+height+"\" style=\"fill:rgb(255,255,255);stroke:black;stroke-width:1;fill-opacity:0.9;stroke-opacity:0.4\" />\n"
                        );
                        offsetx = offsetx + width;
                    }


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

        public static void writeSVG(String filename, Decoup d , Planche p , Panneau f) throws IOException {
        try {
            FileWriter filewriter = new FileWriter(filename);
            filewriter.write("<svg version=\"1.1\"\n" +
                    "     baseProfile=\"full\"\n" +
                    "     width=\""+f.getl()*10+"\" height=\""+f.getL()*10+"\"\n" +
                    "     xmlns=\"http://www.w3.org/2000/svg\">\n" +
                    "\n" +
                    "  <rect width=\"100%\" height=\"100%\" fill=\"peru\" />\n" +
                    "\n"
            );
            if (d.getWrappingH() > p.getNombre()){
                for (int i = 0; i < p.getNombre(); i++) {
                    float width = p.getl()*10*(i+1);
                    float height = (p.getL()*10);
                    filewriter.write("<rect width=\""+width+"\" height=\""+height+"\" style=\"fill:tomato;stroke:black;stroke-width:10;fill-opacity:0.1;stroke-opacity:0.9\" />\n" +
                             " <image href=\"/src/tiles.png\" width=\"" + width + "\" height=\""+height+"\" />\n"
                            );
                }
            }
            else {
                int lines = (p.getNombre() / d.getWrappingH()) + 1;
                int offsetx = (p.getNombre() % d.getWrappingH());
                for (int i = 0; i < lines; i++) {
                    if (i == lines - 1){
                        for (int z = 0; z < offsetx; z++) {
                            float width = p.getl()*10*(z+1);
                            float height = (p.getL()*10*(i+1));
                            filewriter.write(
                                    "<rect width=\""+width+"\" height=\""+height+"\" style=\"fill:tomato;stroke:black;stroke-width:10;fill-opacity:0.1;stroke-opacity:0.9\" />\n" +
                                    " <image href=\"/src/tiles.png\" width=\"" + width + "\" height=\""+height+"\" />\n"
                                    );
                        }
                    }
                    else
                    {
                        for (int z = 0; z < d.getWrappingH(); z++) {
                            float width = p.getl()*10*(z+1);
                            float height = (p.getL()*10*(i+1));
                            filewriter.write(
                                    "<rect width=\""+width+"\" height=\""+height+"\" style=\"fill:tomato;stroke:black;stroke-width:10;fill-opacity:0.1;stroke-opacity:0.9\" />\n" +
                                    " <image href=\"/src/tiles.png\" width=\"" + width + "\" height=\""+height+"\"  />\n"
                                    );
                        }
                    }
                    }
            }
            filewriter.write("  <text x=\" 00%\" y=\"50%\" font-size=\"40\" text-anchor=\"left\" fill=\"BLACK\">Nombre de Planche " + d.getNbPlanche() + " Size V = " + p.getL() + " Size H = " + p.getl() + "</text>\n" +
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
