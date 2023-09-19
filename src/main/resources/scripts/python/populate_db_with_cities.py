import json
import io
from inc.pnw.db import City
from inc.pnw.db import CityDAO
    

    
extractedStrings = []
cityDao = CityDAO()

try:
    with open("D:\\GlobalAirportDatabase\\GlobalAirportDatabase.txt", 'r') as file:
        for line in file:
            parts = line.split(":")
            if len(parts) >= 4:
                secondString = parts[1].strip()
                fourthString = parts[3].strip()
                c = City()
                c.setIata_Code(secondString)
                c.setTitle(fourthString)
                c.setState("N")
                cityDao.save(c)
                extractedStrings.append(secondString)
                extractedStrings.append(fourthString)

except IOError as e:
    e.printStackTrace()



