package chapter10;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubwayTester
 */
@WebServlet("/SubwayTester")
public class SubwayTester extends HttpServlet {
	private static final long serialVersionUID = 1L;
//    private String a=null;
//    private String b=null;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubwayTester() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		   if (args.length != 2) {
//	            System.err.println("Usage: SubwayTester [StartStation] [endStation]");
//	            System.exit(-1);
//	        }
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	        try {
	            SubwayLoader loader = new SubwayLoader();
	            Subway objectville = loader.loadFromFile(new File("C:/william/workspace/Subway/src/chapter10/ObjectvilleSubway.txt"));
	            //break line loader.brokeLine(Name of the line);
	            //break station loader.brokeStation(Name of the station);
	            String line=null;
	            String a=null;
	            String b=null;
	            String station=null;
	            Cookie[] cookies = request.getCookies();
	            System.out.println(cookies);
				if(cookies !=null){
//					System.out.println(cookies.);
				for(Cookie cookie : cookies){
					System.out.println(cookie.getName());
				    if(cookie.getName().equals("a")) a = cookie.getValue();
				    if(cookie.getName().equals("b")) b = cookie.getValue();
				    if(cookie.getName().equals("line") ) line=cookie.getValue();
//				    System.out.println("cl"+cookie.getName().equals("line"));
				    if(cookie.getName().equals("station")) station=cookie.getValue();
//				    System.out.println("cs"+cookie.getName().equals("station"));
				   
					}
				}
				System.out.println("line"+line);
				System.out.println(station);
	            if(line!=null ){
	            	loader.brokeLine(line);
	            }
	            if(station!=null){
	            	loader.brokeStation(station);
	            }
	            
	            
	            if (!objectville.hasStation(a)) {
	                System.err.println(a + " is not a station in Objecville");
//	                System.exit(-1);
	            } else if (!objectville.hasStation(b)) {
	                System.err.println(b + " is not a station in Objecville");
//	                System.exit(-1);
	            }
	            
	            List route = objectville.getDirections(a, b);
	            SubwayPrinter printer = new SubwayPrinter(out);
	            printer.printDirections(route);
	        }
	        catch (Exception e) {
	            e.printStackTrace(out);
	        }
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
