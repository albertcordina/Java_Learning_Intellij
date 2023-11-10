import java.util.ArrayList;
import java.util.ArrayList;

public class Loop_For_Each {

    public static void main(String[] args) {

        // for-each = 'enhanced for loop' traversing technique to iterate through the elements in an array/collection; 2:17;
        //            less steps, more readable;
        //            less flexible;

        //String[] animals = {"cat", "dog", "rat", "bird"};
        ArrayList<String> animals = new ArrayList<String>();

        animals.add("\ncat");
        animals.add("dog");
        animals.add("rat");
        animals.add("bird");

        for (String i : animals) { System.out.println(i); }

            animals.forEach(System.out::println); // <--- even shorter way with the method 'forEach'

    }
}
