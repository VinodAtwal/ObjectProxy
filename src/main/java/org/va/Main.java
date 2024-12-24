package org.va;

import org.va.proxy.CglibProxy;
import org.va.proxy.DynamicProxy;

public class Main {
    public static void main(String[] args) {

        String proxyType = null;
        if(args.length>0){
            proxyType = args[0];
        }
        if("dynamic-proxy".equalsIgnoreCase(proxyType)) new DynamicProxy().run();
        else if("cglib-proxy".equalsIgnoreCase(proxyType)) new CglibProxy().run();
        else System.out.println("Invalid argument");

    }
}