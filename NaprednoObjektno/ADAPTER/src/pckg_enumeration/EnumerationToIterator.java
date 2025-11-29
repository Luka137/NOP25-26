package pckg_enumeration;

import java.util.Iterator;

public class EnumerationToIterator<E> implements Iterator <E>{

    private EnumerationConcrete<E> enumeration;

    public EnumerationToIterator(EnumerationConcrete<E> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public E next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported.");
    }
}