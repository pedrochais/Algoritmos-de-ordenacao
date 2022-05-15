package Generic;

import java.util.Comparator;

public class ComparaGeneric implements Comparator<Generic> {
    //Método comparator para Array.sort
    @Override
    public int compare(Generic o1, Generic o2) {
        return o1.compareTo(o2);
    }
}
