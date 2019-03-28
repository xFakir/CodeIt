package Algorithm.array;

import com.sun.scenario.effect.Merge;

import java.util.*;

/**
 * @ClassName : MergeIntervals
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-20 10:28
 * @Version : 1.0
 */
public class MergeIntervals {
    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2:
     * <p>
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */

    public static List<Interval> solution(List<Interval> intervals) {
        /*Iterator<Interval> iterator = intervals.iterator();
        while (iterator.hasNext()){
            Interval interval = iterator.next();
        }*/


        sortList(intervals);
        for (int i = 1; i < intervals.size(); i++) {
            if(i == 0 && intervals.size() == 1){
                break;
            }

            if (isOverlaid(intervals,i)) {
                intervals.get(i - 1).start = Math.min(intervals.get(i).start,intervals.get(i - 1).start);
                intervals.get(i - 1).end = Math.max(intervals.get(i).end,intervals.get(i - 1).end);
                //开销大
                intervals.remove(i--);


            }

        }

        return intervals;
    }

    public List<Interval> solution2(List<Interval> intervals){
        List<Interval> list=new ArrayList<Interval>();
        Interval L=new Interval();//一层循环保存对象
        Interval R=new Interval();//二层循环保存对象
        for(int i=0;i<intervals.size();i++){
            L=intervals.get(i);
            int j=i+1;
            for(;j<intervals.size();j++){
                R=intervals.get(j);
                if(R.start==L.start){
                    intervals.set(j,new Interval(L.start,Math.max(L.end,R.end)));
                    break;
                }else if(L.start<R.start){
                    if(L.end>=R.start){
                        Interval inter=new Interval(L.start,Math.max(L.end,R.end));
                        intervals.set(j,inter);
                        break;
                    }

                }else{
                    if(R.end>=L.start){
                        Interval inter=new Interval(R.start,Math.max(L.end,R.end));
                        intervals.set(j,inter);
                        break;
                    }
                }
            }

            if(j>=intervals.size()){
                list.add(intervals.get(i));
            }
        }
        return list;
    }

    /**
     * 按照start升序排列
     * @param intervals
     */
    public static void sortList(List<Interval> intervals){
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
    }


    /**
     *
     * @param intervals
     * @param i
     * @return 重叠返回true，未重叠返回false
     */
    public static boolean isOverlaid(List<Interval> intervals,int i){
        int i1_start = intervals.get(i - 1).start;
        int i2_start = intervals.get(i).start;
        int i1_end = intervals.get(i - 1).end;
        int i2_end = intervals.get(i).end;
        boolean before = i1_end > i2_end && i1_start > i2_start && i1_end > i2_start && i1_start > i2_end;
        boolean after = i1_end < i2_end && i1_start < i2_start && i1_end < i2_start && i1_start < i2_end;
        return ! (before || after);
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        MergeIntervals mergeIntervals = new MergeIntervals();
        intervals.add(mergeIntervals.new Interval(1,3));
        intervals.add(mergeIntervals.new Interval(2,6));
        intervals.add(mergeIntervals.new Interval(8,10));
        intervals.add(mergeIntervals.new Interval(15,18));

        List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(mergeIntervals.new Interval(2,3));
        intervals2.add(mergeIntervals.new Interval(5,5));
        intervals2.add(mergeIntervals.new Interval(2,2));
        intervals2.add(mergeIntervals.new Interval(3,4));
        intervals2.add(mergeIntervals.new Interval(3,4));


        System.out.println(solution(intervals2));

    }



    private class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }
}
