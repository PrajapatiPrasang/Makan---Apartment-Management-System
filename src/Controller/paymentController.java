package Controller;

import java.io.IOException; 
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.addResidentDAO;
import VO.paymentVO;

/**
 * Servlet implementation class paymentController
 */
@WebServlet("/paymentController")
public class paymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paymentController() {
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
		if(flag.equals("search")){
			addResidentDAO addResidentDAO=new addResidentDAO();
			List<paymentVO> list_of_all_payments=addResidentDAO.search_all_payments();
			session.setAttribute("list_of_all_payments", list_of_all_payments);
			response.sendRedirect("admin/viewPaymentHistory.jsp");
		}
		else if(flag.equals("search1")){
			String user_name=(String)session.getAttribute("user_name");
			addResidentDAO addResidentDAO=new addResidentDAO();
			List<paymentVO> list_of_all_payment=addResidentDAO.search_all_payment1(user_name);
			if(list_of_all_payment.size()>0){
			session.setAttribute("list_of_all_payment", list_of_all_payment);
			response.sendRedirect("user/viewPayment.jsp");
			}
			else{
				request.setAttribute("error", "You Don't have any pending Bills");
				RequestDispatcher rd=request.getRequestDispatcher("user/index.jsp");
				rd.forward(request, response);
			}
		}
		else if(flag.equals("search2")){
			String user_name=(String)session.getAttribute("user_name");
			addResidentDAO addResidentDAO=new addResidentDAO();
			List<paymentVO> list_of_all_payment=addResidentDAO.search_all_payment(user_name);
			if(list_of_all_payment.size()>0){
			session.setAttribute("list_of_all_payment", list_of_all_payment);
			response.sendRedirect("user/paymentHistory.jsp");
			}
			else{
				request.setAttribute("error", "You Don't have any payment History");
				RequestDispatcher rd=request.getRequestDispatcher("user/index.jsp");
				rd.forward(request, response);
			}
		}
		else if(flag.equals("success")){
			int payment_id=(Integer)session.getAttribute("payment_id");
			paymentVO paymentVO=new paymentVO();
			paymentVO.setPayment_id(payment_id);
			paymentVO.setStatus("paid");
			Date date = new Date();
			Timestamp ts = new Timestamp(date.getTime());
			paymentVO.setPayment_date(ts);
			
			addResidentDAO addResidentDAO=new addResidentDAO();
			addResidentDAO.update_payment(paymentVO);
			request.setAttribute("error", "Thank You for Your Payment");
			RequestDispatcher rd=request.getRequestDispatcher("user/index.jsp");
			rd.forward(request, response);
			
		}
		else if(flag.equals("fail")){
			int payment_id=(Integer)session.getAttribute("payment_id");
			paymentVO paymentVO=new paymentVO();
			paymentVO.setPayment_id(payment_id);
			paymentVO.setStatus("failed");
			
			
			addResidentDAO addResidentDAO=new addResidentDAO();
			addResidentDAO.update_payment1(paymentVO);
			request.setAttribute("error", "Sorry, your transaction failed");
			RequestDispatcher rd=request.getRequestDispatcher("user/index.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String flag=request.getParameter("flag");
		if(flag.equals("pay")){
			String firstname=request.getParameter("firstname");
			String lastname=request.getParameter("lastname");
			String emailId=request.getParameter("emailId");
			String phoneNo=request.getParameter("phoneNo");
			int payment_id=Integer.parseInt(request.getParameter("payment_id"));
			float rent=Float.parseFloat(request.getParameter("rent"));
			
			session.setAttribute("firstname1", firstname);
			session.setAttribute("lastname1", lastname);
			session.setAttribute("emailId1", emailId);
			session.setAttribute("phoneNo1", phoneNo);
			session.setAttribute("rent1", rent);
			session.setAttribute("surl", "http://localhost:8080/Makan/user/success.jsp");
			session.setAttribute("furl", "http://localhost:8080/Makan/user/fail.jsp");
			session.setAttribute("payment_id", payment_id);
			
			response.sendRedirect("user/payu.jsp");
			
		}
	}

}
