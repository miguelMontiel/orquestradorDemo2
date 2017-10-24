package rfcContratante;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "eventos_rfcContratante")
public class EventosrfcContratante 
{    
    private String eventosReglasID_rfcContratante;
    private int eventosReglasTotales_rfcContratante;

    @XmlElement
    public String getEventosReglasID_rfcContratante() 
    {
        return eventosReglasID_rfcContratante;
    }
    public void setEventosReglasID_rfcContratante(String eventosReglasID_rfcContratante) 
    {
        this.eventosReglasID_rfcContratante = eventosReglasID_rfcContratante;
    }

    @XmlElement
    public int getEventosReglasTotales_rfcContratante() 
    {
        return eventosReglasTotales_rfcContratante;
    }
    public void setEventosReglasTotales_rfcContratante(int eventosReglasTotales_rfcContratante) 
    {
        this.eventosReglasTotales_rfcContratante = eventosReglasTotales_rfcContratante;
    }
    
    public EventosrfcContratante(String eventosReglasID_rfcContratante, int eventosReglasTotales_rfcContratante)
    {
        super();
        this.eventosReglasID_rfcContratante = eventosReglasID_rfcContratante;
        this.eventosReglasTotales_rfcContratante = eventosReglasTotales_rfcContratante;
    }
    public EventosrfcContratante()
    {
        super();
    }
}
