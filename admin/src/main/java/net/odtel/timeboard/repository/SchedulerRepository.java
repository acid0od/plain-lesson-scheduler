/*
 * Author: Alexander Ievstratiev
 * Created: 04/23/2018  6:23 PM
 */
package net.odtel.timeboard.repository;

import net.odtel.timeboard.model.Scheduler;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SchedulerRepository extends CrudRepository<Scheduler, UUID> {

/*    @Query("Select * from customer where firstname=?0")
    public Customer findByFirstName(String firstName);

    @Query("Select * from customer where lastname=?0")
    public List<Customer> findByLastName(String lastName);*/
}
