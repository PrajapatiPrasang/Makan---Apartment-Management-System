package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.List;
import java.util.Random;

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
import DAO.addApartmentPhotosDAO;
import VO.addApartmentPhotosVO;
import VO.addApartmentVO;

/**
 * Servlet implementation class addApartmentPhotosController
 */
@WebServlet("/addApartmentPhotosController")
@MultipartConfig
public class addApartmentPhotosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addApartmentPhotosController() {
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
		if(flag.equals("dropdown")){
			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			List<addApartmentVO> list_of_all_apartments=addApartmentDAO.search_all_apartments();
			session.setAttribute("search_apartments_address", list_of_all_apartments);
			response.sendRedirect("admin/addApartmentPhotos.jsp");
		}
		
		else if(flag.equals("search")){
			addApartmentPhotosDAO addApartmentPhotosDAO=new addApartmentPhotosDAO();
			List<addApartmentPhotosVO> list_of_all_apartments_photos=addApartmentPhotosDAO.search_all_apartments_photos();
			session.setAttribute("search_apartments_photos", list_of_all_apartments_photos);
			response.sendRedirect("admin/manageApartmentPhotos.jsp");
			
			
		}
		else if(flag.equals("delete")){
			
			int photo_id=Integer.parseInt(request.getParameter("photo_id"));
			addApartmentPhotosVO addApartmentPhotosVO=new addApartmentPhotosVO();
			addApartmentPhotosVO.setPhoto_id(photo_id);
			addApartmentPhotosDAO addApartmentPhotosDAO=new addApartmentPhotosDAO();
			addApartmentPhotosDAO.delete_apartment_photos(addApartmentPhotosVO);
			
			
			List<addApartmentPhotosVO> list_of_all_apartments_photos=addApartmentPhotosDAO.search_all_apartments_photos();
			session.setAttribute("search_apartments_photos", list_of_all_apartments_photos);
			request.setAttribute("error", "Apartment Photo Deleted");
			RequestDispatcher rd=request.getRequestDispatcher("admin/manageApartmentPhotos.jsp");
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
			String file_name=(String)session.getAttribute("fileName");
			String encrypted_name=(String)session.getAttribute("encryptedName");
			int apartment_id=Integer.parseInt(request.getParameter("apartmentID"));
			System.out.println("Apartment id "+apartment_id);
			addApartmentPhotosVO addApartmentPhotosVO=new addApartmentPhotosVO();
			addApartmentPhotosVO.setFile_name(file_name);
			addApartmentPhotosVO.setEncrypted_name(encrypted_name);

			addApartmentVO addApartmentVO = new addApartmentVO();
			addApartmentVO.setApartment_id(apartment_id);
			addApartmentPhotosVO.setAddApartmentVO(addApartmentVO);
			
			addApartmentPhotosDAO addApartmentPhotosDAO=new addApartmentPhotosDAO();
			addApartmentPhotosDAO.add_photos(addApartmentPhotosVO);
			
			//values for dropdown menu
			addApartmentDAO addApartmentDAO=new addApartmentDAO();
			List<addApartmentVO> list_of_all_apartments=addApartmentDAO.search_all_apartments();
			session.setAttribute("search_apartments_address", list_of_all_apartments);
			
			
			request.setAttribute("error", "Apartment Photo added");
			
			RequestDispatcher rd=request.getRequestDispatcher("admin/addApartmentPhotos.jsp");
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
}
