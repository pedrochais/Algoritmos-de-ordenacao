package Generic;

import java.util.Comparator;

public class ComparaGeneric implements Comparator<Generic> {
    @Override
    public int compare(Generic o1, Generic o2) {
        return o1.compareTo(o2);
    }
}
