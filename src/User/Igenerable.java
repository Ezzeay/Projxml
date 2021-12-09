package src.User;

import java.util.List;

public interface Igenerable {

    public boolean isValid();
    public int getId();
    public int getSize();
    List<Planche> getListPLanche();
    List<Panneau> getListPanneau();
}
