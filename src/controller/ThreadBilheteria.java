package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadBilheteria extends Thread {

	Random sistema = new Random();
	private int idCliente;
	private Semaphore fila; //fila de espera para compra
	private static int totalIngressos = 100;
	int compraIngresso = sistema.nextInt(4) + 1; //1 a 4 ingressos por compra
	
	public ThreadBilheteria() {
		
	}
	
	public ThreadBilheteria(int idCliente, Semaphore fila) { 
	this.idCliente = idCliente;
	this.fila = fila;
		
	}
//// 01 - login do sistema 	
	@Override
	public void run() {
		login();
		try {
			fila.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			fila.release();
		}
	}
	
	private void login() {
		System.out.println("Novo cliente");
		int tempo = (int) ((sistema.nextInt(2000) + 50)); 
		if(tempo < 1000) {
			try {
			sleep(tempo);
			comprandoIngresso();
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}else {
			System.out.println("Time-out: Compra não efetuada");
		}
	}
////02 - etapa de compra	
	private void comprandoIngresso() {
		System.out.println(idCliente + "Comprando Ingresso");
		int tempo = (int) ((sistema.nextInt(3000) + 1000));
		if(tempo < 2500) {
			