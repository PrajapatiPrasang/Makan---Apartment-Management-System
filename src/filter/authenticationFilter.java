package filter;
import java.io.IOException; 
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DAO.addApartmentDAO;
import VO.addApartmentVO;


@WebFilter("/*")
public class authenticationFilter implements Filter {
	public authenticationFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession session =(((HttpServletRequest) request).getSession());
		RequestDispatcher requestDispatcher;
		String flag = request.getParameter("flag");

		String uri = ((HttpServletRequest)request).getRequestURI();
			
		
		if(uri.contains("user/index.jsp") || uri.contains("Makan/") && session.getAttribute("list_of_apartment")==null)
		{
			
			addApartmentVO addApartmentVO=new addApartmentVO();
			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			List<addApartmentVO> list_of_apartment=addApartmentDAO.fetchApartment(addApartmentVO);
			session.setAttribute("list_of_apartment",list_of_apartment);
			
		}
		

		if(uri.contains("/css") || uri.contains("/js") && !uri.contains(".jsp") || uri.contains("/img") || uri.contains("/font") || uri.contains("allProperties") || uri.contains("requestServiceController") || uri.contains("paymentController") || uri.contains("addApartmentPhotosController") || uri.contains("addApartmentController") || uri.contains("addAppointmentController") || uri.contains("addResidentController") || uri.contains("forgotPasswordController1") || uri.contains("loginController") || uri.contains("logout") || uri.contains("index") || uri.contains("/doc") || uri.contains("user/fail.jsp") || uri.contains("user/success.jsp")  || uri.contains("user/header") || uri.contains("user/header1")  || uri.contains("user/login") || uri.contains("user/email") || uri.contains("user/newPassword") || uri.contains("admin/header") || uri.contains("admin/menu"))
		{
			//System.out.println("filter 1");
			chain.doFilter(request,response);

		}

		else if(session.getAttribute("loginId") != null)
		{
			//System.out.println("filter 2");
			String h = (String)session.getAttribute("type");
			if(h!=null && h.equals("admin") && uri.contains("/admin"))
			{
				
				chain.doFilter(request,response);
			}

			else if(h!=null && h.equals("resident") && uri.contains("/user"))
			{
				//System.out.println("filter 3");
				chain.doFilter(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/user/index.jsp");  //User/error.jsp
				rd.forward(request,response);
			}
		}

		else
		{
			//System.out.println("filter 4");
			chain.doFilter(request,response);
			
		}
	}

	

	

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
