package com.copy;

import com.es.model.User;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

/**
 * @Author mahl
 * @Date 2017-11-10
 */
public class CglibBeanCopierUtils {

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("123");
        user.setAge(23);

        User user2 = new User();
        User user3 = new User();

        //beanCopier
        StopWatch sw = new StopWatch();
        sw.start();

        beanCopier(user, user2);

        System.out.println(sw.getTime());

        //beanUtils
        StopWatch sw2 = new StopWatch();
        sw2.start();

        beanUtils(user, user3);
        System.out.println(sw2.getTime());

        //System.out.println(JsonUtils.toJson(user2));
        //System.out.println(JsonUtils.toJson(user3));
    }

    /**
     * @param source 资源类
     * @param target 目标类
     */
    private static void beanCopier(Object source, Object target) {
        BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), false);
        copier.copy(source, target, null);
    }

    /**
     * @param source 资源类
     * @param target 目标类
     */
    private static void beanUtils(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }

    /*注：
    (1)相同属性名，且类型不匹配时候的处理，ok，但是未满足的属性不拷贝；
    (2)get和set方法不匹配的处理，创建拷贝的时候报错，无法拷贝任何属性(当且仅当sourceClass的get方法超过set方法时出现)
    (3)BeanCopier
    初始化例子：BeanCopier copier = BeanCopier.create(Source.class, Target.class, useConverter=true)
    第三个参数userConverter,是否开启Convert,默认BeanCopier只会做同名，同类型属性的copier,否则就会报错.
    copier = BeanCopier.create(source.getClass(), target.getClass(), false);
    copier.copy(source, target, null);
    (4)修复beanCopier对set方法强限制的约束
    改写net.sf.cglib.beans.BeanCopier.Generator.generateClass(ClassVisitor)方法
    将133行的
    MethodInfo write = ReflectUtils.getMethodInfo(setter.getWriteMethod());
    预先存一个names2放入
     109        Map names2 = new HashMap();
     110        for (int i = 0; i < getters.length; ++i) {
     111          names2.put(setters[i].getName(), getters[i]);
                }
    调用这行代码前判断查询下，如果没有改writeMethod则忽略掉该字段的操作，这样就可以避免异常的发生。*/
}
