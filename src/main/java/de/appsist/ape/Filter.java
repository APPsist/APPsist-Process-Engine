package de.appsist.ape;

public interface Filter<E> {
    public boolean accept(E obj);
}
