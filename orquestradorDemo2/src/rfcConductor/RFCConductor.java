package rfcConductor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rfcConductor")
public class RFCConductor 
{
    private String id_rfcConductor;
    private List<EventosrfcConductor> eventosrfcconductor = new ArrayList<EventosrfcConductor>();

    @XmlElement
    public String getId_rfcConductor() 
    {
        return id_rfcConductor;
    }
    public void setId_rfcConductor(String id_rfcConductor) 
    {
        this.id_rfcConductor = id_rfcConductor;
    }

    @XmlElement(name = "eventos_rfcConductor")
    public List<EventosrfcConductor> getEventosrfcconductor() 
    {
        return eventosrfcconductor;
    }
    public void setEventosrfcconductor(List<EventosrfcConductor> eventosrfcconductor) 
    {
        this.eventosrfcconductor = eventosrfcconductor;
    }
    
    public RFCConductor(String id_rfcConductor)
    {
        super();
        this.id_rfcConductor = id_rfcConductor;
    }
    public RFCConductor()
    {
        super();
    }
}
