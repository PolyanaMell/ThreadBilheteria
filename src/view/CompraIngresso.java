package view;

import java.util.concurrent.Semaphore;

import controller.ThreadBilheteria;

public class CompraIngresso {

	public static void main(String[] args) {
		
	Semaphore fila = new Semaphore(1);
			
	for(int idCliente = 1; idCliente <= 300; idCliente++) {
		Thread ingressos = new ThreadBilheteria(idCliente, fila);
		ingressos.start();
			
		}

	}

}