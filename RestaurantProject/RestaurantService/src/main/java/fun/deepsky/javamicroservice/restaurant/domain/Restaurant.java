package fun.deepsky.javamicroservice.restaurant.domain;

import java.util.List;

public class Restaurant extends BaseEntity<String>{

	private List<Table> tables;
	private String address; 
	
	public Restaurant(String name,String id,String address,List<Table> tables) {
		super(id, name);
		this.tables = tables;
		this.address = address;
	}
	
    public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
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
