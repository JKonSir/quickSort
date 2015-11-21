import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Main
{
    private static Random RANDOM = new Random();

    public static void main(String[] args)
    {
        int arraySize = 100;
        ArrayList<Double> array = new ArrayList<>(arraySize);

        for (int i = 0; i < arraySize; i++)
        {
            array.add(RANDOM.nextDouble());
            System.out.println(array.get(i));
        }
        System.out.println("\n");

        QuickSort<Double> quickSort = new QuickSort<Double>();
        Comparator comparator = quickSort.getComparator();
        quickSort.sort(array, arraySize, comparator);
        for (int i = 0; i < arraySize; i++)
        {
            System.out.println(array.get(i));
        }
    }
}
