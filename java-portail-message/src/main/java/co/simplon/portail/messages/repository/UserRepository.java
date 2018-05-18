package co.simplon.portail.messages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.simplon.portail.messages.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "SELECT u FROM User u WHERE u.matricule  = :matricule") 
	//requete HQL personnalisée pour récupérer un user via son matricule
	public User getOneByMatricule(String matricule);
	
}
