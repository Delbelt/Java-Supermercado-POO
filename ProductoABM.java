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
		int id = 1;
		Producto objeto = null;		

		for (i = 0; i < listaProducto.size(); i++) 
		{
			if (listaProducto.get(i).getProducto() == producto)
			{					
				throw new Exception("El producto '" + producto + "' ya esta registrado");		
			}
		}
		
		if (listaProducto.size() > 0)
		{
			id = listaProducto.get(listaProducto.size()-1).getIdProducto()+1;
		}
		
			objeto = new Producto(id, producto, precio);
	
		
			return listaProducto.add(objeto);
	}
	
	public Producto traerProducto(int idProducto) throws Exception	{
		
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
		
		return objeto;
	}
	
	public boolean modificarProducto(int idProducto, String producto, float precio) throws Exception {
		//AGREGAR QUE SI HAY PRODUCTOS EN UN CARRITO NO SE PUEDA MODIFICAR
		Producto objeto = traerProducto(idProducto);
		
		if(objeto == null)		
		throw new Exception("No existe producto con el Id: " + idProducto);
		
		objeto.setProducto(producto);
		objeto.setPrecio(precio);
		
		return true;	
	}
	
	public boolean eliminarProducto(int idProducto) throws Exception {
		
		return listaProducto.remove(traerProducto(idProducto)); //Remueve por objeto - se puede por index		
	}
}