package fun.deepsky.javamicroservice.book.repository;

import java.util.Collection;

import fun.deepsky.javamicroservice.book.domain.Booking;

public interface BookingRepository<Booking,String> extends Repository<Booking,String> {

	 /**
    *
    * @param name
    * @return
    */
   boolean containsName(String name);

   /**
    *
    * @param name
    * @return
    * @throws Exception
    */
   public Collection<Booking> findByName(String name) throws Exception;
}
