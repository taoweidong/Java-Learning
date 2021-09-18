package com.threadPool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName MyPolicy
 * @Description 自定义拒绝策略 策略1：AbortPolicy策略：该策略会直接抛出异常，阻止系统正常工作。 策略2：CallerRunsPolicy
 *              策略：只要线程池未关闭，该策略直接在调用者线程中，运行当前的被丢弃的任务。 策略3：DiscardOleddestPolicy策略：
 *              该策略将丢弃最老的一个请求，也就是即将被执行的任务，并尝试再次提交当前任务。 策略4：DiscardPolicy策略：该策略默默的丢弃无法处理的任务，不予任何处理。
 * @Author Taowd
 * @Date 2018/6/17 14:37
 * @Version V1.0
 */
public class MyPolicy implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

    }
}
