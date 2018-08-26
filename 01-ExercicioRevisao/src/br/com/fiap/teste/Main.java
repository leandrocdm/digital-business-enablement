package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.TipoConta;

public class Main {

	public static void main(String[] args) {
		
		ContaCorrente cc = new ContaCorrente(2819,990,
				Calendar.getInstance(),1000,TipoConta.COMUM);
		
		ContaCorrente c1 = new ContaCorrente(2010, 111, 
				Calendar.getInstance(), 50000, TipoConta.PREMIUM);
		
		ContaCorrente c2 = new ContaCorrente(2010, 111, 
				Calendar.getInstance(), 1000, TipoConta.ESPECIAL);
		
		List<ContaCorrente> lista = new ArrayList<ContaCorrente>();
		
		lista.add(cc);
		lista.add(c1);
		lista.add(c2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		lista.forEach(c -> {
			
			System.out.println("Agencia: " + c.getAgencia());
			System.out.println("Numero: " + c.getNumero());
			System.out.println("Saldo " + c.getSaldo());
			System.out.println("Data Abertura: " + 
			
					sdf.format(c.getDataAbertura().getTime()));
			
			System.out.println("Tipo: " + c.getTipo());
			System.out.println("****************************");
		});
		

		
		
	}
	
}





