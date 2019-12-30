package com.learning.powermockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RunWith(PowerMockRunner.class)
@PrepareForTest({StaticMethodUtil.class, Files.class})

public class StaticMethodInvocationServiceTest {
    @Spy
    @InjectMocks
    private StaticMethodInvocationService staticMethodInvocationService = new StaticMethodInvocationService();

    // 1) test void static method invocation
    @Test
    public void testInvokeVoidStatic() throws Exception {
        PowerMockito.mockStatic(StaticMethodUtil.class);
        PowerMockito.doNothing().when(StaticMethodUtil.class, "voidStatic");
        staticMethodInvocationService.invokeVoidStatic();
        PowerMockito.verifyStatic();
    }

    @Test(expected = Exception.class)
    public void testInvokeVoidStatic_withException() throws Exception {
        PowerMockito.mockStatic(StaticMethodUtil.class);
        PowerMockito.doThrow(new Exception()).when(StaticMethodUtil.class, "voidStatic"); // OR
        // PowerMockito.when(StaticUtil.class, "voidStatic").thenThrow(new Exception());
        staticMethodInvocationService.invokeVoidStatic();
        PowerMockito.verifyStatic();
    }

    // 2) test void static method with input args invocation
    @Test
    public void testInvokeVoidStaticWithArgs() throws Exception {
        PowerMockito.mockStatic(StaticMethodUtil.class);
        PowerMockito.doNothing().when(StaticMethodUtil.class, "voidStaticWithArgs", Mockito.anyString());
        staticMethodInvocationService.invokeVoidStaticWithArgs("test");
        PowerMockito.verifyStatic();
    }

    @Test
    public void testInvokeVoidStaticWithArgs_withException() throws Exception {
        PowerMockito.mockStatic(StaticMethodUtil.class);
        PowerMockito.doThrow(new Exception()).when(StaticMethodUtil.class, "voidStaticWithArgs", Mockito.anyString()); // OR
        // PowerMockito.when(StaticUtil.class, "voidStaticWithArgs",
        // Mockito.anyString()).thenThrow(new Exception());
        staticMethodInvocationService.invokeVoidStaticWithArgs("test");
        PowerMockito.verifyStatic();
    }

    // 3) test static method with return invocation
    @Test
    public void testInvokeStaticMethod() throws Exception {
        PowerMockito.mockStatic(StaticMethodUtil.class);
        PowerMockito.when(StaticMethodUtil.staticMethod()).thenReturn("test");
        String result = staticMethodInvocationService.invokeStaticMethod();
        PowerMockito.verifyStatic();
        Assert.assertEquals("test", result);
    }

    @Test
    public void testInvokeStaticMethod_withException() throws Exception {
        PowerMockito.mockStatic(StaticMethodUtil.class);
        PowerMockito.when(StaticMethodUtil.staticMethod()).thenThrow(new Exception());
        String result = staticMethodInvocationService.invokeStaticMethod();
        PowerMockito.verifyStatic();
        Assert.assertNull(result);
    }

    // 4) test static method with return and input args invocation
    @Test
    public void testInvokeStaticWithArg() throws Exception {
        PowerMockito.mockStatic(StaticMethodUtil.class);
        PowerMockito.when(StaticMethodUtil.staticWithArg(Mockito.anyString())).thenReturn("test");
        String result = staticMethodInvocationService.invokeStaticWithArg("test");
        PowerMockito.verifyStatic();
        Assert.assertEquals("test", result);
    }

    @Test
    public void testInvokeStaticWithArg_withException() throws Exception {
        PowerMockito.mockStatic(StaticMethodUtil.class);
        PowerMockito.when(StaticMethodUtil.staticWithArg(Mockito.anyString())).thenThrow(new Exception());
        String result = staticMethodInvocationService.invokeStaticWithArg("test");
        PowerMockito.verifyStatic();
        Assert.assertNull(result);
    }

    @Test(expected = CustomFilesException.class)
    public void testInvokeFilesClassStatic_withException() throws Exception {
        PowerMockito.mockStatic(Files.class);
        PowerMockito.when(Files.createDirectory(Mockito.any())).thenThrow(new IOException());
        Path result = staticMethodInvocationService.invokeFilesClassStatic("temp");
        PowerMockito.verifyStatic();
        //Assert.assertNull(result);
    }
}
