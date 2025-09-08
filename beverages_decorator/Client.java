package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		System.out.println("Order 1:");
		Beverage order1 = new Cappuccino();
		order1 = new Milk(order1);
		order1 = new Sugar(order1);
		System.out.println("Cappuccino with Milk and Sugar: " + order1.cost());

		System.out.println();

		System.out.println("Order 2:");
		Beverage order2 = new Latte();
		order2 = new ExtraShot(order2);
		order2 = new Cream(order2);
		order2 = new Milk(order2);
		System.out.println("Latte with Extra Shot, Cream and Milk: " + order2.cost());
	}

}