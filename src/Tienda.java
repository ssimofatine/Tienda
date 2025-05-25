import java.util.ArrayList;
import java.util.List;

/**
 * La clase Tienda gestiona un inventario de productos, permitiendo agregar productos,
 * venderlos aplicando descuentos, actualizar precios y stock, y calcular el valor total del
 * inventario.
 * @author Mohamed El Fatine
 * @version 1.0
 */

public class Tienda {
	
	
	
	/**
	 * Constante para el descuento del 25%.
	 */
	private static final double DESCUENTO_25_PORCIENTO = 0.25;
	/**
	 * Constante para el descuento del 10%.
	 */
	private static final double DESCUENTO_10_PORCIENTO = 0.10;
	/**
	 * Lista que almacena los productos en el inventario de la tienda.
	 */
	private List <Producto> productos;
	
	/**
	 * Constructor de la clase Tienda.
	 * Inicializa la lista de productos como un ArrayList vacío.
	 */
	public Tienda() {
		productos =new ArrayList<>();
	}
	
	/**
	 * Este método crea un objeto de tipo Producto con el nombre, precio y stock
	 * @param nombre El nombre del producto
	 * @param precio del producto a agregar
	 * @param stockinicial del producto
	 */
	
	// Añadir producto nuevo
	public void agregarProducto (String nombre, double precio, int stock) {
		Producto producto= new Producto (nombre, precio, stock);
		productos.add(producto);
	}
	
	
	
	/**
	 * Realiza una venta
	 * Si se encuentra el producto en el inventario
	 * el descuento aplicado y el total con descuento
	 * @param nombreProducto El nombre del producto
	 * @param cantidadVendida  La cantidad del producto
	 */
	
	
	
	
	// Vender producto
	public void venderProducto(String nombreProducto, int cantidadVendida) {
	    boolean productoEncontrado = false;  // Variable para verificar si se encontró el producto
	    for (Producto producto : productos) {
	        	        
	        // Comprobamos si el nombre del producto coincide
	        if (producto.getNombre().equals(nombreProducto)) {
	            productoEncontrado = true;  // Marcamos que el producto fue encontrado
	            
	            // Verificamos si hay suficiente stock
	            if (producto.getStock() >= cantidadVendida) {
	                double totalVenta = producto.getPrecio() * cantidadVendida;
	                double descuento = calculoDescuentoVenta(totalVenta);

	                // Calculamos el total con el descuento
	                double totalConDescuento = totalVenta - (totalVenta * descuento);
	                
	                // Reducimos el stock del producto
	                producto.reducirStock(cantidadVendida);    
	                // Mostramos venta por pantalla
	                ventaPorPantalla(producto, totalVenta, descuento, totalConDescuento);
	            } else {
	                System.out.println("Stock insuficiente.");
	            }
	            break;  // Salimos del ciclo porque ya hemos procesado el producto
	        }
	    }
	    
	    // Si no se encontró el producto
	    if (!productoEncontrado) {
	        System.out.println("Producto "+nombreProducto +" no encontrado.");
	    }
	}
	
	
	/**
	 * Muestra los detalles de una venta realizada por pantalla
	 * el subtotal, el descuento aplicado y el total final
	 * @param producto
	 * @param totalVenta
	 * @param descuento
	 * @param totalConDescuento
	 */

	private void ventaPorPantalla(Producto producto, double totalVenta, double descuento, double totalConDescuento) {
		System.out.println("Venta "+ producto.getNombre()+" realizada. ");
		System.out.println("Subtotal : " + totalVenta);
		System.out.println("Decuento aplicado: "+descuento);
		System.out.println("Total : " + totalConDescuento);
	}
	
	/**
	 * Calcula el porcentaje de descuento a aplicar basado en el total
	 *  
	 * y un 25% si el total es mayor que 100.
	 * @param totalVenta El precio total de la venta
	 * @return El porcentaje de descuento a aplicar
	 */

	private double calculoDescuentoVenta(double totalVenta) {
		double descuento = 0;

		// Aplicamos descuento según el total
		boolean descuentoInicial = totalVenta >= 50 && totalVenta <= 100;
		if (descuentoInicial) {
		    descuento = DESCUENTO_10_PORCIENTO;  // 10% de descuento
		} else {
			boolean descuentoAvanzado = totalVenta > 100;
			if (descuentoAvanzado) {
			    descuento = DESCUENTO_25_PORCIENTO;  // 25% de descuento
			}
		}
		return descuento;
	}
	
	/**
	 * Muestra por pantalla todos los productos en el inventario 
	 * 
	 */

	public void mostrarInventario() {
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " - Precio: " + producto.getPrecio() + " - Stock: " + producto.getStock());
        }
    }
	
	
	/**
     * Busca un producto por su nombre
     * @param nombre El nombre del producto a buscar.
     * @return El objeto Producto correspondiente si se encuentra
     */
	
	
	 // Buscar producto por nombre
    public Producto buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
    
    /**
     * Actualiza el precio de un producto si se encuentra en el inventario
     * @param nombre El nombre del producto
     * @param nuevoPrecio El nuevo precio para el producto
     */
	
    // Actualizar precio de un producto
    public void actualizarPrecio(String nombre, double nuevoPrecio) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
            System.out.println("Precio actualizado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    
    /**
     * Aumenta el stock de un producto específico si se encuentra en el inventario
     * @param nombre
     * @param cantidad
     */
	
    // Actualizar stock
    public void reponerStock(String nombre, int cantidad) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            producto.aumentarStock(cantidad);
            System.out.println("Stock actualizado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    
    /**
     * Calcula el valor total del inventario multiplicando el precio 
     * por su stock y sumando los resultados
     * @return El valor total del inventario
     */
	
    // Calcular valor total del inventario
    public double calcularValorInventario() {
        double precioTotalStock = 0;
        for (Producto producto : productos) {
            precioTotalStock += producto.getPrecio() * producto.getStock();
        }
        return precioTotalStock;
    }
	
}//fin clase
