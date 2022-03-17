package org.sid.springjaxws;

import org.sid.springjaxws.entities.Compte;
import org.sid.springjaxws.repository.CompteRepository;
import org.sid.springjaxws.service.ICompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class SpringJaxWsApplication implements CommandLineRunner {
    @Autowired
    private ICompteService compteService;
    public static void main(String[] args) {
        SpringApplication.run(SpringJaxWsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
     compteService.addCompte(1200);
     compteService.addCompte(9000);

     compteService.verser(1l,4000);
     compteService.retirer(2l,2000);

     compteService.virement(1l,2l,5000);

        System.out.println(compteService.getCompte(1l));
        System.out.println(compteService.getCompte(2l));

    }
}
