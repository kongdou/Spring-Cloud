package fun.deepsky.javamicroservice.book.domain;

public abstract class BaseEntity<T> extends Entity<T> {

private boolean isModified;
	
	public BaseEntity(T id,String name) {
		this.id = id;
		this.name = name;
		isModified = false;
	}
	
    /**
    *
    * @return
    */
   public boolean isIsModified() {
       return isModified;
   }
}
