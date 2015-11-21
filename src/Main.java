import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class Main
{
    private static Random RANDOM = new Random();

    public static void main(String[] args)
    {
        int arraySize = 100;
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++)
        {
            int tmp = RANDOM.nextInt(i + 1);

            array[i] = tmp;
            System.out.println(array[i]);
        }
        System.out.println("\n");

        QuickSort quickSort = new QuickSort();
        Comparator comparator = getComparator();
        quickSort.sort(array, arraySize, comparator);
        for (int i = 0; i < arraySize; i++)
        {
            System.out.println(array[i]);
        }
    }

    private static Comparator getComparator()
    {
        return new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                int a = (int) o1;
                int b = (int) o2;
                if (a > b)
                {
                    return -1;
                } else if (a < b)
                {
                    return 1;
                }

                return 0;
            }
        };
    }
}
