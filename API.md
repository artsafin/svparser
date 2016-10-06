API

GET /serial - Get list of serials
Query string:
    (optional) ?search=String - Search by serial name or part of name
Response:
[
    {
        name: String,   // Name of the serial
        image: URL      // Thumbnail of the serial
    },
    ...
]

GET /serial/<name> - Get list of serial seasons with metadata
Parameters:
    <name> String - Serial name
Response:
[
    {
        "id" : ID,                      // Id of the season
        "commonName" : String,          // Name of the serial (same as <name>)
        "name" : String,                // Name of the season
        "url" : URL,                    // URL path to the season page (without hostname)
        "description" : String,         // Human description of the season
        "genres" : String[],            // Array of genres
        "year" : String,                // Year of filming. May be a string containing range (e.g. "2006-2008")
        "img" : URL,                    // URL to season image
        "originalName" : String|null,   // English name of the serial
        "numSeasons" : String|null      // Number of seasons of the serial
    },
    ...
]
