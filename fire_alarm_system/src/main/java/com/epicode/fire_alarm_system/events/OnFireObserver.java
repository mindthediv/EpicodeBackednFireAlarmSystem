package com.epicode.fire_alarm_system.events;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import com.epicode.fire_alarm_system.models.Feeler;
import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class OnFireObserver implements ApplicationListener<OnFireEvent> {
    private WebClient webClient;
    String baseUrl = "http://localhost:8080/alarm"; // avrei voluto attingerne da application.properties ma non funziona mai (nè con @value nè altro)    

    @Override
    public void onApplicationEvent(OnFireEvent event) {
     
        Feeler f = event.getFeeler();
        if(f.getSmokeLevel() > 5){
            log.warn("ATTENZIONE PERICOLO! RILEVATO INCENDIO NELLA STRUTTURA, AVVIO CHIAMATA D'EMERGENZA STAZIONE POMPIERI");
            //preparo lo uri 
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
            .queryParam("feeler-id",f.getId())
            .queryParam("lat", f.getLat())
            .queryParam("lon", f.getLon())
            .queryParam("smokelevel", f.getSmokeLevel());
            String uri = uriBuilder.toUriString();
            //effettuo la chiamata
            String response = webClient.get()
            .uri(uri)
            .retrieve()
            .bodyToMono(String.class)
            .block();
            //stampo la risposta
            log.info(response);
        }
        throw new UnsupportedOperationException("Observable exc");
    }
 
}
