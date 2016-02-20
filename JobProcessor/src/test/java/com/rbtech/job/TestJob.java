package com.rbtech.job;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestJob {

	// CTRl Shift O - look at path for imports Organised imports
	// CTRL SHift F - Format
	// ALT SHift X
	// CTRL Space

	@Test
	public void testGetJob() {

		System.out.println("Testing Job");

	}

	@Test
	public void testAgain() {

		System.out.println("Testing Again");

	}

	@Before
	public void testBefore() {

		System.out.println("Testing Before");

	}

	@After
	public void testAfter() {

		System.out.println("Testing After");

	}

	@BeforeClass
	public static void testBeforeClass() {

		System.out.println("Testing Before CLASS");

	}

	@AfterClass
	public static void testAfterClass() {

		System.out.println("Testing After CLASS");

	}

}
