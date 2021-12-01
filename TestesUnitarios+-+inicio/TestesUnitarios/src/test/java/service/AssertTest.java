package service;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {
	@Test
	public void test() {
		//Serve para testar um booleano
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		
		//igualdade de valores
		Assert.assertEquals(1, 1);
		
		//Aqui precisa tomar cuidado com as casas decimais e por isso � necessario passar um valor de 
		//referencia que � a margem de erro.
		Assert.assertEquals(0.51, 0.51, 0.01);
		Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		
		int i = 5;
		Integer i2 = 5;
		
		//Aqui precisa converter os tipos para dar certo.
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());
		
		Assert.assertEquals("Bola", "Bola");
		Assert.assertTrue("Bola".equalsIgnoreCase("bola"));
		Assert.assertTrue("Bola".startsWith("Bo"));
		
		
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = null;
		
		Assert.assertEquals(u1, u2);
		
		
		//Todo Assert que tem para o verdadeiro tem para o falso, igual aqui a abaixo.
		Assert.assertSame(u1, u1);
		Assert.assertNotSame(u1, u2);
		
		Assert.assertTrue(u3 == null);
		Assert.assertNull(u3);
		Assert.assertNotNull(u3);
	}

	
}
