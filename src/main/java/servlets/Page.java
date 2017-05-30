package servlets;

import org.eclipse.jetty.util.IO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Stream;

/**
 * Created by s.kremlev on 30.05.2017.
 */
public class Page extends HttpServlet {

    private String fileName = "src\\main\\resources\\servlets\\Page.html";
    Hey hey;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if(hey==null||hey.stop){
            resp.setHeader("stop", "stop");
            return;}
        if(req.getHeader("stop")!=null&&req.getHeader("stop").equals("stop")){
            hey.setStop(true);
        }else {
            String request = new String(IO.readBytes(req.getInputStream()), "UTF-8");
            int i;
            try {
                i = new Integer(request);
            }catch (NumberFormatException e){
                i=0;
            }
            resp.setIntHeader("number", hey.i);
            String response = hey.getUp(i).toString();
            resp.getWriter().write(response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String request = new String(IO.readBytes(req.getInputStream()), "UTF-8");
        InputStream loadStream;

        byte[] reply = Files.readAllBytes(Paths.get(fileName));
        resp.getWriter().write(new String(reply, "UTF-8"));
        if(hey!=null && !hey.stop){}else {
            hey = new Hey();
            hey.start();
        }
    }
}
