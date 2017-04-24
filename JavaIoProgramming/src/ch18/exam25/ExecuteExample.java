package ch18.exam25;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteExample {

    public static void main(String... args) throws IOException {
        // 스레드풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10000; i++) {
            // 작업생성코드
            Runnable task = () -> {
                System.out.println(Thread.currentThread().getName() + " :작업처리");
            };

            // 작업처리지시(작업큐에 넣기)
            executorService.submit(task); // 작업큐에 넣는 처리코드
        }

        // 스레드풀 종료
        System.in.read();
        executorService.shutdown(); // shutdownNow()도 가능.
    }
}
