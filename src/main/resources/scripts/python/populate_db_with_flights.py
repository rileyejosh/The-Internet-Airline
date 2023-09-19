import requests
import json
from inc.pnw.db import FlightModel
from inc.pnw.db import CityDAO
from inc.pnw.db import FlightDAO
from datetime import datetime
from java.sql import Time
from java.sql import Date
from java.text import SimpleDateFormat


# Get list of cities
city_dao = CityDAO()
cities = city_dao.getAll()

flight_dao = FlightDAO()



# API endpoint
aviation_stack_url = "http://api.aviationstack.com/v1/flights"
amadeus_url = "https://test.api.amadeus.com/v2/shopping/flight-offers"
amadeus_auth_url = "https://test.api.amadeus.com/v1/security/oauth2/token"


# Query parameters
data = {
    "grant_type": "client_credentials",
    "client_id": "oeBSKumZMjZQjHmujDO163BeKGuUnAsG",
    "client_secret": "mvfA3msEiAqsVuEE"
    
}
params1 = {
    "access_key": "42731718a425fd9197f7d13bed316494"
}

params2 = {

    "max": 10,
    "originLocationCode": " ",
    "departureDate": " ",
    "returnDate": " ",
    "adults": 1,
    "destinationLocationCode": " ",
    
}

# Send GET request to the API
response = requests.get(aviation_stack_url, params=params1)
# Check if the request was successful
if response.status_code == 200:
    # # Parse JSON response
    json_response = response.json()
    #
    # # Access the parsed data
    flights = json_response["data"]
    #
    # # Iterate over flights
    for flight in flights:
    
       departure = flight["departure"]["iata"]
       arrival = flight["arrival"]["iata"]
       dep_scheduled = flight["departure"]["scheduled"]
       arr_scheduled = flight["arrival"]["scheduled"]
       
       date_format = "%Y-%m-%dT%H:%M:%S"
       parsed_date = datetime.strptime(dep_scheduled[:19], date_format)
       dep_date = parsed_date.date()
       dep_time = parsed_date.time()
       
       date_format = "%Y-%m-%dT%H:%M:%S"
       parsed_date = datetime.strptime(arr_scheduled[:19], date_format)
       arr_date = parsed_date.date()
       arr_time = parsed_date.time()
       
       params2["originLocationCode"] = departure
       params2["destinationLocationCode"] = arrival
       params2["departureDate"] =  dep_date
       params2["returnDate"] = arr_date
        # AMADEUS Call
       response = requests.post(amadeus_auth_url, data=data)
       if response.status_code == 200:
        # # Parse JSON response
        json_response = response.json()
        access_token = json_response["access_token"]
        token_type = json_response["token_type"]
         # Example: Make a GET request to the flight offers API
        amadeus_flight_offers_url = "https://test.api.amadeus.com/v2/shopping/flight-offers"
        headers = {
        "Authorization": token_type + " " + access_token
        }
        response = requests.get(amadeus_flight_offers_url, headers=headers, params=params2)
        
        # Get AMADEUS Flight Offers
        if response.status_code == 200:
            flight_offers = json.loads(response.content)
            
            # Access city information
            for flight_offer in flight_offers["data"]:
               itineraries = flight_offer["itineraries"]
               price = flight_offer["price"]["total"]
               capacity = flight_offer["numberOfBookableSeats"]
               
               for itinerary in itineraries:
                segments = itinerary["segments"]
                for segment in segments:
                
    ##################### MAP JSON Object Keys to Table columns ####################
                    flight_model_1 = FlightModel()
                    flight_model_2 = FlightModel()    
                    for c in cities:
                        departure_city = str(segment["departure"]["iataCode"])
                        arrival_city = str(segment["arrival"]["iataCode"])
                        
                        if c.getIata_Code() == departure_city:

                            flight_model_1.setOrig(c.getCityid())
                            flight_model_2.setOrig(c.getCityid())
                            
                        elif c.getIata_Code() == arrival_city:
                            flight_model_1.setDest(c.getCityid())
                            flight_model_2.setDest(c.getCityid())
                        
                     
                    flight_model_1.setFnumber(int(segment["number"]))
                    flight_model_2.setFnumber(int(segment["number"]))
                    # Parse the date string into a java.util.Date object
                    date_format = SimpleDateFormat("yyyy-MM-dd")
                    
                    # Get the current date
                    dep_date = datetime.now()
                    
                    # Format the date using the SimpleDateFormat pattern
                    date_str = date_format.format(dep_date)

                    # Parse the formatted date string into a java.util.Date object
                    util_date = date_format.parse(date_str)
                    # Convert the java.util.Date to a java.sql.Date object
                    sql_date = Date(util_date.getTime())
      
                    flight_model_1.setFdate(sql_date)
                    flight_model_2.setFdate(sql_date)
                    
                    # Step 1: Parse the time string into a Python datetime object
                    time_format = "%H:%M:%S"
                    time_str = dep_time.strftime(time_format)
                    parsed_time = datetime.strptime(time_str, time_format)
                    # Step 2: Extract the time portion (Python time object)
                    time_object = parsed_time.time()
                    sql_time = Time(time_object.hour, time_object.minute, time_object.second)
                    flight_model_1.setFtime(sql_time)
                    flight_model_2.setFtime(sql_time)
                    
                    flight_model_1.setPrice(float(price))
                    flight_model_2.setPrice(float(price))
                    for traveler_pricing in flight_offer["travelerPricings"]:
                        flight_class = traveler_pricing["fareDetailsBySegment"][1]
                        if flight_class == 'ECONOMY':
                            flight_model_1.setClassFlight(3)
                            flight_model_2.setClassFlight(3)
                        elif flight_class == 'BUSINESS':
                            flight_model_1.setClassFlight(2)
                            flight_model_2.setClassFlight(2)
                        elif flight_class == 'FIRST':
                            flight_model_1.setClassFlight(1)
                            flight_model_2.setClassFlight(1)
                            
                    flight_model_1.setCapacity(capacity);
                    flight_model_2.setCapacity(capacity); 
                    flight_model_1.setAvailable(capacity);
                    flight_model_2.setAvailable(capacity);

                    
                    flight_dao.save(flight_model_1)
                    flight_dao.save(flight_model_2)
                    print('flights saved')
                      
        else:
            print("Amadeus Flight Offer Error: ", response.status_code )          
                
       else:
            # Request was unsuccessful
        print("Amadeus Auth Error:", response.status_code )       
else:
    # Request was unsuccessful
    print("Aviation Stack Error:", response.status_code)