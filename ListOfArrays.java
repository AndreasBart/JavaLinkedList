package list_of_arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ListOfArrays<T> {

    private int LENGTH_OF_ALL_ARRAYS;
    private final static int DEFAULT_LENGTH_OF_ALL_ARRAYS;
    private ListOfArraysItem<T> head;
    private ListOfArraysItem<T> tail;

    static {
        DEFAULT_LENGTH_OF_ALL_ARRAYS = 256;
    }

    public ListOfArrays() {
        head = null;
        tail = null;
        LENGTH_OF_ALL_ARRAYS = DEFAULT_LENGTH_OF_ALL_ARRAYS;
    }

    public void readArrayLength(String str) {
        String line;
        try {
            File filereader = new File(str);
            BufferedReader br = new BufferedReader(new FileReader(filereader));
            if ((line = br.readLine()) != null) {
                br.close();
                if (Integer.parseInt(line) < 0) {
                    throw new NegativeArraySizeException();
                } else {
                    LENGTH_OF_ALL_ARRAYS = Integer.parseInt(line);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public boolean contains(T obj) {

        ListOfArraysItem<T> current = head;
        while (current != null) {
            for (int i = 0; i < current.numberOfListElemsInArray; i++) {
                if (obj == current.arrayOfElems[i])
                    return true;
            }
            current = current.next;
        }

        return false;
    }

    public void add(T obj) {
        // Wenn die Liste leer war erzeuge neuen Knoten und hänge obj an index 0 an
        if (head == null) {
            ListOfArraysItem<T> node = new ListOfArraysItem<T>(LENGTH_OF_ALL_ARRAYS);
            head = tail = node;
            head.previous = null;
            tail.next = null;
            node.arrayOfElems[0] = obj;
            node.numberOfListElemsInArray++;
        }
        // Wenn Liste nicht leer war
        else {
            ListOfArraysItem<T> current = head;
            // prüfe ob aktueller Knoten noch Platz hat, wenn ja hänge obj an aktuellen
            // index an
            if (current.numberOfListElemsInArray < LENGTH_OF_ALL_ARRAYS) {
                current.arrayOfElems[current.numberOfListElemsInArray] = obj;
                current.numberOfListElemsInArray++;
            }
            // wenn kein platz mehr ist erzeuge neuen Knoten und hänge obj an index 0 an
            else {
                ListOfArraysItem<T> node = new ListOfArraysItem<T>(LENGTH_OF_ALL_ARRAYS);
                tail.next = node;
                node.previous = tail;
                tail = node;
                tail.next = null;
                node.arrayOfElems[0] = obj;
                node.numberOfListElemsInArray++;
            }

        }
    }

    public void addAll(T[] objArr) {

        for (int i = 0; i < objArr.length; i++) {

            // Wenn die Liste leer war erzeuge neuen Knoten und hänge obj an index 0 an
            if (head == null) {
                ListOfArraysItem<T> node = new ListOfArraysItem<T>(LENGTH_OF_ALL_ARRAYS);
                head = tail = node;
                head.previous = null;
                tail.next = null;
                node.arrayOfElems[0] = objArr[i];
                node.numberOfListElemsInArray++;
            }
            // Wenn Liste nicht leer war
            else {
                ListOfArraysItem<T> current = head;
                // prüfe ob aktueller Knoten noch Platz hat, wenn ja hänge obj an aktuellen
                // index an
                if (current.numberOfListElemsInArray < LENGTH_OF_ALL_ARRAYS) {
                    current.arrayOfElems[current.numberOfListElemsInArray] = objArr[i];
                    current.numberOfListElemsInArray++;
                }
                // wenn kein platz mehr ist erzeuge neuen Knoten und hänge obj an index 0 an
                else {
                    ListOfArraysItem<T> node = new ListOfArraysItem<T>(LENGTH_OF_ALL_ARRAYS);
                    tail.next = node;
                    node.previous = tail;
                    tail = node;
                    tail.next = null;
                    node.arrayOfElems[0] = objArr[i];
                    node.numberOfListElemsInArray++;
                }

            }

        }

    }

}
