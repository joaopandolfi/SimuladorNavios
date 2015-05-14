package model;

public class AguasProfundas extends Rota{

	public AguasProfundas(Porto portoA, Porto portoB, int distancia) {
		super(portoA, portoB, distancia);
		// TODO Auto-generated constructor stub
	}

	public boolean verificaPermissao(TipoNavio tipoNavio) {
		// TODO Auto-generated method stub
		return false;
	}

	public float getMultiplicador() {
		return (float) 4.8;
	}

}
