package br.com.fiap.view;

import java.rmi.RemoteException;
import br.com.fiap.bo.NotaBOStub;
import br.com.fiap.bo.NotaBOStub.CalcularMedia;
import br.com.fiap.bo.NotaBOStub.CalcularMediaResponse;

public class ConsoleView {
	
	public static void main(String[] args) throws RemoteException {
		
		NotaBOStub stub = new NotaBOStub();
		
		CalcularMedia parametros = new CalcularMedia();
		parametros.setAm(10);
		parametros.setNac(9);
		parametros.setPs(5);
		
		CalcularMediaResponse resp =
				stub.calcularMedia(parametros);
		
		System.out.println(resp.get_return());
		
	}

}
