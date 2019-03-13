import java.util.Arrays;

public class Quick {
  public static int partition(int[] data, int start, int end) {
    int index = start + (int)(Math.random() * (end - start + 1));
    swap(data, 0, index);
    start++;
    while (start < end) {
      if (data[start] > data[0]) {
        swap(data, start, end);
        end--;
      } else if (data[end] < data[0]) {
        swap(data, start, end);
        start++;
      } else {
        start++;
      }
    }
    for (int i = start; i <= end; i++) {
      if (data[i] > data[0]) {
        swap(data, 0, i - 1);
        index = i - 1;
        i = end + 1;
      }
    }
    if (data[0] > data[data.length - 1]) swap(data, 0, data.length - 1);
    return index;
  }

  public static int quickselect(int[] data, int k) {
    int start = 0;
    int end = data.length - 1;
    int pivot = 0;
    boolean run = true;
    while (run) {
      pivot = partition(data, start, end);
      System.out.println(Arrays.toString(data) +",  "+pivot);
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
