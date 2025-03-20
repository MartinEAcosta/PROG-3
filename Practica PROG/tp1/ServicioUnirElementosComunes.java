package tp1;

import java.util.ArrayList;

/*Ejercicio 5
Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
suponiendo que: a) Las listas están desordenadas y la lista resultante debe quedar ordenada. b)
Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
 */
public class ServicioUnirElementosComunes<T> {
    
    public MySimpleLinkedList<T> getUnionOrdered(MySimpleLinkedList<T> firstList, MySimpleLinkedList<T> secondList){
        MySimpleLinkedList<T> unionList = new MySimpleLinkedList<T>();
        ArrayList<Node<T>> comunes = new ArrayList<Node<T>>();
        Node<T> currentFirst = firstList.getRoot();
        Node<T> currentSecond = secondList.getRoot();
        int indexFirst = 0;
        int indexSecond = 0;
        while(indexFirst <= firstList.size()){
            while (indexSecond <= secondList.size()) {
                if(currentFirst.getInfo().equals(currentSecond.getInfo())){
                    comunes.add(currentFirst);
                }
            }
        }




        return unionList;

    }

}
