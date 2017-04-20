# Sudocodes for the Project

### Admin

#### Variable:
*  String userName derizsy
*  String password javaproj2017


#### Method
constructor(Stirng userName, String password)
>set userName, password;

setCurrent(int time)
>set the time
*Require a variable in the main function* : Time;

adminLogin(void)
	if userName = userName|| password=password
		lgoin
	else
		reinput

createFlight (String flightId, int departureTime.int  arrivalTime,String  startCity, enum flightStatus,String  airlineCompany,String  arrivalCity,int  price,String  planeType,String  stopByCity)
	set information of a flight;

> Require a set method in the Flight class

updateFlight
	if UNPUBLISHED
		set information of a Flight
	else if PUBLISHED
		set planeType and price for the plane;
	call a reNew method of Flight to refresh

> Unsure  

deleteFlight
>delete a Flight Variable

superQuery
>Unsure

***
###Plane

####Variable
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
* departureTime
* arrivalTime
* startCity
* flightStatus
> enum{UNPUBLISHED, AVAILABLE,FULL, TERMINATE}

* String airlineCompany
* String arrivalCity
* int price
* currentPassengers
* planeType
* passengerIDList
* stopByCity
>default: null, 2 city names are needed

#### Method
constructor()

update()
