package com.learning.powermockito;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StaticMethodInvocationService {

    // 1)
    public void invokeVoidStatic() throws Exception {
        try {
            StaticMethodUtil.voidStatic();
        } catch (Exception e) {
            System.out.println("Error in invokeVoidStatic." + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    // 2)
    public void invokeVoidStaticWithArgs(String msg) throws Exception {
        try {
            StaticMethodUtil.voidStaticWithArgs(msg);
        } catch (Exception e) {
            System.out.println("Error in invokeVoidStaticWithArgs." + e.getMessage());
        }
    }

    // 3)
    public String invokeStaticMethod() {
        try {
            return StaticMethodUtil.staticMethod();
        } catch (Exception e) {
            System.out.println("Error in invokeStaticMethod." + e.getMessage());
        }
        return null;
    }

    // 4)
    public String invokeStaticWithArg(String msg) {
        try {
            return StaticMethodUtil.staticWithArg(msg);
        } catch (Exception e) {
            System.out.println("Error in invokeStaticWithArg." + e.getMessage());
        }
        return null;
    }

    // 5)
    public Path invokeFilesClassStatic(String directory) throws CustomFilesException {
        try {
            return Files.createDirectory(Paths.get(directory));
        } catch (IOException e) {
            System.out.println("Error in invokeFilesClassStatic." + e.getMessage());
            throw new CustomFilesException(e.getMessage());
        }
    }
}
