package Concurrency.ThreadAPI.Join_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName : Join_Practice
 * @Description : 模仿航班联合查询
 * @Author : xcx
 * @Date : 2019-02-28 15:34
 * @Version : 1.0
 */
public class Join_Practice {
    private static List<String> fightCompany = Arrays.asList("CSA","CEA","HNA");

    public static void main(String[] args) {
        List<String> results = search("SH","BJ");
        System.out.println("============result==============");
        results.forEach(System.out::println);
    }

    private static List<String> search(String origin,String destination){
        final List<String> result = new ArrayList<>();
        List<FightQueryTask> tasks = fightCompany.stream()
                .map(f -> createSearchTask(f,origin,destination)).collect(toList());
        tasks.forEach(Thread::start);

        tasks.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        tasks.stream().map(FightQueryTask::get).forEach(result::addAll);

        return result;
    }

    private static FightQueryTask createSearchTask(String fight,String origin,String destination){
        return new FightQueryTask(fight,origin,destination);
    }


}
