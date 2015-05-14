package model;

public class FactoryCruzeiro implements FactorySheeps{

	public Navio criarNavio(TipoNavio tipoNavio) {
		NavioPassageiro novoNavio = new NavioPassageiro(tipoNavio);
		novoNavio.setMultiplicadorPorTipo(36, (float) 0.2);
		//setando cargas e passageiros
		novoNavio.setMaxPassageiros(500);
		//definindo valores aleatorios
		novoNavio.setRandomValues();
		return novoNavio;
	}

}
