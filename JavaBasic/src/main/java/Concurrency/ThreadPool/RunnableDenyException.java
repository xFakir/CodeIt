package Concurrency.ThreadPool;

/**
 * @ClassName : RunnableDenyException
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-06 15:38
 * @Version : 1.0
 */
public class RunnableDenyException extends RuntimeException {
    public RunnableDenyException(String message){
        super(message);
    }
}
