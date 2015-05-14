package model;

public class AguasLitoraneas extends Rota{

	public AguasLitoraneas(Porto portoA, Porto portoB, int distancia) {
		super(portoA, portoB, distancia);
		// TODO Auto-generated constructor stub
	}

	public boolean verificaPermissao(TipoNavio tipoNavio) {
		// TODO Auto-generated method stub
		return false;
	}

	public float getMultiplicador() {
		return 4;
	}

}
