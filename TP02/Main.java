package TP02;

public class Main {
    
    public static void main(String[] args){

        System.out.println(convertirEnBinario(26));
    }
    /*
    (1)La complejidad que tiene este metodo es O(n) + O(n) debido a que contiene 2 accesos a memoria por uso.
       
    (2)Si hay demasiados  elementos en el arreglo la función podria ser un problema deido al consumo de memoria
         y profundidad de la pila. Por lo tanto seria mejor hacerlo iterativo.

    (3)Seria mas costoso para las lista.
    */
    
    public boolean isOrdered(int [] arr,int index){
        if(index < arr.length && arr.length > 1){
            if(arr[index] < arr[index+1]){
                return true;
            }
            isOrdered(arr,index+1);
        }
        return false;
    }


    /*Busqueda binaria ejericio 2 */
    public int findElement(int [] arr,int element, int ini, int fin){
        int medio;
        if(ini > fin)return -1;
        else{
            medio = (ini+fin) /2;
            if(element > arr[medio]){
                return findElement(arr, element, medio+1, fin);
            }
            else{
                if(element < arr[medio]){
                    return findElement(arr, element, ini, medio-1);
                }
                else{
                    return medio;
                }
            }
    }

    /*Convertir en binario ejercicio 3 */
    public static String convertirEnBinario(int num){
        if(num == 0){
            return "0";
        }
        int cociente = num / 2;
        int resto = num%2;
        String binario = convertirEnBinario(cociente);
        return resto + binario;
    }   

    /*Implementar secuencia de fibonacci ejercico 4  */
    public static void cantidadSecuenciaFibonacci(int anterior, int siguiente, int iteraciones){
        if(iteraciones==0){
            return;
        }
        else{
            int suma = anterior+siguiente;
            System.out.println(anterior);
            cantidadSecuenciaFibonacci(siguiente,suma, iteraciones);
        }
    }

    /*Recursivo A[i] = i ejercicio 5*/

    public static boolean anyElemIsEqualsToIndex(int arr [],int index){
        if(arr.length > 0 && index < arr.length){
            if (arr[index] == index) {
                System.out.println(arr[index] + "==" + index);
                return true;
            }else{
                return anyElemIsEqualsToIndex(arr, index+1);
            }
        }
        return false;
    }

    /*ejercicio 6 */

    public static void ordenarArrayPorSeleccion(int [] arr){
        for(int i = 0; i<arr.length;i++){
            for(int j = i+1; j<arr.length;j++ ){
                if(arr[i] > arr[j]){
                    int tmp = arr[i];   
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    /*Complejidad de O(ne2) */

    public static void ordenarArrayPorBurbujeo(int [] arr){
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for(int i = 0; i<arr.length-j;i++){
                if(arr[i]>arr[i+1]){
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    /*Complejidad de O(ne2) */

    /*Ejercicio 7 */
    /*Mergesort tiene una complejidad promedio de O(n) y O(n.log2 n) en el peor caso debido a que pasa 1 sola vez por cada elemento */
    public class Mergesort{
        private int [] numbers;
        private int [] helper;
        private int size;

        public void sort(int [] values){
            this.numbers = values;
            size = values.length;
            this.helper = new int [size];
            mergesort(0, size-1);
        }
        
        public void mergesort(int low,int high){
            if(low<high){
                int middle = (low+high) /2;
                mergesort(low, middle);
                mergesort(middle+1,high);
                merge(low,middle,high);
            }
        }
    
        public void merge(int low,int middle, int high){
            for(int i = low; i<=high;i++){
                helper[i] = numbers[i];
            }
            int i = low;
            int j = middle+1;
            int k = low;    
            while((i <= middle) && (j<=high)){
                if(helper[i]<=helper[j]){
                    numbers[k]=helper[i];
                    i++;
                }else{
                    numbers[k]=helper[j];
                    j++;
                }
                k++;
            }
            while (j<=high) {
                numbers[k] = helper[j];
                k++;
                j++;
            }
        }
    
    }
    /*Complejidad  O(n2) y en el peor caso O(n.log2 n) PEOR QUE EL MERGESORT. NO REQUIERE MEMORIA ADICIONAL */
    public class QuickSort{
        
        private int [] arr = {3,2,5,1,8};

        public int [] ordenarQuickSort(int [] arr){
            return quickSort(arr,0,arr.length);
        }

        public int [] quickSort(int [] arr, int izq, int der){
            int pivot = arr[izq];
            int i = izq;
            int j = der;
            int aux;

            while(i<j){
                while (arr[i]<=pivot && i<j) {
                    i++;
                }
                while (arr[j]>pivot) {
                    j--;
                }
                if(i<j){
                    aux = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;
                }
            }

            arr[izq]= arr[j];
            arr[j] = pivot;
            if(izq<j-1){
                quickSort(arr, izq, j-1);
            }
            if(j+1 <der){
                quickSort(arr, j + 1 , der);
        }
    }



  

}
