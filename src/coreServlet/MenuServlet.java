package coreServlet; // Always use packages. Never use default package.

import java.io.*;
import java.util.List;
import adapter.BuildAuto;
import server.DefaultServerSocket;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/menuServlet")
public class MenuServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  BuildAuto a1 = new BuildAuto();
	  a1.loadAuto("FordZTW.prop");
	  a1.loadAuto("ChevyVoltEV.prop");
	  List<String> keys = a1.getAllKeys();
	  List<String> modeln = a1.getAllModels();
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0" +
	            "Transitional//EN\">\n";
	    out.println(docType +
	            "<html>\n"+
	            "<head><title>CarConfig</title></head>\n"+
	            "<body>\n"+
	            "<h1>CarConfig Application</h1>\n" +
	            "<h2>Pick a Car!</h2>\n"+
	            "<p>Please select a car from the following drop list.</p>\n"+
	            "<form name=\"ModelSelection\" method=\"post\" action=\"optload\">\n"+
              "<select name=\"modelkey\">\n"+
              "<option value=\"\"></option>\n");
	    for(int i = 0; i< keys.size(); i++) {
             out.println("<option value=\""+keys.get(i)+"\""+">"+modeln.get(i)+"</option>\n");
	    }
	    out.println(
              "</select>\n"+
              "<br><br>\n"+
              "<input type=\"submit\">\n"+
              "</form>\n"+
	            "</body>\n"+
	            "</html>");
	    
	}
}
