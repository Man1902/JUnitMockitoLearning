package com.learning.junitmockito;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

public class ListInterfaceMockTest {

    @Test
    public void letsMockListSize() {
        List list = mock(List.class);
        Mockito.when(list.size()).thenReturn(10);
        assertEquals(10, list.size());
    }

    // BDD - Behavior-driven development
    @Test
    public void letsMockListSize_usingBDD() {
        // given - setup
        List list = mock(List.class);
        BDDMockito.given(list.size()).willReturn(10);

        // when - actual method call
        int output = list.size();

        // then - asserts
        Assert.assertThat(10, CoreMatchers.is(output));
    }

    @Test
    public void letsMockListSizeWithMultipleReturnValues() {
        List list = mock(List.class);
        Mockito.when(list.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, list.size()); // First Call
        assertEquals(20, list.size()); // Second Call
    }

    @Test
    public void letsMockListGet() {
        List<String> list = mock(List.class);
        Mockito.when(list.get(0)).thenReturn("firstVal");
        assertEquals("firstVal", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    public void letsMockListGetWithAny() {
        List<String> list = mock(List.class);
        Mockito.when(list.get(Mockito.anyInt())).thenReturn("val");
        assertEquals("val", list.get(0));
        assertEquals("val", list.get(1));
    }

    @Test
    public void letsMockListGetWithAny_UsingBDD() {
        // given
        List<String> list = mock(List.class);
        BDDMockito.given(list.get(Mockito.anyInt())).willReturn("val");
        // when
        String output = list.get(0);
        // then
        Assert.assertThat("val", CoreMatchers.is(output));
    }

    @Test(expected = RuntimeException.class)
    public void letsMockListThrowAnException() {
        List<String> list = mock(List.class);
        Mockito.when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException("Exception occured"));
        list.get(0);
    }

}