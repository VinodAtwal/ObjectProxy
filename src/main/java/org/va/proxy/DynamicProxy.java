package org.va.proxy;

import org.va.model.EmployeeRepo;
import org.va.model.EmployeeRepoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements Runnable {

    @Override
    public void run() {
        EmployeeRepo realObject = new EmployeeRepoImpl();

        /*
        *
        * It intercepts the invocation of method via class
        * can be written in Lambda ✌
        * */
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Before Java Dynamic Proxy: " + method.getName());
                /*
                * Similar to AOP but we can also do some custom code impl on runtime
                * */
                /* we can uncomment below for AOP behaviour
                * */
                //Object result = method.invoke(realObject, args);
                System.out.println("After Java Dynamic Proxy: " + method.getName());

                return  "Vinod Atwal {empId: 123-123-123-1234 }";
            }
        };

        EmployeeRepo proxy = (EmployeeRepo) Proxy.newProxyInstance(
                EmployeeRepo.class.getClassLoader(),
                new Class<?>[]{EmployeeRepo.class},
                handler);
        String dynamicProxyResult = proxy.getEmployee();
        System.out.println("Result from Dynamic Proxy call: " + dynamicProxyResult);

    }
}
