package Sort;

import Generic.Generic;

public abstract class Algoritmo { //Classe pai abstrata das classes dos algoritmos de ordenação
    public abstract void reiniciar();
    public abstract Generic<?, ?>[] ordenar(Generic<?,?>[] vetor, int tipoOrdenacao);
}
