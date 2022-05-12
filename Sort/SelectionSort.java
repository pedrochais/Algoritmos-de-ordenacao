package Sort;
import Generic.Generic;

public class SelectionSort implements Operacoes{
    private int tipoOrdenacao;
    private int atr = 0;
    private int co = 0;

    public Generic<?,?>[] ordenar(Generic<?,?>[] vetor, int tipoOrdenacao){
        this.tipoOrdenacao = tipoOrdenacao;

        for(int i = 0; i < vetor.length - 1; i++){
            int min = i;
            for(int j = i+1; j < vetor.length; j++){
                this.co++;
                this.atr += 2;

                if(this.tipoOrdenacao == 1){
                    if(vetor[j].comparator(vetor[min]) < 0){ //Ordenação em ordem crescente
                        min = j;

                        this.co++;
                        this.atr++;
                    }
                }else{
                    if(vetor[j].comparator(vetor[min]) > 0){ //Ordenação em ordem decrescente
                        min = j;

                        this.co++;
                        this.atr++;
                    }
                }
            }
            Generic<?,?> temp = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = temp;

            this.co++;
            this.atr += 6;
        }
        return vetor;
    }

    @Override
    public int getAtr() {
        return this.atr;
    }

    @Override
    public int getComp() {
        return this.co;
    }

    public void reiniciar(){
        this.atr = 0;
        this.co = 0;
    }
}
