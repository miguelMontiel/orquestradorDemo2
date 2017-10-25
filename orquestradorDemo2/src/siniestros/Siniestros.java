package siniestros;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import numeroPlaca.NumeroPlaca;
import numeroSerie.NumeroSerie;
import rfcConductor.RFCConductor;
import rfcContratante.RFCContratante;

@XmlRootElement(name = "siniestro")
//@XmlType(propOrder = {"tipoVehiculo", "usoVehiculo", "numeroPlaca", "numeroSerie", "rfcContratante", "rfcConductor"})
public class Siniestros 
{	
    private String tipoVehiculo;
    private int usoVehiculo;
    private String tipoSiniestro;
    private List<NumeroPlaca> numeroPlaca = new ArrayList<NumeroPlaca>();
    private List<NumeroSerie> numeroSerie = new ArrayList<NumeroSerie>();
    private List<RFCContratante> rfcContratante = new ArrayList<RFCContratante>();
    private List<RFCConductor> rfcConductor = new ArrayList<RFCConductor>();
    
    @XmlElement
    public String getTipoVehiculo() 
    {
        return tipoVehiculo;
    }
    public void setTipoVehiculo(String tipoVehiculo) 
    {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    @XmlElement
    public int getUsoVehiculo() 
    {
        return usoVehiculo;
    }
    public void setUsoVehiculo(int usoVehiculo) 
    {
        this.usoVehiculo = usoVehiculo;
    }
    
    @XmlElement
    public String getTipoSiniestro() 
    {
        return tipoSiniestro;
    }
    public void setTipoSiniestro(String tipoSiniestro) 
    {
        this.tipoSiniestro = tipoSiniestro;
    }
    @XmlElement(name = "numeroPlaca")
    public List<NumeroPlaca> getNumeroPlaca()
    {
        return numeroPlaca;
    }
    public void setNumeroPlaca(List<NumeroPlaca> numeroPlaca)
    {
        this.numeroPlaca = numeroPlaca;
    }

    @XmlElement(name = "numeroSerie")
    public List<NumeroSerie> getNumeroSerie() 
    {
        return numeroSerie;
    }
    public void setNumeroSerie(List<NumeroSerie> numeroSerie)
    {
        this.numeroSerie = numeroSerie;
    }

    @XmlElement(name = "rfcContratante")
    public List<RFCContratante> getRfcContratante() 
    {
        return rfcContratante;
    }
    public void setRfcContratante(List<RFCContratante> rfcContratante) 
    {
        this.rfcContratante = rfcContratante;
    }

    @XmlElement(name = "rfcConductor")
    public List<RFCConductor> getRfcConductor()
    {
        return rfcConductor;
    }
    public void setRfcConductor(List<RFCConductor> rfcConductor)
    {
        this.rfcConductor = rfcConductor;
    }
}