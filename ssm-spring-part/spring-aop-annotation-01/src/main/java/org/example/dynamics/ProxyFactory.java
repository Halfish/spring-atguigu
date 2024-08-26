package org.example.dynamics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/*
 * JDK 的动态代理工厂
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler handler = (proxy, method, args) -> {
            Object result = null;
            try {

            System.out.println("method = " + method + ", args = " + Arrays.toString(args));
            result = method.invoke(target, args);
            System.out.println("result = " + result);
            } catch (Exception e) {
                System.out.println("Exception = " + e);
            } finally {
                System.out.println(method + " Done");
            }
            return result;
        };

        /*
         * JDK 生成代理对象：类加载器、类目标接口、代理拦截器
         */
        return Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
