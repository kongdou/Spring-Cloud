package fun.deepsky.javamicroservice.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import fun.deepsky.javamicroservice.user.domain.Entity;
import fun.deepsky.javamicroservice.user.domain.User;


public interface UserService {

    /**
     *
     * @param booking
     * @throws Exception
     */
    public void add(User user) throws Exception;

    /**
     *
     * @param booking
     * @throws Exception
     */
    public void update(User user) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Entity findById(String id) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<User> findByName(String name) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<User> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
