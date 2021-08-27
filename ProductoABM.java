package supermercado;

import java.util.ArrayList;
import java.util.List;

public class ProductoABM {
	
	private List <Producto> listaProducto = new ArrayList<Producto>();

	public ProductoABM() {
		super();
	}

	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	@Override
	public String toString() {
		return "ProductoABM [listaProducto=" + listaProducto + "]";
	}
	
	public boolean agregarProducto(String producto, float precio) throws Exception {
		//COMPROBAR SI EL PRECIO INGRESADO ES POSITIVO
		int i = 0;
		Producto lista = null;		

		for (i = 0; i < listaProducto.size(); i++) 
		{
			if (listaProducto.get(i).getProducto() == producto)
			{					
				throw new Exception("El producto '" + producto + "' ya esta registrado");		
			}
		}
		
		if(listaProducto.size() == 0)
		{
			lista = new Producto(1, producto, precio);
		}
		
		else 
		{
			lista = new Producto(listaProducto.get(listaProducto.size()-1).getIdProducto()+1, producto, precio);
		}
		
			return listaProducto.add(lista);
	}
	
	public Producto traerProducto(int idProducto) throws Exception	{
		
		if(listaProducto.size() == 0)		
		throw new Exception("No hay productos en las gondolas");
		
		int i = 0;
		Producto objeto = null;

		while(objeto == null && i < listaProducto.size())
		{
			if (listaProducto.get(i).getIdProducto() == idProducto)
			{		
				objeto = listaProducto.get(i);					
			}
			
			i++;
		}
		
		if(objeto == null)		
		throw new Exception("No existe producto con el Id: " + idProducto);
		
		return objeto;
	}
	
	public boolean modificarProducto(int idProducto, String producto, float precio) throws Exception {
		//AGREGAR QUE SI HAY PRODUCTOS EN UN CARRITO NO SE PUEDA MODIFICAR
		Producto objeto = traerProducto(idProducto);
		
		objeto.setProducto(producto);
		objeto.setPrecio(precio);
		
		return true;	
	}
	
	public boolean eliminarProducto(int idProducto) throws Exception {
				
		return listaProducto.remove(traerProducto(idProducto)); //Remueve por objeto - se puede por index		
	}
}
