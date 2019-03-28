package Concurrency.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName : CacheHealthChecker
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-27 16:00
 * @Version : 1.0
 */
public class CacheHealthChecker extends BaseHealthChecker {
    public CacheHealthChecker (CountDownLatch latch)  {
        super("Cache Service", latch);
    }

    @Override
    public void verifyService()
    {
        System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(7000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
