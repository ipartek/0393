package ciclo.superior.desarrollo.web.ibaiondo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TrenTest {
	
	Tren tren;
	static final String TIPO = "Locomotora";
	static final String REFERENCIA = "LOC-123";
	static final int ASIENTOS_OCUPADOS = 5;
	static final int ANYOS = 3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tren = new Tren(TIPO, REFERENCIA , ASIENTOS_OCUPADOS, ANYOS);
	}

	@After
	public void tearDown() throws Exception {
		tren = null;
	}

	@Test
	public void testTren() {

		assertEquals( TIPO , tren.getTipo() );
		assertEquals( REFERENCIA, tren.getReferencia() );
		assertEquals( ASIENTOS_OCUPADOS, tren.getAsientosOcupados() );
		assertEquals( ANYOS, tren.getAnyosActivo() );
		
		Tren tNull = new Tren( null, null, -5, 0);
		assertEquals( null , tNull.getTipo() );
		assertEquals( null, tNull.getReferencia() );
		assertEquals( -5, tNull.getAsientosOcupados() );
		assertEquals( 0, tNull.getAnyosActivo() );
		
	}

	@Test
	public void testGetTipo() {

		assertEquals(TIPO, tren.getTipo() );
		
	}

	@Test
	public void testSetTipo() {
		
		tren.setTipo("algo");
		assertEquals("algo", tren.getTipo() );
		
		tren.setTipo(null);
		assertEquals(null, tren.getTipo() );
		
	}

	@Test
	public void testGetReferencia() {
		
		assertEquals( REFERENCIA, tren.getReferencia() );
	}

	@Test
	public void testSetReferencia() {
		
		tren.setReferencia("algo");
		assertEquals( "algo", tren.getReferencia() );
		
		tren.setReferencia(null);
		assertEquals( null, tren.getReferencia() );
		
	}

	@Test
	public void testGetAsientosOcupados() {

		assertEquals( ASIENTOS_OCUPADOS, tren.getAsientosOcupados() );
		
	}

	@Test
	public void testSetAsientosOcupados() {

			tren.setAsientosOcupados(-1);
			assertEquals( -1, tren.getAsientosOcupados() );
			
			
			tren.setAsientosOcupados( (Tren.CAPACIDAD_MAXIMA+1) );
			assertEquals( Tren.CAPACIDAD_MAXIMA+1 , tren.getAsientosOcupados() );
			
	}

	@Test
	public void testGetAnyosActivo() {

		assertEquals(ANYOS, tren.getAnyosActivo());
		
	}

	@Test
	public void testSetAnyosActivo() {

		tren.setAnyosActivo(-1);
		assertEquals( -1 , tren.getAnyosActivo());
		
		tren.setAnyosActivo( (Tren.EDAD_MAXIMA+1) );
		assertEquals( Tren.EDAD_MAXIMA+1 , tren.getAnyosActivo());
				
	}

		
	@Ignore
	public void testMostrarDatos() {
		
	}

	@Test
	public void testEstaLleno() {


			assertFalse( tren.estaLleno() );
			
			tren.setAsientosOcupados( Tren.CAPACIDAD_MAXIMA );
			assertTrue( tren.estaLleno() );
			
			
			tren.setAsientosOcupados( Tren.CAPACIDAD_MAXIMA+1 );
			assertTrue( tren.estaLleno() );
			
		
	}

	@Test
	public void testEsViejo() {

		assertFalse( tren.esViejo() ); // 3 años
		
		tren.setAnyosActivo( 40 );
		assertTrue( tren.esViejo() );
		
		tren.setAnyosActivo( 41 );
		assertTrue( tren.esViejo() );
		
		
	}

}
