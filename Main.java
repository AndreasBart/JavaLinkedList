import list_of_arrays.*;

public class Main {
    public static void main(String[] args) {

        ListOfArrays<String> liste = new ListOfArrays<String>();
        liste.readArrayLength("laenge.txt");

        String [] arr = {"eins","zwei","drei","vier"};
        liste.addAll(arr);

        if(liste.contains("zwei")) System.out.println("Ist enthalten");

       
    }
}
