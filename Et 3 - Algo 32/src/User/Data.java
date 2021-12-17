package src.User;

import src.Algo.isValid;

import java.util.List;

 public class Data {
    List<String> mylist;
    public Data(List<String> l){
        this.mylist = l;
    }
    public static List<String> getDataString(Data d){
        return d.mylist;
    }
    public int getsize(){
        return this.mylist.size();
    }
    public String getindex(Data d,int x){
        return getDataString(d).get(x);
    }
    public void show() {
        for (int i = 0; i < this.mylist.size() ; i++) {
            System.out.printf("--> %s \t",this.mylist.get(i));
        }
    }
}
