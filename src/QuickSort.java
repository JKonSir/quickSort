import java.util.Comparator;

public class QuickSort
{
    private void swap(int[] arraySort, int i, int j)
    {
        int tmp;
        tmp = arraySort[i];
        arraySort[i] = arraySort[j];
        arraySort[j] = tmp;
    }

    private int permutation(int[] arraySort, int left, int right, Comparator comparator)
    {
        int pivotIndex = left + (right - left) / 2;
        int pivot = 0;
        try
        {
            pivot = arraySort[pivotIndex];
        } catch (ArrayIndexOutOfBoundsException ex)
        {
            System.out.println();
        }

        swap(arraySort, right, pivotIndex);

        for (int i = pivotIndex = left; i < right; ++i)
        {
            if (comparator.compare(arraySort[i], pivot) <= 0)
            {
                swap(arraySort, i, pivotIndex++);
            }
        }
        swap(arraySort, pivotIndex, right);

        return pivotIndex;
    }

    private void quickSort(int[] arraySort, int left, int right, Comparator comparator)
    {
        if (right > left)
        {
            int pivotIndex = permutation(arraySort, left, right, comparator);
            quickSort(arraySort, left, pivotIndex - 1, comparator);
            quickSort(arraySort, pivotIndex + 1, right, comparator);

        }
    }

    public void sort(int[] arraySort, int arraySize, Comparator comparator)
    {
        quickSort(arraySort, 0, arraySize - 1, comparator);
    }
}
