/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marin
 */
@Entity
@Table(name = "personnage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personnage.findAll", query = "SELECT p FROM Personnage p")
    , @NamedQuery(name = "Personnage.findByIdPerso", query = "SELECT p FROM Personnage p WHERE p.idPerso = :idPerso")
    , @NamedQuery(name = "Personnage.findByIdUsr", query = "SELECT p FROM Personnage p WHERE p.idUsr = :idUsr")
    , @NamedQuery(name = "Personnage.findByLevel", query = "SELECT p FROM Personnage p WHERE p.level = :level")
    , @NamedQuery(name = "Personnage.findByExperience", query = "SELECT p FROM Personnage p WHERE p.experience = :experience")})
public class Personnage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPerso")
    private Integer idPerso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsr")
    private int idUsr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "level")
    private int level;
    @Basic(optional = false)
    @NotNull
    @Column(name = "experience")
    private int experience;
    private PersonnageCtrl ctrl;
    public Personnage() {
    }

    public Personnage(Integer idPerso) {
        this.idPerso = idPerso;
    }

    public Personnage(Integer idPerso, int idUsr, int level, int experience) {
        this.idPerso = idPerso;
        this.idUsr = idUsr;
        this.level = level;
        this.experience = experience;
    }


    
    public Integer getIdPerso() {
        return idPerso;
    }

    public void setIdPerso(Integer idPerso) {
        this.idPerso = idPerso;
    }

    public int getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(int idUsr) {
        this.idUsr = idUsr;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerso != null ? idPerso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personnage)) {
            return false;
        }
        Personnage other = (Personnage) object;
        if ((this.idPerso == null && other.idPerso != null) || (this.idPerso != null && !this.idPerso.equals(other.idPerso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Personnage[ idPerso=" + idPerso + " ]";
    }
    
}
