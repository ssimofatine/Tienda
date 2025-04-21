public class Main {

	public static void main(String[] args) {
		Tienda tienda =new Tienda();
		
		//Agregar productos a la tienda
		tienda.agregarProducto("Camisa", 25, 75);
		tienda.agregarProducto("Pantalón", 30, 60);
		tienda.agregarProducto("Camiseta", 15, 60);
		tienda.agregarProducto("Chaqueta", 45, 25);
		tienda.agregarProducto("Abrigo", 60, 35);
		tienda.agregarProducto("Zapatos", 40, 30);
		tienda.agregarProducto("Calcetines", 10, 100);
		
		  // Mostrar inventario
        System.out.println("Inventario de la tienda:");
        tienda.mostrarInventario();

     // Calcular el valor total del inventario
        double valorInventario = tienda.calcularValorInventario();
        System.out.println("\nValor total del inventario: " + valorInventario);
        
        // Realizar ventas
        System.out.println("\nVendiendo productos...");
        tienda.totalVenta("Camiseta", 3);  
        tienda.totalVenta("Camisa", 2);  
        tienda.totalVenta("Calzoncillos", 2); 

        // Mostrar inventario después de las ventas
        System.out.println("\nInventario después de las ventas:");
        tienda.mostrarInventario();  

        // Calcular el valor total del inventario despues de la venta
         valorInventario = tienda.calcularValorInventario();
        System.out.println("\nValor total del inventario despues de la venta: " + valorInventario);
    }
	

}

