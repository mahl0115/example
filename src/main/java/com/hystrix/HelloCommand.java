package com.hystrix;

import com.alibaba.fastjson.JSON;
import com.es.model.User;
import com.google.common.collect.Lists;
import com.netflix.hystrix.HystrixCommand;

import java.util.List;

/**
 * Created by mahailong on 16/11/17.
 */
public class HelloCommand extends HystrixCommand<List<User>> {

    protected final String groupKey;
    protected final String commandKey;
    protected final int timeout;
    protected final int threadPoolSize;

    protected HelloCommand(String groupKey, String commandKey, int timeout, int threadPoolSize) {
        super(CommandSetter.getInstance().getSetter(groupKey, commandKey, timeout, threadPoolSize));
        this.groupKey = groupKey;
        this.commandKey = commandKey;
        this.timeout = timeout;
        this.threadPoolSize = threadPoolSize;
    }

    @Override
    protected List<User> run() {
        // 依赖逻辑封装在run()方法中
        return service();
    }

    public List<User> service() {
        List<User> users = Lists.newArrayList();
        User user = new User();
        user.setId(123);
        user.setName("123");
        user.setAge(123);
        users.add(user);
        return users;
    }

    //调用实例
    public static void main(String[] args) throws Exception {
        HelloCommand helloCommand = new HelloCommand("testGroup", "testKey", 1000, 10);
        List<User> users = helloCommand.execute();
        System.out.println("users = " + JSON.toJSONString(users));

//        helloCommand = new HelloCommand("testGroupAsync", "testKeyAsync", 1000, 10);
//        Future<String> future = helloCommand.queue();
//        result = future.get();
//        System.out.println("result = " + result);
//        System.out.println("mainThread = " + Thread.currentThread().getName());

        System.exit(0);
    }
}
