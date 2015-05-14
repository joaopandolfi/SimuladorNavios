package controler;

import java.util.ArrayList;
import java.util.Random;

import model.AguasLitoraneas;
import model.AguasProfundas;
import model.AguasTranscontinentais;
import model.Navio;
import model.Porto;
import model.Rota;
import model.TipoRota;

public class ControleRotas {

	//Controle das rotas
	ArrayList<Rota> rotas;
	Random random;
	
	//Controle dos navios
	ControleEstaleiro controleEstaleiro;
	ArrayList<Navio> navios;
	ArrayList<Navio> naviosFinalizados;
	ArrayList<Navio> novosNavios;
	
	ControleRotas(){
		controleEstaleiro = new ControleEstaleiro();
		navios = new ArrayList<Navio>();
		naviosFinalizados = new ArrayList<Navio>();
		rotas = new ArrayList<Rota>();
		random = new Random();
	}
	
	public void iterateDay(){
		
		//calcula distancia para os navios e verifica quem chegou ao destino final
		calcNewDistanceAndEnd();
		
		//verifica se o chegou no porto do destino atual
		checkCurrentDestiny();
		
		//cria navios
		navios = controleEstaleiro.gerarNavios(navios);
		
		//adiciona rota nos novos navios
		novosNavios = controleEstaleiro.getLastCreated();
		addRotaNovosNavios();
		
	}
	
	public ArrayList<Navio> getNaviosFinalizados(){
		return naviosFinalizados;
	}
	
	//verifica se o chegou no porto do destino atual
	private void checkCurrentDestiny(){
		Rota rotaAtual;
		for(Navio navioAnalizado : navios){
			if(navioAnalizado.chegouPorto()){
				rotaAtual = navioAnalizado.getRotaAtual();
				//defino que o navio esta atracado no porto de chegada
				navioAnalizado.setPortoAtracado(rotaAtual.getDestiny(navioAnalizado.getPortoAtracado()));
				addRotaNavio(navioAnalizado);
			}
		}		
	}
	
	//calcula nova distancia para os navios e verifica quem chegou ao destino
	private void calcNewDistanceAndEnd(){
		ArrayList<Navio> toRemove = new ArrayList<Navio>();
		//percorro a lista de navios
		for(Navio navioAnalizado : navios){
			navioAnalizado.calcDistancia();
			if(navioAnalizado.chegouDestino()){
				//se chegou, remove da lista dos andantes e adiciona aos finalizados
				naviosFinalizados.add(navioAnalizado);
				toRemove.add(navioAnalizado);
			}
		}
		//remove os navios que finalizaram
		removeNavios(toRemove);
	}
	
	private void removeNavios(ArrayList<Navio> toRemove){
		for(Navio removed : toRemove){
			navios.remove(removed);
		}
	}
	
	//adiciono rota nos novos navios
	private void addRotaNovosNavios(){
		Rota novaRota;
		//percorro a lista de novos navios
		for(Navio novoNavio: novosNavios){
			//gero uma rota aleatoria
			novaRota = rotas.get(random.nextInt(rotas.size()));
			//coloco o navio na rota aleatoria
			novoNavio.setRota(novaRota);
			novoNavio.setPortoAtracado(novaRota.getPortoA());
			//gero uma nova rota aleatoria
			novaRota = rotas.get(random.nextInt(rotas.size()));
			while(novaRota.equals(novoNavio.getRotaAtual())){
				//garanto que a nova rota não é igual
				novaRota = rotas.get(random.nextInt(rotas.size()));
			}
			// seto ela como destino
			novoNavio.setDestino(novaRota.getPortoA());
		}		
	}
	
	//Adiciona uma nova rota ao navio
	private void addRotaNavio(Navio navio){
		Rota novaRota= null;
		ArrayList<Rota> possiveisRotas = new ArrayList<Rota>();
		for(Rota rotaAnalizada : rotas){
			//pego as rotas que contem o porto atracado
			if(rotaAnalizada.checkRote(navio.getPortoAtracado())){
				possiveisRotas.add(rotaAnalizada);
			}
		}
		//Gero uma nova rota aleatoria
		novaRota = possiveisRotas.get(random.nextInt(possiveisRotas.size()));
	}
	
	//Crio a rota
	public void addRota(int idPortoA, int idPortoB, int distancia,TipoRota tipoRota){
		Rota novaRota = null;
		Porto portoA = new Porto(idPortoA);
		Porto portoB = new Porto(idPortoB);
		
		//cria de acordo com a rota
		switch(tipoRota){
			case AGUAS_LITORANEAS:
				novaRota = new AguasLitoraneas(portoA, portoB, distancia);
			break;
			
			case AGUAS_PROFUNDAS:
				novaRota = new AguasProfundas(portoA, portoB, distancia);
			break;
			
			case AGUAS_TRANSCONTINENTAIS:
				novaRota = new AguasTranscontinentais(portoA, portoB, distancia);
			break;
		}
		rotas.add(novaRota);
	}
}
