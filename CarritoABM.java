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
			if (listaCarrito.get(i).getCliente().equals(cliente))
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
		
		if(listaCarrito.size() == 0)		
		throw new Exception("No hay clientes registrados");
		
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
		
		if(objeto == null)		
		throw new Exception("No existe el carrito con el Id: " + idCarrito);
		
		return objeto;
	}

	public boolean eliminarCarrito(int idCarrito) throws Exception {
						
		return listaCarrito.remove(traerCarrito(idCarrito)); //Remueve por objeto - se puede por index		
	}
}