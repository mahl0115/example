package com.hystrix;

import com.netflix.hystrix.*;

/**
 * Created by mahailong on 16/11/17.
 */
public class CommandSetter {

    private static final CommandSetter setter = new CommandSetter();

    private CommandSetter() {
    }

    public static CommandSetter getInstance() {
        return setter;
    }

    /**
     * 构建Command参数配置,默认线程池数量为10
     * @param groupKey
     * @param commandKey
     * @param timeout
     * @return
     */
    public HystrixCommand.Setter getSetter(String groupKey, String commandKey, int timeout) {
        return getSetter(groupKey, commandKey, timeout, 10);
    }

    /**
     * 构建Command参数配置
     * @param groupKey
     * @param commandKey
     * @param timeout
     * @param poolSize
     */
    public HystrixCommand.Setter getSetter(String groupKey, String commandKey, int timeout, int poolSize) {
        //最少配置:指定命令组名(CommandGroup)
        return (HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey))
        .andCommandKey(HystrixCommandKey.Factory.asKey(commandKey))
        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(timeout))
        .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(poolSize))
        );
    }
}
