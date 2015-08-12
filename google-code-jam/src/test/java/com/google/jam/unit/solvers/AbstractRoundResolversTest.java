package com.google.jam.unit.solvers;

import java.util.Map;
import java.util.function.Function;

import com.google.jam.Round;
import com.google.jam.RoundResolutionFactory;
import com.google.jam.creators.RoundCreator;
import com.google.jam.RoundPathBuilder;
import com.google.jam.RoundTaskReader;
import com.google.jam.solvers.RoundResolver;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

abstract class AbstractRoundResolversTest {

    protected final RoundResolutionFactory roundResolutionFactory;
    private final Function<String, Integer> algorithm;
    private final String location;
    private final char roundLetter;
    private final String complexity;
    private final String roundType;
    private final TestDataProvider testDataProvider;

    public AbstractRoundResolversTest(
            final RoundResolutionFactory roundResolutionFactory,
            final Function<String, Integer> algorithm,
            final char roundLetter,
            final String location,
            final String complexity,
            final String roundType) {
        this.roundResolutionFactory = roundResolutionFactory;
        this.algorithm = algorithm;
        this.roundLetter = roundLetter;
        this.location = location;
        this.complexity = complexity;
        this.roundType = roundType;
        this.testDataProvider = new TestDataProvider();
    }

    private Round round;

    @Before
    public void setUp()
            throws Exception {
        final RoundCreator creator = roundResolutionFactory.buildRoundCreator();
        final RoundPathBuilder smokeTestPathBuilder = new RoundPathBuilder(
                location,
                roundLetter,
                complexity,
                roundType
        );
        round = new RoundTaskReader(smokeTestPathBuilder.build()).applyCreator(creator);
        setUpResolver();
    }

    protected abstract void setUpResolver();

    @Test
    @Ignore(
            "Need to develop:\n" +
            " * manageable multi-thread queue\n" +
            " * queue which can return element's id after element polling"
    )
    public void testTaskSolvingProcess()
            throws Exception {
        final Map<Integer, Integer> resolverResults = getResolver().solve(round, algorithm);
        final Map<Integer, Integer> testData = testDataProvider.provideSetOfTestData(roundLetter, complexity, roundType);
        assertThat(
                "[" + algorithm.getClass().getSimpleName() + "] {" + getResolver().getClass().getSimpleName() + "} " +
                        String.valueOf(roundLetter) + '-' + complexity + '-' + roundType,
                resolverResults,
                is(testData)
        );
    }

    protected abstract RoundResolver getResolver();
}
