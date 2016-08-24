package application.repositories.clientRepository;

import application.model.entities.Client;

/**
 * Created by MSI on 05.06.2016.
 */

//@Repository
public interface UsersRepository// extends CrudRepository<Client, Integer>, JpaSpecificationExecutor<Client>
 {
     Client findByName(String userName);
 }
