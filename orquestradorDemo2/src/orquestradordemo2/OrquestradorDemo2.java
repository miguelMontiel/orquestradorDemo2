package orquestradordemo2;

import numeroPlaca.EventosnumeroPlaca;
import numeroSerie.EventosnumeroSerie;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import siniestros.Siniestros;
import numeroPlaca.NumeroPlaca;
import numeroSerie.NumeroSerie;
import rfcConductor.EventosrfcConductor;
import rfcConductor.RFCConductor;
import rfcContratante.EventosrfcContratante;
import rfcContratante.RFCContratante;

public class OrquestradorDemo2 
{
    public static void main(String[] args) 
    {
        try
        {            
            JFileChooser jfilechooser = new JFileChooser();
            FileNameExtensionFilter filenameextensionfilter = new FileNameExtensionFilter("Archivos XML", "xml");
            jfilechooser.setFileFilter(filenameextensionfilter);
            int seleccionado = jfilechooser.showOpenDialog(null);
            String archivoSeleccionado = jfilechooser.getSelectedFile().getAbsolutePath();

            File file = new File(archivoSeleccionado);

            if(seleccionado == JFileChooser.APPROVE_OPTION)
            {
                System.out.println("El archivo seleccionado es: " + jfilechooser.getSelectedFile().getName() + "\n");
            }

            JAXBContext jaxbcontext = JAXBContext.newInstance(Siniestros.class);
            Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
            Siniestros siniestros = (Siniestros) unmarshaller.unmarshal(file);
            
            Boolean h01 = false, h07 = false;
            String[] claveUsoVehiculo = {"", "Particular", "Privado", "", "Transporte Público", "Renta Diaria", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Chofer Privado"};
            
            if(siniestros.getTipoSiniestro().equals(""))
            {
                if(siniestros.getTipoVehiculo().equals("AUT")  || siniestros.getTipoVehiculo().equals("CA1"))
                {
                    if(siniestros.getUsoVehiculo() == 01 || siniestros.getUsoVehiculo() == 02 || siniestros.getUsoVehiculo() == 04 || siniestros.getUsoVehiculo() == 05 ||siniestros.getUsoVehiculo() == 23)
                    {
                        System.out.println("Entra a H01! \n");
                        System.out.println("Tipo de Vehiculo: " + siniestros.getTipoVehiculo());
                        System.out.println("Uso del Vehiculo: " + siniestros.getUsoVehiculo() + " - " + claveUsoVehiculo[siniestros.getUsoVehiculo()] + "\n");

                        h01 = true;
                    }
                }
            }
            else if(siniestros.getTipoSiniestro().toLowerCase().equals("robo"))
            {
            	System.out.println("Entra a H07! \n");
            	System.out.println("Tipo de Siniestro: " + siniestros.getTipoSiniestro());
            	
            	h07 = true;
            }
            
            for(NumeroPlaca numeroplaca : siniestros.getNumeroPlaca())
            {
                for(EventosnumeroPlaca eventosnumeroplaca : numeroplaca.getEventos_numeroPlaca())
                {
                    if(h01 && eventosnumeroplaca.getEventosReglasID_numeroPlaca().equals("H01") && eventosnumeroplaca.getEventosReglasTotales_numeroPlaca() > 4)
                    {
                        System.out.println("¡¡¡La placa '" + numeroplaca.getId_numeroPlaca() + "' tiene '" + eventosnumeroplaca.getEventosReglasTotales_numeroPlaca() + "' eventos en la regla '" + eventosnumeroplaca.getEventosReglasID_numeroPlaca() + "'!!!");
                    }
                    else if(h01 && eventosnumeroplaca.getEventosReglasID_numeroPlaca().equals("H01b") && eventosnumeroplaca.getEventosReglasTotales_numeroPlaca() > 4)
                    {
                        System.out.println("¡¡¡La placa '" + numeroplaca.getId_numeroPlaca() + "' tiene '" + eventosnumeroplaca.getEventosReglasTotales_numeroPlaca() + "' eventos en la regla '" + eventosnumeroplaca.getEventosReglasID_numeroPlaca() + "'!!!");
                    }
                    else if(h01 && eventosnumeroplaca.getEventosReglasID_numeroPlaca().equals("H01c") && eventosnumeroplaca.getEventosReglasTotales_numeroPlaca() > 5)
                    {
                        System.out.println("¡¡¡La placa '" + numeroplaca.getId_numeroPlaca() + "' tiene '" + eventosnumeroplaca.getEventosReglasTotales_numeroPlaca() + "' eventos en la regla '" + eventosnumeroplaca.getEventosReglasID_numeroPlaca() + "'!!!");
                    }
                    else if(h07 && eventosnumeroplaca.getEventosReglasID_numeroPlaca().equals("H07") && eventosnumeroplaca.getEventosReglasTotales_numeroPlaca() > 1)
                    {
                        System.out.println("¡¡¡La placa '" + numeroplaca.getId_numeroPlaca() + "' tiene '" + eventosnumeroplaca.getEventosReglasTotales_numeroPlaca() + "' eventos en la regla '" + eventosnumeroplaca.getEventosReglasID_numeroPlaca() + "'!!!");
                    }
                    else
                    {
                        System.out.println("Todo chido con el número de Placa.");
                        break;
                    }
                }
            }
            
            System.out.println();
            
            for(NumeroSerie numeroserie : siniestros.getNumeroSerie())
            {                
                for(EventosnumeroSerie eventosnumeroserie : numeroserie.getEventos_numeroSerie())
                {
                    if(h01 && eventosnumeroserie.getEventosReglasID_numeroSerie().equals("H01") && eventosnumeroserie.getEventosReglasTotales_numeroSerie() > 4)
                    {
                        System.out.println("¡¡¡El número de Serie '" + numeroserie.getId_numeroSerie() + "' tiene '" + eventosnumeroserie.getEventosReglasTotales_numeroSerie() + "' eventos en la regla '" + eventosnumeroserie.getEventosReglasID_numeroSerie() + "'!!!");
                    }
                    else if(h01 && eventosnumeroserie.getEventosReglasID_numeroSerie().equals("H01b") && eventosnumeroserie.getEventosReglasTotales_numeroSerie() > 4)
                    {
                        System.out.println("¡¡¡El número de Serie '" + numeroserie.getId_numeroSerie() + "' tiene '" + eventosnumeroserie.getEventosReglasTotales_numeroSerie() + "' eventos en la regla '" + eventosnumeroserie.getEventosReglasID_numeroSerie() + "'!!!");
                    }
                    else if(h01 && eventosnumeroserie.getEventosReglasID_numeroSerie().equals("H01c") && eventosnumeroserie.getEventosReglasTotales_numeroSerie() > 5)
                    {
                        System.out.println("¡¡¡El número de Serie '" + numeroserie.getId_numeroSerie() + "' tiene '" + eventosnumeroserie.getEventosReglasTotales_numeroSerie() + "' eventos en la regla '" + eventosnumeroserie.getEventosReglasID_numeroSerie() + "'!!!");
                    }
                    else if(h07 && eventosnumeroserie.getEventosReglasID_numeroSerie().equals("H07") && eventosnumeroserie.getEventosReglasTotales_numeroSerie() > 1)
                    {
                        System.out.println("¡¡¡El número de Serie '" + numeroserie.getId_numeroSerie() + "' tiene '" + eventosnumeroserie.getEventosReglasTotales_numeroSerie() + "' eventos en la regla '" + eventosnumeroserie.getEventosReglasID_numeroSerie() + "'!!!");
                    }
                    else
                    {
                        System.out.println("Todo chido con el número de Serie.");
                        break;
                    }
                }
            }
            
            System.out.println();
            
            for(RFCContratante rfccontratante : siniestros.getRfcContratante())
            {
                for(EventosrfcContratante eventosrfccontratante : rfccontratante.getEventosrfccontratente())
                {
                    if(h01 && eventosrfccontratante.getEventosReglasID_rfcContratante().equals("H01") && eventosrfccontratante.getEventosReglasTotales_rfcContratante() > 4)
                    {
                        System.out.println("¡¡¡El RFC del Contratante '" + rfccontratante.getId_rfcContratante() + "' tiene '" + eventosrfccontratante.getEventosReglasTotales_rfcContratante() + "' eventos en la regla '" + eventosrfccontratante.getEventosReglasID_rfcContratante() + "'!!!");
                    }
                    else if(h01 && eventosrfccontratante.getEventosReglasID_rfcContratante().equals("H01b") && eventosrfccontratante.getEventosReglasTotales_rfcContratante() > 4)
                    {
                        System.out.println("¡¡¡El RFC del Contratante '" + rfccontratante.getId_rfcContratante() + "' tiene '" + eventosrfccontratante.getEventosReglasTotales_rfcContratante() + "' eventos en la regla '" + eventosrfccontratante.getEventosReglasID_rfcContratante() + "'!!!");
                    }
                    else if(h01 && eventosrfccontratante.getEventosReglasID_rfcContratante().equals("H01c") && eventosrfccontratante.getEventosReglasTotales_rfcContratante() > 5)
                    {
                        System.out.println("¡¡¡El RFC del Contratante '" + rfccontratante.getId_rfcContratante() + "' tiene '" + eventosrfccontratante.getEventosReglasTotales_rfcContratante() + "' eventos en la regla '" + eventosrfccontratante.getEventosReglasID_rfcContratante() + "'!!!");
                    }
                    else if(h07) {}
                    else
                    {
                        System.out.println("Todo chido con el RFC del Contratante.");
                        break;
                    }
                }
            }
            
            System.out.println();
            
            for(RFCConductor rfcconductor : siniestros.getRfcConductor())
            {
                for(EventosrfcConductor eventosrfcconductor : rfcconductor.getEventosrfcconductor())
                {
                    if(h01 && eventosrfcconductor.getEventosReglasID_rfcConductor().equals("H01") && eventosrfcconductor.getEventosReglasTotales_rfcConductor() > 4)
                    {
                        System.out.println("¡¡¡El RFC del Contratante '" + rfcconductor.getId_rfcConductor() + "' tiene '" + eventosrfcconductor.getEventosReglasTotales_rfcConductor() + "' eventos en la regla '" + eventosrfcconductor.getEventosReglasID_rfcConductor() + "'!!!");
                    }
                    else if(h01 && eventosrfcconductor.getEventosReglasID_rfcConductor().equals("H01b") && eventosrfcconductor.getEventosReglasTotales_rfcConductor() > 4)
                    {
                        System.out.println("¡¡¡El RFC del Contratante '" + rfcconductor.getId_rfcConductor() + "' tiene '" + eventosrfcconductor.getEventosReglasTotales_rfcConductor() + "' eventos en la regla '" + eventosrfcconductor.getEventosReglasID_rfcConductor() + "'!!!");
                    }
                    else if(h01 && eventosrfcconductor.getEventosReglasID_rfcConductor().equals("H01c") && eventosrfcconductor.getEventosReglasTotales_rfcConductor() > 5)
                    {
                        System.out.println("¡¡¡El RFC del Contratante '" + rfcconductor.getId_rfcConductor() + "' tiene '" + eventosrfcconductor.getEventosReglasTotales_rfcConductor() + "' eventos en la regla '" + eventosrfcconductor.getEventosReglasID_rfcConductor() + "'!!!");
                    }
                    else if(h07) { }
                    else
                    {
                        System.out.println("Todo chido con el RFC del Conductor.");
                        break;
                    }
                }
            }
        }
        catch(JAXBException e) { e.printStackTrace(); }
    }   
}
