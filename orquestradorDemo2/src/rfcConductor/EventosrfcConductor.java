package rfcConductor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "eventos_rfcConductor")
public class EventosrfcConductor 
{
    private String eventosReglasID_rfcConductor;
    private int eventosReglasTotales_rfcConductor;

    @XmlElement
    public String getEventosReglasID_rfcConductor() 
    {
        return eventosReglasID_rfcConductor;
    }
    public void setEventosReglasID_rfcConductor(String eventosReglasID_rfcConductor) 
    {
        this.eventosReglasID_rfcConductor = eventosReglasID_rfcConductor;
    }

    @XmlElement
    public int getEventosReglasTotales_rfcConductor() 
    {
        return eventosReglasTotales_rfcConductor;
    }
    public void setEventosReglasTotales_rfcConductor(int eventosReglasTotales_rfcConductor) 
    {
        this.eventosReglasTotales_rfcConductor = eventosReglasTotales_rfcConductor;
    }
    
    public EventosrfcConductor(String eventosReglasID_rfcConductor, int eventosReglasTotales_rfcConductor)
    {
        super();
        this.eventosReglasID_rfcConductor = eventosReglasID_rfcConductor;
        this.eventosReglasTotales_rfcConductor = eventosReglasTotales_rfcConductor;
    }
    public EventosrfcConductor()
    {
        super();
    }
}