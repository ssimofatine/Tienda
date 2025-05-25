public class Producto {
	
	/**
	 * atrobitos
	 */

	private String nombre;
	private double precio;
	private int stock;
	
	/**
	 * constrctur
	 * @param nombre
	 * @param precio
	 * @param stock
	 */
	
	public Producto (String nombre, double precio, int stock) {
		this.nombre=nombre;
		this.precio=precio;
		this.stock=stock;
	}
	
	/**
	 * getter y setter
	 * @return
	 */
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre (String nombre) {
		this.nombre=nombre;
	}
	
	public double getPrecio () {
		return precio;
	}
	
	public void setPrecio (double precio) {
		this.precio=precio;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock=stock;
	}
	
	public void reducirStock (int cantidad) {
		this.stock-=cantidad;
	}
	
	public void aumentarStock (int cantidad) {
		this.stock+=cantidad;
	}
	
}
