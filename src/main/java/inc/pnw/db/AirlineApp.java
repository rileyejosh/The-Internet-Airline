package inc.pnw.db;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.logging.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import java.io.FileWriter;

/**
 * Servlet implementation class AirlineApp, responsible for receiving requests from the client. It
 * also invokes the DAO to get a list of items from the database, saves this list as an attribute in
 * the request, and then forwards the request to a JSP page.
 * 
 * @author Joshua Riley
 */

/*
 * Declares the AirlineApp servlet. // The urlPatterns of the servlet mapping in your @WebServlet
 * annotation should include the URL of the servlet that handles the form submission.
 */
@WebServlet(urlPatterns = {"", "/departureflight", "/returnflight"})
public class AirlineApp extends HttpServlet {
  private static final long serialVersionUID = 1L;

  static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(AirlineApp.class);
  

  /**
   * @see HttpServlet#HttpServlet()
   */
  public AirlineApp() {
    super();

  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      LOGGER.info("In doGet");

      String requestURI = request.getRequestURI();
      String page = null;

      // handle url requests
      if (requestURI.endsWith("/")) {
        page = "";
      } else if (requestURI.endsWith("departureflight")) {
        page = "/departureflight.jsp";

      } else if (requestURI.endsWith("returnflight")) {
        page = "/returnflight.jsp";
      } else {
        page = "/error.jsp";
      }

      switch (page) {
        case "":
          try {
            
            request.setAttribute("listCity", CityService.listCity());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            
          } catch (ServletException e) {

            e.printStackTrace();
          } catch (IOException e) {

            e.printStackTrace();
          }
          break;
        case "/departureflight.jsp":
          LOGGER.info("Under Construction");
          break;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LOGGER.info("In doPost");
    String action = request.getParameter("action");

    LOGGER.info("The action is: " + action);
    // handle actions
    if (action.equals("departure")) {
      FlightService.action = "departure";  
      String origCity = request.getParameter("ocity");
      String destCity = request.getParameter("dcity");
      String dYear = request.getParameter("dyear");
      String dDay = request.getParameter("dday");
      String dMonth = request.getParameter("dmonth");
      String dateString = dYear + "-" + dMonth + "-" + dDay;

      try {
        java.sql.Date dDate = ServiceBase.formatDate(dateString);
        List<FlightDTO> listDepartureFlight = FlightService.getCityNamesForFlights(FlightService.retrieveDepartureFlights(origCity, destCity, dDate));
        try {

          HttpSession session = request.getSession(true);
          session.setAttribute("df", listDepartureFlight);
          // TODO: Display message if no flights are returned.
          response.sendRedirect(request.getContextPath() + "/departureflight.jsp");

          // Retrieve the Return Date
          String rYear = request.getParameter("ryear");
          String rMonth = request.getParameter("rmonth");
          String rDay = request.getParameter("rday");
          String rDate = rYear + "-" + rMonth + "-" + rDay;
          LOGGER.info(dateString);

          // Get current session
          session = request.getSession();

          // Store Departure and Return Date in the current session
          LOGGER.info("Departure date is " + dDate);
          LOGGER.info("Return date is " + rDate);
          session.setAttribute("ReturnDate", rDate);
          session.setAttribute("DepartureDate", dDate);

        } catch (Exception e) {
          e.printStackTrace();
        }
      } catch (Exception e) {
        System.out.println("Error parsing date: " + e.getMessage());
      }
    }
    if (action.equals("return")) {
      FlightService.action = "return";
      java.sql.Date dFormattedDate;
      java.sql.Date rFormattedDate;
      HttpSession session = request.getSession();
      try {

        dFormattedDate = ServiceBase.formatDate(session.getAttribute("DepartureDate").toString());
        rFormattedDate = ServiceBase.formatDate(session.getAttribute("ReturnDate").toString());

        try {
          
          List<FlightDTO> listReturnFlight =
              FlightService.getCityNamesForFlights(FlightService.retrieveReturnFlights(6, rFormattedDate));
          session.setAttribute("rf", listReturnFlight);
          response.sendRedirect(request.getContextPath() + "/returnflight.jsp");

        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
