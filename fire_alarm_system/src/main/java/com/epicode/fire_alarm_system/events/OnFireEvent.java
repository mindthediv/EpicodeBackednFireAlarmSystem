package com.epicode.fire_alarm_system.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import com.epicode.fire_alarm_system.models.Feeler;

import lombok.Getter;

@Getter
@Component
public class OnFireEvent extends ApplicationEvent {
    private Feeler feeler;
    public OnFireEvent(Feeler f) {
        super(f);
        this.feeler = f;
    }
    
}
