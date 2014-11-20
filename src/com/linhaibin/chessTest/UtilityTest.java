package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.Utility;

public class UtilityTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		int i = Utility.getOneDimention(0, 0);
//		Utility.debug(i);
		assertEquals(i, 0);
	}

	@Test
	public void test2() {
		int i = Utility.getOneDimention(1, 0);
//		Utility.debug(i);
		assertEquals(i, 1);
	}

	@Test
	public void test3() {
		int i = Utility.getOneDimention(2, 1);
		assertEquals(i, 11);
	}

}
