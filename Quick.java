import java.util.Arrays;

public class Quick {
  public static int partition(int[] data, int start, int end) {
    int pivot = getPivot(data, start, end);
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
      } else if (data[start] == data[pivot] && (((int)Math.random())*2)%2 == 0) {
        swap(data, start, hi);
        hi--;
      } else if (data[hi] == data[pivot] && (((int)Math.random())*2)%2 == 0) {
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
      if (data[i] < data[pivot]) lastLeft = i;
      if (data[i] > data[pivot]) i = end + 1;
    }
    swap(data, pivot, lastLeft);
    return lastLeft;
  }

  public static int[] partitionDutch(int[] data, int start, int end) {
    swap(data, start, getPivot(data, start, end));
    int gt = end;
    int lt = start;
    int i = start + 1;
    while (i <= gt) {
      //System.out.println(Arrays.toString(data)+" lt="+lt+",gt="+gt+",i="+i);
      if (data[i] < data[lt]) {
        swap(data, i, lt);
        lt++;
        i++;
      } else if (data[i] > data[lt]) {
        swap(data, i, gt);
        gt--;
      } else i++;
      //try {
      //  Thread.sleep(1000);
      //} catch (InterruptedException e) {}
    }
    return new int[] {lt, gt};
  }

  private static int getPivot(int[] data, int start, int end) {
    int mid = (start + end) / 2;
    if (data[start] > data[end]) {
      if (data[end] > data[mid]) return end;
      if (data[start] > data[mid]) return mid;
      return start;
    } else {
      if (data[start] > data[mid]) return start;
      if (data[end] > data[mid]) return mid;
      return end;
    }
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

  public static void quicksort(int[] data) {
    sort(data, 0, data.length);
  }

  private static void sort(int[] data, int start, int end) {
    if (start >= end) return;
    int pivot = partition(data, start, end);
    sort(data, start, pivot - 1);
    sort(data, pivot + 1, end);
  }

  private static void swap(int[] data, int a, int b) {
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  public static void main(String[] args) {
    int[] test = new int[10];
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 10; j++) {
       test[j] = (int)(Math.random() * 3);
      }
      //System.out.println(partition(test, 0, 7));
      int[] k = partitionDutch(test, 0, 9);
      for (int j = 0; j < 10; j++) {
        if (j < k[0] && test[j] >= test[k[0]]
        || j > k[1] && test[j] <= test[k[1]]
        || j >= k[0] && j <= k[1] && (test[j] != test[k[0]] || test[j] != test[k[1]])) {
          System.out.println("FAIL on test "+i);
          System.out.println(k+"\n"+Arrays.toString(test));
          System.exit(1);
        }
      }
    }
    System.out.println(Arrays.toString(test));
    System.out.println("PASS");
  }
}
