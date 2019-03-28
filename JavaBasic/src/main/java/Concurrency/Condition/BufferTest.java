package Concurrency.Condition;

import java.util.Random;

/**
 * @ClassName : BufferTest
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-28 14:12
 * @Version : 1.0
 */
public class BufferTest {
    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        for(int i = 0; i < 5; i ++) { //开启5个线程往缓冲区存数据
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        buffer.put(new Random().nextInt(1000)); //随机存数据
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for(int i = 0; i < 10; i ++) { //开启10个线程从缓冲区中取数据
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        buffer.take(); //从缓冲区取数据
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
