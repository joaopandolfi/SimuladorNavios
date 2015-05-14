package model;

public class Estaleiro implements FactorySheeps {

	FactorySheeps fabrica;
	
	public Estaleiro(){
		fabrica = null;
	}
	
	public Navio criarNavio(TipoNavio tipoNavio) {
		Navio novoNavio = null;
	
		//encontro a fabrica especifica para o tipo
		switch(tipoNavio){
			case CARGA_GERAL:
				fabrica = new FactoryCargaGeral();
			break;
			
			case CRUZEIRO:
				fabrica = new FactoryCruzeiro();
			break;
			
			case ESCUNA:
				fabrica = new FactoryEscuna();
			break;
			
			case GRANELEIRO:
				fabrica = new FactoryGraneleiro();
			break;
		}
		
		//Recebo o navio criado pela fabrica correta
		novoNavio = fabrica.criarNavio(tipoNavio);
		return novoNavio;
	}

	
}
