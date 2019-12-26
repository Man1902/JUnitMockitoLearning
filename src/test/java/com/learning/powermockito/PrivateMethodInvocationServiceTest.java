package com.learning.powermockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({PrivateMethodInvocationService.class})

public class PrivateMethodInvocationServiceTest {
    @Spy
    private PrivateMethodInvocationService privateMethodInvocationService = new PrivateMethodInvocationService();

    @Test
    public void testInvokeVoidPrivate() throws Exception {
        PowerMockito.doNothing().when(privateMethodInvocationService, PowerMockito.method(PrivateMethodInvocationService.class, "voidPrivate")).withNoArguments();
        privateMethodInvocationService.invokeVoidPrivate();
        PowerMockito.verifyPrivate(privateMethodInvocationService, Mockito.times(1)).invoke("voidPrivate");
    }

    @Test
    public void testInvokeVoidPrivate_withException() throws Exception {
        PowerMockito.doThrow(new Exception()).when(privateMethodInvocationService, PowerMockito.method(PrivateMethodInvocationService.class, "voidPrivate")).withNoArguments();
        //PowerMockito.when(privateMethodInvocationService, PowerMockito.method(privateMethodInvocationService.class, "voidPrivate")).withNoArguments().thenThrow(new Exception());
        privateMethodInvocationService.invokeVoidPrivate();
        PowerMockito.verifyPrivate(privateMethodInvocationService, Mockito.times(1)).invoke("voidPrivate");
    }

    @Test
    public void testInvokePrivateVoidWithArgs() throws Exception {
        PowerMockito.doNothing().when(privateMethodInvocationService, PowerMockito.method(PrivateMethodInvocationService.class, "voidPrivateWithArgs")).withArguments(Mockito.anyString()); // OR
        //PowerMockito.doNothing().when(privateMethodInvocationService, PowerMockito.method(privateMethodInvocationService.class, "voidPrivateWithArgs",String.class)).withArguments(Mockito.anyString());
        privateMethodInvocationService.invokeVoidPrivateWithArgs("test");
        PowerMockito.verifyPrivate(privateMethodInvocationService, Mockito.times(1)).invoke("voidPrivateWithArgs", Mockito.anyString());
    }

    @Test
    public void testInvokePrivateVoidWithArgs_withException() throws Exception {
        PowerMockito.doThrow(new Exception()).when(privateMethodInvocationService, PowerMockito.method(PrivateMethodInvocationService.class, "voidPrivateWithArgs")).withArguments(Mockito.anyString());
        privateMethodInvocationService.invokeVoidPrivateWithArgs("test");
        PowerMockito.verifyPrivate(privateMethodInvocationService, Mockito.times(1)).invoke("voidPrivateWithArgs", Mockito.anyString());
    }

    @Test
    public void testInvokePrivateMethod() throws Exception {
        PowerMockito.doReturn("test").when(privateMethodInvocationService, PowerMockito.method(PrivateMethodInvocationService.class, "privateMethod")).withNoArguments();
        //PowerMockito.when(privateMethodInvocationService, PowerMockito.method(privateMethodInvocationService.class, "privateMethod")).withNoArguments().thenReturn("test");
        String result = privateMethodInvocationService.invokePrivateMethod();
        PowerMockito.verifyPrivate(privateMethodInvocationService, Mockito.times(1)).invoke("privateMethod");
        Assert.assertEquals("test", result);
    }

    @Test
    public void testInvokePrivateMethod_withException() throws Exception {
        PowerMockito.doThrow(new Exception()).when(privateMethodInvocationService, PowerMockito.method(PrivateMethodInvocationService.class, "privateMethod")).withNoArguments();
        String result = privateMethodInvocationService.invokePrivateMethod();
        PowerMockito.verifyPrivate(privateMethodInvocationService, Mockito.times(1)).invoke("privateMethod");
        Assert.assertNull(result);
    }

    @Test
    public void testInvokePrivateWithArgs() throws Exception {
        PowerMockito.doReturn("test").when(privateMethodInvocationService, PowerMockito.method(PrivateMethodInvocationService.class, "privateWithArgs")).withArguments(Mockito.anyString());
        String result = privateMethodInvocationService.invokePrivateWithArgs("test");
        PowerMockito.verifyPrivate(privateMethodInvocationService, Mockito.times(1)).invoke("privateWithArgs", Mockito.anyString());
        Assert.assertEquals("test", result);
    }

    @Test
    public void testInvokePrivateWithArgs_withException() throws Exception {
        PowerMockito.doThrow(new Exception()).when(privateMethodInvocationService, PowerMockito.method(PrivateMethodInvocationService.class, "privateWithArgs")).withArguments(Mockito.anyString());
        String result = privateMethodInvocationService.invokePrivateWithArgs("test");
        PowerMockito.verifyPrivate(privateMethodInvocationService, Mockito.times(1)).invoke("privateWithArgs", Mockito.anyString());
        Assert.assertNull(result);
    }

