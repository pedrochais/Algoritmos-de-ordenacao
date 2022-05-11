import Generic.Generic;
import Sort.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        InsertionSort is = new InsertionSort();
        SelectionSort ss = new SelectionSort();
        SelectionSortOtimizado sso = new SelectionSortOtimizado();
        QuickSort qs = new QuickSort();
        HeapSort hs = new HeapSort();
        MergeSort ms = new MergeSort();
        MergeSortOtimizado mso = new MergeSortOtimizado();

        Generic<String, Integer>[] vetor = new Generic[20];

        System.out.println("Vetor não ordenado");
        for (int i = 0; i < 20; i++){
            vetor[i] = new Generic<>(GeradorString.getRandomString(3), random.nextInt(100));
            System.out.println("Chave: "+vetor[i].getChave()+" / Valor: "+vetor[i].getValor());
        }

        //Nome dos métodos de ordenação
        List<String> nomeMetodos = new ArrayList<>();
        nomeMetodos.add("InsertionSort");
        //nomeMetodos.add("SelectionSort");
        //nomeMetodos.add("MergeSort");
        //nomeMetodos.add("QuickSort");
        //nomeMetodos.add("HeapSort");
        //nomeMetodos.add("SelectionSortOtimizado");
        //nomeMetodos.add("MergeSortOtimizado");
        //nomeMetodos.add();

        int tipoOrdenacao = 2;

        for(String metodo : nomeMetodos){
            switch (metodo){
                case "InsertionSort":
                    is.ordenar(vetor, vetor.length, tipoOrdenacao);
                    break;
                case "SelectionSort":
                    ss.ordenar(vetor, tipoOrdenacao);
                    break;
                case "MergeSort":
                    ms.ordenar(vetor, tipoOrdenacao);
                    break;
                case "QuickSort":
                    qs.ordenar(vetor, 0, 19, tipoOrdenacao);
                    break;
                case "HeapSort":
                    hs.ordenar(vetor, vetor.length, tipoOrdenacao);
                    break;
                case "SelectionSortOtimizado":
                    sso.ordenar(vetor, tipoOrdenacao);
                    break;
                case "MergeSortOtimizado":
                    mso.ordenar(vetor, tipoOrdenacao);
                    break;
                default:
                    break;
            }
        }
        System.out.println("Vetor ordenado pelo metodo " + nomeMetodos.get(0) + ":");
        for(int i=0; i < vetor.length; i++){
            System.out.println("Chave: " + vetor[i].getChave() + " Valor: " + vetor[i].getValor());
        }
    }
}