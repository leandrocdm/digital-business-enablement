package br.com.fiap.view;

import java.rmi.RemoteException;
import br.com.fiap.bo.NotaBOStub;
import br.com.fiap.bo.NotaBOStub.CalcularPs;
import br.com.fiap.bo.NotaBOStub.CalcularPsResponse;


public class CalcularPsView {

	public static void main(String[] args) throws RemoteException {
		
		NotaBOStub stub = new NotaBOStub();
		
		CalcularPs parametros = new CalcularPs();
		
		parametros.setAm(10);
		parametros.setNac(6);
		
		 CalcularPsResponse resp = stub.calcularPs(parametros);
		 		 
		 System.out.println(resp.get_return());
	}
	
}
