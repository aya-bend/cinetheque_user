package com.example.cinetheque_users;

import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private UserService userService; // Service EJB pour les opérations utilisateur

    private List<CD> cdDisponibles;
    private List<Emprunt> empruntsUtilisateur;

    private Long cdId;

    @PostConstruct
    public void init() {
        // Charger les CD disponibles au démarrage
        cdDisponibles = userService.listerCDsDisponibles();
    }

    public List<CD> getCdDisponibles() {
        return cdDisponibles;
    }

    public List<Emprunt> getEmpruntsUtilisateur() {
        return empruntsUtilisateur;
    }

    public void emprunterCD() {
        userService.emprunterCD(cdId, "utilisateur1"); // Ici l'utilisateur est en dur pour l'exemple
        cdDisponibles = userService.listerCDsDisponibles(); // Rafraîchir la liste des CD disponibles
    }

    public void voirEmprunts() {
        empruntsUtilisateur = userService.voirEmprunts("utilisateur1");
    }

    public void retournerCD(Long empruntId) {
        userService.retournerCD(empruntId);
        voirEmprunts(); // Rafraîchir la liste des emprunts
    }

    // Getters et Setters
    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }
}