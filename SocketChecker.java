
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Philip Ward
 */
public class SocketChecker{
        boolean reached = false;
        String webaddress;
        Socket s;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        public SocketChecker(String site){}
        
        public void isReachable(String w) {
            webaddress=w;
            try{
                System.out.println("Sending Request to " + webaddress);
                InetAddress inet=InetAddress.getByName(webaddress);
                if(inet.isReachable(3000)){
                    Date date = new Date();
                    System.out.println(webaddress+" is reachable at "+date);
                }
                else{
                    Date date = new Date();
                    System.out.println("*** "+webaddress+" is NOT reachable at "+date+" ***");

                    try {
                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("monitoring.log", true)));
                        out.println(webaddress+" is NOT reachable at " +date);
                        out.close();
                    } catch (IOException e) {
                    }
                }
            }
            catch(UnknownHostException e){
                System.out.println("*** UnknownHostException: "+e.getMessage()+" ***");
                try {
                        Date date = new Date();
                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("monitoring.log", true)));
                        out.println("UnknownHostException: "+e.getMessage()+" at "+date);
                        out.close();
                    } catch (IOException f) {
                    }
            }
            catch(IOException e){
                System.out.println("*** IOException: "+e.getMessage()+ " ***");
                try {
                        Date date = new Date();
                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("monitoring.log", true)));
                        out.println("IOException: "+e.getMessage()+" "+webaddress+" at "+date);
                        out.close();
                    } catch (IOException f) {
                    }
            }

        }
        
    }
