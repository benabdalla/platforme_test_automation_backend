package com.saphir.platforme.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "action")
public class Action implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long numFiche;
    String source;
    String type;
    String priorite;
    String gravite;
    String resptraitement;
    String respcloture;
    String respSuivi;
    String type_cause;
    String designation;
    String description;
    String site;
    String processus;
    String activite;
    String direction;
    String service;
    String Desi_SA;
    String date_réalisation;
    String taux_réalisation;
    String date_suivi;
    String taux_suivi;
    String date_création;
    String produit;
    String dechlencheur;

    public long getNumFiche() {
        return numFiche;
    }

    public String getSource() {
        return source;
    }

    public String getType() {
        return type;
    }

    public String getPriorite() {
        return priorite;
    }

    public String getGravite() {
        return gravite;
    }

    public String getResptraitement() {
        return resptraitement;
    }

    public String getRespcloture() {
        return respcloture;
    }

    public String getRespSuivi() {
        return respSuivi;
    }



    public String getType_cause() {
        return type_cause;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDescription() {
        return description;
    }

    public String getSite() {
        return site;
    }

    public String getProcessus() {
        return processus;
    }

    public String getActivite() {
        return activite;
    }

    public String getDirection() {
        return direction;
    }

    public String getService() {
        return service;
    }

    public String getDesi_SA() {
        return Desi_SA;
    }

    public String getDate_réalisation() {
        return date_réalisation;
    }

    public String getTaux_réalisation() {
        return taux_réalisation;
    }

    public String getDate_suivi() {
        return date_suivi;
    }

    public String getTaux_suivi() {
        return taux_suivi;
    }

    public String getDate_création() {
        return date_création;
    }

    public String getProduit() {
        return produit;
    }

    public String getDechlencheur() {
        return dechlencheur;
    }

    public void setNumFiche(long numFiche) {
        this.numFiche = numFiche;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    public void setGravite(String gravite) {
        this.gravite = gravite;
    }

    public void setResptraitement(String resptraitement) {
        this.resptraitement = resptraitement;
    }

    public void setRespcloture(String respcloture) {
        this.respcloture = respcloture;
    }

    public void setRespSuivi(String respSuivi) {
        this.respSuivi = respSuivi;
    }



    public void setType_cause(String type_cause) {
        this.type_cause = type_cause;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setProcessus(String processus) {
        this.processus = processus;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setDesi_SA(String desi_SA) {
        Desi_SA = desi_SA;
    }

    public void setDate_réalisation(String date_réalisation) {
        this.date_réalisation = date_réalisation;
    }

    public void setTaux_réalisation(String taux_réalisation) {
        this.taux_réalisation = taux_réalisation;
    }

    public void setDate_suivi(String date_suivi) {
        this.date_suivi = date_suivi;
    }

    public void setTaux_suivi(String taux_suivi) {
        this.taux_suivi = taux_suivi;
    }

    public void setDate_création(String date_création) {
        this.date_création = date_création;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public void setDechlencheur(String dechlencheur) {
        this.dechlencheur = dechlencheur;
    }
}
