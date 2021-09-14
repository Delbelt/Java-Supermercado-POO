package supermercado;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List <ItemCarrito> listaItem = new ArrayList <ItemCarrito>();	
	private Cliente cliente;
	
	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) {
		
		super();
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;		
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public List<ItemCarrito> getListaItem() {
		return listaItem;
	}

	public void setListaItem(List<ItemCarrito> listaItem) {
		this.listaItem = listaItem;
	}	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora + ", listaItem=" + listaItem
				+ ", cliente=" + cliente + "]";
	}	

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + idCarrito;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		return ((Carrito)obj).getIdCarrito() == this.getIdCarrito();
	}

	public boolean agregarItem(Producto producto, int cantidad) throws Exception {
		
		if(cantidad <= 0)
		throw new Exception("No se puede agregar menos de una unidad");
		
		if(producto == null)
		throw new Exception("No existe el producto");
		
		int i = 0;
		ItemCarrito objeto = null;
		boolean agregarItem = false;
		
		if(listaItem.size() == 0) //Si la lista no existe, crea el primer Item
		{
			objeto = new ItemCarrito(1, producto, cantidad);
			agregarItem = listaItem.add(objeto);
		}
		
		else
		{
			while(i < listaItem.size() && objeto == null)
			{
				if (listaItem.get(i).getProducto().equals(producto)) 
				{
					objeto = listaItem.get(i);	
					objeto.setCantidad(objeto.getCantidad() + cantidad); //Si el Item existe, le suma la cantidad
				}
				
				i++;
			}
			
				if(objeto == null) //si no esta el Item en la lista, lo crea con el Id correspondiente
				{
					objeto = new ItemCarrito(listaItem.get(listaItem.size()-1).getIdItem()+1, producto, cantidad);
					agregarItem = listaItem.add(objeto);
				}
		}
		
			return agregarItem; //Si se crea/modifica el objeto = true
	}
		
	public boolean eliminarItem(Producto producto, int cantidad) throws Exception {
		
		if(cantidad <= 0)
		throw new Exception("No se puede eliminar menos de una unidad");
		
		int i = 0;
		ItemCarrito objeto = null;
		boolean eliminado = true;
		
		while (i < listaItem.size() && objeto == null)
		{
			if 	(listaItem.get(i).getProducto().equals(producto)) 
			{
				if(listaItem.get(i).getCantidad() > cantidad)
				{	
					objeto = listaItem.get(i);
					objeto.setCantidad(listaItem.get(i).getCantidad() - cantidad);
					eliminado = false;
					
				}
				
				else
				{
					objeto = listaItem.get(i);
					listaItem.remove(objeto);
				}
			}			

			i++;
		}
					if(eliminado == false && objeto == null)
					throw new Exception("El producto no se encuentra en la lista de Items");
					
					return eliminado;	//Devuelve True si lo elimino	
	}
	
	public ItemCarrito traerItem(int idItem) throws Exception {
		
		int i = 0;
		ItemCarrito objeto = null;		

		while(i < listaItem.size() && objeto == null)
		{
			if (listaItem.get(i).getIdItem() == idItem)
			{		
				objeto = listaItem.get(i);					
			}
			
			i++;
		}
		
		return objeto;
	}
	
	public void comprobarProductoListaItem(Producto producto) throws Exception {
		
		int i;
		
		for(i = 0; i < listaItem.size(); i++)
		{
			if(listaItem.get(i).getProducto().equals(producto))
			throw new Exception("No se puede eliminar un producto que exista en una carrito de compras");			
		}
	}
	
	public float calcularTotal()
	{
		int i;
		float total = 0;
		
		for(i=0;i<listaItem.size();i++)
		{
			total += listaItem.get(i).calcularSubTotal();
		}
		
		return total;
	}
}
