FORMAT: 1A
HOST: http://polls.apiblueprint.org/

# githubstats API
## Version [V3]

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

## Get All Stats [/githubstats/stats]
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

## Get Historical Stats [/history{?from,to}]
Returns Historical data 
### Retrieve Historic Stats [GET]

+ Parameters
    + from (DateTime) - a valid date that specifies the beginning of the interval that is used to retrieve historical data
    + to (DateTime) - a valid date that specifies the end of the interval that is used to retrieve historical data

+ Response 200 (application/json)

    + Body
```
[
    {
        "timestamp": "2017-09-29T09:58:16",
        "stats": {
            "stats": [
                {
                    "state": "MA",
                    "numCommits": 221,
                    "numStars": 21,
                    "numEvents": 648
                },
                {
                    "state": "IN",
                    "numCommits": 117,
                    "numStars": 3,
                    "numEvents": 336
                },
                {
                    "state": "ID",
                    "numCommits": 11,
                    "numStars": 1,
                    "numEvents": 36
                },
                {
                    "state": "NM",
                    "numCommits": 5,
                    "numStars": 1,
                    "numEvents": 33
                },
                {
                    "state": "MH",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "OR",
                    "numCommits": 80,
                    "numStars": 1,
                    "numEvents": 246
                },
                {
                    "state": "IA",
                    "numCommits": 10,
                    "numStars": 1,
                    "numEvents": 50
                },
                {
                    "state": "IL",
                    "numCommits": 181,
                    "numStars": 6,
                    "numEvents": 424
                },
                {
                    "state": "TN",
                    "numCommits": 45,
                    "numStars": 1,
                    "numEvents": 131
                },
                {
                    "state": "PR",
                    "numCommits": 46,
                    "numStars": 1,
                    "numEvents": 112
                },
                {
                    "state": "MO",
                    "numCommits": 49,
                    "numStars": 1,
                    "numEvents": 143
                },
                {
                    "state": "ME",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 18
                },
                {
                    "state": "AZ",
                    "numCommits": 78,
                    "numStars": 1,
                    "numEvents": 191
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
                    "numEvents": 7
                },
                {
                    "state": "VT",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 9
                },
                {
                    "state": "WA",
                    "numCommits": 331,
                    "numStars": 27,
                    "numEvents": 870
                },
                {
                    "state": "SD",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "KY",
                    "numCommits": 16,
                    "numStars": 1,
                    "numEvents": 40
                },
                {
                    "state": "NJ",
                    "numCommits": 84,
                    "numStars": 1,
                    "numEvents": 204
                },
                {
                    "state": "TX",
                    "numCommits": 306,
                    "numStars": 14,
                    "numEvents": 805
                },
                {
                    "state": "MI",
                    "numCommits": 101,
                    "numStars": 1,
                    "numEvents": 204
                },
                {
                    "state": "MD",
                    "numCommits": 51,
                    "numStars": 1,
                    "numEvents": 215
                },
                {
                    "state": "NV",
                    "numCommits": 9,
                    "numStars": 1,
                    "numEvents": 40
                },
                {
                    "state": "NE",
                    "numCommits": 9,
                    "numStars": 1,
                    "numEvents": 38
                },
                {
                    "state": "MN",
                    "numCommits": 69,
                    "numStars": 1,
                    "numEvents": 161
                },
                {
                    "state": "KS",
                    "numCommits": 10,
                    "numStars": 1,
                    "numEvents": 34
                },
                {
                    "state": "OK",
                    "numCommits": 10,
                    "numStars": 1,
                    "numEvents": 29
                },
                {
                    "state": "CT",
                    "numCommits": 26,
                    "numStars": 1,
                    "numEvents": 54
                },
                {
                    "state": "OH",
                    "numCommits": 76,
                    "numStars": 1,
                    "numEvents": 179
                },
                {
                    "state": "AR",
                    "numCommits": 4,
                    "numStars": 1,
                    "numEvents": 17
                },
                {
                    "state": "FL",
                    "numCommits": 141,
                    "numStars": 6,
                    "numEvents": 344
                },
                {
                    "state": "WI",
                    "numCommits": 45,
                    "numStars": 1,
                    "numEvents": 182
                },
                {
                    "state": "CO",
                    "numCommits": 116,
                    "numStars": 4,
                    "numEvents": 256
                },
                {
                    "state": "MT",
                    "numCommits": 14,
                    "numStars": 1,
                    "numEvents": 46
                },
                {
                    "state": "PW",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "DC",
                    "numCommits": 54,
                    "numStars": 1,
                    "numEvents": 151
                },
                {
                    "state": "ND",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 9
                },
                {
                    "state": "PA",
                    "numCommits": 189,
                    "numStars": 10,
                    "numEvents": 475
                },
                {
                    "state": "GA",
                    "numCommits": 147,
                    "numStars": 5,
                    "numEvents": 385
                },
                {
                    "state": "NH",
                    "numCommits": 8,
                    "numStars": 1,
                    "numEvents": 36
                },
                {
                    "state": "HI",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 18
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
                    "numCommits": 79,
                    "numStars": 1,
                    "numEvents": 147
                },
                {
                    "state": "CA",
                    "numCommits": 1224,
                    "numStars": 112,
                    "numEvents": 2508
                },
                {
                    "state": "UT",
                    "numCommits": 32,
                    "numStars": 1,
                    "numEvents": 79
                },
                {
                    "state": "AL",
                    "numCommits": 18,
                    "numStars": 1,
                    "numEvents": 52
                },
                {
                    "state": "WV",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 6
                },
                {
                    "state": "VA",
                    "numCommits": 123,
                    "numStars": 6,
                    "numEvents": 335
                },
                {
                    "state": "NC",
                    "numCommits": 145,
                    "numStars": 8,
                    "numEvents": 354
                },
                {
                    "state": "MP",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "NY",
                    "numCommits": 327,
                    "numStars": 23,
                    "numEvents": 656
                },
                {
                    "state": "SC",
                    "numCommits": 97,
                    "numStars": 1,
                    "numEvents": 269
                },
                {
                    "state": "RI",
                    "numCommits": 6,
                    "numStars": 1,
                    "numEvents": 26
                },
                {
                    "state": "MS",
                    "numCommits": 15,
                    "numStars": 1,
                    "numEvents": 49
                },
                {
                    "state": "DE",
                    "numCommits": 274,
                    "numStars": 8,
                    "numEvents": 671
                }
            ]
        }
    },
    {
        "timestamp": "2017-09-29T09:58:18",
        "stats": {
            "stats": [
                {
                    "state": "MA",
                    "numCommits": 356,
                    "numStars": 35,
                    "numEvents": 1022
                },
                {
                    "state": "IN",
                    "numCommits": 199,
                    "numStars": 5,
                    "numEvents": 485
                },
                {
                    "state": "ID",
                    "numCommits": 16,
                    "numStars": 1,
                    "numEvents": 57
                },
                {
                    "state": "NM",
                    "numCommits": 7,
                    "numStars": 1,
                    "numEvents": 46
                },
                {
                    "state": "MH",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "OR",
                    "numCommits": 122,
                    "numStars": 1,
                    "numEvents": 356
                },
                {
                    "state": "IA",
                    "numCommits": 15,
                    "numStars": 1,
                    "numEvents": 78
                },
                {
                    "state": "IL",
                    "numCommits": 258,
                    "numStars": 6,
                    "numEvents": 659
                },
                {
                    "state": "TN",
                    "numCommits": 78,
                    "numStars": 1,
                    "numEvents": 192
                },
                {
                    "state": "PR",
                    "numCommits": 78,
                    "numStars": 1,
                    "numEvents": 162
                },
                {
                    "state": "MO",
                    "numCommits": 69,
                    "numStars": 1,
                    "numEvents": 216
                },
                {
                    "state": "ME",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 28
                },
                {
                    "state": "AZ",
                    "numCommits": 111,
                    "numStars": 1,
                    "numEvents": 280
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
                    "numEvents": 11
                },
                {
                    "state": "VT",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 12
                },
                {
                    "state": "WA",
                    "numCommits": 501,
                    "numStars": 41,
                    "numEvents": 1210
                },
                {
                    "state": "SD",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "KY",
                    "numCommits": 23,
                    "numStars": 1,
                    "numEvents": 65
                },
                {
                    "state": "NJ",
                    "numCommits": 113,
                    "numStars": 1,
                    "numEvents": 308
                },
                {
                    "state": "TX",
                    "numCommits": 497,
                    "numStars": 26,
                    "numEvents": 1285
                },
                {
                    "state": "MI",
                    "numCommits": 150,
                    "numStars": 1,
                    "numEvents": 373
                },
                {
                    "state": "MD",
                    "numCommits": 83,
                    "numStars": 1,
                    "numEvents": 304
                },
                {
                    "state": "NV",
                    "numCommits": 14,
                    "numStars": 1,
                    "numEvents": 60
                },
                {
                    "state": "NE",
                    "numCommits": 10,
                    "numStars": 1,
                    "numEvents": 56
                },
                {
                    "state": "MN",
                    "numCommits": 118,
                    "numStars": 1,
                    "numEvents": 272
                },
                {
                    "state": "KS",
                    "numCommits": 14,
                    "numStars": 1,
                    "numEvents": 55
                },
                {
                    "state": "OK",
                    "numCommits": 12,
                    "numStars": 1,
                    "numEvents": 39
                },
                {
                    "state": "CT",
                    "numCommits": 38,
                    "numStars": 1,
                    "numEvents": 86
                },
                {
                    "state": "OH",
                    "numCommits": 105,
                    "numStars": 1,
                    "numEvents": 297
                },
                {
                    "state": "AR",
                    "numCommits": 6,
                    "numStars": 1,
                    "numEvents": 31
                },
                {
                    "state": "FL",
                    "numCommits": 204,
                    "numStars": 9,
                    "numEvents": 569
                },
                {
                    "state": "WI",
                    "numCommits": 71,
                    "numStars": 1,
                    "numEvents": 259
                },
                {
                    "state": "CO",
                    "numCommits": 181,
                    "numStars": 5,
                    "numEvents": 444
                },
                {
                    "state": "MT",
                    "numCommits": 20,
                    "numStars": 1,
                    "numEvents": 74
                },
                {
                    "state": "PW",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "DC",
                    "numCommits": 87,
                    "numStars": 1,
                    "numEvents": 244
                },
                {
                    "state": "ND",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 11
                },
                {
                    "state": "PA",
                    "numCommits": 275,
                    "numStars": 17,
                    "numEvents": 748
                },
                {
                    "state": "GA",
                    "numCommits": 219,
                    "numStars": 9,
                    "numEvents": 644
                },
                {
                    "state": "NH",
                    "numCommits": 15,
                    "numStars": 1,
                    "numEvents": 55
                },
                {
                    "state": "HI",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 30
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
                    "numCommits": 104,
                    "numStars": 1,
                    "numEvents": 242
                },
                {
                    "state": "CA",
                    "numCommits": 1892,
                    "numStars": 162,
                    "numEvents": 3891
                },
                {
                    "state": "UT",
                    "numCommits": 43,
                    "numStars": 1,
                    "numEvents": 131
                },
                {
                    "state": "AL",
                    "numCommits": 27,
                    "numStars": 1,
                    "numEvents": 78
                },
                {
                    "state": "WV",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 8
                },
                {
                    "state": "VA",
                    "numCommits": 190,
                    "numStars": 10,
                    "numEvents": 528
                },
                {
                    "state": "NC",
                    "numCommits": 195,
                    "numStars": 9,
                    "numEvents": 565
                },
                {
                    "state": "MP",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "NY",
                    "numCommits": 548,
                    "numStars": 33,
                    "numEvents": 1117
                },
                {
                    "state": "SC",
                    "numCommits": 148,
                    "numStars": 1,
                    "numEvents": 367
                },
                {
                    "state": "RI",
                    "numCommits": 6,
                    "numStars": 1,
                    "numEvents": 45
                },
                {
                    "state": "MS",
                    "numCommits": 21,
                    "numStars": 1,
                    "numEvents": 74
                },
                {
                    "state": "DE",
                    "numCommits": 402,
                    "numStars": 11,
                    "numEvents": 1031
                }
            ]
        }
    },
    {
        "timestamp": "2017-09-29T09:58:17",
        "stats": {
            "stats": [
                {
                    "state": "MA",
                    "numCommits": 317,
                    "numStars": 29,
                    "numEvents": 898
                },
                {
                    "state": "IN",
                    "numCommits": 159,
                    "numStars": 5,
                    "numEvents": 393
                },
                {
                    "state": "ID",
                    "numCommits": 13,
                    "numStars": 1,
                    "numEvents": 43
                },
                {
                    "state": "NM",
                    "numCommits": 6,
                    "numStars": 1,
                    "numEvents": 41
                },
                {
                    "state": "MH",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "OR",
                    "numCommits": 104,
                    "numStars": 1,
                    "numEvents": 295
                },
                {
                    "state": "IA",
                    "numCommits": 13,
                    "numStars": 1,
                    "numEvents": 64
                },
                {
                    "state": "IL",
                    "numCommits": 225,
                    "numStars": 6,
                    "numEvents": 526
                },
                {
                    "state": "TN",
                    "numCommits": 56,
                    "numStars": 1,
                    "numEvents": 169
                },
                {
                    "state": "PR",
                    "numCommits": 59,
                    "numStars": 1,
                    "numEvents": 130
                },
                {
                    "state": "MO",
                    "numCommits": 63,
                    "numStars": 1,
                    "numEvents": 186
                },
                {
                    "state": "ME",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 23
                },
                {
                    "state": "AZ",
                    "numCommits": 88,
                    "numStars": 1,
                    "numEvents": 221
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
                    "numEvents": 10
                },
                {
                    "state": "VT",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 10
                },
                {
                    "state": "WA",
                    "numCommits": 402,
                    "numStars": 33,
                    "numEvents": 1065
                },
                {
                    "state": "SD",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "KY",
                    "numCommits": 20,
                    "numStars": 1,
                    "numEvents": 54
                },
                {
                    "state": "NJ",
                    "numCommits": 105,
                    "numStars": 1,
                    "numEvents": 248
                },
                {
                    "state": "TX",
                    "numCommits": 406,
                    "numStars": 18,
                    "numEvents": 1062
                },
                {
                    "state": "MI",
                    "numCommits": 115,
                    "numStars": 1,
                    "numEvents": 305
                },
                {
                    "state": "MD",
                    "numCommits": 66,
                    "numStars": 1,
                    "numEvents": 261
                },
                {
                    "state": "NV",
                    "numCommits": 11,
                    "numStars": 1,
                    "numEvents": 49
                },
                {
                    "state": "NE",
                    "numCommits": 10,
                    "numStars": 1,
                    "numEvents": 50
                },
                {
                    "state": "MN",
                    "numCommits": 91,
                    "numStars": 1,
                    "numEvents": 207
                },
                {
                    "state": "KS",
                    "numCommits": 10,
                    "numStars": 1,
                    "numEvents": 44
                },
                {
                    "state": "OK",
                    "numCommits": 11,
                    "numStars": 1,
                    "numEvents": 34
                },
                {
                    "state": "CT",
                    "numCommits": 32,
                    "numStars": 1,
                    "numEvents": 72
                },
                {
                    "state": "OH",
                    "numCommits": 90,
                    "numStars": 1,
                    "numEvents": 234
                },
                {
                    "state": "AR",
                    "numCommits": 4,
                    "numStars": 1,
                    "numEvents": 23
                },
                {
                    "state": "FL",
                    "numCommits": 180,
                    "numStars": 8,
                    "numEvents": 450
                },
                {
                    "state": "WI",
                    "numCommits": 59,
                    "numStars": 1,
                    "numEvents": 219
                },
                {
                    "state": "CO",
                    "numCommits": 149,
                    "numStars": 5,
                    "numEvents": 370
                },
                {
                    "state": "MT",
                    "numCommits": 18,
                    "numStars": 1,
                    "numEvents": 62
                },
                {
                    "state": "PW",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "DC",
                    "numCommits": 70,
                    "numStars": 1,
                    "numEvents": 212
                },
                {
                    "state": "ND",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 11
                },
                {
                    "state": "PA",
                    "numCommits": 234,
                    "numStars": 13,
                    "numEvents": 614
                },
                {
                    "state": "GA",
                    "numCommits": 178,
                    "numStars": 8,
                    "numEvents": 500
                },
                {
                    "state": "NH",
                    "numCommits": 11,
                    "numStars": 1,
                    "numEvents": 47
                },
                {
                    "state": "HI",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 23
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
                    "numCommits": 89,
                    "numStars": 1,
                    "numEvents": 195
                },
                {
                    "state": "CA",
                    "numCommits": 1563,
                    "numStars": 138,
                    "numEvents": 3210
                },
                {
                    "state": "UT",
                    "numCommits": 38,
                    "numStars": 1,
                    "numEvents": 114
                },
                {
                    "state": "AL",
                    "numCommits": 22,
                    "numStars": 1,
                    "numEvents": 64
                },
                {
                    "state": "WV",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 7
                },
                {
                    "state": "VA",
                    "numCommits": 155,
                    "numStars": 8,
                    "numEvents": 443
                },
                {
                    "state": "NC",
                    "numCommits": 157,
                    "numStars": 9,
                    "numEvents": 459
                },
                {
                    "state": "MP",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "NY",
                    "numCommits": 472,
                    "numStars": 29,
                    "numEvents": 918
                },
                {
                    "state": "SC",
                    "numCommits": 125,
                    "numStars": 1,
                    "numEvents": 319
                },
                {
                    "state": "RI",
                    "numCommits": 6,
                    "numStars": 1,
                    "numEvents": 39
                },
                {
                    "state": "MS",
                    "numCommits": 18,
                    "numStars": 1,
                    "numEvents": 59
                },
                {
                    "state": "DE",
                    "numCommits": 351,
                    "numStars": 9,
                    "numEvents": 916
                }
            ]
        }
    },
    {
        "timestamp": "2017-09-29T09:58:19",
        "stats": {
            "stats": [
                {
                    "state": "MA",
                    "numCommits": 397,
                    "numStars": 36,
                    "numEvents": 1025
                },
                {
                    "state": "IN",
                    "numCommits": 213,
                    "numStars": 5,
                    "numEvents": 514
                },
                {
                    "state": "ID",
                    "numCommits": 16,
                    "numStars": 1,
                    "numEvents": 61
                },
                {
                    "state": "NM",
                    "numCommits": 7,
                    "numStars": 1,
                    "numEvents": 50
                },
                {
                    "state": "MH",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "OR",
                    "numCommits": 128,
                    "numStars": 1,
                    "numEvents": 391
                },
                {
                    "state": "IA",
                    "numCommits": 16,
                    "numStars": 1,
                    "numEvents": 80
                },
                {
                    "state": "IL",
                    "numCommits": 276,
                    "numStars": 6,
                    "numEvents": 702
                },
                {
                    "state": "TN",
                    "numCommits": 79,
                    "numStars": 1,
                    "numEvents": 206
                },
                {
                    "state": "PR",
                    "numCommits": 82,
                    "numStars": 1,
                    "numEvents": 166
                },
                {
                    "state": "MO",
                    "numCommits": 76,
                    "numStars": 1,
                    "numEvents": 221
                },
                {
                    "state": "ME",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 30
                },
                {
                    "state": "AZ",
                    "numCommits": 115,
                    "numStars": 1,
                    "numEvents": 299
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
                    "numEvents": 11
                },
                {
                    "state": "VT",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 13
                },
                {
                    "state": "WA",
                    "numCommits": 516,
                    "numStars": 44,
                    "numEvents": 1280
                },
                {
                    "state": "SD",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "KY",
                    "numCommits": 23,
                    "numStars": 1,
                    "numEvents": 70
                },
                {
                    "state": "NJ",
                    "numCommits": 119,
                    "numStars": 1,
                    "numEvents": 316
                },
                {
                    "state": "TX",
                    "numCommits": 542,
                    "numStars": 28,
                    "numEvents": 1317
                },
                {
                    "state": "MI",
                    "numCommits": 158,
                    "numStars": 1,
                    "numEvents": 396
                },
                {
                    "state": "MD",
                    "numCommits": 88,
                    "numStars": 1,
                    "numEvents": 316
                },
                {
                    "state": "NV",
                    "numCommits": 14,
                    "numStars": 1,
                    "numEvents": 60
                },
                {
                    "state": "NE",
                    "numCommits": 10,
                    "numStars": 1,
                    "numEvents": 62
                },
                {
                    "state": "MN",
                    "numCommits": 125,
                    "numStars": 1,
                    "numEvents": 298
                },
                {
                    "state": "KS",
                    "numCommits": 16,
                    "numStars": 1,
                    "numEvents": 56
                },
                {
                    "state": "OK",
                    "numCommits": 12,
                    "numStars": 1,
                    "numEvents": 40
                },
                {
                    "state": "CT",
                    "numCommits": 39,
                    "numStars": 1,
                    "numEvents": 89
                },
                {
                    "state": "OH",
                    "numCommits": 109,
                    "numStars": 1,
                    "numEvents": 300
                },
                {
                    "state": "AR",
                    "numCommits": 6,
                    "numStars": 1,
                    "numEvents": 33
                },
                {
                    "state": "FL",
                    "numCommits": 214,
                    "numStars": 9,
                    "numEvents": 578
                },
                {
                    "state": "WI",
                    "numCommits": 80,
                    "numStars": 1,
                    "numEvents": 277
                },
                {
                    "state": "CO",
                    "numCommits": 196,
                    "numStars": 6,
                    "numEvents": 489
                },
                {
                    "state": "MT",
                    "numCommits": 21,
                    "numStars": 1,
                    "numEvents": 77
                },
                {
                    "state": "PW",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "DC",
                    "numCommits": 95,
                    "numStars": 1,
                    "numEvents": 246
                },
                {
                    "state": "ND",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 11
                },
                {
                    "state": "PA",
                    "numCommits": 297,
                    "numStars": 18,
                    "numEvents": 814
                },
                {
                    "state": "GA",
                    "numCommits": 235,
                    "numStars": 9,
                    "numEvents": 670
                },
                {
                    "state": "NH",
                    "numCommits": 16,
                    "numStars": 1,
                    "numEvents": 55
                },
                {
                    "state": "HI",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 31
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
                    "numCommits": 112,
                    "numStars": 1,
                    "numEvents": 255
                },
                {
                    "state": "CA",
                    "numCommits": 2018,
                    "numStars": 176,
                    "numEvents": 4300
                },
                {
                    "state": "UT",
                    "numCommits": 45,
                    "numStars": 1,
                    "numEvents": 137
                },
                {
                    "state": "AL",
                    "numCommits": 28,
                    "numStars": 1,
                    "numEvents": 83
                },
                {
                    "state": "WV",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 8
                },
                {
                    "state": "VA",
                    "numCommits": 207,
                    "numStars": 10,
                    "numEvents": 532
                },
                {
                    "state": "NC",
                    "numCommits": 218,
                    "numStars": 10,
                    "numEvents": 581
                },
                {
                    "state": "MP",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "NY",
                    "numCommits": 573,
                    "numStars": 35,
                    "numEvents": 1139
                },
                {
                    "state": "SC",
                    "numCommits": 155,
                    "numStars": 1,
                    "numEvents": 404
                },
                {
                    "state": "RI",
                    "numCommits": 7,
                    "numStars": 1,
                    "numEvents": 48
                },
                {
                    "state": "MS",
                    "numCommits": 22,
                    "numStars": 1,
                    "numEvents": 79
                },
                {
                    "state": "DE",
                    "numCommits": 420,
                    "numStars": 13,
                    "numEvents": 1091
                }
            ]
        }
    },
    {
        "timestamp": "2017-09-29T09:58:15",
        "stats": {
            "stats": [
                {
                    "state": "MA",
                    "numCommits": 155,
                    "numStars": 18,
                    "numEvents": 446
                },
                {
                    "state": "IN",
                    "numCommits": 88,
                    "numStars": 1,
                    "numEvents": 228
                },
                {
                    "state": "ID",
                    "numCommits": 10,
                    "numStars": 1,
                    "numEvents": 23
                },
                {
                    "state": "NM",
                    "numCommits": 4,
                    "numStars": 1,
                    "numEvents": 28
                },
                {
                    "state": "MH",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "OR",
                    "numCommits": 64,
                    "numStars": 1,
                    "numEvents": 187
                },
                {
                    "state": "IA",
                    "numCommits": 9,
                    "numStars": 1,
                    "numEvents": 38
                },
                {
                    "state": "IL",
                    "numCommits": 129,
                    "numStars": 3,
                    "numEvents": 320
                },
                {
                    "state": "TN",
                    "numCommits": 32,
                    "numStars": 1,
                    "numEvents": 100
                },
                {
                    "state": "PR",
                    "numCommits": 35,
                    "numStars": 1,
                    "numEvents": 78
                },
                {
                    "state": "MO",
                    "numCommits": 38,
                    "numStars": 1,
                    "numEvents": 104
                },
                {
                    "state": "ME",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 14
                },
                {
                    "state": "AZ",
                    "numCommits": 56,
                    "numStars": 1,
                    "numEvents": 123
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
                    "numEvents": 6
                },
                {
                    "state": "VT",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 6
                },
                {
                    "state": "WA",
                    "numCommits": 227,
                    "numStars": 19,
                    "numEvents": 665
                },
                {
                    "state": "SD",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "KY",
                    "numCommits": 12,
                    "numStars": 1,
                    "numEvents": 26
                },
                {
                    "state": "NJ",
                    "numCommits": 60,
                    "numStars": 1,
                    "numEvents": 136
                },
                {
                    "state": "TX",
                    "numCommits": 213,
                    "numStars": 8,
                    "numEvents": 624
                },
                {
                    "state": "MI",
                    "numCommits": 85,
                    "numStars": 1,
                    "numEvents": 181
                },
                {
                    "state": "MD",
                    "numCommits": 38,
                    "numStars": 1,
                    "numEvents": 164
                },
                {
                    "state": "NV",
                    "numCommits": 6,
                    "numStars": 1,
                    "numEvents": 30
                },
                {
                    "state": "NE",
                    "numCommits": 7,
                    "numStars": 1,
                    "numEvents": 26
                },
                {
                    "state": "MN",
                    "numCommits": 51,
                    "numStars": 1,
                    "numEvents": 123
                },
                {
                    "state": "KS",
                    "numCommits": 8,
                    "numStars": 1,
                    "numEvents": 26
                },
                {
                    "state": "OK",
                    "numCommits": 8,
                    "numStars": 1,
                    "numEvents": 22
                },
                {
                    "state": "CT",
                    "numCommits": 19,
                    "numStars": 1,
                    "numEvents": 45
                },
                {
                    "state": "OH",
                    "numCommits": 58,
                    "numStars": 1,
                    "numEvents": 130
                },
                {
                    "state": "AR",
                    "numCommits": 2,
                    "numStars": 1,
                    "numEvents": 16
                },
                {
                    "state": "FL",
                    "numCommits": 103,
                    "numStars": 4,
                    "numEvents": 247
                },
                {
                    "state": "WI",
                    "numCommits": 35,
                    "numStars": 1,
                    "numEvents": 127
                },
                {
                    "state": "CO",
                    "numCommits": 69,
                    "numStars": 2,
                    "numEvents": 174
                },
                {
                    "state": "MT",
                    "numCommits": 11,
                    "numStars": 1,
                    "numEvents": 36
                },
                {
                    "state": "PW",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "DC",
                    "numCommits": 38,
                    "numStars": 1,
                    "numEvents": 122
                },
                {
                    "state": "ND",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 8
                },
                {
                    "state": "PA",
                    "numCommits": 129,
                    "numStars": 9,
                    "numEvents": 368
                },
                {
                    "state": "GA",
                    "numCommits": 116,
                    "numStars": 5,
                    "numEvents": 265
                },
                {
                    "state": "NH",
                    "numCommits": 7,
                    "numStars": 1,
                    "numEvents": 26
                },
                {
                    "state": "HI",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 13
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
                    "numCommits": 67,
                    "numStars": 1,
                    "numEvents": 86
                },
                {
                    "state": "CA",
                    "numCommits": 946,
                    "numStars": 92,
                    "numEvents": 1872
                },
                {
                    "state": "UT",
                    "numCommits": 25,
                    "numStars": 1,
                    "numEvents": 58
                },
                {
                    "state": "AL",
                    "numCommits": 12,
                    "numStars": 1,
                    "numEvents": 39
                },
                {
                    "state": "WV",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 5
                },
                {
                    "state": "VA",
                    "numCommits": 104,
                    "numStars": 5,
                    "numEvents": 229
                },
                {
                    "state": "NC",
                    "numCommits": 91,
                    "numStars": 8,
                    "numEvents": 234
                },
                {
                    "state": "MP",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "NY",
                    "numCommits": 229,
                    "numStars": 15,
                    "numEvents": 494
                },
                {
                    "state": "SC",
                    "numCommits": 80,
                    "numStars": 1,
                    "numEvents": 189
                },
                {
                    "state": "RI",
                    "numCommits": 4,
                    "numStars": 1,
                    "numEvents": 19
                },
                {
                    "state": "MS",
                    "numCommits": 11,
                    "numStars": 1,
                    "numEvents": 38
                },
                {
                    "state": "DE",
                    "numCommits": 214,
                    "numStars": 4,
                    "numEvents": 473
                }
            ]
        }
    },
    {
        "timestamp": "2017-09-29T09:58:14",
        "stats": {
            "stats": [
                {
                    "state": "MA",
                    "numCommits": 111,
                    "numStars": 14,
                    "numEvents": 302
                },
                {
                    "state": "IN",
                    "numCommits": 58,
                    "numStars": 1,
                    "numEvents": 165
                },
                {
                    "state": "ID",
                    "numCommits": 6,
                    "numStars": 1,
                    "numEvents": 18
                },
                {
                    "state": "NM",
                    "numCommits": 3,
                    "numStars": 1,
                    "numEvents": 21
                },
                {
                    "state": "MH",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "OR",
                    "numCommits": 50,
                    "numStars": 1,
                    "numEvents": 112
                },
                {
                    "state": "IA",
                    "numCommits": 4,
                    "numStars": 1,
                    "numEvents": 24
                },
                {
                    "state": "IL",
                    "numCommits": 88,
                    "numStars": 3,
                    "numEvents": 222
                },
                {
                    "state": "TN",
                    "numCommits": 27,
                    "numStars": 1,
                    "numEvents": 73
                },
                {
                    "state": "PR",
                    "numCommits": 21,
                    "numStars": 1,
                    "numEvents": 54
                },
                {
                    "state": "MO",
                    "numCommits": 29,
                    "numStars": 1,
                    "numEvents": 68
                },
                {
                    "state": "ME",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 11
                },
                {
                    "state": "AZ",
                    "numCommits": 39,
                    "numStars": 1,
                    "numEvents": 77
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
                    "numEvents": 4
                },
                {
                    "state": "VT",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 5
                },
                {
                    "state": "WA",
                    "numCommits": 147,
                    "numStars": 13,
                    "numEvents": 506
                },
                {
                    "state": "SD",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "KY",
                    "numCommits": 9,
                    "numStars": 1,
                    "numEvents": 18
                },
                {
                    "state": "NJ",
                    "numCommits": 47,
                    "numStars": 1,
                    "numEvents": 89
                },
                {
                    "state": "TX",
                    "numCommits": 142,
                    "numStars": 4,
                    "numEvents": 420
                },
                {
                    "state": "MI",
                    "numCommits": 62,
                    "numStars": 1,
                    "numEvents": 128
                },
                {
                    "state": "MD",
                    "numCommits": 32,
                    "numStars": 1,
                    "numEvents": 128
                },
                {
                    "state": "NV",
                    "numCommits": 4,
                    "numStars": 1,
                    "numEvents": 17
                },
                {
                    "state": "NE",
                    "numCommits": 5,
                    "numStars": 1,
                    "numEvents": 16
                },
                {
                    "state": "MN",
                    "numCommits": 33,
                    "numStars": 1,
                    "numEvents": 79
                },
                {
                    "state": "KS",
                    "numCommits": 5,
                    "numStars": 1,
                    "numEvents": 19
                },
                {
                    "state": "OK",
                    "numCommits": 7,
                    "numStars": 1,
                    "numEvents": 18
                },
                {
                    "state": "CT",
                    "numCommits": 13,
                    "numStars": 1,
                    "numEvents": 35
                },
                {
                    "state": "OH",
                    "numCommits": 39,
                    "numStars": 1,
                    "numEvents": 89
                },
                {
                    "state": "AR",
                    "numCommits": 2,
                    "numStars": 1,
                    "numEvents": 9
                },
                {
                    "state": "FL",
                    "numCommits": 61,
                    "numStars": 2,
                    "numEvents": 165
                },
                {
                    "state": "WI",
                    "numCommits": 20,
                    "numStars": 1,
                    "numEvents": 87
                },
                {
                    "state": "CO",
                    "numCommits": 55,
                    "numStars": 1,
                    "numEvents": 100
                },
                {
                    "state": "MT",
                    "numCommits": 7,
                    "numStars": 1,
                    "numEvents": 24
                },
                {
                    "state": "PW",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "DC",
                    "numCommits": 22,
                    "numStars": 1,
                    "numEvents": 77
                },
                {
                    "state": "ND",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 5
                },
                {
                    "state": "PA",
                    "numCommits": 83,
                    "numStars": 6,
                    "numEvents": 271
                },
                {
                    "state": "GA",
                    "numCommits": 92,
                    "numStars": 4,
                    "numEvents": 187
                },
                {
                    "state": "NH",
                    "numCommits": 4,
                    "numStars": 1,
                    "numEvents": 19
                },
                {
                    "state": "HI",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 8
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
                    "numCommits": 50,
                    "numStars": 1,
                    "numEvents": 57
                },
                {
                    "state": "CA",
                    "numCommits": 595,
                    "numStars": 69,
                    "numEvents": 1363
                },
                {
                    "state": "UT",
                    "numCommits": 18,
                    "numStars": 1,
                    "numEvents": 44
                },
                {
                    "state": "AL",
                    "numCommits": 9,
                    "numStars": 1,
                    "numEvents": 26
                },
                {
                    "state": "WV",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 3
                },
                {
                    "state": "VA",
                    "numCommits": 65,
                    "numStars": 4,
                    "numEvents": 140
                },
                {
                    "state": "NC",
                    "numCommits": 66,
                    "numStars": 6,
                    "numEvents": 118
                },
                {
                    "state": "MP",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "NY",
                    "numCommits": 156,
                    "numStars": 12,
                    "numEvents": 243
                },
                {
                    "state": "SC",
                    "numCommits": 52,
                    "numStars": 1,
                    "numEvents": 142
                },
                {
                    "state": "RI",
                    "numCommits": 4,
                    "numStars": 1,
                    "numEvents": 15
                },
                {
                    "state": "MS",
                    "numCommits": 9,
                    "numStars": 1,
                    "numEvents": 26
                },
                {
                    "state": "DE",
                    "numCommits": 151,
                    "numStars": 4,
                    "numEvents": 256
                }
            ]
        }
    },
    {
        "timestamp": "2017-09-29T09:58:13",
        "stats": {
            "stats": [
                {
                    "state": "MA",
                    "numCommits": 56,
                    "numStars": 8,
                    "numEvents": 137
                },
                {
                    "state": "IN",
                    "numCommits": 26,
                    "numStars": 1,
                    "numEvents": 84
                },
                {
                    "state": "ID",
                    "numCommits": 3,
                    "numStars": 1,
                    "numEvents": 9
                },
                {
                    "state": "NM",
                    "numCommits": 3,
                    "numStars": 1,
                    "numEvents": 13
                },
                {
                    "state": "MH",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "OR",
                    "numCommits": 25,
                    "numStars": 1,
                    "numEvents": 46
                },
                {
                    "state": "IA",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 13
                },
                {
                    "state": "IL",
                    "numCommits": 46,
                    "numStars": 2,
                    "numEvents": 90
                },
                {
                    "state": "TN",
                    "numCommits": 14,
                    "numStars": 1,
                    "numEvents": 34
                },
                {
                    "state": "PR",
                    "numCommits": 7,
                    "numStars": 1,
                    "numEvents": 21
                },
                {
                    "state": "MO",
                    "numCommits": 15,
                    "numStars": 1,
                    "numEvents": 40
                },
                {
                    "state": "ME",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 4
                },
                {
                    "state": "AZ",
                    "numCommits": 13,
                    "numStars": 1,
                    "numEvents": 32
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
                    "numEvents": 3
                },
                {
                    "state": "WA",
                    "numCommits": 57,
                    "numStars": 7,
                    "numEvents": 156
                },
                {
                    "state": "SD",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "KY",
                    "numCommits": 6,
                    "numStars": 1,
                    "numEvents": 8
                },
                {
                    "state": "NJ",
                    "numCommits": 26,
                    "numStars": 1,
                    "numEvents": 34
                },
                {
                    "state": "TX",
                    "numCommits": 56,
                    "numStars": 2,
                    "numEvents": 179
                },
                {
                    "state": "MI",
                    "numCommits": 26,
                    "numStars": 1,
                    "numEvents": 53
                },
                {
                    "state": "MD",
                    "numCommits": 11,
                    "numStars": 1,
                    "numEvents": 50
                },
                {
                    "state": "NV",
                    "numCommits": 2,
                    "numStars": 1,
                    "numEvents": 6
                },
                {
                    "state": "NE",
                    "numCommits": 2,
                    "numStars": 1,
                    "numEvents": 4
                },
                {
                    "state": "MN",
                    "numCommits": 15,
                    "numStars": 1,
                    "numEvents": 19
                },
                {
                    "state": "KS",
                    "numCommits": 3,
                    "numStars": 1,
                    "numEvents": 9
                },
                {
                    "state": "OK",
                    "numCommits": 3,
                    "numStars": 1,
                    "numEvents": 9
                },
                {
                    "state": "CT",
                    "numCommits": 7,
                    "numStars": 1,
                    "numEvents": 18
                },
                {
                    "state": "OH",
                    "numCommits": 17,
                    "numStars": 1,
                    "numEvents": 50
                },
                {
                    "state": "AR",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 7
                },
                {
                    "state": "FL",
                    "numCommits": 35,
                    "numStars": 1,
                    "numEvents": 83
                },
                {
                    "state": "WI",
                    "numCommits": 9,
                    "numStars": 1,
                    "numEvents": 52
                },
                {
                    "state": "CO",
                    "numCommits": 26,
                    "numStars": 1,
                    "numEvents": 30
                },
                {
                    "state": "MT",
                    "numCommits": 2,
                    "numStars": 1,
                    "numEvents": 11
                },
                {
                    "state": "PW",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "DC",
                    "numCommits": 10,
                    "numStars": 1,
                    "numEvents": 38
                },
                {
                    "state": "ND",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 3
                },
                {
                    "state": "PA",
                    "numCommits": 32,
                    "numStars": 4,
                    "numEvents": 137
                },
                {
                    "state": "GA",
                    "numCommits": 42,
                    "numStars": 2,
                    "numEvents": 54
                },
                {
                    "state": "NH",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 8
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
                    "numCommits": 24,
                    "numStars": 1,
                    "numEvents": 25
                },
                {
                    "state": "CA",
                    "numCommits": 323,
                    "numStars": 31,
                    "numEvents": 558
                },
                {
                    "state": "UT",
                    "numCommits": 10,
                    "numStars": 1,
                    "numEvents": 16
                },
                {
                    "state": "AL",
                    "numCommits": 4,
                    "numStars": 1,
                    "numEvents": 15
                },
                {
                    "state": "WV",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 3
                },
                {
                    "state": "VA",
                    "numCommits": 31,
                    "numStars": 2,
                    "numEvents": 58
                },
                {
                    "state": "NC",
                    "numCommits": 13,
                    "numStars": 4,
                    "numEvents": 51
                },
                {
                    "state": "MP",
                    "numCommits": 1,
                    "numStars": 1,
                    "numEvents": 1
                },
                {
                    "state": "NY",
                    "numCommits": 96,
                    "numStars": 7,
                    "numEvents": 63
                },
                {
                    "state": "SC",
                    "numCommits": 24,
                    "numStars": 1,
                    "numEvents": 62
                },
                {
                    "state": "RI",
                    "numCommits": 3,
                    "numStars": 1,
                    "numEvents": 6
                },
                {
                    "state": "MS",
                    "numCommits": 6,
                    "numStars": 1,
                    "numEvents": 14
                },
                {
                    "state": "DE",
                    "numCommits": 64,
                    "numStars": 3,
                    "numEvents": 110
                }
            ]
        }
    }
]
```

