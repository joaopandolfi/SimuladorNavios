package model;

import java.util.Random;

public class NavioPassageiro extends Navio{

	NavioPassageiro(TipoNavio tipoNavio) {
		super(tipoNavio);
	}

	@Override
	public float getVelocidade() {
		velocidade = multiplicadorTE*rotaAtual.getMultiplicador() - passageiros*multiplicadorNP;
		return velocidade;
	}

	@Override
	public void setRandomValues() {
		Random random = new Random();
		passageiros = random.nextInt(maxPassageiros);
	}

}
