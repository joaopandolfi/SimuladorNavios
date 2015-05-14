package model;

public class FactoryGraneleiro implements FactorySheeps{

	public Navio criarNavio(TipoNavio tipoNavio) {
		NavioCarga novoNavio = new NavioCarga(tipoNavio);
		novoNavio.setMultiplicadorPorTipo(20, (float) 0.01,(float) 0.3);
		//setando cargas e passageiros
		novoNavio.setMaxCarga(200);
		novoNavio.setMaxPassageiros(6);
		//definindo valores aleatorios
		novoNavio.setRandomValues();
		return novoNavio;
	}

}
