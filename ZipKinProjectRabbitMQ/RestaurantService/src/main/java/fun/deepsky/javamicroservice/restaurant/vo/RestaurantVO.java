package fun.deepsky.javamicroservice.restaurant.vo;

import java.util.ArrayList;
import java.util.List;

import fun.deepsky.javamicroservice.restaurant.domain.Table;

public class RestaurantVO {

	private List<Table> tables = new ArrayList<>();
	private String id;
	private String name;
	private String address;
	
	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
    public String toString() {
        return new StringBuilder("{id: ").append(id).append(", name: ")
                .append(name).append(", address: ").append(address).
                append(", tables: ").append(tables).append("}").toString();
    }
	
}
