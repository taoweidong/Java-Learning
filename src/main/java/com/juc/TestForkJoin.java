package com.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 分支合并框架.就是在必要的情况下，将一个大任务，进行拆分(fork)成 若干个小任务（拆到不可再拆时），再将一个个的小任务运算的结果进 行 join 汇总。 Fork/Join 框架采用
 * “工作窃取”模式（work-stealing）：当执行新的任务时它可以将其拆分分成更小的任务执行， 并将小任务加到线程队列中，然后再从一个随机线程的队列中偷一个并把它放在自己的队列中。
 */
public class TestForkJoin {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 1000000000L);
        Long sumCount = pool.invoke(task);
        System.out.println(sumCount);

        Long o = LongStream.range(0L, 5000000000000L).parallel().reduce(0L, Long::sum);
        System.out.println(o);
    }
}

class ForkJoinSumCalculate extends RecursiveTask<Long> {

    private Long start;

    private Long end;

    private static final Long ZERO = 10000L;

    public ForkJoinSumCalculate(Long start, Long end) {

        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        Long length = end - start;

        if (length <= ZERO) {
            Long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            Long middle = (start + end) / 2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, middle);
            left.fork();// 进行拆分，同时压入线程队列

            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle + 1, end);
            right.fork();// 进行拆分，同时压入线程队列

            return left.join() + right.join();

        }
    }
}
