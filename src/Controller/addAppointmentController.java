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

import VO.addApartmentVO;
import VO.addAppointmentVO;
import VO.rentalRequestVO;
import DAO.addApartmentDAO;
import DAO.appointmentDAO;


/**
 * Servlet implementation class addAppointmentController
 */
@WebServlet("/addAppointmentController")
public class addAppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAppointmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		String flag=request.getParameter("flag");
		
		if(flag.equals("search")){
			int apartment_id=Integer.parseInt(request.getParameter("apartment_id"));
			addApartmentVO addApartmentVO=new addApartmentVO();
			addApartmentVO.setApartment_id(apartment_id);
			addAppointmentVO addAppointmentVO= new addAppointmentVO();
			addAppointmentVO.setAddApartmentVO(addApartmentVO);
			appointmentDAO appointmentDAO=new appointmentDAO();
			List<addApartmentVO> list_of_apartments=appointmentDAO.all_apartments(addApartmentVO);
			session.setAttribute("apartments", list_of_apartments);
			response.sendRedirect("user/appointment.jsp");
		}
		else if(flag.equals("fetchAddress")){
			int apartment_id=Integer.parseInt(request.getParameter("apartment_id"));
			addApartmentVO addApartmentVO=new addApartmentVO();
			addApartmentVO.setApartment_id(apartment_id);
			addApartmentDAO addApartmentDAO=new addApartmentDAO(); 
			List<addApartmentVO> list_of_apartments=addApartmentDAO.apartment_address(addApartmentVO);
			session.setAttribute("apartment_address", list_of_apartments);
			response.sendRedirect("user/rentalRequest.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		HttpSession session=request.getSession();
		
		String flag=request.getParameter("flag");
		if(flag.equals("add")){
		int apartment_id=Integer.parseInt(request.getParameter("apartment_id"));
		//System.out.println(apartment_id);
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String date = request.getParameter("date");
		String slot = request.getParameter("slot");
		String apt_address=request.getParameter("apt_address");
		
		
		addAppointmentVO addAppointmentVO=new addAppointmentVO();
		addAppointmentVO.setFirstname(firstname);
		addAppointmentVO.setLastname(lastname);
		addAppointmentVO.setEmaiid(email);
		addAppointmentVO.setPhoneno(phone);
		addAppointmentVO.setAddress(address);
		addAppointmentVO.setDate(date);
		addAppointmentVO.setSlot(slot);
		
		addApartmentVO addApartmentVO=new addApartmentVO();
		addApartmentVO.setApartment_id(apartment_id);
		addAppointmentVO.setAddApartmentVO(addApartmentVO);
		int appointment_id=appointmentDAO.insertNewAppointment(addAppointmentVO);
		addAppointmentVO.setAppointment_id(appointment_id);
		List<addAppointmentVO> list_of_appointments=appointmentDAO.searchAppointment(addAppointmentVO);
		session.setAttribute("view_appointments", list_of_appointments);
		addAppointmentVO user=list_of_appointments.get(0);
		int apartment_id2=user.getAddApartmentVO().getApartment_id();
		addApartmentVO.setApartment_id(apartment_id2);
		

		appointmentDAO appointmentDAO=new appointmentDAO();
		List<addApartmentVO> list_of_apartments=appointmentDAO.all_apartments(addApartmentVO);
		session.setAttribute("apartments_address", list_of_apartments);
		sendMail(email,appointment_id,firstname,apt_address,date,slot);
		response.sendRedirect("user/appointmentsuccess.jsp");
	}
		else if(flag.equals("fetch")){
		int appointmentid=Integer.parseInt(request.getParameter("appointmentid"));
		String emailid=request.getParameter("emailid");
		
		addAppointmentVO addAppointmentVO=new addAppointmentVO();
		addAppointmentVO.setAppointment_id(appointmentid);
		addAppointmentVO.setEmaiid(emailid);
		session.setAttribute("appointment_id", appointmentid);
		appointmentDAO appointmentDAO = new appointmentDAO();
		addApartmentVO addApartmentVO=new addApartmentVO();
		List list =  appointmentDAO.fetch_appointment(addAppointmentVO);
		if(list != null && list.size()>=1)
		{
			
			addAppointmentVO user1=(addAppointmentVO) list.get(0);
			int appointment_id=user1.getAppointment_id();
			addAppointmentVO.setAppointment_id(appointment_id);
			List<addAppointmentVO> list_of_appointments=appointmentDAO.updateAppointment(addAppointmentVO);
			addAppointmentVO user=list_of_appointments.get(0);
			int apartment_id2=user.getAddApartmentVO().getApartment_id();
			addApartmentVO.setApartment_id(apartment_id2);
			List<addApartmentVO> list_of_apartments=appointmentDAO.all_apartments(addApartmentVO);
			session.setAttribute("apartments_address", list_of_apartments);
			session.setAttribute("update_appointments", list_of_appointments);
			response.sendRedirect("user/updateAppointment.jsp");
		}
		else{
			request.setAttribute("error", "Invalid Appointment Id ");
			RequestDispatcher rd=request.getRequestDispatcher("user/changeAppointment.jsp");
			rd.forward(request, response);
			
		
	}
		
	}
	else if(flag.equals("update")){
		int appointment_id=(int) session.getAttribute("appointment_id");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String date = request.getParameter("date");
		String slot = request.getParameter("slot");
		
		addAppointmentVO addAppointmentVO=new addAppointmentVO();
		addAppointmentVO.setAppointment_id(appointment_id);
		addAppointmentVO.setFirstname(firstname);
		addAppointmentVO.setLastname(lastname);
		addAppointmentVO.setEmaiid(email);
		addAppointmentVO.setPhoneno(phone);
		addAppointmentVO.setAddress(address);
		addAppointmentVO.setDate(date);
		addAppointmentVO.setSlot(slot);
		
		appointmentDAO appointmentDAO=new appointmentDAO();
		appointmentDAO.update_appointment(addAppointmentVO);
		addApartmentVO addApartmentVO=new addApartmentVO();
		List<addAppointmentVO> list_of_appointments=appointmentDAO.searchAppointment1(addAppointmentVO);
		if(list_of_appointments != null && list_of_appointments.size() >=1){
			addAppointmentVO user1=(addAppointmentVO) list_of_appointments.get(0);
			int appointment_id1=user1.getAppointment_id();
			
			addAppointmentVO.setAppointment_id(appointment_id1);
			List<addAppointmentVO> list_of_appointments1=appointmentDAO.updateAppointment(addAppointmentVO);
			
			
			addAppointmentVO user=list_of_appointments1.get(0);
			int apartment_id2=user.getAddApartmentVO().getApartment_id();
			addApartmentVO.setApartment_id(apartment_id2);
			List<addApartmentVO> list_of_apartments=appointmentDAO.all_apartments(addApartmentVO);
			session.setAttribute("apartments_address", list_of_apartments);
		session.setAttribute("view_appointments1", list_of_appointments);
		response.sendRedirect("user/appointmentupdated.jsp");
		}
		else{
			request.setAttribute("error", "Invalid Appointment Id ");
			RequestDispatcher rd=request.getRequestDispatcher("user/updateAppointment.jsp");
			rd.forward(request, response);
			
		
	}
	}
	else if(flag.equals("view")){
		int appointmentid=Integer.parseInt(request.getParameter("appointmentid"));
		String emailid=request.getParameter("emailid");
		addAppointmentVO addAppointmentVO=new addAppointmentVO();
		addAppointmentVO.setAppointment_id(appointmentid);
		addAppointmentVO.setEmaiid(emailid);
		session.setAttribute("appointment_id", appointmentid);
		appointmentDAO appointmentDAO = new appointmentDAO();
		addApartmentVO addApartmentVO=new addApartmentVO();
		List list =  appointmentDAO.fetch_appointment(addAppointmentVO);
		if(list != null && list.size()>=1)
		{
			addAppointmentVO user1=(addAppointmentVO) list.get(0);
			int appointment_id=user1.getAppointment_id();
			
			addAppointmentVO.setAppointment_id(appointment_id);
			List<addAppointmentVO> list_of_appointments=appointmentDAO.updateAppointment(addAppointmentVO);
			
			
			addAppointmentVO user=list_of_appointments.get(0);
			int apartment_id2=user.getAddApartmentVO().getApartment_id();
			addApartmentVO.setApartment_id(apartment_id2);
			List<addApartmentVO> list_of_apartments=appointmentDAO.all_apartments(addApartmentVO);
			session.setAttribute("apartments_address", list_of_apartments);
			session.setAttribute("view_appointments", list_of_appointments);
			response.sendRedirect("user/appointmentsuccess.jsp");
			}
			else{
				request.setAttribute("error", "Invalid Appointment Id ");
				RequestDispatcher rd=request.getRequestDispatcher("user/viewAppointment.jsp");
				rd.forward(request, response);
				
			
		}
	}
	else if(flag.equals("viewRentalRequest")){
		int rental_request_id=Integer.parseInt(request.getParameter("rental_id"));
		String emailid=request.getParameter("emailid");
		
		rentalRequestVO rentalRequestVO=new rentalRequestVO();
		rentalRequestVO.setRental_request_id(rental_request_id);
		rentalRequestVO.setEmail_id(emailid);
		
	
		session.setAttribute("rental_request_id", rental_request_id);
		
		
		
		appointmentDAO appointmentDAO = new appointmentDAO();
		
		List list =  appointmentDAO.fetch_rental_request(rentalRequestVO);
		
		
		if(list != null && list.size()>=1)
		{
			rentalRequestVO user1=(rentalRequestVO) list.get(0);
			int rental_request_id1=user1.getRental_request_id();
			rentalRequestVO.setRental_request_id(rental_request_id1);
			
			List<rentalRequestVO> rental_data=appointmentDAO.getRentalData(rentalRequestVO);
			
			session.setAttribute("rental_data", rental_data);
			response.sendRedirect("user/viewRentalData.jsp");
			}
		
			else{
				request.setAttribute("error", "Invalid Request Rental Id ");
				RequestDispatcher rd=request.getRequestDispatcher("user/viewRentalRequest.jsp");
				rd.forward(request, response);
				
			
		}
	}
	else if(flag.equals("delete")){
		int appointmentid=Integer.parseInt(request.getParameter("appointmentid"));
		String emailid=request.getParameter("emailid");
		addAppointmentVO addAppointmentVO=new addAppointmentVO();

		addAppointmentVO.setAppointment_id(appointmentid);
		addAppointmentVO.setEmaiid(emailid);
		appointmentDAO appointmentDAO=new appointmentDAO();
		
		List<addAppointmentVO> list_of_appointments=appointmentDAO.searchAppointment2(addAppointmentVO);
		
		if(list_of_appointments!=null && list_of_appointments.size()>=1){
		
		
		appointmentDAO.delete_appointment(addAppointmentVO);
		request.setAttribute("error", "Appointment Cancelled");
		RequestDispatcher rd=request.getRequestDispatcher("user/index.jsp");
		rd.forward(request, response);
		}
		else{
			request.setAttribute("error", "Invalid Appointment Id ");
			RequestDispatcher rd=request.getRequestDispatcher("user/cancelAppointment.jsp");
			rd.forward(request, response);
			
		}
	}
	else if(flag.equals("cancelRentalRequest")){
		int rental_id=Integer.parseInt(request.getParameter("rental_id"));
		String emailid=request.getParameter("emailid");
		rentalRequestVO rentalRequestVO=new rentalRequestVO();
		rentalRequestVO.setRental_request_id(rental_id);
		rentalRequestVO.setEmail_id(emailid);
		appointmentDAO appointmentDAO=new appointmentDAO();
		List<rentalRequestVO> list_of_appointments=appointmentDAO.searchRentalRequest(rentalRequestVO);
		if(list_of_appointments!=null && list_of_appointments.size()>=1){
		rentalRequestVO data=list_of_appointments.get(0);
		String status=data.getStatus();
		if(status.equals("pending")){
		appointmentDAO.delete_rental(rentalRequestVO);
		request.setAttribute("error", "Rental Request Cancelled");
		RequestDispatcher rd=request.getRequestDispatcher("user/index.jsp");
		rd.forward(request, response);
		}
		else if(status.equals("denied")){
			request.setAttribute("error", "Your Rental Request is denied, So it can't be Deleted ");
			RequestDispatcher rd=request.getRequestDispatcher("user/index.jsp");
			rd.forward(request, response);
		}
		else{
			request.setAttribute("error", "Your Rental Request is Approved, So it can't be Deleted ");
			RequestDispatcher rd=request.getRequestDispatcher("user/index.jsp");
			rd.forward(request, response);
		}
		}
		else{
			request.setAttribute("error", "Invalid Rental Request Id ");
			RequestDispatcher rd=request.getRequestDispatcher("user/cancelRentalRequest.jsp");
			rd.forward(request, response);
			
		}
	}
	
}
protected void sendMail(String email2,int rental_id, String first_name, String address,String date, String slot){
		
		java.util.Properties properties = new java.util.Properties();
        properties.put("mail.smtp.auth", "true");
         properties.put("mail.smtp.starttls.enable", "true");
         javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);
        
        try {
        	
            MimeMessage message = new MimeMessage(mailSession);
   
           
            message.setContent("<h1>Appointment Confirmation</h1><br><hr><h2>Hi :"+first_name+" </h2>" +"<br><h2>We have confirmed your Appointment for Apartment:<br> "+ address+",<br> on : " +date+"<br> time: "+slot +" <br>And Your Appointment Id is "+ rental_id+". 	</h2>","text/html" );
            message.setSubject("Appointment Confirmation");
            
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

