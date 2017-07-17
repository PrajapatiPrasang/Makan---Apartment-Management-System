package Controller;

import java.io.IOException; 
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.addApartmentDAO;
import DAO.addResidentDAO;
import DAO.replyDAO;
import DAO.requestServiceDAO;
import VO.addApartmentVO;
import VO.addResidentVO;
import VO.replyVO;
import VO.requestServiceVO;

/**
 * Servlet implementation class requestServiceController
 */
@WebServlet("/requestServiceController")
public class requestServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public requestServiceController() {
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
		if(flag.equals("search")){
			
			requestServiceDAO requestServiceDAO=new requestServiceDAO();
			List<requestServiceVO> list_of_all_services=requestServiceDAO.search_all_services();
			session.setAttribute("search_services", list_of_all_services);
			response.sendRedirect("admin/manageServices.jsp");
			
		}
		else if(flag.equals("delete")){
			int service_id=Integer.parseInt(request.getParameter("service_id"));
			requestServiceVO requestServiceVO=new requestServiceVO();
			requestServiceVO.setService_id(service_id);
			requestServiceDAO requestServiceDAO=new requestServiceDAO();
			requestServiceDAO.delete_request(requestServiceVO);
			List<requestServiceVO> list_of_all_services=requestServiceDAO.search_all_services();
			session.setAttribute("search_services", list_of_all_services);
			request.setAttribute("error", "Requested Service Deleted");
			RequestDispatcher rd=request.getRequestDispatcher("admin/manageServices.jsp");
			rd.forward(request, response);
		}
		else if(flag.equals("fetch")){
			int service_id=Integer.parseInt(request.getParameter("service_id"));
			int resident_id=Integer.parseInt(request.getParameter("resident_id"));
			
			requestServiceVO requestServiceVO=new requestServiceVO();
			requestServiceVO.setService_id(service_id);
			
			 addResidentVO addResidentVO=new addResidentVO();
			 addResidentVO.setResident_id(resident_id);
			
			
			requestServiceDAO requestServiceDAO=new requestServiceDAO();
			List<requestServiceVO> list_of_service=requestServiceDAO.search_service(requestServiceVO);
			List<addResidentVO> list_of_resident=requestServiceDAO.search_resident(addResidentVO);
			session.setAttribute("list_of_service", list_of_service);
			session.setAttribute("list_of_resident", list_of_resident);
			response.sendRedirect("admin/replyServiceRequest.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String flag=request.getParameter("flag");
		if(flag.equals("add")){
			String serviceType=request.getParameter("serviceType");
			String serviceDescription=request.getParameter("serviceDescription");
			
			requestServiceVO requestServiceVO=new VO.requestServiceVO();
			requestServiceVO.setService_type(serviceType);
			requestServiceVO.setService_description(serviceDescription);
			int resident_id=(int) session.getAttribute("resident_id");
			addResidentVO addResidentVO=new addResidentVO(); 
			addResidentVO.setResident_id(resident_id);
			requestServiceVO.setAddResidentVO(addResidentVO);
			requestServiceDAO requestServiceDAO=new requestServiceDAO();
			requestServiceDAO.addService(requestServiceVO);
			request.setAttribute("error", "Request for a service is submitted");
			RequestDispatcher rd=request.getRequestDispatcher("user/index.jsp");
			rd.forward(request, response);
		}
		else if(flag.equals("add_reply")){
			int service_id=Integer.parseInt(request.getParameter("service_id"));
			int resident_id=Integer.parseInt(request.getParameter("resident_id"));
			String emailId=request.getParameter("emailId");
			String replyMessage=request.getParameter("replyMessage");
			
			replyVO replyVO=new replyVO();
			replyVO.setReply_message(replyMessage);
			
			requestServiceVO requestServiceVO=new requestServiceVO();
			requestServiceVO.setService_id(service_id);
			replyVO.setRequestServiceVO(requestServiceVO);
			
			addResidentVO addResidentVO=new addResidentVO();
			addResidentVO.setResident_id(resident_id);
			replyVO.setAddResidentVO(addResidentVO);
			
			replyDAO replyDAO=new replyDAO();
			replyDAO.addReply(replyVO);
			
			sendMail(emailId,replyMessage);
			
			requestServiceDAO requestServiceDAO=new requestServiceDAO();
			List<requestServiceVO> list_of_all_services=requestServiceDAO.search_all_services();
			session.setAttribute("search_services", list_of_all_services);
			
			request.setAttribute("error", "Reply to a service is e-Mailed");
			RequestDispatcher rd=request.getRequestDispatcher("admin/manageServices.jsp");
			rd.forward(request, response);
		}
	}
protected void sendMail(String email,String replyMessage){
		
		java.util.Properties properties = new java.util.Properties();
        properties.put("mail.smtp.auth", "true");
         properties.put("mail.smtp.starttls.enable", "true");
         javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);
        
        try {
        	
            MimeMessage message = new MimeMessage(mailSession);
   
           
            message.setContent(replyMessage,"text/html" );
            message.setSubject("RE:Your requested service");
            
            InternetAddress sender = new InternetAddress(email,"Mail");
            InternetAddress receiver = new InternetAddress(email);
            message.setFrom(sender);
            message.setRecipient(Message.RecipientType.TO, receiver);
             message.saveChanges();
            
            javax.mail.Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", 587, "makanapartment@gmail.com", "makan1234");
             transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            
                      
        } catch (Exception e) {
            e.printStackTrace();
         }
		
       
		
	}
}
