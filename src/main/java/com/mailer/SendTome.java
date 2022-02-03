package com.mailer;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SendTome
 */
public class SendTome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendTome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
//    	String phone = request.getParameter("phone");
    	String message=request.getParameter("message");
    	String mail= request.getParameter("mail");
        String subject="dont_replay@Subham";
        String from="subhamsp2419@gmail.com";
        String to="subhamsp2419@gmail.com";
        
    
        
    
//        System.out.println(name+" "+phone+" "+message);
	
		// TODO Auto-generated method stub
		
		//variable for gmail
		String host="smtp.gmail.com";
		
		//system properties
		Properties properties = new Properties();
		
		

		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		
		//session object
		
		Session session=Session.getInstance(properties, new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {


					return new PasswordAuthentication("subhamsp2419@gmail.com","Subham@2001");
			}
			
		});
		
		session.setDebug(true);
		
		//message composing//
		
		MimeMessage mess=new MimeMessage(session);
		
		
		try {
			//from mail
			mess.setFrom(from);
			
			mess.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//subject
			
			mess.setSubject(subject);
			
			
			//text message
			
			mess.setText("Message: "+message+"\n Mail: "+mail+"\n Name: "+name);
			 
			
			
			//send the message using transport class
			
		Transport.send(mess);
			
			System.out.println("Success....");
			
			HttpSession sess=request.getSession();
			sess.setAttribute("message", "Message send Successfully");
			response.sendRedirect("home.jsp");
			return;
			 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
