package com;

import javax.naming.*;

import java.io.File;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws NamingException {
        String name = "D:\\prog\\javalessons\\rmi\\JL223JNDI\\JavaBooks.txt";
        // String name="D:\\prog\\javalessons\\rmi\\JL223JNDI\\src\\com";
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        properties.put(Context.PROVIDER_URL, "file:/");

        Context initialContext = new InitialContext(properties);
        File obj = (File) initialContext.lookup(name);
        System.out.println(obj.getName());
        if (name.equals("")) {
            System.out.println("Looked up the initial context");
        } else {
            System.out.println(name + " is bound to: " + obj);
        }
        System.out.println("######################################");
        NamingEnumeration list = initialContext.list("d:/");
        while (list.hasMore()) {
            NameClassPair nc = (NameClassPair) list.next();
            System.out.println(nc);
        }
        System.out.println("######################################");
        NamingEnumeration bindings = initialContext.listBindings("d:/");

        while(bindings.hasMore()){
            Binding bd=(Binding)bindings.next();
            System.out.println(bd.getName()+" : "+bd.getObject());
        }
    }
}












































