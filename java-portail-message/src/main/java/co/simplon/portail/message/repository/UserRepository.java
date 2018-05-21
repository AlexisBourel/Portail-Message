package co.simplon.portail.message.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.simplon.portail.message.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "SELECT u FROM User u WHERE u.matricule  = :matricule") 
	//requete HQL personnalisée pour récupérer un user via son matricule
	public Optional<User> getOneByMatricule(@Param("matricule") String matricule);
	
}
