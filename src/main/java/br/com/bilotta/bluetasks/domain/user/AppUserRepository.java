package br.com.bilotta.bluetasks.domain.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(exported = false)//este recurso não permite a exposição da classe via webservice
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

	AppUser findByUsername(String username);
	
}
