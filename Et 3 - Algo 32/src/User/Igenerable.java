package src.User;

import java.util.List;

public interface Igenerable {

     boolean isValid();
     int getId();
     int getSize();
    List<Planche> getListPLanche();
    List<Panneau> getListPanneau();
}
