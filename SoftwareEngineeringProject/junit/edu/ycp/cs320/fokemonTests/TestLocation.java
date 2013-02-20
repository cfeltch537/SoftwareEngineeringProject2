package edu.ycp.cs320.fokemonTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.fokemon.Location;

public class TestLocation {
	private Location pos1;
	private Location pos2;
	private Location pos3;
	
	@Before
	public void setUp() throws Exception {
		pos1 = new Location(5, 8, 10);
		pos2 = new Location(4, 17, 2);
		pos3 = new Location(9, 410, 67);
	}
	
	@Test
	public void testGetX() throws Exception {
		assertEquals(8, pos1.GetX());
		assertEquals(17, pos2.GetX());
		assertEquals(410, pos3.GetX());
	}
	
	@Test
	public void testGetY() throws Exception {
		assertEquals(10, pos1.GetY());
		assertEquals(2, pos2.GetY());
		assertEquals(67, pos3.GetY());
	}
	
	@Test
	public void testGetAreaArrayIndex() throws Exception {
		assertEquals(5, pos1.GetAreaArrayIndex());
		assertEquals(4, pos2.GetAreaArrayIndex());
		assertEquals(9, pos3.GetAreaArrayIndex());
	}
	
	@Test
	public void testSetX() throws Exception {
		pos1.SetX(11);
		assertEquals(11, pos1.GetX());
		pos2.SetX(22);
		assertEquals(22, pos2.GetX());
	}
	
	@Test
	public void testSetY() throws Exception {
		pos1.SetY(88);
		assertEquals(88, pos1.GetY());
		pos2.SetY(64);
		assertEquals(64, pos2.GetY());
	}
	
	@Test
	public void testSetAreaArrayIndex() throws Exception {
		pos1.SetAreaArrayIndex(115);
		assertEquals(115, pos1.GetAreaArrayIndex());
		pos2.SetAreaArrayIndex(48361);
		assertEquals(48361, pos2.GetAreaArrayIndex());
	}
}
