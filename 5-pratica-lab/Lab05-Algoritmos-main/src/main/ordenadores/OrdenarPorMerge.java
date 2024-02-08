package ordenadores;
public class OrdenarPorMerge implements Ordenador{

    @Override
    public int[] ordene(int[] array) {
        return array;
    }

    public int[] merge(int[] array, int[] array2) {
        
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
    


