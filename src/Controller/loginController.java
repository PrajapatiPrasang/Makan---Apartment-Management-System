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

import DAO.loginDAO;
import VO.addResidentVO;
import VO.loginVO;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		HttpSession session=request.getSession();
		if(flag.equals("logout")){
			session.invalidate();
			response.sendRedirect("user/index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String flag=request.getParameter("flag");
		if(flag.equals("login")){
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			loginVO loginVO=new loginVO();
			loginVO.setUser_name(username);
			loginVO.setPassword(password);
			
			loginDAO loginDAO = new loginDAO();
			List list =  loginDAO.authentication(loginVO);

			if(list != null && list.size()>=1)
			{	
				loginVO user1=(loginVO) list.get(0);
				String pwd=user1.getPassword();
				String un=user1.getUser_name();
				if(pwd.equals(loginVO.getPassword()) && un.equals(loginVO.getUser_name())){
				
				int login_id = user1.getLogin_id();
				String type = user1.getUser_type();
				String user_name=user1.getUser_name();
				
				session.setAttribute("loginId",login_id);
				session.setAttribute("user_name", user_name);
				session.setAttribute("userType", type);
				
				loginVO.setLogin_id(login_id);
				List list1 =  loginDAO.fetchName(loginVO);
				addResidentVO user =(addResidentVO)list1.get(0);
				
				if(list1 != null && list1.size()>=1 && type.equalsIgnoreCase("admin"))
				{
				String firstName=user.getFirst_name();
				session.setAttribute("firstName", firstName);
				session.setAttribute("type", "admin");
				response.sendRedirect("admin/index.jsp");
				}
				
				else if(list1 != null && list1.size()>=1 && type.equalsIgnoreCase("resident"))
				{
					String firstName=user.getFirst_name();
					int resident_id=user.getResident_id();
					
					session.setAttribute("firstName", firstName);
					session.setAttribute("type", "resident");
					session.setAttribute("resident_id", resident_id);
					
					
					response.sendRedirect("user/index.jsp");
				}
				else{
					request.setAttribute("error", "Not yet Registered");
					RequestDispatcher rd=request.getRequestDispatcher("user/login.jsp");
					rd.forward(request, response);
					
				}
			}
				else{
					request.setAttribute("error", "Invalid Login Credentials");
					RequestDispatcher rd=request.getRequestDispatcher("user/login.jsp");
					rd.forward(request, response);
					
				}
			}
			else{
				request.setAttribute("error", "Invalid Login Credentials");
				RequestDispatcher rd=request.getRequestDispatcher("user/login.jsp");
				rd.forward(request, response);
				
			}
		}
		
	}

}
