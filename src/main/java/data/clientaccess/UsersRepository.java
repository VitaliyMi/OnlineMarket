package data.clientaccess;

import model.Client;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MSI on 05.06.2016.
 */

@Repository
public interface UsersRepository extends CrudRepository<Client, Integer>, JpaSpecificationExecutor<Client>
 {
    Client findByName(String userName);

}
