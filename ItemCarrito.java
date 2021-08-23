package supermercado;

public class ItemCarrito {
	
	private int idItem;
	private Producto producto;
	private int cantidad;
	
	public ItemCarrito(int idItem, Producto producto, int cantidad) {
		
		super();
		this.idItem = idItem;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ItemCarrito [idItem=" + idItem + ", producto=" + producto + ", cantidad=" + cantidad + "]\n";
	}
	
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + idItem;
		return result;
	}	

	@Override
	public boolean equals(Object obj) {
		
		return ((ItemCarrito)obj).getIdItem() == this.getIdItem();
	}		
	
	public float calcularSubTotal()
	{
		return producto.getPrecio() * cantidad;
	}	
	
}
