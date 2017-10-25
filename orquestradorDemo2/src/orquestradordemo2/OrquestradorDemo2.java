package orquestradordemo2;

import numeroPlaca.EventosnumeroPlaca;
import numeroSerie.EventosnumeroSerie;
import java.io.File;
import java.util.Scanner;

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
            JFileChooser jfilechooser = new JFileChooser("C:\\Users\\IBM_ADMIN\\Desktop\\orquestradorDemo2\\orquestradorDemo2\\src\\data");
            FileNameExtensionFilter filenameextensionfilter = new FileNameExtensionFilter("Archivos XML", "xml");
            jfilechooser.setFileFilter(filenameextensionfilter);
            int seleccionado = jfilechooser.showOpenDialog(null);
            String archivoSeleccionado = jfilechooser.getSelectedFile().getAbsolutePath();
            
            Scanner scanner = new Scanner(System.in);

            File file = new File(archivoSeleccionado);

            if(seleccionado == JFileChooser.APPROVE_OPTION)
            {
                System.out.println("El archivo seleccionado es: " + jfilechooser.getSelectedFile().getName() + "\n");
            }

            JAXBContext jaxbcontext = JAXBContext.newInstance(Siniestros.class);
            Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
            Siniestros siniestros = (Siniestros) unmarshaller.unmarshal(file);
            
            Boolean h01 = false, h07 = false, vehiculoTipoUso = false;
            String[] claveUsoVehiculo = {"", "Particular", "Privado", "", "Transporte Público", "Renta Diaria", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Chofer Privado"};
            
            while(!h01 && !h07)
            {
                System.out.println("¿Qué regla quiere buscar en este XML? (H01, H07 o Ambas)");
                String reglaElegir = scanner.nextLine();
                
                if(reglaElegir.toLowerCase().equals("h01"))
                {
                	if(siniestros.getTipoVehiculo().equals("AUT")  || siniestros.getTipoVehiculo().equals("CA1") 
                			&& siniestros.getUsoVehiculo() == 01 || siniestros.getUsoVehiculo() == 02 || siniestros.getUsoVehiculo() == 04 || siniestros.getUsoVehiculo() == 05 || siniestros.getUsoVehiculo() == 23)
                	{
	                	System.out.println("Entra a H01! \n");
	                    System.out.println("Tipo de Vehiculo: " + siniestros.getTipoVehiculo());
	                    System.out.println("Uso del Vehiculo: " + siniestros.getUsoVehiculo() + " - " + claveUsoVehiculo[siniestros.getUsoVehiculo()] + "\n");
	                    h01 = true;
	                    vehiculoTipoUso = true;
                	}
                }
                else if(reglaElegir.toLowerCase().equals("h07"))
                {
                	System.out.println("Entra a H07! \n");
                	System.out.println("Tipo de Siniestro: " + siniestros.getTipoSiniestro() + "\n");
                	h07 = true;
                }
                else if(reglaElegir.toLowerCase().equals("ambas") || reglaElegir.toLowerCase().equals("ambos"))
                {
                	System.out.println("Entra a Ambas.");
                	System.out.println("Tipo de Vehiculo: " + siniestros.getTipoVehiculo());
                    System.out.println("Uso del Vehiculo: " + siniestros.getUsoVehiculo() + " - " + claveUsoVehiculo[siniestros.getUsoVehiculo()]);
                    System.out.println("Tipo de Siniestro: " + siniestros.getTipoSiniestro() + "\n");
                	h07 = true;
                    h01 = true;
                    vehiculoTipoUso = true;
                }
                else
                {
                	System.out.println("Sólo se pueden las reglas H01 y H07, o ambas. \n");
                }
            }
            scanner.close();
            
            for(NumeroPlaca numeroplaca : siniestros.getNumeroPlaca())
            {
                for(EventosnumeroPlaca eventosnumeroplaca : numeroplaca.getEventos_numeroPlaca())
                {
                	if(h01 && vehiculoTipoUso && eventosnumeroplaca.getEventosReglasTotales_numeroPlaca() > 4 && eventosnumeroplaca.getEventosReglasID_numeroPlaca().equals("H01") 
                			|| h01 && vehiculoTipoUso && eventosnumeroplaca.getEventosReglasTotales_numeroPlaca() > 4 && eventosnumeroplaca.getEventosReglasID_numeroPlaca().equals("H01b")
                			|| h01 && vehiculoTipoUso && eventosnumeroplaca.getEventosReglasTotales_numeroPlaca() > 5 && eventosnumeroplaca.getEventosReglasID_numeroPlaca().equals("H01c")
                			|| h07 && eventosnumeroplaca.getEventosReglasTotales_numeroPlaca() > 1 && eventosnumeroplaca.getEventosReglasID_numeroPlaca().equals("H07"))
                	{
                		System.out.println("La Placa: '" + numeroplaca.getId_numeroPlaca() + "' tiene " + eventosnumeroplaca.getEventosReglasTotales_numeroPlaca() + 
                				" eventos con la regla '" + eventosnumeroplaca.getEventosReglasID_numeroPlaca() + "'.");
                	}
                }
                System.out.println("No hay más problemas con el número de Placa: " + numeroplaca.getId_numeroPlaca() + "\n");
            }

            for(NumeroSerie numeroserie : siniestros.getNumeroSerie())
            {                
                for(EventosnumeroSerie eventosnumeroserie : numeroserie.getEventos_numeroSerie())
                {
                	if(h01 && vehiculoTipoUso && eventosnumeroserie.getEventosReglasTotales_numeroSerie() > 4 && eventosnumeroserie.getEventosReglasID_numeroSerie().equals("H01") 
                			|| h01 && vehiculoTipoUso && eventosnumeroserie.getEventosReglasTotales_numeroSerie() > 4 && eventosnumeroserie.getEventosReglasID_numeroSerie().equals("H01b")
                			|| h01 && vehiculoTipoUso && eventosnumeroserie.getEventosReglasTotales_numeroSerie() > 5 && eventosnumeroserie.getEventosReglasID_numeroSerie().equals("H01c")
                			|| h07 && eventosnumeroserie.getEventosReglasTotales_numeroSerie() > 1 && eventosnumeroserie.getEventosReglasID_numeroSerie().equals("H07"))
                	{
                		System.out.println("El número de Serie: '" + numeroserie.getId_numeroSerie() + "' tiene " + eventosnumeroserie.getEventosReglasTotales_numeroSerie() + 
                				" eventos con la regla '" + eventosnumeroserie.getEventosReglasID_numeroSerie() + "'.");
                	}
                }
                System.out.println("No hay más problemas con el número de Serie: " + numeroserie.getId_numeroSerie() + "\n");
            }
            
            for(RFCContratante rfccontratante : siniestros.getRfcContratante())
            {
                for(EventosrfcContratante eventosrfccontratante : rfccontratante.getEventosrfccontratente())
                {
                    if(h01 && vehiculoTipoUso && eventosrfccontratante.getEventosReglasTotales_rfcContratante() > 4 && eventosrfccontratante.getEventosReglasID_rfcContratante().equals("H01") 
                    		|| h01 && vehiculoTipoUso && eventosrfccontratante.getEventosReglasTotales_rfcContratante() > 4 && eventosrfccontratante.getEventosReglasID_rfcContratante().equals("H01b")
                    		|| h01 && vehiculoTipoUso && eventosrfccontratante.getEventosReglasTotales_rfcContratante() > 5 && eventosrfccontratante.getEventosReglasID_rfcContratante().equals("H01c"))
                    {
                        System.out.println("El RFC del Contratante '" + rfccontratante.getId_rfcContratante() + "' tiene " + eventosrfccontratante.getEventosReglasTotales_rfcContratante() + 
                        		" eventos con la regla '" + eventosrfccontratante.getEventosReglasID_rfcContratante() + "'.");
                    }
                }
                if(h01)
                {
                	System.out.println("No hay más problemas con el RFC del Conductor: " + rfccontratante.getId_rfcContratante() + "\n");
                }
            }

            for(RFCConductor rfcconductor : siniestros.getRfcConductor())
            {
                for(EventosrfcConductor eventosrfcconductor : rfcconductor.getEventosrfcconductor())
                {
                    if(h01 && vehiculoTipoUso && eventosrfcconductor.getEventosReglasTotales_rfcConductor() > 4 && eventosrfcconductor.getEventosReglasID_rfcConductor().equals("H01")
                    		|| h01 && vehiculoTipoUso && eventosrfcconductor.getEventosReglasTotales_rfcConductor() > 4 && eventosrfcconductor.getEventosReglasID_rfcConductor().equals("H01b")
                    		|| h01 && vehiculoTipoUso && eventosrfcconductor.getEventosReglasTotales_rfcConductor() > 5 && eventosrfcconductor.getEventosReglasID_rfcConductor().equals("H01c"))
                    {
                        System.out.println("El RFC del Conductor '" + rfcconductor.getId_rfcConductor() + "' tiene " + eventosrfcconductor.getEventosReglasTotales_rfcConductor() + 
                        		" eventos con la regla '" + eventosrfcconductor.getEventosReglasID_rfcConductor() + "'.");
                    }
                }
                if(h01)
                {
                	System.out.println("No hay más problemas con el RFC del Conductor: " + rfcconductor.getId_rfcConductor() + "\n");
                }
            }
        }
        catch(JAXBException e) { e.printStackTrace(); }
    }   
}
