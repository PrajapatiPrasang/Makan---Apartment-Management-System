package Controller;

import java.io.File; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.List;
import java.util.Random;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DAO.addApartmentDAO;
import DAO.addResidentDAO;
import DAO.appointmentDAO;
import DAO.loginDAO;
import VO.addApartmentPhotosVO;
import VO.addApartmentVO;
import VO.addResidentVO;
import VO.loginVO;
import VO.rentalRequestVO;

/**
 * Servlet implementation class addApartmentController
 */
@WebServlet("/addApartmentController")
@MultipartConfig
public class addApartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addApartmentController() {
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
			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			List<addApartmentVO> list_of_all_apartments=addApartmentDAO.search_all_apartments1();
			session.setAttribute("search_apartments", list_of_all_apartments);
			response.sendRedirect("admin/manageApartment.jsp");
		}
		else if(flag.equals("delete_rental_request")){
			int residentId=Integer.parseInt(request.getParameter("rental_request_id"));
			rentalRequestVO rentalRequestVO=new rentalRequestVO();
			rentalRequestVO.setRental_request_id(residentId);
			rentalRequestVO.setStatus("denied");
			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			addApartmentDAO.denyRental(rentalRequestVO);
			//addApartmentDAO.delete_rental_request(rentalRequestVO);
			request.setAttribute("error", "Rental Request Denied");
			List<rentalRequestVO> list_of_all_request=addApartmentDAO.fetch_all_rental_request();
			session.setAttribute("list_of_all_request", list_of_all_request);
			RequestDispatcher rd=request.getRequestDispatcher("admin/manageRequest.jsp");
			rd.forward(request, response);
		}
		else if(flag.equals("assign_username_password")){
			int rental_request_id=Integer.parseInt(request.getParameter("rental_request_id"));
			rentalRequestVO rentalRequestVO=new rentalRequestVO();
			rentalRequestVO.setRental_request_id(rental_request_id);
			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			List<rentalRequestVO> list_of_request=addApartmentDAO.edit_rental_request(rentalRequestVO);
			session.setAttribute("edit_rental_request", list_of_request);
			response.sendRedirect("admin/editRequest.jsp");
			
		}
		else if(flag.equals("delete_apartment")){
			int apartment_id=Integer.parseInt(request.getParameter("apartment_id"));
			addApartmentVO addApartmentVO=new addApartmentVO();
			addApartmentVO.setApartment_id(apartment_id);
			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			addApartmentDAO.delete_apartment(addApartmentVO);
			
			addApartmentDAO addApartmentDAO1=new addApartmentDAO();
			List<addApartmentVO> list_of_all_apartments=addApartmentDAO1.search_all_apartments();
			session.setAttribute("search_apartments", list_of_all_apartments);
			request.setAttribute("error", "Apartment Details Deleted");
			RequestDispatcher rd=request.getRequestDispatcher("admin/manageApartment.jsp");
			rd.forward(request, response);
		}
		else if(flag.equals("edit_apartments")){
			int apartment_id=Integer.parseInt(request.getParameter("apartment_id"));
			addApartmentVO addApartmentVO=new addApartmentVO();
			addApartmentVO.setApartment_id(apartment_id);
			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			List<addApartmentVO> list_of_apartments=addApartmentDAO.edit_apartments(addApartmentVO);
			session.setAttribute("edit_apartments", list_of_apartments);
			response.sendRedirect("admin/editApartment.jsp");
		}
		else if(flag.equals("list")){
			
			int apartment_id=Integer.parseInt(request.getParameter("apartment_id"));
			addApartmentVO addApartmentVO=new addApartmentVO();
			addApartmentVO.setApartment_id(apartment_id);
			
			addApartmentPhotosVO addApartmentPhotosVO=new addApartmentPhotosVO();
			addApartmentPhotosVO.setAddApartmentVO(addApartmentVO);
			
			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			List<addApartmentVO> list_of_apartments=addApartmentDAO.edit_apartments(addApartmentVO);
			List<addApartmentPhotosVO> list_of_apartment_photos=addApartmentDAO.apartment_photos(addApartmentPhotosVO);
			session.setAttribute("list_of_apartment_photos", list_of_apartment_photos);
			session.setAttribute("edit_apartments1", list_of_apartments);
			response.sendRedirect("user/viewPropertyDetail.jsp");
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
			for(Part filePart : request.getParts())
			{
				if(filePart.getSubmittedFileName()!=null && !filePart.getSubmittedFileName().equals(""))
				{					
					String fileName = filePart.getSubmittedFileName();
					session.setAttribute("fileName",fileName);
				    InputStream fileContent = filePart.getInputStream();
				    byte[] buffer = new byte[fileContent.available()];
					fileContent.read(buffer);	
					String filePath = getServletContext().getRealPath(request.getServletPath());
					int path = filePath.lastIndexOf('\\');
					String path1= filePath.substring(0, path) +"\\doc\\";
					String encryptFileName = encryptFileName(fileName);
					session.setAttribute("encryptedName", encryptFileName);
				    File targetEncryptFile = new File(path1+encryptFileName);
				    OutputStream outStream = new FileOutputStream(targetEncryptFile);
				    outStream.write(buffer);
				    outStream.close();
				}
			}
			String rental_status=request.getParameter("rental_status");
			String apartmentAddress=request.getParameter("address");
			int bedroom=Integer.parseInt(request.getParameter("bedroom"));
			int bathroom=Integer.parseInt(request.getParameter("bathroom"));
			String amenities=request.getParameter("amenities");
			Long zipCode=Long.parseLong(request.getParameter("zipCode"));
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			Float price=Float.parseFloat(request.getParameter("price"));
			String file_name=(String)session.getAttribute("fileName");
			String encrypted_name=(String)session.getAttribute("encryptedName");
			
			addApartmentVO addApartmentVO=new addApartmentVO();
			addApartmentVO.setAddress(apartmentAddress);
			addApartmentVO.setBedroom(bedroom);
			addApartmentVO.setBathroom(bathroom);
			addApartmentVO.setAminities(amenities);
			addApartmentVO.setZip_code(zipCode);
			addApartmentVO.setCity(city);
			addApartmentVO.setState(state);
			addApartmentVO.setPrice(price);
			addApartmentVO.setFile_name(file_name);
			addApartmentVO.setEncrypted_name(encrypted_name);
			addApartmentVO.setRental_status(rental_status);
			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			int apartment_id=addApartmentDAO.addApartment(addApartmentVO);
			request.setAttribute("error", "Apartment Details Added");
			RequestDispatcher rd=request.getRequestDispatcher("admin/addApartment.jsp");
			rd.forward(request, response);
		
		}
		else if(flag.equals("addRental")){
			int apartment_id=Integer.parseInt(request.getParameter("apartment_id"));
			String first_name=request.getParameter("firstname");
			String last_name=request.getParameter("lastname");
			String email_id=request.getParameter("email");
			Long phone=Long.parseLong(request.getParameter("phone"));
			String address=request.getParameter("address");


			rentalRequestVO rentalRequestVO=new rentalRequestVO();
			rentalRequestVO.setFirst_name(first_name);
			rentalRequestVO.setLast_name(last_name);
			rentalRequestVO.setEmail_id(email_id);
			rentalRequestVO.setPhone_no(phone);
			rentalRequestVO.setAddress(address);
			rentalRequestVO.setStatus("pending");

			addApartmentVO addApartmentVO=new addApartmentVO();
			addApartmentVO.setApartment_id(apartment_id);
			rentalRequestVO.setAddApartmentVO(addApartmentVO);

			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			List list =  addApartmentDAO.authentication_request(rentalRequestVO);

			if(list.size()==0){
			int rental_id=addApartmentDAO.addRentalRequest(rentalRequestVO);
			rentalRequestVO.setRental_request_id(rental_id);
			session.setAttribute("rental_request_id", rental_id);
			appointmentDAO appointmentDAO = new appointmentDAO();
			List<rentalRequestVO> rental_data=appointmentDAO.getRentalData(rentalRequestVO);
			session.setAttribute("rental_data", rental_data);
			sendMail(email_id,rental_id,first_name,address);
			
			response.sendRedirect("user/viewRentalData.jsp");

			}
			else{
			request.setAttribute("error", "You already have Rental Request for this Apartment");
			RequestDispatcher rd=request.getRequestDispatcher("user/index.jsp");
			rd.forward(request, response);
			}
			
		}
		else if(flag.equals("update")){
			int apartment_id=Integer.parseInt(request.getParameter("apartmentId"));
			String apartmentAddress=request.getParameter("address");
			int bedroom=Integer.parseInt(request.getParameter("bedroom"));
			int bathroom=Integer.parseInt(request.getParameter("bathroom"));
			String amenities=request.getParameter("amenities");
			Long zipCode=Long.parseLong(request.getParameter("zipCode"));
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			Float price=Float.parseFloat(request.getParameter("price"));
			
			addApartmentVO addApartmentVO=new addApartmentVO();
			addApartmentVO.setApartment_id(apartment_id);
			addApartmentVO.setAddress(apartmentAddress);
			addApartmentVO.setBedroom(bedroom);
			addApartmentVO.setBathroom(bathroom);
			addApartmentVO.setAminities(amenities);
			addApartmentVO.setZip_code(zipCode);
			addApartmentVO.setCity(city);
			addApartmentVO.setState(state);
			addApartmentVO.setPrice(price);
			
			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			addApartmentDAO.updateApartment(addApartmentVO);
			
			addApartmentDAO addApartmentDAO1=new addApartmentDAO();
			List<addApartmentVO> list_of_all_apartments=addApartmentDAO1.search_all_apartments();
			session.setAttribute("search_apartments", list_of_all_apartments);
			request.setAttribute("error", "Apartment Details Updated");
			RequestDispatcher rd=request.getRequestDispatcher("admin/manageApartment.jsp");
			rd.forward(request, response);
		}
	}
	
	private String encryptFileName(String fileName){
		 
		   Random r = new Random();
		   String file[] = fileName.split("\\.");
		  
		   byte[] unencodedFile = file[0].getBytes();
		   MessageDigest md = null;
		   try {
		   md = MessageDigest.getInstance("MD5");
		   } catch (Exception e) {}
		   md.reset();
		   md.update(unencodedFile);
		   byte[] encodedFile = md.digest();
		   StringBuffer buf = new StringBuffer();
		   for (int i = 0; i < encodedFile.length; i++) {
		   if (((int) encodedFile[i] & 0xff) < 0x10) {
		   buf.append("0");
		   }
		   buf.append(Long.toString((int) encodedFile[i] & 0xff, 16));
		   }
		  
		   String encryptedFileName=(buf.toString()).concat(String.valueOf(r.nextInt())); 
		   return encryptedFileName+"."+file[1];
		   
	}
protected void sendMail(String email2,int rental_id, String first_name, String address){
		
		java.util.Properties properties = new java.util.Properties();
        properties.put("mail.smtp.auth", "true");
         properties.put("mail.smtp.starttls.enable", "true");
         javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);
        
        try {
        	
            MimeMessage message = new MimeMessage(mailSession);
   
           
            message.setContent("<h1>Rental Request Received</h1><br><hr><h2>Hi :"+first_name+" </h2>" +"<br><h2>We have received your rental Request for Apartment "+ address+"And, This is your Rental Request Id :" +rental_id+" Keep this to check your Rental Status.</h2>","text/html" );
            message.setSubject("Rental Request Received");
            
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
