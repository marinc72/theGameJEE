/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

/**
 *
 * @author marin
 */
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class MissionsView implements Serializable{
    
    private List<Missions> missions;
    private Missions selectedMission;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    
    @PostConstruct
    public void init() {
        missions = new ArrayList<Missions>();
        missions.add(new Missions(1, 0, date, 1));
        missions.add(new Missions(2, 0, date, 2));
        missions.add(new Missions(3, 0, date, 3));
    }
 
    public List<Missions> getMissions() {
        return missions;
    }
 
    public void setMissions(List<Missions> missions) {
        this.missions = missions;
    }
 
    public Missions getSelectedMission() {
        return selectedMission;
    }
 
    public void setSelectedMission(Missions selectedMissions) {
        this.selectedMission = selectedMissions;
    }
    
    public String missionDifficulty(int id){
        switch (id) {
            case 1:
                return "Facile";
            case 2:
                return "Moyen";
            default:
                return "Dur";
        }
    }
    
        public String missionLenght(int id){
        switch (id) {
            case 1:
                return "30min";
            case 2:
                return "1h30";
            default:
                return "4h";
        }
    }
        
        public String missionEXP(int id){
        switch (id) {
            case 1:
                return "30 EXP";
            case 2:
                return "120 EXP";
            default:
                return "350 EXP";
        }            
            
        }
}
