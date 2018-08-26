package br.com.fiap.view;

import java.rmi.RemoteException;
import java.util.Scanner;

import org.apache.axis2.AxisFault;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class ConsoleView {

	public static void main(String[] args) throws RemoteException {
		
		Scanner input = new Scanner(System.in);
		
		CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
		
		CalcPrazo calc = new CalcPrazo();
		
		System.out.println("Digite CEP de origem");
		String cepOrigem = input.nextLine();
		
		System.out.println("Digite CEP de destino");
		String cepDestino = input.nextLine();
		
		calc.setSCepDestino(cepDestino);
		calc.setSCepOrigem(cepOrigem);
		calc.setNCdServico("4014");
		
		CalcPrazoResponse resp = stub.calcPrazo(calc);
		
		System.out.println("Data Maxima de Entrega: " + resp.getCalcPrazoResult()
		.getServicos().getCServico()[0].getDataMaxEntrega());
		
		input.close();
	}
	
}
