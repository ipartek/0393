package com.ipartek.formacion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class YoutubeTest {
	
	Youtube youtube; 
	static final String TITULO = "Surf Search Spot 2 0 video promo";
	static final String CODIGO = "LPDhuthFD98";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		youtube = new Youtube(TITULO, CODIGO);
		
	}

	@After
	public void tearDown() throws Exception {
		youtube = null;
	}

	@Test
	public void testYoutube() {
		
		assertEquals( CODIGO, youtube.getCodigo() );
		assertEquals( TITULO, youtube.getTitulo() );
		assertEquals( 0, youtube.getReproducciones() );
		
		
		try {
			youtube = new Youtube( null , null);
			fail("Constructo con NULLS");
			
		} catch (Exception e) {
			assertTrue(true);
		}
		
		try {
			youtube = new Youtube( TITULO , "11" );
			fail("Codigo <> 11");
			
		} catch (Exception e) {
			assertTrue(true);
		}
		
		try {
			youtube = new Youtube( " " , CODIGO	);
			fail("Titulo incorrecto");
			
		} catch (Exception e) {
			assertTrue(true);
		}
		
	}

	@Test
	public void testGetTitulo() {
		
		assertEquals(TITULO, youtube.getTitulo() );
		
	}

	@Test
	public void testSetTitulo() throws Exception {

		//TODO probar los 5 casos
		youtube.setTitulo("");
		
	}

	@Test
	public void testGetCodigo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCodigo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetReproducciones() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetReproducciones() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUrl() {
		fail("Not yet implemented");
	}

}
