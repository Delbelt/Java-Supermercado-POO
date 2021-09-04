package supermercado;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CarritoABM {
	
	private List <Carrito> listaCarrito = new ArrayList<Carrito>();

	public CarritoABM() {
		super();
	}

	public List<Carrito> getListaCarrito() {
		return listaCarrito;
	}

	public void setListaCarrito(List<Carrito> listaCarrito) {
		this.listaCarrito = listaCarrito;
	}

	@Override
	public String toString() {
		return "CarritoABM [listaCarrito=" + listaCarrito + "]";
	}
	
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {
		
		int i = 0;
		Carrito lista = null;
		
		for (i = 0; i < listaCarrito.size(); i++) 
		{

			if(listaCarrito.get(i).getFecha() == fecha && listaCarrito.get(i).getHora() == hora &&  listaCarrito.get(i).getCliente().equals(cliente))
			{				
				throw new Exception("El carrito ya esta registrado");		
			}
		}
		
		if(listaCarrito.size() == 0)
		{
			lista = new Carrito(1, fecha, hora, cliente);
		}
		
		else
		{
			lista = new Carrito(listaCarrito.get(listaCarrito.size()-1).getIdCarrito()+1, fecha, hora, cliente);
		}
		
			return listaCarrito.add(lista);
	}
	
	public Carrito traerCarrito(int idCarrito) throws Exception	{
		
		int i = 0;
		Carrito objeto = null;		

		while(objeto == null && i < listaCarrito.size())
		{
			if (listaCarrito.get(i).getIdCarrito() == idCarrito)
			{		
				objeto = listaCarrito.get(i);					
			}
			
			i++;
		}
		
		return objeto;
	}

	public boolean eliminarCarrito(int idCarrito) throws Exception {
		
		Carrito objeto = traerCarrito(idCarrito);
		
		if(objeto == null)		
		throw new Exception("No existe el carrito con el Id: " + idCarrito);
						
		return listaCarrito.remove(traerCarrito(idCarrito)); //Remueve por objeto	
	}
	
	public void comprobarProductoListaCarrito(Producto producto) throws Exception {
		
		int i;		
		
		for(i = 0 ; i < listaCarrito.size() ; i++) //RECORRE LA LISTA DE CARRITOS
		{
			listaCarrito.get(i).comprobarProductoListaItem(producto);
		}
	}
	
	public void comprobarClienteListaCarrito(Cliente cliente) throws Exception {
		
		int i;
		
		for(i = 0; i < listaCarrito.size(); i++)
		{
			if(listaCarrito.get(i).getCliente().equals(cliente))
			throw new Exception("No se puede eliminar un cliente que tenga una compra pendiente");
		}
	}
}