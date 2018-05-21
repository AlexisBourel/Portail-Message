package co.simplon.portail.message.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.portail.message.model.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long>{

}
