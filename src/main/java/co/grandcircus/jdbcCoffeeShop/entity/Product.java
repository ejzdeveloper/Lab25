package co.grandcircus.jdbcCoffeeShop.entity;

public class Product {
	
	private Long id;
	private String name;
	private String descripcion;
	private double price;
	
	public Product() {}
	
	public Product(Long id, String name, String descripcion, double price) {
		super();
		this.id = id;
		this.name = name;
		this.descripcion = descripcion;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", descripcion=" + descripcion + ", price=" + price + "]";
	}
	
	
}//end class
