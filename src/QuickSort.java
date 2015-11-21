import java.util.ArrayList;
import java.util.Comparator;

public class QuickSort<T extends Number>
{
    private void swap(ArrayList<T> arraySort, int i, int j)
    {
        T tmp;
        tmp = arraySort.get(i);
        arraySort.set(i, arraySort.get(j));
        arraySort.set(j, tmp);
    }

    private int permutation(ArrayList<T> arraySort, int left, int right, Comparator comparator)
    {
        int pivotIndex = left + (right - left) / 2;
        T pivot = arraySort.get(pivotIndex);

        swap(arraySort, right, pivotIndex);

        for (int i = pivotIndex = left; i < right; ++i)
        {
            if (comparator.compare(arraySort.get(i), pivot) <= 0)
            {
                swap(arraySort, i, pivotIndex++);
            }
        }
        swap(arraySort, pivotIndex, right);

        return pivotIndex;
    }

    private void quickSort(ArrayList<T> arraySort, int left, int right, Comparator comparator)
    {
        if (right > left)
        {
            int pivotIndex = permutation(arraySort, left, right, comparator);
            quickSort(arraySort, left, pivotIndex - 1, comparator);
            quickSort(arraySort, pivotIndex + 1, right, comparator);

        }
    }

    public void sort(ArrayList<T> arraySort, int arraySize, Comparator comparator)
    {
        quickSort(arraySort, 0, arraySize - 1, comparator);
    }

    public Comparator<? extends T> getComparator()
    {
        return new Comparator<T>()
        {
            @Override
            public int compare(Number o1, Number o2)
            {
                if (o1.doubleValue() > o2.doubleValue())
                {
                    return -1;
                } else if (o1.doubleValue() < o2.doubleValue())
                {
                    return 1;
                }
                return 0;
            }
        };
    }
}
