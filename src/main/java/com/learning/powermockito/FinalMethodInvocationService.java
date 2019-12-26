package com.learning.powermockito;

public class FinalMethodInvocationService {
    private FinalMethodUtil finalMethodUtil;

    public FinalMethodInvocationService() {
    }

    public FinalMethodInvocationService(FinalMethodUtil finalMethodUtil) {
        this.finalMethodUtil = finalMethodUtil;
    }

    // 1)
    public final void invokeVoidFinal() throws Exception {
        try {
            finalMethodUtil.voidFinal();
        }catch (Exception e){
            System.out.println("Error in invokeVoidFinal." + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    // 2)
    public final void invokeVoidFinalWithArgs(String msg) throws Exception {
        try {
            finalMethodUtil.voidFinalWithArgs(msg);
        }catch (Exception e){
            System.out.println("Error in invokeVoidFinalWithArgs." + e.getMessage());
        }
    }

    // 3)
    public final String invokeFinalMethod() throws Exception {
        try {
            return finalMethodUtil.finalMethod();
        }catch (Exception e){
            System.out.println("Error in invokeFinalMethod." + e.getMessage());
        }
        return null;
    }

    // 4)
    public final String invokeFinalWithArgs(String msg) throws Exception {
        try {
            return finalMethodUtil.finalWithArgs(msg);
        }catch (Exception e){
            System.out.println("Error in invokeFinalWithArgs." + e.getMessage());
        }
        return null;
    }

    public final String finalMethodCall(String message) {
        return message;
    }
}
