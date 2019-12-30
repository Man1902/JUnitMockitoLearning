package com.learning.powermockito;

import java.util.ArrayList;
import java.util.List;

public class ConstructorInvocationService {
    public void invokeCustomExceptionConstructor() throws CustomException {
        throw new CustomException("Error Occurred");
    }

    public int invokeArrayListConstructor() {
        List<String> list = new ArrayList<>();
        return list.size();
    }


}
