package com.google.jam.unit.creators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.google.jam.Round;
import com.google.jam.RoundCreator;
import com.google.jam.WrongRoundFormatException;
import com.google.jam.creators.InfiniteHouseOfPancakesRoundCreator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static com.jcabi.matchers.RegexMatchers.matchesPattern;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class InputInfiniteHouseOfPancakesRoundTest {

    private final String queueLength;
    private RoundCreator creator;

    public InputInfiniteHouseOfPancakesRoundTest(String queueLength) {
        this.queueLength = queueLength;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new String[][] {{"g"}, {""}, {"-4"}, {"1"}, {"100"}});
    }

    @Before
    public void setUp()
            throws Exception {
        creator = new InfiniteHouseOfPancakesRoundCreator();
    }

    @Test(expected = WrongRoundFormatException.class)
    public void testWrongInputInfiniteHouseOfPancakesRoundFormat_shouldThrowException()
            throws Exception {
        creator.createRound(
                new ArrayList<>(
                        Arrays.asList(
                                queueLength,
                                "1",
                                "3",
                                "4",
                                "1 2 1 2",
                                "1",
                                "4",
                                "5",
                                "4 8 7 8 3"
                        )
                )
        );
    }

    @Test
    public void testInputInfiniteHouseOfPancakesRoundFormat()
            throws Exception {
        final Round round = creator.createRound(
                new ArrayList<>(
                        Arrays.asList(
                                "4",
                                "1",
                                "3",
                                "4",
                                "1 2 1 2",
                                "1",
                                "4",
                                "5",
                                "4 8 7 8 3"
                        )
                )
        );
        String task = round.getNextTask().getValue();
        assertThat(task, matchesPattern("^([0-9]*)( [0-9]*)$"));
    }
}
