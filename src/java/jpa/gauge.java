/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.chart.MeterGaugeChartModel;

/**
 *
 * @author marin
 */
@Named(value="barxp")
@ManagedBean
@SessionScoped
public class gauge implements Serializable{
    private MeterGaugeChartModel meterGaugeModel2;
    
    @PostConstruct
    public void init() {
        createMeterGaugeModels();
    }
    
    public MeterGaugeChartModel getMeterGaugeModel2() {
        return meterGaugeModel2;
    }
    
    private MeterGaugeChartModel initMeterGaugeModel() {
        List<Number> intervals = new ArrayList<Number>(){{
            add(20);
            add(50);
            add(120);
            add(220);
        }};    
        return new MeterGaugeChartModel(140, intervals);
    }
    
    private void createMeterGaugeModels() {
 
        meterGaugeModel2 = initMeterGaugeModel();
        meterGaugeModel2.setTitle("Experience bar");
        meterGaugeModel2.setSeriesColors("66cc66,93b75f,E7E658,cc6666");
        meterGaugeModel2.setGaugeLabel("experience");
        meterGaugeModel2.setShowTickLabels(false);
        meterGaugeModel2.setLabelHeightAdjust(110);
        meterGaugeModel2.setIntervalOuterRadius(100);
    }
    
}
