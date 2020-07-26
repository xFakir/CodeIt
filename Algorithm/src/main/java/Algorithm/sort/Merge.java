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

    /**
     * 辅助数组
     * @param a
     */
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
        show(getResult());
    }

    /**
     * 原地归并
     * 自顶向下
     */
    public static void sort2(Comparable[] a) {
        aux = new Comparable[a.length];
        sort2(a,0,a.length - 1);
    }

    public static void sort2(Comparable[] a, int lo, int hi) {
        if (hi <= lo)  return;
        int mid = lo + (hi - lo)/2;
        sort2(a,lo,mid);
        sort2(a,mid,hi);
        merge(a,lo,mid,hi);
    }

    /**
     * 自底向上
     * @param a
     */
    public static void sort3(Comparable[] a){
        aux = new Comparable[a.length];
        for (int sz=1; sz < a.length; sz = sz + sz) {
            for (int lo = 0; lo < a.length - sz; lo += sz+sz){
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,a.length-1));
            }
        }
    }

}
