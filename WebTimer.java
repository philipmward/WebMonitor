
import java.util.Timer;
import java.util.TimerTask;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Philip Ward
 */
public class WebTimer {
    private Timer timer;
    private String site;
    private int delay;
    private SocketChecker socket; 
            
    public WebTimer(String s, int d){
        site=s;
        delay=d;
        timer=new Timer();
        timer.schedule(new RunTimer(), 0, delay*1000);
    }
    
    class RunTimer extends TimerTask {
        public void run(){
        socket=new SocketChecker(site);
        socket.isReachable(site);
        }
    }
}
