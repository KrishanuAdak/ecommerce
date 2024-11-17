package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Servlet implementation class EmailOTP
 */
public class EmailOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailOTP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String customer_id=request.getParameter("customer_id");
			String address1=request.getParameter("address1");
			String pin=request.getParameter("pincode");
			String land=request.getParameter("landmark");
			String state=request.getParameter("state");
			String vill=request.getParameter("village");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
			String sql="update address_customer set pincode=?,village=?,landmark=?,address1=?,state=? where customer_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,pin);
			ps.setString(2, vill);
			ps.setString(3, land);
			ps.setString(4, address1);
			ps.setString(5,state);
			ps.setInt(6,Integer.parseInt(customer_id));
			System.out.println(pin+""+vill+""+address1+""+state);
			int r=ps.executeUpdate();
			if(r>0)
			{
				System.out.println("Updated Address"+r);
				response.sendRedirect("FinalPage.jsp");
			}
		} 
		catch (ClassNotFoundException | SQLException  e) {
	
			e.printStackTrace();
		}		


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customer_id=request.getParameter("customer_id");
		String address1=request.getParameter("address1");
		String pin=request.getParameter("pincode");
		String land=request.getParameter("landmark");
		String state=request.getParameter("state");
		String vill=request.getParameter("village");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
			String sql="insert into address_customer values (?,?,?,?,?,?,?)";			
			PreparedStatement ps=con.prepareStatement(sql);
			Random rand=new Random();
			int id=rand.nextInt(90000)+10000;
			ps.setInt(1,id);
			ps.setInt(2, Integer.parseInt(customer_id));
			ps.setInt(3, Integer.parseInt(pin));
			ps.setString(4,address1);
			ps.setString(5,vill);
			ps.setString(6,land);
			ps.setString(7, state);
			int r=ps.executeUpdate();
			if(r>0)
			{
				response.sendRedirect("FinalPage.jsp");
			}
			
			
		}
		catch(ClassNotFoundException | SQLException  e)
		{
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		String email = request.getParameter("email");
//        int otp = generateOTP();
//
//        // Send OTP to the email address
//        boolean result = sendEmail(email, otp);
//
//        if (result) {
//            // Store OTP in session
//            HttpSession session = request.getSession();
//            session.setAttribute("otp", otp);
//            session.setAttribute("email", email);
//            response.sendRedirect("verifyEmailOtp.jsp");
//        } else {
//            response.getWriter().println("Failed to send OTP. Try again.");
//        }
//    }
//
//    private int generateOTP() {
//        Random random = new Random();
//        return 100000 + random.nextInt(900000); // 6-digit OTP
//    }
//
//    private boolean sendEmail(String to, int otp) {
//    	return true;
    	
//        // SMTP server configuration
//        String host = "smtp-relay.sendinblue.com"; // replace with your SMTP server
//        final String username = "7b0fac001@smtp-brevo.com"; // replace with your email
//        final String password = "5XMxaLZ3pgkY8WUR"; // replace with your password
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//            message.setSubject("Your OTP Code");
//            message.setText("Your OTP is: " + otp);
//
//            Transport.send(message);
//            return true;
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            return false;
//        }
	
	}

}
