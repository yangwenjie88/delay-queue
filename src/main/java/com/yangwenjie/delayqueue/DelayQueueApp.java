package com.yangwenjie.delayqueue;

import com.yangwenjie.delayqueue.listener.ApplicationStartup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yang WenJie
 * @date 2018/1/27 下午10:09
 */
@SpringBootApplication
public class DelayQueueApp {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DelayQueueApp.class);
        application.addListeners(new ApplicationStartup());
        application.run(args);
    }
}
