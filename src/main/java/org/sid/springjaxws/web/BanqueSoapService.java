package org.sid.springjaxws.web;

import org.sid.springjaxws.entities.Compte;
import org.sid.springjaxws.service.ICompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@WebService(serviceName = "BanqueWS")
public class BanqueSoapService {

    @Autowired
    private ICompteService compteService;

    @WebMethod
    public Compte getCompte(@WebParam(name = "code") Long code){
        return compteService.getCompte(code);

    }
    @WebMethod
    public List<Compte> listComptes(){
        return compteService.listComptes();
    }
    @WebMethod
    public Compte versement(@WebParam(name = "code") Long code, @WebParam(name = "montant")double montant){
        compteService.verser(code,montant);
        return compteService.getCompte(code);
    }
    @WebMethod
    public Compte reterait(@WebParam(name = "code") Long code, @WebParam(name = "montant")double montant){
        compteService.retirer(code,montant);
        return compteService.getCompte(code);
    }
    @WebMethod
    public List<Compte> viremnet(@WebParam(name = "sourceCompte") Long c1, @WebParam(name = "destinationCompte")Long c2, @WebParam(name = "montant")double montant){
        compteService.virement(c1,c2,montant);
        List<Compte> comptes=new ArrayList<>();
        comptes.add(compteService.getCompte(c1));
        comptes.add(compteService.getCompte(c2));


        return comptes;
    }


}
