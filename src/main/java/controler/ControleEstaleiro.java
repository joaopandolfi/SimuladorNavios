package controler;

import java.util.ArrayList;
import java.util.Random;

import model.Estaleiro;
import model.Navio;
import model.TipoNavio;

public class ControleEstaleiro {
	Estaleiro estaleiro;
	ArrayList<Navio> lastCreateds;
	Random random;
	
	ControleEstaleiro(){
		estaleiro = new Estaleiro();
		lastCreateds = new ArrayList<Navio>();
		random = new Random();
	}
	
	//gero os navios do dia
	public ArrayList<Navio> gerarNavios(ArrayList<Navio> navios){
		Navio novo;
		int tamMaximo;
		int contador = 0;
		lastCreateds = new ArrayList<Navio>();
		
		//Gero Cruzeiros
		tamMaximo = random.nextInt(2);
		for(contador = 0 ; contador < tamMaximo; contador++){
			novo = estaleiro.criarNavio(TipoNavio.CRUZEIRO);
			lastCreateds.add(novo);
			navios.add(novo);
		}
		
		//Gero Escunas
		tamMaximo = random.nextInt(5);
		for(contador = 0 ; contador < tamMaximo; contador++){
			novo = estaleiro.criarNavio(TipoNavio.ESCUNA);
			lastCreateds.add(novo);
			navios.add(novo);
		}

		//Gero Carga geral
		tamMaximo = random.nextInt(3);
		for(contador = 0 ; contador < tamMaximo; contador++){
			novo = estaleiro.criarNavio(TipoNavio.CARGA_GERAL);
			lastCreateds.add(novo);
			navios.add(novo);
		}

		//Gero Graneleiros
		tamMaximo = random.nextInt(2);
		for(contador = 0 ; contador < tamMaximo; contador++){
			novo = estaleiro.criarNavio(TipoNavio.GRANELEIRO);
			lastCreateds.add(novo);
			navios.add(novo);
		}


		return navios;
	}
	
	public ArrayList<Navio> getLastCreated(){
		return lastCreateds;
	}
}
