import Generic.*;
import Sort.*;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static String menu(){
        System.out.print("""
                
                Algoritmos de ordenação
                1. InsertioSort
                2. SelectionSort
                3. MergeSort
                4. QuickSort
                5. HeapSort
                6. SelectionSort Otimizado
                7. MergeSort Otimizado
                8. JDKMergeSort
                9. JDKQuickSort
                0. Finalizar programa
                
                Digite a opção: """);
        return input.nextLine();
    }

    public static int submenu(){
        int tipoOrdenacao = 0;
        while(true) {
            System.out.print("""
                Tipo de ordenacao
                1. Crescente
                2. Decrescente
                """);

            try {
                tipoOrdenacao = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
            }

            if(tipoOrdenacao == 1 || tipoOrdenacao == 2){
                return tipoOrdenacao;
            }else{
                System.out.println("Opção inválida!");
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        ComparaGeneric cv = new ComparaGeneric();
        List<Generic> aux = new ArrayList<>();

        InsertionSort is = new InsertionSort();
        SelectionSort ss = new SelectionSort();
        SelectionSortOtimizado sso = new SelectionSortOtimizado();
        QuickSort qs = new QuickSort();
        HeapSort hs = new HeapSort();
        MergeSort ms = new MergeSort();
        MergeSortOtimizado mso = new MergeSortOtimizado();

        Generic<String, Integer>[] vetor = new Generic[20];

        System.out.println("Vetor não ordenado");
        for (int i = 0; i < 20; i++) {
            vetor[i] = new Generic<>(GeradorString.getRandomString(3), random.nextInt(100));
            System.out.println("Chave: " + vetor[i].getChave() + " / Valor: " + vetor[i].getValor());
        }

        String opcao;
        while(true){
            opcao = menu();
            if(opcao.equals("0")) break;

            int tipoOrdenacao = 0;
            switch (opcao) {
                case "1":
                    tipoOrdenacao = submenu();
                    is.ordenar(vetor, vetor.length, tipoOrdenacao);
                    break;
                case "2":
                    tipoOrdenacao = submenu();
                    ss.ordenar(vetor, tipoOrdenacao);
                    break;
                case "3":
                    tipoOrdenacao = submenu();
                    ms.ordenar(vetor, tipoOrdenacao);
                    break;
                case "4":
                    tipoOrdenacao = submenu();
                    qs.ordenar(vetor, 0, 19, tipoOrdenacao);
                    break;
                case "5":
                    tipoOrdenacao = submenu();
                    hs.ordenar(vetor, vetor.length, tipoOrdenacao);
                    break;
                case "6":
                    tipoOrdenacao = submenu();
                    sso.ordenar(vetor, tipoOrdenacao);
                    break;
                case "7":
                    tipoOrdenacao = submenu();
                    mso.ordenar(vetor, tipoOrdenacao);
                    break;
                case "8":
                    aux = Arrays.asList(vetor);
                    Collections.sort(aux);
                    break;
                case "9":
                    Arrays.sort(vetor, cv);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            for (int i = 0; i < vetor.length; i++) {
                System.out.println("Chave: " + vetor[i].getChave() + " Valor: " + vetor[i].getValor());
            }
            //input.nextLine();
        }
    }
}