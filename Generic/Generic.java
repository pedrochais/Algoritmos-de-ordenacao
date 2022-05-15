package Generic;

import java.util.Comparator;

public class Generic <K,V> implements Comparable<Generic>{
    private K chave;
    private V valor;

    //Método construtor que inicializa a chave e o valor do elemento ao instanciar
    public Generic(K chave, V valor){
        this.chave = chave;
        this.valor = valor;
    }

    //Retorna chave
    public K getChave() {
        return chave;
    }

    //Retorna valor
    public V getValor() {
        return valor;
    }

    //Metodo para fazer a comparação das estruturas Generics através de castings
    public int comparator(Generic<?,?> valorChave){
        if(this.valor instanceof Integer){
            return((Integer) this.valor).compareTo((Integer) valorChave.getValor());
        }else if(this.valor instanceof String){
            return((String) this.valor).compareTo((String) valorChave.getValor());
        }else{
            return((Double) this.valor).compareTo((Double) valorChave.getValor());
        }
    }

    //Metodo para fazer a comparação das estruturas Generics através de castings
    @Override
    public int compareTo(Generic o) {
        if(this.valor instanceof Integer){
            return((Integer) this.valor).compareTo((Integer) o.getValor());
        }else if(this.valor instanceof String){
            return((String) this.valor).compareTo((String) o.getValor());
        }else{
            return((Double) this.valor).compareTo((Double) o.getValor());
        }
    }
}
