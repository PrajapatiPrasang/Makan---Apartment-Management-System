package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.addApartmentDAO;
import VO.addApartmentVO;

/**
 * Servlet implementation class allProperties
 */
@WebServlet("/allProperties")
public class allProperties extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allProperties() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String flag=request.getParameter("flag");
		if(flag.equals("fetch_properties")){
		addApartmentVO addApartmentVO=new addApartmentVO();
		addApartmentDAO addApartmentDAO=new addApartmentDAO();
		List<addApartmentVO> list_of_apartment=addApartmentDAO.fetchApartment2(addApartmentVO);
		session.setAttribute("fetch_properties",list_of_apartment);
		response.sendRedirect("user/allProperties.jsp");
		}
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			HttpSession session=request.getSession();
			String flag=request.getParameter("flag");
			if(flag.equals("fetch_properties1")){
			int bed=Integer.parseInt(request.getParameter("bed"));
			int bath=Integer.parseInt(request.getParameter("bath"));
			
			addApartmentVO addApartmentVO=new addApartmentVO();
			addApartmentVO.setBedroom(bed);
			addApartmentVO.setBathroom(bath);
			
			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			List<addApartmentVO> list_of_apartment=addApartmentDAO.fetchApartment1(addApartmentVO);
			if(list_of_apartment.size()>0){
			session.setAttribute("fetch_properties",list_of_apartment);
			response.sendRedirect("user/allProperties.jsp");
			}
			else{
				List<addApartmentVO> list_of_apartment1=addApartmentDAO.fetchApartment2(addApartmentVO);
				session.setAttribute("fetch_properties",list_of_apartment1);
				request.setAttribute("error", "Apartments Not Found");
				RequestDispatcher rd=request.getRequestDispatcher("user/allProperties.jsp");
				rd.forward(request, response);
			}
		}
	}

}
