package controler;

import java.util.ArrayList;

import model.Navio;
import model.TipoRota;
import view.Console;
import view.View;

public class ControleGeral {
	private ControleRotas controleRotas;
	private ControleTempo controleTempo;
	private View view;
	//dados
	private int totalCarga;
	private int totalPassageiros;
	
	public ControleGeral(){
		controleRotas = new ControleRotas();
		setRotas();
		controleTempo = new ControleTempo(controleRotas);
		view = new Console();
		
		totalCarga = 0;
		totalPassageiros = 0;
	}

	public void startSimulator(){
		view.showMenu();
		controleTempo.simulateTime(view.getDays());
		calculaResultado();
		view.showResult(totalPassageiros, totalCarga);
	}
	
	private void calculaResultado(){
		ArrayList<Navio> naviosFinalizados = controleRotas.getNaviosFinalizados();
		//percorro calculando tudo
		for(Navio navioAnalizado : naviosFinalizados){
			totalCarga += navioAnalizado.getCarga();
			totalPassageiros += navioAnalizado.getPassageiros();
		}
	}
	
	//Cria rotas
	private void setRotas(){
		controleRotas.addRota(0, 1, 32, TipoRota.AGUAS_LITORANEAS);
		controleRotas.addRota(0, 2, 129, TipoRota.AGUAS_LITORANEAS);
		controleRotas.addRota(1, 2, 1036, TipoRota.AGUAS_TRANSCONTINENTAIS);
		controleRotas.addRota(1, 4, 950, TipoRota.AGUAS_PROFUNDAS);
		controleRotas.addRota(3, 6, 451, TipoRota.AGUAS_LITORANEAS);
		controleRotas.addRota(2, 5, 1445, TipoRota.AGUAS_PROFUNDAS);
		controleRotas.addRota(5, 4, 279, TipoRota.AGUAS_LITORANEAS);
		controleRotas.addRota(5, 7, 705, TipoRota.AGUAS_TRANSCONTINENTAIS);
		controleRotas.addRota(7, 4, 605, TipoRota.AGUAS_TRANSCONTINENTAIS);
	}
	
}
