

import junit.framework.Assert;
import model.Estaleiro;
import model.Navio;
import model.NavioCarga;
import model.TipoNavio;

import org.junit.Before;
import org.junit.Test;

public class Testes {

	Navio navio;
	Estaleiro estaleiro;
	
	@Before
	public void before(){
		navio = null;
		estaleiro = new Estaleiro();
	}
	
	@Test
	public void testeFactory1(){
		navio = estaleiro.criarNavio(TipoNavio.CARGA_GERAL);
		Assert.assertEquals(TipoNavio.CARGA_GERAL, navio.getTipoNavio());
	}
	
	@Test
	public void testeFactor2(){
		navio = estaleiro.criarNavio(TipoNavio.ESCUNA);
		Assert.assertEquals(TipoNavio.ESCUNA, navio.getTipoNavio());
	}

	@Test
	public void testeFactory(){
		navio = estaleiro.criarNavio(TipoNavio.GRANELEIRO);
		Assert.assertEquals(TipoNavio.GRANELEIRO, navio.getVelocidade());
	}

}
