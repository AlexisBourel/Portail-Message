package co.simplon.portail.messages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.portail.messages.model.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	
}
