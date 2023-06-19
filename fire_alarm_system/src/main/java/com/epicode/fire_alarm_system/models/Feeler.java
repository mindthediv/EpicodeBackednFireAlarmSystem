package com.epicode.fire_alarm_system.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.epicode.fire_alarm_system.events.OnFireEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
// @Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Feeler {
    long id;
    int smokeLevel = 0;
    double lat;
    double lon;

    @Autowired 
    private ApplicationEventPublisher aep;

    public Feeler(long id, int smokeLevel, double lat, double lon) {
        this.id = id;
        this.smokeLevel = smokeLevel;
        this.lat = lat;
        this.lon = lon;
    }

    public void setSmokeLevel(int sl) {
        this.smokeLevel = sl;
        if(this.smokeLevel > 5){
        OnFireEvent event = new OnFireEvent(this);
        aep.publishEvent(event);
        }
    }
    //comm
}
