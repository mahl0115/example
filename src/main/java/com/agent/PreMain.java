package com.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author mahl
 * @date 2018-11-27
 */
public class PreMain {

    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("=========premain方法执行========");
        System.out.println(agentOps);
        // 添加Transformer
        inst.addTransformer(new FirstAgent());
    }
}
