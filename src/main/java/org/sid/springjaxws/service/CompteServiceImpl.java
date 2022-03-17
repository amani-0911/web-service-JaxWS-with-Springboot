package org.sid.springjaxws.service;

import lombok.AllArgsConstructor;
import org.sid.springjaxws.entities.Compte;
import org.sid.springjaxws.repository.CompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
@Transactional
public class CompteServiceImpl implements ICompteService {

   private final CompteRepository compteRepository;


    @Override
    public Compte addCompte(double soldeinitiale) {

        return compteRepository.save(new Compte(null,soldeinitiale,new Date(),true));
    }

    @Override
    public Compte getCompte(Long id) {
        return compteRepository.findById(id).get();
    }

    @Override
    public List<Compte> listComptes() {

     return compteRepository.findAll();
    }

    @Override
    public void verser(Long code, double mt) {
     Compte compte=compteRepository.findById(code).get();
     compte.setSolde(compte.getSolde()+mt);
     compteRepository.save(compte);

    }

    @Override
    public void retirer(Long code, double mt) {
     Compte compte=compteRepository.findById(code).get();
     if (compte.getSolde()<mt) throw new RuntimeException("Solde insuffisant");
     compte.setSolde(compte.getSolde()-mt);
     compteRepository.save(compte);

    }

    @Override
    public void virement(Long c1, Long c2, double mt) {
    retirer(c1,mt);
    verser(c2,c2);
    }
}
