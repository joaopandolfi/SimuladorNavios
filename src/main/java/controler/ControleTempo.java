package controler;

public class ControleTempo {
	ControleRotas controleRotas;
	
	public ControleTempo(ControleRotas controleRotas){
		this.controleRotas = controleRotas;
	}
	
	public void simulateTime(int totalDias){
		int diaAtual;
		//fa�o itara��o dos dias
		for(diaAtual = 0 ; diaAtual<totalDias; diaAtual++){
			//faz itera��o do dia
			controleRotas.iterateDay();
		}
	}
}