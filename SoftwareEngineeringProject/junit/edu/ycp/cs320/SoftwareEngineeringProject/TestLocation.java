package edu.ycp.cs320.SoftwareEngineeringProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import PlayerClasses.Location;

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
	public void testgetX() throws Exception {
		assertEquals(8, pos1.getX());
		assertEquals(17, pos2.getX());
		assertEquals(410, pos3.getX());
	}
	
	@Test
	public void testgetY() throws Exception {
		assertEquals(10, pos1.getY());
		assertEquals(2, pos2.getY());
		assertEquals(67, pos3.getY());
	}
	
	@Test
	public void testgetAreaArrayIndex() throws Exception {
		assertEquals(5, pos1.getAreaArrayIndex());
		assertEquals(4, pos2.getAreaArrayIndex());
		assertEquals(9, pos3.getAreaArrayIndex());
	}
	
	@Test
	public void testsetX() throws Exception {
		pos1.setX(11);
		assertEquals(11, pos1.getX());
		pos2.setX(22);
		assertEquals(22, pos2.getX());
	}
	
	@Test
	public void testsetY() throws Exception {
		pos1.setY(88);
		assertEquals(88, pos1.getY());
		pos2.setY(64);
		assertEquals(64, pos2.getY());
	}
	
	@Test
	public void testsetAreaArrayIndex() throws Exception {
		pos1.setAreaArrayIndex(115);
		assertEquals(115, pos1.getAreaArrayIndex());
		pos2.setAreaArrayIndex(48361);
		assertEquals(48361, pos2.getAreaArrayIndex());
	}
}
