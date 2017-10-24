package numeroPlaca;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "numeroPlaca")
public class NumeroPlaca 
{
    private String id_numeroPlaca;
    private List<EventosnumeroPlaca> eventos_numeroPlaca = new ArrayList<EventosnumeroPlaca>();

    @XmlElement
    public String getId_numeroPlaca() 
    {
        return id_numeroPlaca;
    }
    public void setId_numeroPlaca(String id_numeroPlaca) 
    {
        this.id_numeroPlaca = id_numeroPlaca;
    }

    @XmlElement(name = "eventos_numeroPlaca")
    public List<EventosnumeroPlaca> getEventos_numeroPlaca() 
    {
        return eventos_numeroPlaca;
    }
    public void setEventos_numeroPlaca(List<EventosnumeroPlaca> eventos_numeroPlaca) 
    {
        this.eventos_numeroPlaca = eventos_numeroPlaca;
    }
    
    public NumeroPlaca(String id_numeroPlaca)
    {
        super();
        this.id_numeroPlaca = id_numeroPlaca;
    }
    public NumeroPlaca()
    {
        super();
    }
}