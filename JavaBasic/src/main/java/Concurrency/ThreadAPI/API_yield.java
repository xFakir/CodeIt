package Concurrency.ThreadAPI;

import java.util.stream.IntStream;

/**
 * @ClassName : API_yield
 * @Description :
 * @Author : xcx
 * @Date : 2019-02-26 16:57
 * @Version : 1.0
 */
public class API_yield {
    public static void main(String[] args) {
        IntStream.range(0,2).mapToObj(API_yield::create).forEach(Thread::start);
    }

    private static Thread create(int index){
        return new Thread(()->{
            if(index == 0){
                Thread.yield();
            }
            System.out.println(index);
        });
    }
}
