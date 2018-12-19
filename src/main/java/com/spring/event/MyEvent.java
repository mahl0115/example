package com.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * 事件
 *
 * @Author mahl
 * @Date 2017-11-26
 */
public class MyEvent extends ApplicationContextEvent{

    public MyEvent(ApplicationContext source) {
        super(source);
    }
}
