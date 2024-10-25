package com.example.cinetheque_users;

import java.util.List;

public interface UserService {
    List<CD> listerCDsDisponibles();
    void emprunterCD(Long cdId, String utilisateur);
    List<Emprunt> voirEmprunts(String utilisateur);
    void retournerCD(Long empruntId);
}