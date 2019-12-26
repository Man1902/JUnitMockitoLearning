package com.learning.powermockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FinalMethodUtil.class})

public class FinalMethodInvocationServiceTest {
    @Mock
    private FinalMethodUtil finalMethodUtil;

    @Spy
    @InjectMocks
    private FinalMethodInvocationService finalMethodInvocationService = new FinalMethodInvocationService();

    // 1) test void final method invocation
    @Test
    public void testInvokeVoidFinal() throws Exception {
        Mockito.doNothing().when(finalMethodUtil).voidFinal();
        finalMethodInvocationService.invokeVoidFinal();
        Mockito.verify(finalMethodUtil, Mockito.times(1)).voidFinal();
    }

    @Test(expected = Exception.class)
    public void testInvokeVoidFinal_withException() throws Exception {
        Mockito.doThrow(new Exception()).when(finalMethodUtil).voidFinal();
        finalMethodInvocationService.invokeVoidFinal();
        Mockito.verify(finalMethodUtil, Mockito.times(1)).voidFinal();
    }

    // 2) test void final method with input args invocation
    @Test
    public void testInvokeVoidFinalWithArgs() throws Exception {
        Mockito.doNothing().when(finalMethodUtil).voidFinalWithArgs(Mockito.anyString());
        finalMethodInvocationService.invokeVoidFinalWithArgs("test");
        Mockito.verify(finalMethodUtil, Mockito.times(1)).voidFinalWithArgs(Mockito.anyString());
    }

    @Test
    public void testInvokeVoidFinalWithArgs_withException() throws Exception {
        Mockito.doThrow(new Exception()).when(finalMethodUtil).voidFinalWithArgs(Mockito.anyString());
        finalMethodInvocationService.invokeVoidFinalWithArgs("test");
        Mockito.verify(finalMethodUtil, Mockito.times(1)).voidFinalWithArgs(Mockito.anyString());
    }

    // 3) test final method with return invocation
    @Test
    public void testInvokeFinalMethod() throws Exception {
        Mockito.when(finalMethodUtil.finalMethod()).thenReturn("test");
        String result = finalMethodInvocationService.invokeFinalMethod();
        Mockito.verify(finalMethodUtil, Mockito.times(1)).finalMethod();
        Assert.assertEquals("test", result);
    }

    @Test
    public void testInvokeFinalMethod_withException() throws Exception {
        Mockito.doThrow(new Exception()).when(finalMethodUtil).finalMethod();
        String result = finalMethodInvocationService.invokeFinalMethod();
        Mockito.verify(finalMethodUtil, Mockito.times(1)).finalMethod();
        Assert.assertNull(result);
    }

    // 4) test final method with return and input args invocation
    @Test
    public void testInvokeFinalWithArgs() throws Exception {
        Mockito.when(finalMethodUtil.finalWithArgs(Mockito.anyString())).thenReturn("test");
        String result = finalMethodInvocationService.invokeFinalWithArgs("test");
        Mockito.verify(finalMethodUtil, Mockito.times(1)).finalWithArgs(Mockito.anyString());
        Assert.assertEquals("test", result);
    }

    @Test
    public void testInvokeFinalWithArgs_withException() throws Exception {
        Mockito.doThrow(new Exception()).when(finalMethodUtil).finalWithArgs(Mockito.anyString());
        String result = finalMethodInvocationService.invokeFinalWithArgs("test");
        Mockito.verify(finalMethodUtil, Mockito.times(1)).finalWithArgs(Mockito.anyString());
        Assert.assertNull(result);
    }
}
