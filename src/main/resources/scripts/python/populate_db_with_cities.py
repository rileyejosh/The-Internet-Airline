from java.io import BufferedReader, FileReader
from java.util import ArrayList, List
from org.apache.http import ClientProtocolException
from org.apache.http.client.methods import CloseableHttpResponse, HttpGet
from org.apache.http.impl.client import CloseableHttpClient, HttpClients
from org.apache.http.util import EntityUtils
from com.google.gson import Gson
from com.google.gson.JsonArray import JsonArray
from com.google.gson.JsonObject import JsonObject
import os

key = "ACCESS_KEY"

class ApiIntegrationHandler:

    def __init__(self):
        # Create an HTTP client
        self.httpClient = HttpClients.createDefault()

    @staticmethod
    def getAviationApiCredentials():
        return os.getenv(key)  # Replace with your implementation

    @staticmethod
    def extractStringsFromFile(filePath):
        extractedStrings = ArrayList()
        cityDao = CityDAO()

        try:
            with BufferedReader(FileReader(filePath)) as reader:
                line = reader.readLine()
                while line is not None:
                    parts = line.split(":")
                    if len(parts) >= 4:
                        secondString = parts[1].strip()
                        fourthString = parts[3].strip()
                        c = City()
                        c.setIata_Code(secondString)
                        c.setTitle(fourthString)
                        c.setState("N")
                        cityDao.save(c)
                        extractedStrings.add(secondString)
                        extractedStrings.add(fourthString)
                    line = reader.readLine()

        except IOException as e:
            e.printStackTrace()

        return extractedStrings

    @staticmethod
    def populateDBWithCities():
        cities = ArrayList()
        cityDao = CityDAO()

        # Create an HttpClient
        httpClient = HttpClients.createDefault()

        url = "http://api.aviationstack.com/v1/cities?access_key=" + getAviationApiCredentials()

        # Create an HttpGet request with the URL
        httpGet = HttpGet(url)

        # Execute the request and get the response
        response = None
        try:
            response = httpClient.execute(httpGet)
        except ClientProtocolException as e:
            e.printStackTrace()
        except IOException as e:
            e.printStackTrace()

        try:
            # Extract the response body as a String
            responseBody = EntityUtils.toString(response.getEntity())

            # Parse the response body as JSON
            json = Gson().fromJson(responseBody, JsonObject)

            # Access the specific fields in the JSON response
            if json.has("data"):
                dataArray = json.getAsJsonArray("data")
                for element in dataArray:
                    data = element.getAsJsonObject()
                    if data.has("city_id") and data.has("city_name") and data.has("iata_code"):
                        cityName = data.get("city_name").getAsString()
                        state = data.get("iata_code").getAsString()
                        city = City()
                        city.setTitle(cityName)
                        city.setState(state)
                        cities.add(city)

            # Print the response body
            for c in cities:
                cityDao.save(c)

        finally:
            # Close the HttpClient and response
            try:
                response.close()
            except IOException as e:
                e.printStackTrace()
            try:
                httpClient.close()
            except IOException as e:
                e.printStackTrace()

if __name__ == "__main__":
    filePath = "D:\\GlobalAirportDatabase\\GlobalAirportDatabase.txt"
    print(len(ApiIntegrationHandler.extractStringsFromFile(filePath)))
