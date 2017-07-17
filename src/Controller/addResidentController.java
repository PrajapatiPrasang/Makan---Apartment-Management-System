package Controller;

import java.io.IOException;   
import java.util.Date;
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
import DAO.loginDAO;
import VO.addApartmentVO;
import VO.addResidentVO;
import VO.loginVO;
import VO.paymentVO;
import VO.rentalRequestVO;
import Validate.addResidentValidate;


/**
 * Servlet implementation class addResidentController
 */
@WebServlet("/addResidentController")
public class addResidentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addResidentController() {
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
			List<addResidentVO> list_of_all_residents=addResidentDAO.search_all_residents();
			
			session.setAttribute("search_residents", list_of_all_residents);
			response.sendRedirect("admin/editDeleteResident.jsp");
		}
		
		else if(flag.equals("search_apartment")){
			
			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			List<addApartmentVO> list_of_all_apartments=addApartmentDAO.search_all_apartments();
			session.setAttribute("search_apartments_address1", list_of_all_apartments);
			response.sendRedirect("admin/addResident.jsp");
			
		}
		else if(flag.equals("search_request")){
			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			List<rentalRequestVO> list_of_all_request=addApartmentDAO.search_all_rental_request();
			session.setAttribute("list_of_all_request", list_of_all_request);
			response.sendRedirect("admin/manageRequest.jsp");
			
		}
		else if(flag.equals("edit_residents"))
		{
			
			int resident_id=Integer.parseInt(request.getParameter("resident_id"));
			addResidentVO addResidentVO=new addResidentVO();
			addResidentVO.setResident_id(resident_id);
			addResidentDAO addResidentDAO=new addResidentDAO();
			List<addResidentVO> list_of_residents=addResidentDAO.edit_residents(addResidentVO);
			
			session.setAttribute("edit_residents", list_of_residents);
			response.sendRedirect("admin/editResident.jsp");
			
		}
		else if(flag.equals("edit"))
		{
			
			int resident_id=Integer.parseInt(request.getParameter("resident_id"));
			addResidentVO addResidentVO=new addResidentVO();
			addResidentVO.setResident_id(resident_id);
			addResidentDAO addResidentDAO=new addResidentDAO();
			List<addResidentVO> list_of_residents=addResidentDAO.edit_residents(addResidentVO);
			
			session.setAttribute("edit_residents1", list_of_residents);
			response.sendRedirect("user/editProfile.jsp");
			
		}
		else if(flag.equals("delete_resident"))
		{
			int resident_id=Integer.parseInt(request.getParameter("resident_id"));
			addResidentVO addResidentVO=new addResidentVO();
			addResidentVO.setResident_id(resident_id);
			
			addResidentDAO addResidentDAO = new addResidentDAO();
			List list =  addResidentDAO.authentication(addResidentVO);

			if(list != null && list.size()>=1)
			{
				addResidentVO user1=(addResidentVO) list.get(0);
				String userId=user1.getUser_id();
				loginVO loginVO=new loginVO();
				
				loginVO.setUser_name(userId);
				loginDAO loginDAO=new loginDAO();
				
				addResidentDAO.delete_resident(addResidentVO);
				loginDAO.delete(loginVO);
				List<addResidentVO> list_of_all_residents=addResidentDAO.search_all_residents();
				session.setAttribute("search_residents", list_of_all_residents);
				
				
				request.setAttribute("error", "Resident Deleted");
				RequestDispatcher rd=request.getRequestDispatcher("admin/editDeleteResident.jsp");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		HttpSession session=request.getSession();
		if(flag.equals("add")){
			int apartmentID=Integer.parseInt(request.getParameter("apartmentID"));
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String emailId=request.getParameter("emailId");
			Long phoneNo=Long.parseLong(request.getParameter("phoneNo"));
			String userId=request.getParameter("userId");
			String password=request.getParameter("password");
			String userType=request.getParameter("userType");
			
			addResidentVO addResidentVO = new addResidentVO();
			addResidentVO.setFirst_name(firstName);
			addResidentVO.setLast_name(lastName);
			addResidentVO.setEmail_id(emailId);
			addResidentVO.setPhone_no(phoneNo);
			
			addResidentVO.setUser_id(userId);
			addResidentVO.setPassword(password);
			addResidentVO.setUser_type(userType);
			
			addApartmentVO addApartmentVO=new addApartmentVO();
			addApartmentVO.setApartment_id(apartmentID);
			addResidentVO.setAddApartmentVO(addApartmentVO);
			
			addResidentDAO addResidentDAO=new addResidentDAO();
			
			addResidentValidate addResidentValidate=new addResidentValidate();
			String validateMandatory=addResidentValidate.mandatory(addResidentVO);
			String matchFields=addResidentValidate.parameters_resident(addResidentVO);
			if(validateMandatory.equals("All fields are Mandatory") || validateMandatory.equals("First Name is mandatory!") || validateMandatory.equals("Last Name is mandatory!") || validateMandatory.equals("Email Id is mandatory!") || validateMandatory.equals("Address is mandatory!") || validateMandatory.equals("User Id is mandatory!") || validateMandatory.equals("Password is mandatory!")){
				request.setAttribute("error", validateMandatory);
				RequestDispatcher rd=request.getRequestDispatcher("admin/addResident.jsp");
				rd.forward(request, response);
			}
			
			else if(matchFields.equals("Password should be alph-numeric") || matchFields.equals("User Id should be alpha-numeric") || matchFields.equals("Last Name should be alphabets only!") || matchFields.equals("First Name should be alphabets only!") ){
				System.out.println(matchFields);
				request.setAttribute("error", matchFields);
				RequestDispatcher rd=request.getRequestDispatcher("admin/addResident.jsp");
				rd.forward(request, response);
			}
			else{
			loginVO loginVO=new loginVO();
			loginVO.setUser_name(userId);
			loginVO.setPassword(password);
			loginVO.setUser_type(userType);
			
			List list2 =  addResidentDAO.authentication_userid(addResidentVO);
			List list =  addResidentDAO.authentication_email(addResidentVO);
			if(list != null && list.size()>=1)
			{
				request.setAttribute("error", "Email Id already Registered");
				RequestDispatcher rd=request.getRequestDispatcher("admin/addResident.jsp");
				rd.forward(request, response);
			}
			
			else if(list2 != null && list2.size()>=1)
			{
				request.setAttribute("error", "User Id already Registered");
				RequestDispatcher rd=request.getRequestDispatcher("admin/addResident.jsp");
				rd.forward(request, response);
			}
			else{
			loginDAO logindao=new loginDAO();
			int login_id = logindao.add_login(loginVO);
			addResidentVO.setLoginvo(loginVO);
			
			
			List list1 =  addResidentDAO.authentication1(addApartmentVO);
			addApartmentVO user =(addApartmentVO)list1.get(0);
			if(list1 != null && list1.size()>=1)
			{	
				String address = user.getAddress() +", " +user.getCity() +", " +user.getState() +" - " +user.getZip_code() ;
				addResidentVO.setAddress(address);
				
				int resident_id=addResidentDAO.addResident(addResidentVO);
				addResidentDAO.update_rental_status(addResidentVO);
				
				
				
				paymentVO paymentVO=new paymentVO();
				Date date=new Date();
				java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String currentTime = sdf.format(date);
				paymentVO.setDate(currentTime);
				//paymentVO.setRent(addApartmentVO.getPrice());
				paymentVO.setStatus("pending");
				
				addResidentVO addResidentVO1=new addResidentVO();
				addResidentVO1.setResident_id(resident_id);
				paymentVO.setAddResidentVO(addResidentVO1);
				
				addApartmentVO addApartmentVO1=new addApartmentVO();
				addApartmentVO1.setApartment_id(apartmentID);
				paymentVO.setAddApartmentVO(addApartmentVO1);
				
				
				addResidentDAO.addPayment(paymentVO);
				
				addApartmentDAO addApartmentDAO=new addApartmentDAO();
				List<addApartmentVO> list_of_all_apartments=addApartmentDAO.search_all_apartments();
				session.setAttribute("search_apartments_address1", list_of_all_apartments);
				
			}
			String email_id=addResidentVO.getEmail_id();
			String un=addResidentVO.getUser_id();
			String password1=addResidentVO.getPassword();
			sendMail(email_id,password1,un);
			
			request.setAttribute("error", "Resident Added");
			RequestDispatcher rd=request.getRequestDispatcher("admin/addResident.jsp");
			rd.forward(request, response);
			}
			}
		}
			
		
		if(flag.equals("update")){
				int residentId=Integer.parseInt(request.getParameter("residentId"));
				String firstName=request.getParameter("firstName");
				String lastName=request.getParameter("lastName");
				String emailId=request.getParameter("emailId");
				Long phoneNo=Long.parseLong(request.getParameter("phoneNo"));
				
				String userId=request.getParameter("userId");
				String password=request.getParameter("password");
				
				addResidentVO addResidentVO = new addResidentVO();
				addResidentVO.setResident_id(residentId);
				addResidentVO.setFirst_name(firstName);
				addResidentVO.setLast_name(lastName);
				addResidentVO.setEmail_id(emailId);
				addResidentVO.setPhone_no(phoneNo);
				
				addResidentVO.setUser_id(userId);
				addResidentVO.setPassword(password);
				
				loginVO loginVO=new loginVO();
				loginVO.setUser_name(userId);
				loginVO.setPassword(password);
				loginDAO loginDAO=new loginDAO();
				List list1 =  addResidentDAO.fetchid(addResidentVO);
				addResidentVO user =(addResidentVO)list1.get(0);
				if(list1 != null && list1.size()>=1)
				{
					int login_id=user.getLoginvo().getLogin_id();
					loginVO.setLogin_id(login_id);
				
				}
				addResidentValidate addResidentValidate=new addResidentValidate();
				String validateMandatory=addResidentValidate.mandatory(addResidentVO);
				String matchFields=addResidentValidate.parameters_resident(addResidentVO);
				if(validateMandatory.equals("All fields are Mandatory") || validateMandatory.equals("First Name is mandatory!") || validateMandatory.equals("Last Name is mandatory!") || validateMandatory.equals("Email Id is mandatory!") || validateMandatory.equals("Address is mandatory!") || validateMandatory.equals("User Id is mandatory!") || validateMandatory.equals("Password is mandatory!")){
					request.setAttribute("error", validateMandatory);
					RequestDispatcher rd=request.getRequestDispatcher("admin/editResident.jsp");
					rd.forward(request, response);
				}
				
				else if(matchFields.equals("Password should be alph-numeric") || matchFields.equals("User Id should be alpha-numeric") || matchFields.equals("Last Name should be alphabets only!") || matchFields.equals("First Name should be alphabets only!") ){
					System.out.println(matchFields);
					request.setAttribute("error", matchFields);
					RequestDispatcher rd=request.getRequestDispatcher("admin/editResident.jsp");
					rd.forward(request, response);
				}
				else{
				
				addResidentDAO addResidentDAO=new addResidentDAO();
				addResidentDAO.update_resident(addResidentVO);
				loginDAO.updatelogin(loginVO);
				
				List<addResidentVO> list_of_all_residents=addResidentDAO.search_all_residents();
				session.setAttribute("search_residents", list_of_all_residents);
				request.setAttribute("error", "Resident Details Updated");
				RequestDispatcher rd=request.getRequestDispatcher("admin/editDeleteResident.jsp");
				rd.forward(request, response);
				}
			}
		else if(flag.equals("add_requested_rental_as_resident")){
			int rental_request_id=Integer.parseInt(request.getParameter("rental_request_id"));
			int apartmentID=Integer.parseInt(request.getParameter("apartmentID"));
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String emailId=request.getParameter("emailId");
			Long phoneNo=Long.parseLong(request.getParameter("phoneNo"));
			String address=request.getParameter("address");
			String userId=request.getParameter("userId");
			String password=request.getParameter("password");
			String userType=request.getParameter("userType");
			
			addResidentVO addResidentVO = new addResidentVO();
			addResidentVO.setFirst_name(firstName);
			addResidentVO.setLast_name(lastName);
			addResidentVO.setEmail_id(emailId);
			addResidentVO.setPhone_no(phoneNo);
			addResidentVO.setUser_id(userId);
			addResidentVO.setPassword(password);
			addResidentVO.setUser_type(userType);
			
			addApartmentVO addApartmentVO=new addApartmentVO();
			addApartmentVO.setApartment_id(apartmentID);
			addResidentVO.setAddApartmentVO(addApartmentVO);
			
			addResidentDAO addResidentDAO=new addResidentDAO();
			
			loginVO loginVO=new loginVO();
			loginVO.setUser_name(userId);
			loginVO.setPassword(password);
			loginVO.setUser_type(userType);
			
			List list2 =  addResidentDAO.authentication_userid(addResidentVO);
			List list =  addResidentDAO.authentication_email(addResidentVO);
			if(list != null && list.size()>=1)
			{
				request.setAttribute("error", "Email Id already Registered");
				List<rentalRequestVO> list_of_all_request=addApartmentDAO.search_all_rental_request();
				session.setAttribute("list_of_all_request", list_of_all_request);
				RequestDispatcher rd=request.getRequestDispatcher("admin/manageRequest.jsp");
				rd.forward(request, response);
			}
			else if(list2 != null && list2.size()>=1)
			{
				request.setAttribute("error", "User Id already Registered");
				List<rentalRequestVO> list_of_all_request=addApartmentDAO.search_all_rental_request();
				session.setAttribute("list_of_all_request", list_of_all_request);
				RequestDispatcher rd=request.getRequestDispatcher("admin/manageRequest.jsp");
				rd.forward(request, response);
			}
			else{
			loginDAO logindao=new loginDAO();
			logindao.add_login(loginVO);
			addResidentVO.setLoginvo(loginVO);
			addResidentVO.setAddress(address);
			addResidentDAO.addResident(addResidentVO);
			
			rentalRequestVO rentalRequestVO=new rentalRequestVO();
			rentalRequestVO.setStatus("approved");
			
			addResidentDAO.update_rental_status(addResidentVO);
			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			List<addApartmentVO> list_of_all_apartments=addApartmentDAO.search_all_apartments();
			session.setAttribute("search_apartments_address1", list_of_all_apartments);
			
			String email_id=addResidentVO.getEmail_id();
			String un=addResidentVO.getUser_id();
			String password1=addResidentVO.getPassword();
			sendMail(email_id,password1,un);
			
			
			request.setAttribute("error", "Resident Added");
			List<rentalRequestVO> list_of_all_request=addApartmentDAO.search_all_rental_request1();
			session.setAttribute("list_of_all_request", list_of_all_request);
			RequestDispatcher rd=request.getRequestDispatcher("admin/manageRequest.jsp");
			rd.forward(request, response);
			}
		}
		
		if(flag.equals("update1")){
			int residentId=Integer.parseInt(request.getParameter("residentId"));
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			
			Long phoneNo=Long.parseLong(request.getParameter("phoneNo"));
			String address=request.getParameter("address");
			
			addResidentVO addResidentVO = new addResidentVO();
			addResidentVO.setResident_id(residentId);
			addResidentVO.setFirst_name(firstName);
			addResidentVO.setLast_name(lastName);
			addResidentVO.setPhone_no(phoneNo);
			addResidentVO.setAddress(address);
			addResidentDAO addResidentDAO=new addResidentDAO();
			addResidentDAO.update_resident1(addResidentVO);
			List<addResidentVO> list_of_all_residents=addResidentDAO.search_all_residents();
			session.setAttribute("search_residents", list_of_all_residents);
			request.setAttribute("error", "Profile updated successfully");
			RequestDispatcher rd=request.getRequestDispatcher("user/index.jsp");
			rd.forward(request, response);
			}	
	}
	String email2;
	String password2;
	String user_name2;
protected void sendMail(String email2,String password2, String user_name2){
		
		java.util.Properties properties = new java.util.Properties();
        properties.put("mail.smtp.auth", "true");
         properties.put("mail.smtp.starttls.enable", "true");
         javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);
        
        try {
        	
            MimeMessage message = new MimeMessage(mailSession);
   
           
            message.setContent("<h1>Makan Login Credentials</h1><br><hr><h2>This is your User Id :"+user_name2+" </h2>" +"<br><h2>and this is Your Password :" +password2+"</h2>","text/html" );
            message.setSubject("Makan Login Credentials");
            
            InternetAddress sender = new InternetAddress(email2,"Mail");
            InternetAddress receiver = new InternetAddress(email2);
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
