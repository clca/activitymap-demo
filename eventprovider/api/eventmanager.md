FORMAT: 1A
HOST: http://polls.apiblueprint.org/

# EventManager

EventManager is a simple API allowing user to interact with EventManager.

It allows user to:

* register/unregister an EventProvider with EventManager
* get the information of a registered EventProvider
* list all the registered EventProvider
* send event to the EventBus via EventManager

## EventManager Resource [/events]

### Welcome [GET]

You can check whether the EventManager is running by calling this endpoint.
It will simply display a welcome message: **Event Manager is running!**

+ Response 200 (text/plain)

        Event Manager is running!

## EventProvider Resource [/events/providers]


### List all registered EventProvider [GET]

+ Response 200 (application/json)

        [
            {
                "name": "eventProvider",
                "eventDescriptors": [
                    {
                        "event_name": "onCreate",
                        "description": "on create",
                        "supplied_parameters": null
                    }
                ]
            },
            {
                "name": "my-news",
                "eventDescriptors": [
                    {
                        "event_name": "us",
                        "description": "this is the latest news from U.S.",
                        "supplied_parameters": null
                    },
                    {
                        "event_name": "europe",
                        "description": "this is the latest news from Europe",
                        "supplied_parameters": null
                    }
                ]
            }
        ]

### Register EventProvider [PUT]

You may register a new EventProvider instance using this action. It takes a JSON
object containing a unique name for this EventProvider and a collection of 
eventDescriptors. 

A type of `EventProvider` can generate certain types of events. A user can create 
an instance from a type of EventProvider.

An `EventDescriptor` describes a type of event that this EventProvider
exposes. It contains the name of the event in String format, 
the description of the event in String format, and the parameters
that needs to be supplied in the payload of the event. 

A bit more explanation in the `supplied_parameters`: let's say for a type of event
called "user-login", it needs to have **["username", "password"]** as supplied parameters, then 
in a event of "user-login", in the payload of the event, it needs to be in the format
of:
```json
        {
            "username":"oracle",
            "password": "system1234"
        }
```        

+ Request (application/json)

        {
            "name":"my-news",
            "eventDescriptors":[
                {
                    "event_name":"us",
                    "description":"this is the latest news from U.S.",
                    "supplied_parameters":null
                },
                {
                    "event_name":"europe",
                    "description":"this is the latest news from Europe",
                    "supplied_parameters":null
                }
            ]
        }
        
+ Response 200 (application/json)

        {
            "name":"my-news",
            "eventDescriptors":[
                {
                    "event_name":"us",
                    "description":"this is the latest news from U.S.",
                    "supplied_parameters":null
                },
                {
                    "event_name":"europe",
                    "description":"this is the latest news from Europe",
                    "supplied_parameters":null
                }
            ]
        }
        
## Get a specific EventProvider [/events/providers/{providerName}]

+ Parameters
    + providerName - the name of the registered eventProvider instance

### Get EventProvider [GET]
    
+ Response 200 (application/json)   

        {
            "name": "my-news",
            "eventDescriptors": [
                {
                    "event_name": "us",
                    "description": "this is the latest news from U.S.",
                    "supplied_parameters": null
                },
                {
                    "event_name": "europe",
                    "description": "this is the latest news from Europe",
                    "supplied_parameters": null
                }
            ]
        }

### Delete EventProvider [DELETE]

+ Response 200 (application/json)

## Sending Messages [/events/{providerName}/{eventName}]

### Send Message [POST]

EventProvider may send an event by specifing the registered EventProvider name, 
and the name of event type that it will send.

The request body contains the payload of the message.

+ Parameters
    + providerName - the name of the registered eventProvider instance
    + eventName - the name of the event type 
    
    
+ Request (application/json)

        {
            "top-news":"This is a good news"
        }
        
+ Response 200 (application/json)

        {
            "provider": "my-news",
            "event": "us",
            "payload": {
                "top-news": "This is a good news"
            },
            "id": "b81f3919-fed3-41ba-a17c-8dbe23b3d28f"
        }
            