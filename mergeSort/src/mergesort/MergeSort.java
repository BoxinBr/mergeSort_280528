package mergesort;

public class MergeSort {

    public static void mergeSort(int[] arreglo) {
        if (arreglo.length < 2) {
            return; 
        }
        
        int mitad = arreglo.length / 2;
        int[] izquierda = new int[mitad];
        int[] derecha = new int[arreglo.length - mitad];
        
        for (int i = 0; i < mitad; i++) {
            izquierda[i] = arreglo[i];
        }
        for (int i = mitad; i < arreglo.length; i++) {
            derecha[i - mitad] = arreglo[i];
        }
        
        mergeSort(izquierda);
        mergeSort(derecha);
        
        merge(arreglo, izquierda, derecha);
    }
    
    private static void merge(int[] arregloOriginal, int[] izquierda, int[] derecha) {
        int i = 0; 
        int j = 0; 
        int k = 0;
        
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                arregloOriginal[k++] = izquierda[i++];
            } else {
                arregloOriginal[k++] = derecha[j++];
            }
        }
        
        while (i < izquierda.length) {
            arregloOriginal[k++] = izquierda[i++];
        }
        
        while (j < derecha.length) {
            arregloOriginal[k++] = derecha[j++];
        }
    }
    
    public static void main(String[] args) {
        int[] miArreglo = {38, 27, 43, 3, 9, 82, 10};
        
        System.out.println("Arreglo original:");
        for (int num : miArreglo) {
            System.out.print(num + " ");
        }
        
        mergeSort(miArreglo);
        
        System.out.println("\nArreglo ordenado:");
        for (int num : miArreglo) {
            System.out.print(num + " ");
        }
    }
}