/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marin
 */
@Entity
@Table(name = "missions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Missions.findAll", query = "SELECT m FROM Missions m")
    , @NamedQuery(name = "Missions.findById", query = "SELECT m FROM Missions m WHERE m.id = :id")
    , @NamedQuery(name = "Missions.findByIdUser", query = "SELECT m FROM Missions m WHERE m.idUser = :idUser")
    , @NamedQuery(name = "Missions.findByTemps", query = "SELECT m FROM Missions m WHERE m.temps = :temps")
    , @NamedQuery(name = "Missions.findByType", query = "SELECT m FROM Missions m WHERE m.type = :type")})
public class Missions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUser")
    private int idUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temps")
//    @Temporal(TemporalType.DATE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date temps;  
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private int type;

    public Missions() {
    }

    public Missions(Integer id) {
        this.id = id;
    }
    
    public Missions(int idUser, Date temps, int type) {
        this.idUser = idUser;
        this.temps = temps;
        this.type = type;
    }

    public Missions(Integer id, int idUser, Date temps, int type) {
        this.id = id;
        this.idUser = idUser;
        this.temps = temps;
        this.type = type;
    }
    
    
    public String displayDateF(Date dateF){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'à' HH'h'mm");
        String dateDisplaying = formatter.format(dateF);
        return dateDisplaying;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getTemps() {
        return temps;
    }

    public void setTemps(Date temps) {
        this.temps = temps;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Missions)) {
            return false;
        }
        Missions other = (Missions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Missions[ id=" + id + " ]";
    }
    
}
