package controller;

import java.util.Arrays;

import model.Product;
import repository.Buy;
import service.BuyService;
import service.TimeOfPurchase;

public class AppSuperMarket {

	public static void main(String[] args) {
		

		Product prod1 = new Product("Biscoito", 3.5);
		Product prod2 = new Product("Suco", 5);
		Product prod3 = new Product("Pão", 4.7);
		Product prod4 = new Product("queijo", 20);
		
		TimeOfPurchase diaCompraHora = new TimeOfPurchase();
		diaCompraHora.defineTimeOfPurchase(20, 4, 2022, 11, 25, 0);
		
		BuyService prodsDaCompra = new BuyService(Arrays.asList(prod1, prod2, prod3, prod4), diaCompraHora);
		Buy.buy.add(prodsDaCompra);
		
		
		Product prod5 = new Product("feijão", 6);
		Product prod6 = new Product("Carne", 30);
		
		TimeOfPurchase diaCompraHora2 = new TimeOfPurchase();
		diaCompraHora2.defineTimeOfPurchase(23, 4, 2022, 11, 25, 0);
		
		BuyService prodsDaCompra2 = new BuyService(Arrays.asList(prod5, prod6), diaCompraHora2);
		Buy.buy.add(prodsDaCompra2);
		
		
	}

}
