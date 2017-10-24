package numeroSerie;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "numeroSerie")
public class NumeroSerie 
{    
    private String id_numeroSerie;
    private List<EventosnumeroSerie> eventos_numeroSerie = new ArrayList<EventosnumeroSerie>();

    @XmlElement
    public String getId_numeroSerie()
    {
        return id_numeroSerie;
    }
    public void setId_numeroSerie(String id_numeroSerie) 
    {
        this.id_numeroSerie = id_numeroSerie;
    }
    
    @XmlElement(name = "eventos_numeroSerie")
    public List<EventosnumeroSerie> getEventos_numeroSerie() 
    {
        return eventos_numeroSerie;
    }
    public void setEventos_numeroSerie(List<EventosnumeroSerie> eventos_numeroSerie) 
    {
        this.eventos_numeroSerie = eventos_numeroSerie;
    }
    
    public NumeroSerie(String id_numeroSerie)
    {
        super();
        this.id_numeroSerie = id_numeroSerie;
    }
    public NumeroSerie()
    {
        super();
    }
}