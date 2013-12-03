
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Philip Ward
 */
public class WebMonitor {
    private static Properties props=new Properties();
    private static String[] keys;
    
    public WebMonitor(String a){
       this.loadProps(a);
       keys=this.createKeyArray();
    }
    
    public static void main(String[] args){
        String configFile = args[0];
        WebMonitor monitor = new WebMonitor(configFile);
        
        for(int i=0;i<keys.length;i++){
        String site = keys[i]; 
        int delay = monitor.getProp(site);
        WebTimer t = new WebTimer(site, delay);
        }
    }
    
    public void loadProps(String filename) {
        InputStream in = this.getClass().getResourceAsStream(filename);
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public int getProp(String s) {
        return Integer.parseInt(props.getProperty(s));
    }
            
    public String[] createKeyArray(){
        Set<String> propKeys=this.props.stringPropertyNames();
        String[] keyArray=((propKeys.toString().replace("[", "")).replace("]", "")).split(", ");
        return keyArray;
    }
}
