package team.projects.initial;

import com.hopding.jrpicam.RPiCamera;
import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;
import jssc.SerialPort;
import jssc.SerialPortException;
import static team.projects.initial.ShootStill.shootStill;

/**
 *
 * @author Ian & Carl
 */
public class TeamProjectsInitial {

    static boolean active = false;

    public static void main(String[] args) {
        
        RPiCamera piCamera = null;
		// Attempt to create an instance of RPiCamera, will fail if raspistill is not properly installed
		try {
			String saveDir = "/home/pi/Desktop";
			piCamera = new RPiCamera(saveDir);
		} catch (FailedToRunRaspistillException e) {
			e.printStackTrace();
		}
        
        /*
        SerialPort serialPort = new SerialPort("/dev/ttyACM1");
        try {
            /*System.out.println("Port opened: " + serialPort.openPort());
            System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));
            System.out.println("\"Hello World!!!\" successfully writen to port: " + serialPort.writeBytes("Hello World!!!".getBytes()));
            System.out.println("Port closed: " + serialPort.closePort());
            active = true;
            byte[] readSerial;
            
            serialPort.openPort();
            
            while(true)
            {
                
                readSerial = serialPort.readBytes();
                if (readSerial != null)
                {
                    
                    //System.out.println(Arrays.toString(readSerial));
                    System.out.println("Motion");
                    
                }
               
            }
        }
        catch (SerialPortException ex){
            System.out.println(ex);
        }   
        
        if (active) {
            System.out.println("Waiting for something to do...");
            
            //https://github.com/Hopding/JRPiCam/blob/master/README.md
            //The above is the API for the Raspberry Pi camera
            //Installation instructions are listed in the README and will need to
            //build the .jar file used to take photos from the Raspberry Pi
        }*/   
        
        
        if (piCamera != null){
            shootStill(piCamera);
        }
    }
}


