package controler;

public class ControleTempo {
	ControleRotas controleRotas;
	
	public ControleTempo(ControleRotas controleRotas){
		this.controleRotas = controleRotas;
	}
	
	public void simulateTime(int totalDias){
		int diaAtual;
		//faço itaração dos dias
		for(diaAtual = 0 ; diaAtual<totalDias; diaAtual++){
			//faz iteração do dia
			controleRotas.iterateDay();
		}
	}
}