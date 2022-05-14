package Sort;

import Generic.Generic;

public abstract class Algoritmo {
    public abstract void reiniciar();
    public abstract Generic<?, ?>[] ordenar(Generic<?,?>[] vetor, int tipoOrdenacao);
}
