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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

<<<<<<< Updated upstream
  static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(AirlineApp.class);
<<<<<<< Updated upstream
  
=======
=======
  private static final Logger LOGGER = LogManager.getLogger(AirlineApp.class);

>>>>>>> Stashed changes

>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
          try {
            
            request.setAttribute("listCity", CityService.listCity());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            
          } catch (ServletException e) {
=======
>>>>>>> Stashed changes

          request.setAttribute("listCity", CityService.listCity());
          RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
          dispatcher.forward(request, response);


          break;
        case "departureflight.jsp":
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

    String action = request.getParameter("action");

    // handle actions
    if (action.equals("departure")) {
<<<<<<< Updated upstream
      FlightService.action = "departure";  
=======
<<<<<<< Updated upstream

=======
      
      LOGGER.info("Do Departure");
      FlightService.action = "departure";
>>>>>>> Stashed changes
>>>>>>> Stashed changes
      String origCity = request.getParameter("ocity");
      LOGGER.info(origCity);
      String destCity = request.getParameter("dcity");
      String dYear = request.getParameter("dyear");
      String dDay = request.getParameter("dday");
      String dMonth = request.getParameter("dmonth");
      String dateString = dYear + "-" + dMonth + "-" + dDay;

      try {
<<<<<<< Updated upstream
        java.sql.Date dDate = ServiceBase.formatDate(dateString);
        List<FlightDTO> listDepartureFlight = FlightService.getCityNamesForFlights(FlightService.retrieveDepartureFlights(origCity, destCity, dDate));
=======
<<<<<<< Updated upstream
        java.sql.Date dDate = formatDate(dateString);
        List<DepartureFlightModel> listDepartureFlight =
            retrieveDepartureFlights(origCity, destCity, dDate);

=======
        LOGGER.info("Retrieving Departure Flights");
        java.sql.Date dDate = ServiceBase.formatDate(dateString);
        LOGGER.info(dDate.toString());
        List<FlightDTO> listDepartureFlight = FlightService.getCityNamesForFlights(
            FlightService.retrieveDepartureFlights(origCity, destCity, dDate));
>>>>>>> Stashed changes
>>>>>>> Stashed changes
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
          
          


          // Get current session
          session = request.getSession();

          // Store the inside the session attribute 
          // Store the return date inside the session attribute "ReturnDate"
          session.setAttribute("ReturnDate", rDate);

        } catch (Exception e) {
          e.printStackTrace();
        }
      } catch (Exception e) {
        System.out.println("Error parsing date: " + e.getMessage());
      }
    }
    if (action.equals("return")) {
<<<<<<< Updated upstream
      FlightService.action = "return";
=======
<<<<<<< Updated upstream

>>>>>>> Stashed changes
      java.sql.Date dFormattedDate;
=======
      LOGGER.info("Do Return");
      FlightService.action = "return";
      //Retrieve the selected departure flight
      String[] selectedIndices = request.getParameterValues("selectedFlight");
      LOGGER.info(selectedIndices[0]);

      
>>>>>>> Stashed changes
      java.sql.Date rFormattedDate;
      List<FlightDTO> listReturnFlight;
      HttpSession session = request.getSession();
      try {

<<<<<<< Updated upstream
        dFormattedDate = ServiceBase.formatDate(session.getAttribute("DepartureDate").toString());
        rFormattedDate = ServiceBase.formatDate(session.getAttribute("ReturnDate").toString());
=======
<<<<<<< Updated upstream
        dFormattedDate = formatDate(session.getAttribute("DepartureDate").toString());
        rFormattedDate = formatDate(session.getAttribute("ReturnDate").toString());
>>>>>>> Stashed changes

        try {
          
          List<FlightDTO> listReturnFlight =
              FlightService.getCityNamesForFlights(FlightService.retrieveReturnFlights(6, rFormattedDate));
          session.setAttribute("rf", listReturnFlight);
          response.sendRedirect(request.getContextPath() + "/returnflight.jsp");

        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
=======
        rFormattedDate = ServiceBase.formatDate(session.getAttribute("ReturnDate").toString());
        if (selectedIndices != null) {
            
            listReturnFlight = FlightService.getCityNamesForFlights(
                FlightService.retrieveReturnFlights(Integer.parseInt(ServiceBase.filterJson(selectedIndices[0], "flightNumber").trim()), rFormattedDate));
            LOGGER.info(listReturnFlight.size());
            session.setAttribute("rf", listReturnFlight);
            response.sendRedirect(request.getContextPath() + "/returnflight.jsp");
        } 
        LOGGER.info(rFormattedDate);

>>>>>>> Stashed changes
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
