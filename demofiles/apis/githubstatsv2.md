FORMAT: 1A
HOST: http://polls.apiblueprint.org/

# githubstats API
## Version [V2]

Generate Github statistics on:
* number of commits
* number of stars
* Aggregated activity

for GitHub projects aggregated by US States

# Group Healthcheck
Group of all healthcheck-related APIs

## Status [/githubstats/status]
Call to check the liveness of the service

### Retrieve Service's liveness [GET]

+ Request Plain Text Message

    + Headers

            Accept: text/plain

+ Response 200 (text/plain)


    + Body

            with CORS 7164803 milliseconds

# Group Stats

## Get All Stats [/githubstatus/stats]
Returns stats for all US States

### Retrieve all Stats [GET]

+ Response 200 (application/json)

    + Body
```
{
    "stats": [
        {
            "state": "MA",
            "numCommits": 17,
            "numStars": 2,
            "numEvents": 10
        },
        {
            "state": "IN",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 9
        },
        {
            "state": "ID",
            "numCommits": 2,
            "numStars": 1,
            "numEvents": 3
        },
        {
            "state": "NM",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 1
        },
        {
            "state": "MH",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 1
        },
        {
            "state": "OR",
            "numCommits": 8,
            "numStars": 1,
            "numEvents": 19
        },
        {
            "state": "IA",
            "numCommits": 2,
            "numStars": 1,
            "numEvents": 1
        },
        {
            "state": "IL",
            "numCommits": 14,
            "numStars": 1,
            "numEvents": 36
        },
        {
            "state": "TN",
            "numCommits": 5,
            "numStars": 1,
            "numEvents": 7
        },
        {
            "state": "PR",
            "numCommits": 4,
            "numStars": 1,
            "numEvents": 6
        },
        {
            "state": "MO",
            "numCommits": 6,
            "numStars": 1,
            "numEvents": 10
        },
        {
            "state": "ME",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 2
        },
        {
            "state": "AZ",
            "numCommits": 6,
            "numStars": 1,
            "numEvents": 14
        },
        {
            "state": "AK",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 1
        },
        {
            "state": "GU",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 2
        },
        {
            "state": "VT",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 1
        },
        {
            "state": "WA",
            "numCommits": 5,
            "numStars": 1,
            "numEvents": 27
        },
        {
            "state": "SD",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 1
        },
        {
            "state": "KY",
            "numCommits": 2,
            "numStars": 1,
            "numEvents": 5
        },
        {
            "state": "NJ",
            "numCommits": 6,
            "numStars": 1,
            "numEvents": 10
        },
        {
            "state": "TX",
            "numCommits": 2,
            "numStars": 3,
            "numEvents": 47
        },
        {
            "state": "MI",
            "numCommits": 2,
            "numStars": 1,
            "numEvents": 15
        },
        {
            "state": "MD",
            "numCommits": 3,
            "numStars": 1,
            "numEvents": 18
        },
        {
            "state": "NV",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 2
        },
        {
            "state": "NE",
            "numCommits": 2,
            "numStars": 1,
            "numEvents": 5
        },
        {
            "state": "MN",
            "numCommits": 5,
            "numStars": 1,
            "numEvents": 4
        },
        {
            "state": "KS",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 3
        },
        {
            "state": "OK",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 4
        },
        {
            "state": "CT",
            "numCommits": 3,
            "numStars": 1,
            "numEvents": 4
        },
        {
            "state": "OH",
            "numCommits": 4,
            "numStars": 1,
            "numEvents": 17
        },
        {
            "state": "AR",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 2
        },
        {
            "state": "FL",
            "numCommits": 5,
            "numStars": 1,
            "numEvents": 30
        },
        {
            "state": "WI",
            "numCommits": 6,
            "numStars": 1,
            "numEvents": 12
        },
        {
            "state": "CO",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 16
        },
        {
            "state": "MT",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 3
        },
        {
            "state": "PW",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 1
        },
        {
            "state": "DC",
            "numCommits": 2,
            "numStars": 1,
            "numEvents": 11
        },
        {
            "state": "ND",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 2
        },
        {
            "state": "PA",
            "numCommits": 11,
            "numStars": 1,
            "numEvents": 6
        },
        {
            "state": "GA",
            "numCommits": 7,
            "numStars": 1,
            "numEvents": 12
        },
        {
            "state": "NH",
            "numCommits": 2,
            "numStars": 1,
            "numEvents": 1
        },
        {
            "state": "HI",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 3
        },
        {
            "state": "AS",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 1
        },
        {
            "state": "WY",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 1
        },
        {
            "state": "VI",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 1
        },
        {
            "state": "LA",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 16
        },
        {
            "state": "CA",
            "numCommits": 14,
            "numStars": 10,
            "numEvents": 43
        },
        {
            "state": "UT",
            "numCommits": 3,
            "numStars": 1,
            "numEvents": 8
        },
        {
            "state": "AL",
            "numCommits": 2,
            "numStars": 1,
            "numEvents": 3
        },
        {
            "state": "WV",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 1
        },
        {
            "state": "VA",
            "numCommits": 13,
            "numStars": 2,
            "numEvents": 13
        },
        {
            "state": "NC",
            "numCommits": 10,
            "numStars": 1,
            "numEvents": 14
        },
        {
            "state": "MP",
            "numCommits": 1,
            "numStars": 1,
            "numEvents": 1
        },
        {
            "state": "NY",
            "numCommits": 25,
            "numStars": 1,
            "numEvents": 29
        },
        {
            "state": "SC",
            "numCommits": 8,
            "numStars": 1,
            "numEvents": 6
        },
        {
            "state": "RI",
            "numCommits": 2,
            "numStars": 1,
            "numEvents": 2
        },
        {
            "state": "MS",
            "numCommits": 2,
            "numStars": 1,
            "numEvents": 5
        },
        {
            "state": "DE",
            "numCommits": 4,
            "numStars": 2,
            "numEvents": 16
        }
    ]
}
```

## Get Stats by State [/stats/{usState}]
Returns Stats for a specific US State. 
### Retrieve Stats for a State [GET]

+ Parameters

    + usState (text) - Two-letter code for the US State (ex. CA, WA, HI, ...)

+ Response 200 (application/json)

    + Body
```
{
    "state": "WA",
    "numCommits": 16,
    "numStars": 3,
    "numEvents": 55
}
```

