package src.User;
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
    public String getDate(){
        return "-" + this.d + this.m + this.year +" ";
    }
    public boolean Compare(Date d){
        boolean res = false;
        if (this.year > d.year){
            res = true;
        }
        if (this.year == d.year && this.m > d.m){
            res = true;
        }
        if (this.year == d.year && this.m == d.m && this.d > d.d){
            res = true;
        }
        return res;
    }
    @Override
    public boolean isValid() {
        String pattern = "dd-MM-yy";
        boolean res = false;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new java.util.Date());
        String[] actualvalues = date.split("-");
        int day = Integer.parseInt(actualvalues[0]);
        int month = Integer.parseInt(actualvalues[1]);
        int year = Integer.parseInt(actualvalues[2]);

        if (this.year > year ){
            if (this.m <= 12 && this.d <= 31){
                res = true;
            }

        }
        if (year == this.year){
            if (this.m > month && this.d <= 31){
                res = true;
            }
            if (this.m == month && this.d > day){
                res = true;

            }
        }
        return res;

    }
}
