package com.learning.junitmockito;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class HamcrestMatcherTest {

    @Test
    public void basicHamcrestMatchers() {
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);
        MatcherAssert.assertThat(scores, Matchers.hasSize(4));
        MatcherAssert.assertThat(scores, Matchers.hasItems(100, 101));
        MatcherAssert.assertThat(scores, Matchers.everyItem(Matchers.greaterThan(90)));
        MatcherAssert.assertThat(scores, Matchers.everyItem(Matchers.lessThan(200)));

        // String
        MatcherAssert.assertThat("", Matchers.isEmptyString());
        MatcherAssert.assertThat(null, Matchers.isEmptyOrNullString());

        // Array
        Integer[] marks = {1, 2, 3};
        MatcherAssert.assertThat(marks, Matchers.arrayWithSize(3));
		MatcherAssert.assertThat(marks, Matchers.arrayContaining(1,2,3));
        MatcherAssert.assertThat(marks, Matchers.arrayContainingInAnyOrder(2, 3, 1));
    }
}