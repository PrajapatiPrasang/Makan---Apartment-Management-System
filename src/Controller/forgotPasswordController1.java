package Controller;

import java.io.IOException; 
import java.util.List;
import java.util.Random;

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

import DAO.addResidentDAO;
import DAO.loginDAO;
import DAO.recoverPasswordDAO;
import VO.addResidentVO;


/**
 * Servlet implementation class forgotPasswordController1
 */
@WebServlet("/forgotPasswordController1")
public class forgotPasswordController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgotPasswordController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	int OTP;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String flag=request.getParameter("flag");
		if(flag.equals("email")){
			String email = request.getParameter("email");
			
			addResidentVO addResidentVO=new addResidentVO();
			addResidentVO.setEmail_id(email);
			
			loginDAO loginDAO = new loginDAO();
			List ls = loginDAO.forgetPassword(addResidentVO);
			
			if(ls != null && ls.size()>=1)
			{
				session.setAttribute("email", addResidentVO.getEmail_id());
				
				sendMail(email,generateOTP(5));
				
				session.setAttribute("OTP", OTP);
				response.sendRedirect("user/newPassword.jsp");
			}
			else
			{
				response.sendRedirect("admin/email.jsp");
			}
		}
		else if(flag.equals("changepassword")){
			int otp2=(Integer)session.getAttribute("OTP");
			int otp_value=Integer.parseInt(request.getParameter("otp"));
			System.out.println("user entered" +otp_value);
			String newPassword=request.getParameter("newPassword");
			
			if(otp_value==otp2){
				String email=(String)session.getAttribute("email");
				
				addResidentVO addResidentVO=new addResidentVO();
				addResidentVO.setEmail_id(email);
				recoverPasswordDAO cpDAO = new recoverPasswordDAO();
				List list =  cpDAO.authentication(addResidentVO);
				if(list != null && list.size()>=1){
					
					addResidentVO.setPassword(newPassword);;
					addResidentVO user=(addResidentVO) list.get(0);
					String user_id = user.getUser_id();
					addResidentVO.setUser_id(user_id);
					addResidentDAO addResidentDAO=new addResidentDAO();
					addResidentDAO.updatePassword(addResidentVO);
					
					loginDAO loginDAO=new loginDAO();
					loginDAO.updatePassword(addResidentVO);
					response.sendRedirect("user/login.jsp");
				}
			}
			else{
				request.setAttribute("error", "Invalid OTP");
				RequestDispatcher rd=request.getRequestDispatcher("user/newPassword.jsp");
				rd.forward(request, response);
			}
		}
	}
	
	public int generateOTP(int limit) {

        int otp = 0;

        if (limit > 5 || limit < 1)
            limit = 3;

        for (int i = 0; i < limit; i++) {

            int x = new Random().nextInt(9);

            if (x == 0 && i == 0)
                i--;
            else
                otp = (otp * 10) + x;
        }
        OTP=otp;
        
        
        return otp;
    }


	protected void sendMail(String email,int OTP){
		
		java.util.Properties properties = new java.util.Properties();
        properties.put("mail.smtp.auth", "true");
         properties.put("mail.smtp.starttls.enable", "true");
         javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);
        
        try {
        	
            MimeMessage message = new MimeMessage(mailSession);
   
           
            message.setContent("<h1>This is your OTP "+OTP+" Code</h1>","text/html" );
            message.setSubject("OTP for Forgot password");
            
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
