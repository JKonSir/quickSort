import java.util.Comparator;
import java.util.Random;

public class Main
{
    private static Random RANDOM = new Random();

    public static void main(String[] args)
    {
        int arraySize = 10;
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++)
        {
            array[i] = RANDOM.nextInt(20);
            System.out.println(array[i]);
        }
        System.out.println(array.toString());

        QuickSort quickSort = new QuickSort();
        Comparator comparator = getComparator();
        quickSort.sort(array, arraySize, comparator);
        System.out.println(array);
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
