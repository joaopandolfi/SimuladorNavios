package model;

public abstract class Rota {
	
	Porto portoA;
	Porto portoB;
	int distancia;
	
	Rota(Porto portoA, Porto portoB, int distancia){
		this.portoA = portoA;
		this.portoB = portoB;
		this.distancia = distancia;
	}

	//verifica se o porto faz parte dessa rota
	public boolean checkRote(Porto porto){
		if(portoA.getId() == porto.getId())
			return true;
		else if(portoB.getId() == porto.getId())
			return true;
					
		return false;
	}
	
	//retorno o porto contrario ao pedido
	public Porto getDestiny(Porto saida){
		if(portoA.getId() == saida.getId())
			return portoB;
		
		return portoA;
	}
	
	public int getDistance(){
		return distancia;
	}
	
	public Porto getPortoA(){
		return portoA;
	}
	
	//Metodos abstratos
	public abstract boolean verificaPermissao(TipoNavio tipoNavio);
	public abstract float getMultiplicador(); 
}