    @Test
    public void testInvokeVoidPrivateStatic() throws Exception {
        PowerMockito.spy(PrivateMethodInvocationService.class);
        PowerMockito.doNothing().when(PrivateMethodInvocationService.class, "voidPrivateStatic");
        PrivateMethodInvocationService.invokeVoidPrivateStatic();
        PowerMockito.verifyPrivate(PrivateMethodInvocationService.class, Mockito.times(1)).invoke("voidPrivateStatic");
    }

    @Test
    public void testInvokeVoidPrivateStatic_withException() throws Exception {
        PowerMockito.spy(PrivateMethodInvocationService.class);
        PowerMockito.doThrow(new Exception()).when(PrivateMethodInvocationService.class, "voidPrivateStatic");
        PrivateMethodInvocationService.invokeVoidPrivateStatic();
        PowerMockito.verifyPrivate(PrivateMethodInvocationService.class, Mockito.times(1)).invoke("voidPrivateStatic");
    }

    @Test
    public void testInvokeVoidPrivateStaticWithArgs() throws Exception {
        PowerMockito.spy(PrivateMethodInvocationService.class);
        PowerMockito.doNothing().when(PrivateMethodInvocationService.class, "voidPrivateStaticWithArgs", Mockito.anyString());
        PrivateMethodInvocationService.invokeVoidPrivateStaticWithArgs("test");
        PowerMockito.verifyPrivate(PrivateMethodInvocationService.class, Mockito.times(1)).invoke("voidPrivateStaticWithArgs", Mockito.anyString());
    }

    @Test
    public void testInvokeVoidPrivateStaticWithArgs_withException() throws Exception {
        PowerMockito.spy(PrivateMethodInvocationService.class);
        PowerMockito.doThrow(new Exception()).when(PrivateMethodInvocationService.class, "voidPrivateStaticWithArgs", Mockito.anyString());
        PrivateMethodInvocationService.invokeVoidPrivateStaticWithArgs("test");
        PowerMockito.verifyPrivate(PrivateMethodInvocationService.class, Mockito.times(1)).invoke("voidPrivateStaticWithArgs", Mockito.anyString());
    }

    // 12)
    @Test
    public void testInvokePrivateStatic() throws Exception {
        PowerMockito.spy(PrivateMethodInvocationService.class);
        PowerMockito.when(PrivateMethodInvocationService.class, "privateStatic").thenReturn("test");
        String result = PrivateMethodInvocationService.invokePrivateStatic();
        PowerMockito.verifyPrivate(PrivateMethodInvocationService.class, Mockito.times(1)).invoke("privateStatic");
        Assert.assertEquals("test", result);
    }

    @Test
    public void testInvokePrivateStatic_withException() throws Exception {
        PowerMockito.spy(PrivateMethodInvocationService.class);
        PowerMockito.when(PrivateMethodInvocationService.class, "privateStatic").thenThrow(new Exception());
        //PowerMockito.doThrow(new Exception()).when(privateMethodInvocationService.class, "privateStatic");
        String result = PrivateMethodInvocationService.invokePrivateStatic();
        PowerMockito.verifyPrivate(PrivateMethodInvocationService.class, Mockito.times(1)).invoke("privateStatic");
        Assert.assertNull(result);
    }

    // 13)
    @Test
    public void testInvokePrivateStaticWithArgs() throws Exception {
        PowerMockito.spy(PrivateMethodInvocationService.class);
        PowerMockito.when(PrivateMethodInvocationService.class, "privateStaticWithArgs", Mockito.anyString()).thenReturn("test");
        String result = PrivateMethodInvocationService.invokePrivateStaticWithArgs("test");
        PowerMockito.verifyPrivate(PrivateMethodInvocationService.class, Mockito.times(1)).invoke("privateStaticWithArgs", Mockito.anyString());
        Assert.assertEquals("test", result);
    }

    @Test
    public void testInvokePrivateStaticWithArgs_withException() throws Exception {
        PowerMockito.spy(PrivateMethodInvocationService.class);
        PowerMockito.when(PrivateMethodInvocationService.class, "privateStaticWithArgs", Mockito.anyString()).thenThrow(new Exception());
        String result = PrivateMethodInvocationService.invokePrivateStaticWithArgs("test");
        PowerMockito.verifyPrivate(PrivateMethodInvocationService.class, Mockito.times(1)).invoke("privateStaticWithArgs", Mockito.anyString());
        Assert.assertNull(result);
    }
}
