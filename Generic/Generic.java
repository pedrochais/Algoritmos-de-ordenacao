package Generic;

import java.util.Comparator;

public class Generic <K,V> implements Comparable<Generic>{
    private K chave;
    private V valor;

    public Generic(K chave, V valor){
        this.chave = chave;
        this.valor = valor;
    }

    public K getChave() {
        return chave;
    }

    public V getValor() {
        return valor;
    }

    //Metodo de comparacao da tipagem dos valores do vetor com a chave que está armazenando o valor temporariamente
    public int comparator(Generic<?,?> valorChave){
        if(this.valor instanceof Integer){
            return((Integer) this.valor).compareTo((Integer) valorChave.getValor()); //0 se for igual; menor que 0 se A é menor que B
        }else if(this.valor instanceof String){
            return((String) this.valor).compareTo((String) valorChave.getValor());
        }else{
            return((Double) this.valor).compareTo((Double) valorChave.getValor());
        }
    }

    @Override
    public int compareTo(Generic o) {
        if(this.valor instanceof Integer){
            return((Integer) this.valor).compareTo((Integer) o.getValor()); //0 se for igual; menor que 0 se A é menor que B
        }else if(this.valor instanceof String){
            return((String) this.valor).compareTo((String) o.getValor());
        }else{
            return((Double) this.valor).compareTo((Double) o.getValor());
        }
    }
}
