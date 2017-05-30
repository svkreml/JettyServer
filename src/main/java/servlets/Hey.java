package servlets;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by s.kremlev on 30.05.2017.
 */
public class Hey extends Thread {
    int i = 0;
    Vector<String> up = new Vector<>();
boolean stop = false;
    @Override
    public void run() {
        int j=0;
        while(!stop) {
            if(j++>30){
                up.add("Thats all!");
                stop=true;
                break;}
            up.add("Hey! " + i);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized List<String> getUp(int from) {
        if(from>up.size()) return new ArrayList<String>();
        return up.subList(from,up.size());
    }
    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
