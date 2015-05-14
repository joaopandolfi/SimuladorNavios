package model;

public class FactoryEscuna implements FactorySheeps{

	public Navio criarNavio(TipoNavio tipoNavio) {
		NavioPassageiro novoNavio = new NavioPassageiro(tipoNavio);
		novoNavio.setMultiplicadorPorTipo(22, (float) 0.06);
		//setando cargas e passageiros
		novoNavio.setMaxPassageiros(20);
		//definindo valores aleatorios
		novoNavio.setRandomValues();
		return novoNavio;
	}

}
