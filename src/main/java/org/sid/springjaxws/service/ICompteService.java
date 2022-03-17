package org.sid.springjaxws.service;

import org.sid.springjaxws.entities.Compte;

import java.util.List;

public interface ICompteService {

    Compte addCompte(double soldeinitiale);
    Compte getCompte(Long id);
    List<Compte> listComptes();
    void verser(Long code, double mt);
    void retirer(Long code, double mt);
    void virement(Long c1,Long c2,double mt);

}
