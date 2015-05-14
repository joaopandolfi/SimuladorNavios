package view;

import java.util.Scanner;

public class Console implements View{
	private Scanner read = new Scanner(System.in);
	public Console(){
		
	}
	
	public void showMenu(){
		System.out.println("Informe o numero de dias da simulação: ");
	}
	
	public int getDays(){
		return read.nextInt();
	}

	public void showResult(int totalPassageiros, int totalCarga) {
		System.out.println("RESULTADO: ");
		System.out.println("Passageiros: "+totalPassageiros);
		System.out.println("Carga: "+totalCarga +" (Toneladas)");
	}
}
