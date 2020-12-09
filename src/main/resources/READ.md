Build a Vehicle Service Management System - 5MVehicleCare.
While 5MVehicleCare itself owns several of Service Centres. It is also an aggregator of various other 3rdParty service centre providers.

Focus on two main flows:
1. SEARCH
   - customers can search for eligible service centres in a given location
   - can search for available slots in a given day

2. BOOK
- book API to allow booking for a service centre for a given time slot, vehicle type, etc
build a marketplace of SC providers (also keep self as one of the providers)
- get the payments done at your end (for simplicity assume that the initial estimated cost can be paid at the time of booking itself.) 

3. [BONUS] cancellation within prescribed time slabs and charge accordingly as per refund policy


Assumptions
- use static data and mention in comment about network & db calls




--------------- Solution ---------------- 
- 
SEARCH
-

- search by location

curl --location --request GET 'http://localhost:8080/search/location?location=New%20Delhi' \
--header 'Content-Type: application/json'

[
    {
        "id": "Self1",
        "name": "Self1",
        "location": {
            "id": "location1",
            "addressLine": "address1",
            "city": "New Delhi",
            "state": "Delhi"
        },
        "owned": true,
        "slots": {
            "2020-12-12": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ],
            "2020-12-11": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ],
            "2020-12-10": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ]
        }
    },
    {
        "id": "Partner1",
        "name": "Partner1",
        "location": {
            "id": "location1",
            "addressLine": "address1",
            "city": "New Delhi",
            "state": "Delhi"
        },
        "owned": false,
        "slots": {
            "2020-12-12": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ],
            "2020-12-11": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ],
            "2020-12-10": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ]
        }
    }
]


- search by slot of the day

curl --location --request GET 'http://localhost:8080/search/slot?date=2020-12-10&from=10&to=11' \
--header 'Content-Type: application/json'


[
    {
        "id": "Self1",
        "name": "Self1",
        "location": {
            "id": "location1",
            "addressLine": "address1",
            "city": "New Delhi",
            "state": "Delhi"
        },
        "owned": true,
        "slots": {
            "2020-12-12": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ],
            "2020-12-11": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ],
            "2020-12-10": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ]
        }
    },
    {
        "id": "Self3",
        "name": "Self3",
        "location": {
            "id": "location3",
            "addressLine": "address3",
            "city": "Bengaluru",
            "state": "Karnataka"
        },
        "owned": true,
        "slots": {
            "2020-12-12": [
                {
                    "from": 9,
                    "to": 11
                },
                {
                    "from": 13,
                    "to": 15
                }
            ],
            "2020-12-11": [
                {
                    "from": 9,
                    "to": 11
                },
                {
                    "from": 13,
                    "to": 15
                }
            ],
            "2020-12-10": [
                {
                    "from": 9,
                    "to": 11
                },
                {
                    "from": 13,
                    "to": 15
                }
            ]
        }
    },
    {
        "id": "Self2",
        "name": "Self2",
        "location": {
            "id": "location2",
            "addressLine": "address2",
            "city": "Gurgaon",
            "state": "Harayan"
        },
        "owned": true,
        "slots": {
            "2020-12-12": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ],
            "2020-12-11": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ],
            "2020-12-10": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ]
        }
    },
    {
        "id": "Self4",
        "name": "Self4",
        "location": {
            "id": "location4",
            "addressLine": "address4",
            "city": "Noida",
            "state": "Uttar Pradesh"
        },
        "owned": true,
        "slots": {
            "2020-12-12": [
                {
                    "from": 9,
                    "to": 11
                },
                {
                    "from": 13,
                    "to": 15
                }
            ],
            "2020-12-11": [
                {
                    "from": 9,
                    "to": 11
                },
                {
                    "from": 13,
                    "to": 15
                }
            ],
            "2020-12-10": [
                {
                    "from": 9,
                    "to": 11
                },
                {
                    "from": 13,
                    "to": 15
                }
            ]
        }
    },
    {
        "id": "Partner1",
        "name": "Partner1",
        "location": {
            "id": "location1",
            "addressLine": "address1",
            "city": "New Delhi",
            "state": "Delhi"
        },
        "owned": false,
        "slots": {
            "2020-12-12": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ],
            "2020-12-11": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ],
            "2020-12-10": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ]
        }
    },
    {
        "id": "Partner2",
        "name": "Partner2",
        "location": {
            "id": "location2",
            "addressLine": "address2",
            "city": "Gurgaon",
            "state": "Harayan"
        },
        "owned": false,
        "slots": {
            "2020-12-12": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ],
            "2020-12-11": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ],
            "2020-12-10": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ]
        }
    },
    {
        "id": "Partner3",
        "name": "Partner3",
        "location": {
            "id": "location3",
            "addressLine": "address3",
            "city": "Bengaluru",
            "state": "Karnataka"
        },
        "owned": false,
        "slots": {
            "2020-12-12": [
                {
                    "from": 9,
                    "to": 11
                },
                {
                    "from": 13,
                    "to": 15
                }
            ],
            "2020-12-11": [
                {
                    "from": 9,
                    "to": 11
                },
                {
                    "from": 13,
                    "to": 15
                }
            ],
            "2020-12-10": [
                {
                    "from": 9,
                    "to": 11
                },
                {
                    "from": 13,
                    "to": 15
                }
            ]
        }
    }
]




BOOKING
- 

- booking by slot, date, vehicle type etc

curl --location --request POST 'http://localhost:8080/booking/slot' \
--header 'Content-Type: application/json' \
--data-raw '{
    "serviceCenterId" : "Self1",
    "owned" : true,
    "vehicleType" : "LVT",
    "day" : "2020-12-10",
    "slot" : {
        "from" : 10,
        "to" : 11
    }
}'

Response : e83a5684-b56b-4eed-9daa-a1bf402edd68


- get booking details by id

curl --location --request GET 'http://localhost:8080/booking/e83a5684-b56b-4eed-9daa-a1bf402edd68'


{
    "id": "e83a5684-b56b-4eed-9daa-a1bf402edd68",
    "serviceCenter": {
        "id": "Self1",
        "name": "Self1",
        "location": {
            "id": "location1",
            "addressLine": "address1",
            "city": "New Delhi",
            "state": "Delhi"
        },
        "owned": true,
        "slots": {
            "2020-12-12": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ],
            "2020-12-11": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ],
            "2020-12-10": [
                {
                    "from": 9,
                    "to": 12
                },
                {
                    "from": 14,
                    "to": 17
                }
            ]
        }
    },
    "vehicleType": "LVT",
    "day": "2020-12-10",
    "slot": {
        "from": 10,
        "to": 11
    }
}




----------------------- Run program
- 
- cd <path-of-project>
- mvn clean install
- To Debug : start the "DemoApplication" in debug more
- To run : mvn spring-boot:run 
