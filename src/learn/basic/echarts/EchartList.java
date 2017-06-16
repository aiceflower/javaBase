package learn.basic.echarts;

import java.util.ArrayList;
import java.util.Iterator;

public class EchartList<E> extends ArrayList<E> {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Override
    public String toString() {
        Iterator<E> it = iterator();
        if (!it.hasNext())
            return "[]";
        
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            E e = it.next();
            if (e.toString() != null)
                sb.append(e == this ? "(this Collection)" : e);
            if (!it.hasNext())
                return sb.append(']').toString();
            if (e.toString() != null)
                sb.append(',').append(' ');
        }
    }
    
}
