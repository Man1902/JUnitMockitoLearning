package com.learning.powermockito;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrivateMethodInvocationService {
    // 1)
    public void invokeVoidPrivate() {
        try {
            this.voidPrivate();
        } catch (Exception e) {
            System.out.println("Error in invokeVoidPrivate." + e.getMessage());
        }
    }
    private void voidPrivate() throws  Exception {
        System.out.println("voidPrivate");
    }

    // 2)
    public void invokeVoidPrivateWithArgs(String msg) {
        try {
            this.voidPrivateWithArgs(msg);
        } catch (Exception e) {
            System.out.println("Error in invokeVoidPrivate." + e.getMessage());
        }
    }
    private void voidPrivateWithArgs(String msg) throws  Exception {
        System.out.println("voidPrivateWithArgs.msg : " + msg);
    }

    // 3)
    public String invokePrivateMethod() {
        try {
            return this.privateMethod();
        } catch (Exception e) {
            System.out.println("Error in invokeVoidPrivate." + e.getMessage());
        }
        return null;
    }
    private String privateMethod() throws  Exception{
        return "privateMethod";
    }

    // 4)
    public String invokePrivateWithArgs(String msg) {
        try {
            return this.privateWithArgs(msg);
        } catch (Exception e) {
            System.out.println("Error in invokePrivateWithArgs." + e.getMessage());
        }
        return null;
    }
    private String privateWithArgs(String msg) throws  Exception{
        return "privateMethod.msg : "+msg;
    }

    // 5)
    public static void invokeVoidPrivateStatic(){
        try {
            voidPrivateStatic();
        } catch (Exception e) {
            System.out.println("Error in invokeVoidPrivateStatic." + e.getMessage());
        }
    }
    private static void voidPrivateStatic() throws Exception{
        System.out.println("voidPrivateStatic");
    }

    // 6)
    public static void invokeVoidPrivateStaticWithArgs(String msg){
        try {
            voidPrivateStaticWithArgs(msg);
        } catch (Exception e) {
            System.out.println("Error in invokeVoidPrivateStaticWithArgs." + e.getMessage());
        }
    }
    private static void voidPrivateStaticWithArgs(String msg) throws Exception{
        System.out.println("voidPrivateStaticWithArgs.msg : "+msg);
    }

    // 7)
    public static String invokePrivateStatic(){
        try {
           return  privateStatic();
        } catch (Exception e) {
            System.out.println("Error in invokePrivateStatic." + e.getMessage());
        }
        return  null;
    }
    private static String privateStatic() throws Exception{
        return "privateStatic";
    }

    // 8)
    public static String invokePrivateStaticWithArgs(String msg){
        try {
            return  privateStaticWithArgs(msg);
        } catch (Exception e) {
            System.out.println("Error in invokePrivateStaticWithArgs." + e.getMessage());
        }
        return  null;
    }
    private static String privateStaticWithArgs(String msg) throws Exception{
        return "privateStatic.msg : "+msg;
    }
}
