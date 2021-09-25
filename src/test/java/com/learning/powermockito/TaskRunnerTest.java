package com.learning.powermockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Method;

@RunWith(MockitoJUnitRunner.class)
public class TaskRunnerTest {
    @Mock
    private TaskScheduler taskScheduler;

    Method method;

    @Spy
   @InjectMocks
    private TaskRunner taskRunner;

   @Before
   public  void init() throws NoSuchMethodException {
   }

    @Test
    public void testRun() throws Exception {
        method = taskScheduler.getClass().getMethod("m1");
        taskRunner = new TaskRunner(method,taskScheduler,null);
        taskRunner.run();
    }
}
