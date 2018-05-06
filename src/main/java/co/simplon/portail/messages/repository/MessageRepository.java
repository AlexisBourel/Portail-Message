package co.simplon.portail.messages.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.simplon.portail.messages.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	@Query(value = "SELECT m FROM Message m WHERE m.tournee.id  = :id") //requete HQL personnalisée pour récupérer les message d'une tournée
	public List<Message> findMeessagesFromTournee(String id);
}
