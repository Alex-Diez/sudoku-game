package com.google.jam.unit.solvers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Supplier;

import com.google.jam.solvers.RoundResolver;
import com.google.jam.solvers.SingleThreadRoundResolver;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SingleThreadRoundResolversTest
        extends AbstractRoundResolversTest {

    @Parameters
    public static Collection<Object[]> dataSubClass() {
        return new DataProvider().provide(
                new AlgorithmSupplier(),
                new RoundLetterSupplier(),
                new TestDataLocationSupplier()
        );
    }

    private RoundResolver resolver;

    public SingleThreadRoundResolversTest(
            Function<String, Integer> algorithm,
            char roundLetter,
            String smokeTestLocation,
            String smokeTestComplexity,
            String smokeTestRoundType,
            String smallLocation,
            String smallComplexity,
            String smallRoundType,
            String largeLocation,
            String largeComplexity,
            String largeRoundType) {
        super(
                algorithm,
                roundLetter,
                smokeTestLocation,
                smokeTestComplexity,
                smokeTestRoundType,
                smallLocation,
                smallComplexity,
                smallRoundType,
                largeLocation,
                largeComplexity,
                largeRoundType
        );
    }

    @Override
    @Before
    public void setUp()
            throws Exception {
        super.setUp();
        resolver = new SingleThreadRoundResolver();
    }

    @Override
    protected RoundResolver getResolver() {
        return resolver;
    }

    private static class DataProvider {

        public Collection<Object[]> provide(
                final Supplier<Iterator<Function<String, Integer>>> algorithmSupplier,
                final Supplier<Iterator<Character>> roundLetterSupplier,
                final Supplier<Iterator<String[]>> testDataLocationSupplier) {
            Collection<Object[]> collection = new ArrayList<>();
            Iterator<Function<String, Integer>> algorithmIterator = algorithmSupplier.get();
            while (algorithmIterator.hasNext()) {
                Function<String, Integer> algorithm = algorithmIterator.next();
                Iterator<Character> roundLetterIterator = roundLetterSupplier.get();
                while (roundLetterIterator.hasNext()) {
                    Character roundLetter = roundLetterIterator.next();
                    Iterator<String[]> testDataLocationIterator = testDataLocationSupplier.get();
                    while (testDataLocationIterator.hasNext()) {
                        String[] testDataLocation = testDataLocationIterator.next();
                        collection.add(
                                new Object[] {
                                        algorithm,
                                        roundLetter,
                                        testDataLocation[0],
                                        testDataLocation[1],
                                        testDataLocation[2],
                                        testDataLocation[3],
                                        testDataLocation[4],
                                        testDataLocation[5],
                                        testDataLocation[6],
                                        testDataLocation[7],
                                        testDataLocation[8]
                                }
                        );
                    }
                }
            }
            return collection;
        }
    }
}