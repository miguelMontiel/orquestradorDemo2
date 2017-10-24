package numeroPlaca;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "eventos_numeroPlaca")
public class EventosnumeroPlaca 
{
    private String eventosReglasID_numeroPlaca;
    private int eventosReglasTotales_numeroPlaca;

    @XmlElement
    public String getEventosReglasID_numeroPlaca() 
    {
        return eventosReglasID_numeroPlaca;
    }
    public void setEventosReglasID_numeroPlaca(String eventosReglasID_numeroPlaca) 
    {
        this.eventosReglasID_numeroPlaca = eventosReglasID_numeroPlaca;
    }

    @XmlElement
    public int getEventosReglasTotales_numeroPlaca() 
    {
        return eventosReglasTotales_numeroPlaca;
    }
    public void setEventosReglasTotales_numeroPlaca(int eventosReglasTotales_numeroPlaca) 
    {
        this.eventosReglasTotales_numeroPlaca = eventosReglasTotales_numeroPlaca;
    }
    
    public EventosnumeroPlaca(String eventosReglasID_numeroPlaca, int eventosReglasTotales_numeroPlaca)
    {
        super();
        this.eventosReglasID_numeroPlaca = eventosReglasID_numeroPlaca;
        this.eventosReglasTotales_numeroPlaca = eventosReglasTotales_numeroPlaca;
    }
    public EventosnumeroPlaca()
    {
        super();
    }
}
