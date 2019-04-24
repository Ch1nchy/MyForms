package team.projects.initial;

import com.hopding.jrpicam.RPiCamera;
import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;
import java.io.*;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;
import jssc.SerialPort;
import jssc.SerialPortException;
import static team.projects.initial.ShootStill.shootStill;
import team.projects.initial.SendAttachmentInEmail;


/**
 *
 * @author Ian & Carl
 */
public class TeamProjectsInitial {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        
        try {
            /*RPiCamera piCamera = null;
            // Attempt to create an instance of RPiCamera, will fail if raspistill is not properly installed
            try {
            String saveDir = "/home/pi/Pictures";
            piCamera = new RPiCamera(saveDir);
            } catch (FailedToRunRaspistillException e) {
            e.printStackTrace();
            }*/
            
            SendAttachmentInEmail sendEmail = new SendAttachmentInEmail();
            
            //Encapsulate this in a loop to test whether the Arduino is connected via ACM0 or ACM1
            /*SerialPort serialPort = new SerialPort("/dev/ttyACM0");
            try {
            System.out.println("Port opened: " + serialPort.openPort());
            System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));
            
            

            /*while(true)
            {
            
            readSerial = serialPort.readBytes();
            if (readSerial != null)
            {
            
            if (piCamera != null){
            shootStill(piCamera);
            
            SendAttachmentInEmail sendEmail = new SendAttachmentInEmail();
            
            
            serialPort.writeString("L");
            }
            }
            
            }
            }
            catch (SerialPortException ex){
            System.out.println(ex);
            }
            
            //The arduino needs the code below to activate Light/sound
            try
            {
            serialPort.closePort();
            } catch(SerialPortException ex){
            System.out.println(ex);
            }*/
        } catch (NamingException ex) {
            Logger.getLogger(TeamProjectsInitial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}