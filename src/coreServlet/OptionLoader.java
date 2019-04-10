package coreServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import adapter.BuildAuto;

@WebServlet("/optload")
public class OptionLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;

@Override
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	  PrintWriter writer = response.getWriter();
		String modelkey = request.getParameter("modelkey");
		if (modelkey.isEmpty()) {
			String htmlRespone = "<html>";
			htmlRespone += "<h2>Incorrect Selection</h2>";
			htmlRespone += "</html>";
			writer.println(htmlRespone);
		}else {
			//code to config the automobile is called and created in a form (HTML) here.
			BuildAuto a2 = new BuildAuto();
			request.setAttribute("modelkey",modelkey);
			String htmlRespone = "<html>";
	        htmlRespone += "<head>";
	        htmlRespone += "<title>CarConfig</title>";
	        htmlRespone += "<style>";
	        htmlRespone += "table{";
	        htmlRespone += "font-family: arial, sans-serif;";
	        htmlRespone += "border-collapse: collapse;";
	        htmlRespone += "width: 100%;";
	        htmlRespone += "}";
	        htmlRespone += "td, th {";
	        htmlRespone += "border: 1px solid #dddddd";
	        htmlRespone += "text-align: left;";
	        htmlRespone += "padding: 8px";
	        htmlRespone += "}";
	        htmlRespone += "tr:nth-child(even) {";
	        htmlRespone += "background-color: #dddddd;";
	        htmlRespone += "}";
	        htmlRespone += "</style>";
	        htmlRespone += "</head>";
	        htmlRespone += "<body>";
	        htmlRespone += "<h2>Config Car</h2>";
	        htmlRespone += "<form name=\"choices\" method=\"post\" action=\"Report.jsp\">";
	        htmlRespone += "<table>";
	        htmlRespone += "<tr>";
	        htmlRespone += "<td>Model Name</td>";
	        htmlRespone +=  "<td><select name=\"modelkey\">\n";
	        htmlRespone += "<option value=\"" +modelkey+"\">" +a2.getAuto(modelkey).getName()+"</option>\n";
	        htmlRespone += "</tr>";
	        writer.println(htmlRespone);
	        for(int i = 0; i< a2.getAuto(modelkey).getOptionSetSize(); i++) {
	        	writer.println("<tr>\n"+
		        "<td>"+a2.getAuto(modelkey).getOptionSetname(i)+"</td>\n"+
		        "<td><select name=\""+a2.getAuto(modelkey).getOptionSetname(i)+"\">\n");
	        	for(int j=0; j< a2.getAuto(modelkey).getOptionsize(a2.getAuto(modelkey).getOptionSetname(i)); j++) {
	        		String OPSname = a2.getAuto(modelkey).getOptionSetname(i);
	        		 writer.println("<option value=\"" +a2.getAuto(modelkey).getOptionName(OPSname, j)+"\">" +a2.getAuto(modelkey).getOptionName(OPSname, j)+","+a2.getAuto(modelkey).getOptionPrice(OPSname, j) + "</option>\n");
	        	}
	        	writer.println("</tr>");
	        }
	        writer.println("</table>\n"+
	        "<input type=\"submit\">\n"+
	        "</form>\n"+
	        "</body>\n"+   
	        "</html>");
		}

  }
}