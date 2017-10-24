package numeroSerie;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "eventos_numeroSerie")
public class EventosnumeroSerie 
{    
    private String eventosReglasID_numeroSerie;
    private int eventosReglasTotales_numeroSerie;

    @XmlElement
    public String getEventosReglasID_numeroSerie() 
    {
        return eventosReglasID_numeroSerie;
    }
    public void setEventosReglasID_numeroSerie(String eventosReglasID_numeroSerie) 
    {
        this.eventosReglasID_numeroSerie = eventosReglasID_numeroSerie;
    }

    @XmlElement
    public int getEventosReglasTotales_numeroSerie() 
    {
        return eventosReglasTotales_numeroSerie;
    }
    public void setEventosReglasTotales_numeroSerie(int eventosReglasTotales_numeroSerie) 
    {
        this.eventosReglasTotales_numeroSerie = eventosReglasTotales_numeroSerie;
    }
    
    public EventosnumeroSerie(String eventosReglasID_numeroSerie, int eventosReglasTotales_numeroSerie)
    {
        super();
        this.eventosReglasID_numeroSerie = eventosReglasID_numeroSerie;
        this.eventosReglasTotales_numeroSerie = eventosReglasTotales_numeroSerie;
    }
    public EventosnumeroSerie()
    {
        super();
    }
}
