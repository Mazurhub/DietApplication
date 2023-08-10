package com.example.demo.persondetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonDetailsRepository extends JpaRepository<PersonDetailsEntity, UUID> {
    @Query("SELECT pd FROM PersonDetailsEntity pd WHERE pd.id = ?1")
    PersonDetailsEntity findPersonById(UUID id);

    //W powyższym przykładzie używamy adnotacji
    // @Query do zdefiniowania zapytania, które wyszuka osobę na podstawie id.
    // To pozwoli uniknąć konfliktu z metodą findById(ID) w CrudRepository
}
