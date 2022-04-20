package service;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import service.TimeOfPurchase;


public class BuyService {

	private static Integer id = 0;
	private List<Product> products = new ArrayList<>();
	private Double cart = 0.0;
	private Double discount = 0.0;
	double discountCart = 0.0;
	
	public void buyInfo(TimeOfPurchase timeOfPurchase) {
		
		System.out.println("");
		System.out.println("Pedido Nº " + id);
		System.out.println("Hora da compra: " + timeOfPurchase.gethourFormatted()+ "H");
		System.out.println("Dia da compra: " + timeOfPurchase.getDayOfTheWeek());
	}
	
	public BuyService(List<Product> products, TimeOfPurchase timeOfPurchase) {
		id += 1;
		
		this.products = products;
		
		buyInfo(timeOfPurchase);
		
		if(timeOfPurchase.gethourFormatted() >= 20 || timeOfPurchase.getTimeOfPurchase().getDayOfWeek() == DayOfWeek.SATURDAY || timeOfPurchase.getTimeOfPurchase().getDayOfWeek() == DayOfWeek.SUNDAY) {
			
			discount = 0.10;
			
			System.out.println("------------------------------------------------------------------ ");
			System.out.println("=====================================Desconto aplicado========================================");
			System.out.println("Compra feita após 20h ou realizada no sábado ou domingo recebem 10% de desconto por produto.");
			System.out.println("==============================================================================================");

			System.out.println("Produtos comprados: ");
			
			
			this.products.forEach(product -> { 
				System.out.println("___________________");
				System.out.println(product.getName());
				System.out.println("___________________");

				cart += product.getPrice();
				
				double  priceDiscount = (product.getPrice() * discount);
				
				discountCart += (product.getPrice() - priceDiscount);
	
				System.out.println("Valor do desconto do produto |" + product.getName() +"| : R$ "+ priceDiscount);
				System.out.println("Preço do produto: R$ " + product.getPrice());
				System.out.println("Preço do produto com desconto: R$ " + (product.getPrice() - priceDiscount));

				System.out.println("Preço total a pagar com desconto: R$ " + discountCart);

				
			});
			
		} else {
			System.out.println("------------------------------------------------------------------ ");
			System.out.println("=====Compra sem desconto=====");

			System.out.println("Produtos comprados: ");
			this.products.forEach(product -> {
			
				System.out.println(product.getName());
				cart += product.getPrice();
				System.out.println("Preço do produto: R$ " + product.getPrice());
			});
		}
		System.out.println("------------------------------------------------------------------ ");

		System.out.println("Valor total dos produtos comprados sem desconto: R$ " + cart);
		System.out.println("Valor total dos produtos comprados com desconto: R$ " + discountCart );
		System.out.println("------------------------------------------------------------------ ");

		
		
	}
	
	
	
}
