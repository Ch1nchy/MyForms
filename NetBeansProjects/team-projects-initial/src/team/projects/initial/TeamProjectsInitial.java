package team.projects.initial;
import jssc.SerialPort;
import jssc.SerialPortException;
/**
 *
 * @author Ian & Carl
 */
public class TeamProjectsInitial {

    static boolean active = false;

    public static void main(String[] args) {
        
        SerialPort serialPort = new SerialPort("/dev/ttyS0");
        try {
            System.out.println("Port opened: " + serialPort.openPort());
            System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));
            System.out.println("\"Hello World!!!\" successfully writen to port: " + serialPort.writeBytes("Hello World!!!".getBytes()));
            System.out.println("Port closed: " + serialPort.closePort());
            active = true;
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
        }
    }
}
