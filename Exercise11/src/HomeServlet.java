

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import chapter10.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String box=request.getParameter("station");
		String box1=request.getParameter("line");
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		String box2=request.getParameter("textLine");
		String box3=request.getParameter("textStation");
		System.out.println(box);
		System.out.println(box1);
		System.out.println(start);
		System.out.println(end);
		System.out.println(box2);
		System.out.println(box3);
//		Object data = null;
//		String map=new HashMap();
//		Cookie cookie2= new Cookie("station",null);
//		Cookie cookie3= new Cookie("line",null);
		if((box!=null && box.equals("Station")) && box3!=null){
			
			Cookie cookie2= new Cookie("station",box3);
			cookie2.setMaxAge(30*60);
			response.addCookie(cookie2);
		}
		if((box1!=null &&box1.equals("Line")) && box2!=null){
			Cookie cookie3= new Cookie("line",box2);
			cookie3.setMaxAge(30*60);
			response.addCookie(cookie3);
			
		}
		Cookie cookie=new Cookie("a", start);
		Cookie cookie1=new Cookie("b", end);
		cookie.setMaxAge(30*60);
		cookie1.setMaxAge(30*60);
		
		
//		Cookie cookie2= new Cookie("map",map);
		response.addCookie(cookie);
		response.addCookie(cookie1);
		response.sendRedirect("SubwayTester");
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
