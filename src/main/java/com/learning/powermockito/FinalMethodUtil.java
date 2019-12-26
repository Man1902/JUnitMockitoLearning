package com.learning.powermockito;

public class FinalMethodUtil {
    public final void voidFinal() throws Exception {
        System.out.println("voidFinal");
    }

    public final void voidFinalWithArgs(String msg) throws Exception {
        System.out.println("voidFinalWithArgs.msg : " + msg);
    }

    public final String finalMethod() throws Exception {
        return "finalMethod";
    }

    public final String finalWithArgs(String msg) throws Exception {
        return "finalWithArgs.msg : " + msg;
    }
}
