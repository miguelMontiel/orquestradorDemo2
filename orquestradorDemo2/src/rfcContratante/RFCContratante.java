package rfcContratante;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rfcContratante")
public class RFCContratante 
{    
    private String id_rfcContratante;
    private List<EventosrfcContratante> eventosrfccontratente = new ArrayList<EventosrfcContratante>();

    @XmlElement
    public String getId_rfcContratante() 
    {
        return id_rfcContratante;
    }
    public void setId_rfcContratante(String id_rfcContratante) 
    {
        this.id_rfcContratante = id_rfcContratante;
    }

    @XmlElement(name = "eventos_rfcContratante")
    public List<EventosrfcContratante> getEventosrfccontratente() 
    {
        return eventosrfccontratente;
    }
    public void setEventosrfccontratente(List<EventosrfcContratante> eventosrfccontratente) 
    {
        this.eventosrfccontratente = eventosrfccontratente;
    }
    
    public RFCContratante(String id_rfcContratante)
    {
        super();
        this.id_rfcContratante = id_rfcContratante;
    }
    public RFCContratante()
    {
        super();
    }
}
