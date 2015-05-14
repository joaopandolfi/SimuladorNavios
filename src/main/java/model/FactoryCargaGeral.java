package model;

public class FactoryCargaGeral implements FactorySheeps{

	public Navio criarNavio(TipoNavio tipoNavio) {
		NavioCarga novoNavio = new NavioCarga(tipoNavio);
		novoNavio.setMultiplicadorPorTipo(22, (float) 0.01,(float) 0.4);
		//setando cargas e passageiros
		novoNavio.setMaxCarga(150);
		novoNavio.setMaxPassageiros(15);
		//definindo valores aleatorios
		novoNavio.setRandomValues();
		return novoNavio;
	}

}
