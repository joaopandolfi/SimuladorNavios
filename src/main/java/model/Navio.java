package model;

public abstract class Navio {

	//Variaveis para controle de passageiros
	int passageiros;
	int maxPassageiros;
	
	//Variaveis para controle de rotas
	Rota rotaAtual;
	Porto destino;
	Porto portoAtracado;

	float velocidade;
	int carga;
	int maxCarga;
	float distancia;
	float multiplicadorTE;
	float multiplicadorNP;
	TipoNavio tipoNavio;
	
	//construtor
	Navio(TipoNavio tipoNavio){
		this.tipoNavio = tipoNavio;
		destino = null;
		multiplicadorNP = 0;
		multiplicadorTE = 0;
	}
	
	//Métodos abstratos
	public abstract float getVelocidade();
	public abstract void setRandomValues();


	// == metodos iguais == 
	public boolean chegouDestino(){
		if(rotaAtual.checkRote(destino)){
			if(rotaAtual.getDistance() <= distancia)
				return true;
		}
		return false;
	}

	public boolean chegouPorto(){
		if(rotaAtual.getDistance() <= distancia)
			return true;
		return false;
	}
	
	//Getters
	
	public boolean semDestino(){
		return destino == null;
	}
	
	public Rota getRotaAtual(){
		return rotaAtual;
	}
	
	public int getCarga(){
		return carga;
	}
	
	public int getPassageiros(){
		return passageiros;
	}

	public TipoNavio getTipoNavio(){
		return tipoNavio;
	}
	
	public Porto getPortoAtracado(){
		return portoAtracado;
	}

	//Setters
	
	public void setRota(Rota novaRota){
		rotaAtual = novaRota;
		portoAtracado = null;
		distancia = 0;
	}
	
	//calcula a nova distancia percorrida desde o ultimo porto
	public void calcDistancia(){
		distancia += getVelocidade();
	}
	
	public void setPortoAtracado(Porto portoAtracado){
		this.portoAtracado = portoAtracado;
	}
	
	public void setDestino(Porto destino){
		this.destino =  destino;
	}
	
	public void setPassageiros(int pessoas){
		passageiros = pessoas;
	}

	public void setMaxPassageiros(int maxPessoas){
		maxPassageiros = maxPessoas;
	}
	
	public void setMultiplicadorPorTipo(float multiplicadorTE, float multiplicadorNP){
		this.multiplicadorTE = multiplicadorTE;
		this.multiplicadorNP = multiplicadorNP;
	}
}
