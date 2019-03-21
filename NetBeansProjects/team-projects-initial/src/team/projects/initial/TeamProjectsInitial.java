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

    static boolean active = false;

    public static void main(String[] args) {
        
        RPiCamera piCamera = null;
		// Attempt to create an instance of RPiCamera, will fail if raspistill is not properly installed
		try {
			String saveDir = "/home/pi/Pictures";
			piCamera = new RPiCamera(saveDir);
		} catch (FailedToRunRaspistillException e) {
			e.printStackTrace();
		}
        
        
        SerialPort serialPort = new SerialPort("/dev/ttyACM0");
        try {
            System.out.println("Port opened: " + serialPort.openPort());
            System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));
            int num  = 1;
            serialPort.writeInt(num);
            byte[] readSerial;

            while(true)
            {
                
                readSerial = serialPort.readBytes();
                if (readSerial != null)
                {
                    
                    if (piCamera != null){
                        shootStill(piCamera);
                        
                        SendAttachmentInEmail sendEmail = new SendAttachmentInEmail();
                        
                        
                        serialPort.writeInt(num);
                    }
                }
               
            }
        }
        catch (SerialPortException ex){
            System.out.println(ex);
        }  
    }
}