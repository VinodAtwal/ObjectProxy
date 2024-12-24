package org.va.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.va.model.DepartmentRepo;

import java.lang.reflect.Method;

public class CglibProxy implements Runnable{
    @Override
    public void run() {
        MethodInterceptor interceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("Before CGLIB Proxy: " + method.getName());
                /*
                 * Similar to AOP but we can also do some custom code impl on runtime
                 * */
                /* we can uncomment below for AOP behaviour
                 * */
//                Object result = proxy.invokeSuper(obj, args); // Important: Use invokeSuper!
                System.out.println("After CGLIB Proxy: " + method.getName());
                return "cglib departments {depId: 123-123-123-1234}";
            }
        };
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DepartmentRepo.class);
        enhancer.setCallback(interceptor);
        DepartmentRepo cglibProxy = (DepartmentRepo) enhancer.create();

        String cglibProxyResult = cglibProxy.getDepartments();
        System.out.println("Result from CGLIB Proxy call: " + cglibProxyResult);
    }
}
