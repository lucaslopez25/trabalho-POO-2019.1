package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import //session
//import //exceptions na session

public class L2ConsoleUI {
	
	private BufferedReader br;
	
	public L2ConsoleUI () throws ClassNotFoundException, IOException {
		this.br = new BufferedReader(new InputStreamReader (System.in));
		
	}
	
	
	
	public void run() {
		char opc = '0';
		do {
			
			System.out.println("Menu");
			System.out.println("------------------------");
			System.out.println("Digite 0 para SAIR");
			System.out.println("Digite 1 para ver pigmentos disponiveis + quantidade de tinta");
			System.out.println("Digite 2 para debitar um pigmento");
			System.out.println("------------------------");
			
			try {
				opc = br.readLine().charAt(0);
			}
			catch (IOException a){
				System.out.println("Erro - E/S: Caractere digitado inválido!");
			}
			switch (opc) {
				case '1' :
					try {
						
					}
					catch {
						
					}
					catch {
						
					}
				break;
				case '2' :
			}
			
		} while (opc != '0');
	}
	
	public static void main (String args[]) throws ClassNotFoundException, IOException {
		(new L2ConsoleUI()).run();
	}
	
}
