package list_of_arrays;

final class ListOfArraysItem <T>{
    int numberOfListElemsInArray;
    Object [] arrayOfElems;
    ListOfArraysItem<T> next;
    ListOfArraysItem<T> previous;

    ListOfArraysItem(int size){
        arrayOfElems = new Object[size];
        numberOfListElemsInArray = 0;
    }
}
