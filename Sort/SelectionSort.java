package Sort;
import Generic.Generic;

public class SelectionSort extends Algoritmo implements Operacoes{
    private int tipoOrdenacao; //Crescente ou decrescente
    private long atr = 0; //Quantidade de atribuições
    private long co = 0; //Quantidade de comparações

    public Generic<?,?>[] ordenar(Generic<?,?>[] vetor, int tipoOrdenacao){
        this.tipoOrdenacao = tipoOrdenacao;

        for(int i = 0; i < vetor.length - 1; i++){ //Seleciona um valor na posição i
            int min = i;
            for(int j = i+1; j < vetor.length; j++){ //Percorre o subvetor que inicia depois de i comparando os valores nas posições j com o valor na posição i
                this.co++;
                this.atr += 2;

                if(this.tipoOrdenacao == 1){ //Condição para ordenação crescente
                    if(vetor[j].comparator(vetor[min]) < 0){ //Busca o índice do menor valor
                        min = j;

                        this.co++;
                        this.atr++;
                    }
                }else{ //Condição para ordenação decrescente
                    if(vetor[j].comparator(vetor[min]) > 0){  //Busca o índice do menor valor
                        min = j;

                        this.co++;
                        this.atr++;
                    }
                }
            }
            //Realiza a troca dos valores
            Generic<?,?> temp = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = temp;

            this.co++;
            this.atr += 6;
        }
        return vetor;
    }

    @Override
    public long getAtr() {
        return this.atr;
    }

    @Override
    public long getComp() {
        return this.co;
    }

    //Reinicia a quantidade de atribuições e de comparações
    public void reiniciar(){
        this.atr = 0;
        this.co = 0;
    }
}
