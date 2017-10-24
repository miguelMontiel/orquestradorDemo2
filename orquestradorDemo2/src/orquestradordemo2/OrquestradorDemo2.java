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

            System.out.println(siniestros.getTipoVehiculo());
            System.out.println(siniestros.getUsoVehiculo());
            
            for(NumeroPlaca numeroplaca : siniestros.getNumeroPlaca())
            {
                System.out.println("Numero de la placa: " + numeroplaca.getId_numeroPlaca());
                
                for(EventosnumeroPlaca eventosnumeroplaca : numeroplaca.getEventos_numeroPlaca())
                {
                    System.out.println("Regla: " + eventosnumeroplaca.getEventosReglasID_numeroPlaca());
                    System.out.println("Numero de eventos: " + eventosnumeroplaca.getEventosReglasTotales_numeroPlaca());
                    System.out.println("===============================");
                }
            }
            
            for(NumeroSerie numeroserie : siniestros.getNumeroSerie())
            {
                System.out.println("Numero de serie: " + numeroserie.getId_numeroSerie());
                
                for(EventosnumeroSerie eventosnumeroserie : numeroserie.getEventos_numeroSerie())
                {
                    System.out.println("Regla: " + eventosnumeroserie.getEventosReglasID_numeroSerie());
                    System.out.println("Numero de eventos: " + eventosnumeroserie.getEventosReglasTotales_numeroSerie());
                    System.out.println("===============================");
                }
            }
            
            for(RFCContratante rfccontratante : siniestros.getRfcContratante())
            {
                System.out.println("RFC del Contratante: " + rfccontratante.getId_rfcContratante());
                
                for(EventosrfcContratante eventosrfccontratante : rfccontratante.getEventosrfccontratente())
                {
                    System.out.println("Regla: " + eventosrfccontratante.getEventosReglasID_rfcContratante());
                    System.out.println("Numero de eventos: " + eventosrfccontratante.getEventosReglasTotales_rfcContratante());
                    System.out.println("===============================");
                }
            }
            
            for(RFCConductor rfcconductor : siniestros.getRfcConductor())
            {
                System.out.println("RFC del Conductor: " + rfcconductor.getId_rfcConductor());
                
                for(EventosrfcConductor eventosrfcconductor : rfcconductor.getEventosrfcconductor())
                {
                    System.out.println("Regla: " + eventosrfcconductor.getEventosReglasID_rfcConductor());
                    System.out.println("Numero de eventos: " + eventosrfcconductor.getEventosReglasTotales_rfcConductor());
                    System.out.println("===============================");
                }
            }
        }
        catch(JAXBException e) { e.printStackTrace(); }
    }   
}
