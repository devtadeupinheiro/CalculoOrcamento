package strategy;

import model.Produto;
import servicos.ObterAtributos;

public class ObterId implements ObterAtributos {

	@Override
	public Object retornarAtributo(Produto produto, int columnIndex) {
		return produto.getId();
	}
	

}
