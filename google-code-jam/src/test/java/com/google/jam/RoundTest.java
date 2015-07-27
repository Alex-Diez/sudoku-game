package com.google.jam;

import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class RoundTest {

	private Round small;

	@Before
	public void setUp()
			throws Exception {
		final RoundPathBuilder pathBuilder = new RoundPathBuilder("test", 'A', "small", "test");
		small = new Round(pathBuilder.build());
	}

	@Test(expected = IOException.class)
	public void testCreateWrongRound_shouldThrowException()
			throws Exception {
		final RoundPathBuilder pathBuilder = new RoundPathBuilder("test", 'A', "huge", "test");
		new Round(pathBuilder.build());
	}

	@Test
	public void testValidateTaskLine()
			throws Exception {
		final String task = small.getNextTask();
		assertThat(task, is(notNullValue()));
	}
}
