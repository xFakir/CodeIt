package Algorithm.sort;

/**
 * @ClassName : Quick
 * @Description :
 * @Author : xfakir
 * @Date : 2020/7/26 10:14
 * @Version : 1.0
 */
public class Quick {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);

    }

    public static void sort(Comparable[] a,int lo,int hi) {
        if (hi <= lo) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    private static int partition(Comparable[] a,int lo,int hi){
        int i = lo,j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (SortBasic.less(a[++i],v)) if (i == hi) break;
            while (SortBasic.less(v,a[--j])) if (j == lo) break;
            if (i >= j) break;
            SortBasic.exchange(a,i,j);
        }
        SortBasic.exchange(a,lo,j);
        return j;
    }
}
