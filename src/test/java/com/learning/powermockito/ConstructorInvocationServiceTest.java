package com.learning.powermockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ConstructorInvocationService.class})   /*To be able to mock the Constructor, we need to add in the Class that creates the new object*/

public class ConstructorInvocationServiceTest {
    @InjectMocks
    private ConstructorInvocationService constructorInvocationService;

    @Test(expected = CustomException.class)
    public void testInvokeCustomExceptionConstructor() throws Exception {
        CustomException mockCustomException = Mockito.mock(CustomException.class);
        PowerMockito.whenNew(CustomException.class).withAnyArguments().thenReturn(mockCustomException); // OR
        //PowerMockito.whenNew(CustomException.class).withArguments(Mockito.anyString()).thenReturn(mockCustomException); // OR
        //PowerMockito.whenNew(CustomException.class).withParameterTypes(String.class).withArguments(Mockito.anyString()).thenReturn(mockCustomException);
        constructorInvocationService.invokeCustomExceptionConstructor();
    }

    @Test
    public void testInvokeArrayListConstructor() throws Exception {
        ArrayList<String> mockList = Mockito.mock(ArrayList.class);
        PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
        Mockito.when(mockList.size()).thenReturn(1);
        int size = constructorInvocationService.invokeArrayListConstructor();
        Assert.assertEquals(1, size);
    }
}
