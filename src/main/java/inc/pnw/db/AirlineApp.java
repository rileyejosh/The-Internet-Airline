package inc.pnw.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Servlet implementation class AirlineApp, responsible for receiving requests from the client. It
 * also invokes the DAO to get a list of items from the database, saves this list as an attribute in
 * the request, and then forwards the request to a JSP page.
 *
 * @author Joshua Riley
 */

/*
 * Declare the AirlineApp servlet. The urlPatterns of the servlet mapping in your @WebServlet
 * annotation should include the URL of the servlet that handles the form submission.
 */
@WebServlet(urlPatterns = {"", "/departureflight", "/returnflight", "/ticketquantity"})
public class AirlineApp extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private static final Logger LOGGER = LogManager.getLogger(AirlineApp.class);


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
      LOGGER.info("In doGet method");

      String requestURI = request.getRequestURI();
      String page = null;

      // handle url requests
      if (requestURI.endsWith("/")) {
        page = "";
      } else if (requestURI.endsWith("departureflight")) {
        page = "/departureflight.jsp";

      } else if (requestURI.endsWith("returnflight")) {
        page = "/returnflight.jsp";
      
      } else if(requestURI.endsWith("ticketquantity"))
        page = "/ticketquantity.jsp";
      else {
        page = "/error.jsp";
      }

      switch (page) {
        case "":

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

      LOGGER.info("Do Departure");
      FlightService.action = "departure";
      String origCity = request.getParameter("ocity");
      LOGGER.info(origCity);
      String destCity = request.getParameter("dcity");
      String dYear = request.getParameter("dyear");
      String dDay = request.getParameter("dday");
      String dMonth = request.getParameter("dmonth");
      String dateString = dYear + "-" + dMonth + "-" + dDay;

      try {

        LOGGER.info("Retrieving Departure Flights");
        java.sql.Date dDate = ServiceBase.formatDate(dateString);
        LOGGER.info(dDate.toString());
        List<FlightDTO> listDepartureFlight = FlightService.getCityNamesForFlights(
            FlightService.retrieveDepartureFlights(origCity, destCity, dDate));

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

      LOGGER.info("Do Return");
      FlightService.action = "return";
      // Retrieve the selected departure flight
      String[] selectedIndices = request.getParameterValues("selectedFlight");
      LOGGER.info(selectedIndices.length);


      java.sql.Date rFormattedDate;
      List<FlightDTO> listReturnFlight;
      HttpSession session = request.getSession();
      session.setAttribute("selectedIndices", selectedIndices);
      LOGGER.info(selectedIndices[0]);
      try {

        rFormattedDate = ServiceBase.formatDate(session.getAttribute("ReturnDate").toString());
        if (selectedIndices != null) {

          listReturnFlight =
              FlightService.getCityNamesForFlights(FlightService.retrieveReturnFlights(
                  Integer.parseInt(ServiceBase.filterJson(selectedIndices[0], "dFid").trim()),
                  rFormattedDate));
          LOGGER.info(listReturnFlight.size());
          session.setAttribute("rf", listReturnFlight);
          response.sendRedirect(request.getContextPath() + "/returnflight.jsp");
        }

      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    if (action.equals("ticket")) {
      HttpSession session = request.getSession();

      List<String> flightTickets = new ArrayList<String>();

      // get departure flight
      flightTickets.add(Arrays.toString((String[]) session.getAttribute("selectedIndices")));
      LOGGER.info(flightTickets.get(0));
      // get return flight (if it exists)
      String[] selectedReturnFlight = request.getParameterValues("selectedReturnFlight");
      LOGGER.info("Selected return flight " + selectedReturnFlight[0].toString());
      if (!selectedReturnFlight[0].equalsIgnoreCase("")) {
        flightTickets.add((Arrays.toString(selectedReturnFlight)));
      }
      LOGGER.info("# of Flight ticket " + flightTickets.size());
      session.setAttribute("ft", FlightService.getFlightTicket(flightTickets));
      session.setAttribute("ftp",
          FlightService.getFlightTicketPrice(FlightService.getFlightTicket(flightTickets)));
      response.sendRedirect(request.getContextPath() + "/ticketquantity.jsp");

    }
  }
}
