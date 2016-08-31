package application.repositories.clientrepository;

import application.model.entities.Client;

/**
 * Created by MSI on 05.06.2016.
 */

public interface UsersRepository// extends CrudRepository<Client, Integer>, JpaSpecificationExecutor<Client>
 {
     Client findByName(String userName);
 }
