package model;

import java.util.Random;

public class NavioCarga extends Navio {
	float multiplicadorTC = 0;
	
	NavioCarga(TipoNavio tipoNavio) {
		super(tipoNavio);
	}

	@Override
	public float getVelocidade() {
		velocidade = multiplicadorTE*rotaAtual.getMultiplicador() - passageiros*multiplicadorNP - multiplicadorTC*carga;
		return velocidade;
	}

	public void setMultiplicadorPorTipo(float multiplicadorTE, float multiplicadorNP, float multiplicadorTC){
		this.multiplicadorTE = multiplicadorTE;
		this.multiplicadorNP = multiplicadorNP;
		this.multiplicadorTC = multiplicadorTC;
	}
	
	public void setMaxCarga(int maxCarga){
		this.maxCarga = maxCarga;
	}
	
	public void setCarga(int carga){
		this.carga = carga;
	}
	
	public int getMaxCarga(){
		return maxCarga;
	}
	
	public void setRandomValues(){
		Random random = new Random();
		passageiros = random.nextInt(maxPassageiros);
		carga = random.nextInt(maxCarga);
	}
}
