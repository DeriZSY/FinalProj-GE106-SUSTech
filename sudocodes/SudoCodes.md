# Sudocodes for the Project

### Admin

#### Variable:
*  String userName
*  String password
*  adminStatus admstatus


#### Method
constructor(String userName, String password)
>set userName, password;


adminLogin(void)
	if userName = userName|| password=password
		login
	else
		reinput

createFlight
	>set information of a flight;


updateFlight
	>if UNPUBLISHED
		set information of a Flight
	else if PUBLISHED
		set planeType and price for the plane;
	call a reNew method of Flight to refresh


deleteFlight
	>set flightEx to DELETED

superQuery
	>Unsure

***
### Plane

#### Variable
* int seatCapacity
* int firstClassCap
* int normalClassCap

#### Method
constructor(int sC, int fC, int nC)
	>set all three variables

***
### Flight

#### Variable
* String flightID
* Date departureTime
* Date arrivalTime
	>Use Date Class, for more information, check setTime.java in the complement tools.
The time format should be "yyyy-MM-dd HH:mm"
for example: 2017-04-25 11:30

* String startCity
* flightStatus
	> enum{UNPUBLISHED, AVAILABLE,FULL, TERMINATE}

* String airlineCompany
* String arrivalCity
* int price
* currentPassengers
* planeType

* String stopByCity
	>default: null, 2 city names are needed

* enum FlightExistting flightEX
	> to tell if the flight exists.

* passengerIDList

#### Method
constructor()

update()
	> get Year, Month, Date, Hour, for departureTime and currenTime;
if currenTime.Hour <= departureTime.Hour+2
	status = TERMINATE;

set_Flight()
> set the information of the flight

### Main function

#### Variable
* ArrayList flightIDs
	>An arraylist that contains all the flight IDs, use item.add()  to add item to the arraylist.
