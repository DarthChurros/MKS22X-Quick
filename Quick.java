import java.util.Arrays;

public class Quick {
  public static int partition(int[] data, int start, int end) {
    int pivot = start + (int)(Math.random() * (end - start + 1));
    swap(data, start, pivot);
    int hi = end;
    pivot = start;
    start++;
    while (start < hi) {
      if (data[start] > data[pivot]) {
        swap(data, start, hi);
        hi--;
      } else if (data[hi] < data[pivot]) {
        swap(data, start, hi);
        start++;
      } else {
        start++;
        hi--;
      }
      //System.out.println(Arrays.toString(data) + ", start="+start+",end="+hi);
    }
    int lastLeft = pivot;
    for (int i = pivot+1; i <= end; i++) {
      if (data[i] < data[pivot]) {
        lastLeft = i;
      }
    }
    swap(data, pivot, lastLeft);
    return lastLeft;
  }

  public static int quickselect(int[] data, int k) {
    int start = 0;
    int end = data.length - 1;
    int pivot = 0;
    boolean run = true;
    while (run) {
      pivot = partition(data, start, end);
      //System.out.println(Arrays.toString(data) +"start="+start+", end="+end+",pivot="+pivot);
      if (k > pivot) start = pivot + 1;
      else if (k < pivot) end = pivot - 1;
      else run = false;
    }
    return data[pivot];
  }

  private static void swap(int[] data, int a, int b) {
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }
}
