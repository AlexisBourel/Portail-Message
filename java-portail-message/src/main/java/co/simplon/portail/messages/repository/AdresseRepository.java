package co.simplon.portail.messages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.portail.messages.model.Adresse;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long>{

}
