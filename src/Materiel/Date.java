package src.Materiel;
import src.Algo.isValid;
import java.text.SimpleDateFormat;


public class Date implements isValid{
    private int d;
    private int m;
    private int year;
    public Date(String date){

        String[] values = date.split("\\.");
        this.d = Integer.parseInt(values[0]);
        this.m = Integer.parseInt(values[1]);
        this.year = Integer.parseInt(values[2]);

    }
    public Date getDate(){
        return this;
    }

    @Override
    public Boolean isValid() {
        String pattern = "dd-mm-yy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new java.util.Date());
        String[] actualvalues = date.split("-");
        int day = Integer.parseInt(actualvalues[0]);
        int month = Integer.parseInt(actualvalues[1]);
        int year = Integer.parseInt(actualvalues[2]);

        if (year > this.year ){
            return false;
        }
        if (month > this.m){
            return false;
        }
        if (day > this.d){
            return false;
        }
        return true;

    }
}
