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
    while (data[end] != k) {
      end = partition(data, start, end);
    }
    return end;

  }

  private static void swap(int[] data, int a, int b) {
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }
}
