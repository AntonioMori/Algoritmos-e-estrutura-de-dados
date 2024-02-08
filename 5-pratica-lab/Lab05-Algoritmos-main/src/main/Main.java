import ordenadores.Ordenador;
import ordenadores.OrdenarPorInsercao;
import ordenadores.OrdenarPorMerge;
import ordenadores.OrdenarPorSelecao;

public class Main {
    public static void main(String[] args) {
    
        
        System.out.println("Teste Ordenaçao por Inserçao");
        Ordenador o = new OrdenarPorInsercao();
        
        
        int[] array = { 5, 3, 2, 4, 7, 1, 0, 6 };
        int[] array2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] array3 = { 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int[] array4 = { 0 };
        int[] array5 = { 5, 3, 2, 4, 7, 2, 0, 7 };
        
        System.out.println("\nArray desordenado X Array ordenado");
        
        System.out.println("\nArray 1");
        printArray(array);
        printArray(o.ordene(array));
        
        System.out.println("\nArray 2");
        printArray(array2);
        printArray(o.ordene(array2));
        
        System.out.println("\nArray 3");
        printArray(array3);
        printArray(o.ordene(array3));

        System.out.println("\nArray 4");
        printArray(array4);
        printArray(o.ordene(array4));
        
        System.out.println("\n\nTeste Ordenação por seleção");
        

        Ordenador s = new OrdenarPorSelecao();

        int[] arrayS = { 5, 3, 2, 4, 7, 1, 0, 6 };
        int[] arrayS2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] arrayS3 = { 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int[] arrayS4 = { 0 };
        int[] arrayS5 = { 5, 3, 2, 4, 7, 2, 0, 7 };

        System.out.println("\nArray 1");
        printArray(arrayS);
        printArray(s.ordene(arrayS));

        System.out.println("\nArray 2");
        printArray(arrayS2);
        printArray(s.ordene(arrayS2));

         System.out.println("\nArray 3");
        printArray(arrayS3);
        printArray(s.ordene(arrayS3));

        System.out.println("\nArray 4");
        printArray(arrayS4);
        printArray(s.ordene(arrayS4));
        
        System.out.println("\nArray 5");
        printArray(arrayS5);
        printArray(s.ordene(arrayS5));
        

        System.out.println("\n\nTeste Ordenação por Merge");
        
        Ordenador m = new OrdenarPorMerge();
        
        int[] arrayM1 = { 0,1,2,4};
        int[] arrayM2 = { 3,5,6};
        printArray(merge(arrayM1, arrayM2));


    }
    
    
    public static void printArray(int[] array) {
        String resultado = "{ ";
        for (int i = 0; i < array.length; i++) {
            if (array.length - 1 == i) {
                resultado+= array[i] + " }";
            }else{
                resultado += array[i] + ",";

            }
        }
        System.out.println(resultado);
    }

    public static int[] merge(int[] array, int[] array2) {
        
        int length1 = array.length;
        int length2 = array2.length;
        int[] array3 = new int[length1 + length2];

        int i = 0, j = 0, k = 0;

        // Percorre ambos os arrays enquanto houver elementos restamtes em qualquer um dos dois
        while (i < length1 && j < length2) {
            
            if (array[i] <= array2[j]) {
                // Se o elemento do primeiro array for menor ou igual, coloca no mergedArray
                array3[k] = array[i];
                i++;
            }
            else {
                // Se o elemento do segundo array for menor, coloca no mergedArray
                array3[k] = array2[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes, se houver, do primeiro array para o array3
        while (i < length1) {
            array3[k] = array[i];
            i++;
            k++;
        }

        // Copia os elementos restantes, se houver, do segundo array para o array3
        while (j < length2) {
            array3[k] = array2[j];
            j++;
            k++;
        }

        return array3;
    }



}
