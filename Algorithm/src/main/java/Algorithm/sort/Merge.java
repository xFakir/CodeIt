package Algorithm.sort;

/**
 * @ClassName : Merge
 * @Description :
 * @Author : xfakir
 * @Date : 2020/6/5 10:26
 * @Version : 1.0
 */
public class Merge extends SortBasic{
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a,0,a.length - 1);
    }

    public static void sort(Comparable[] a, int left,int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sort(a,left,mid);
        sort(a,mid+1,right);
        merge(a,left,mid,right);
    }

    public static void merge(Comparable[] a, int left,int mid,int right) {
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right ; k++) {
            aux[k] = a[k];
        }
        for (int k = left; k <= right; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > right) a[k] = aux[i++];
            else if (less(aux[j],aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        sort(setTestCase("57948513589"));
        show(getResult()  );
    }
}
