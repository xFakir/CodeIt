package Concurrency.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName : NetworkHealthChecker
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-27 15:56
 * @Version : 1.0
 */
public class NetworkHealthChecker extends BaseHealthChecker {
    public NetworkHealthChecker (CountDownLatch latch)  {
        super("Network Service", latch);
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
