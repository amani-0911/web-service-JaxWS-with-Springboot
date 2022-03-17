package org.sid.springjaxws.repository;

import org.sid.springjaxws.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte,Long> {

}
