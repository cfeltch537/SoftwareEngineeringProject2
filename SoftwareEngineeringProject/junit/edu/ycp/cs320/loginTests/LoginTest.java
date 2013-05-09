package edu.ycp.cs320.loginTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;

public class LoginTest {
	private Login testA;
	private Login testB;

	@Before
	public void setUp()	{
		testA = new Login();
		testB = new Login();
	}

	@Test
	public void testGetSetUsername()	{
		testA.setUsername("dhill3");
		assertEquals("dhill3", testA.getUsername());
		testB.setUsername("cfeltch537");
		assertEquals("cfeltch537", testB.getUsername());
	}

	@Test
	public void testGetSetId()	{
		testA.setId(22);
		testB.setId(69);
		assertEquals(22, testA.getId());
		assertEquals(69, testB.getId());
	}

	@Test
	public void testGetSetPassword()	{
		testA.setPassword("password");
		testB.setPassword("incorrect");
		assertEquals("password", testA.getPassword());
		assertEquals("incorrect", testB.getPassword());
	}

	@Test
	public void testGetSetRole()	{
		testA.setRole("admin");
		testB.setRole("derrikes subordinate");
		assertEquals("admin", testA.getRole());
		assertEquals("derrikes subordinate", testB.getRole());
	}

}
