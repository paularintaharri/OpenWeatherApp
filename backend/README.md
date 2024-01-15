# Backend

The backend is implemented in Kotlin. It fetches weather data from the [Visual Crossing API](https://www.visualcrossing.com/) and stores it in an SQLite database. The backend features an API with CRUD operations.

## Getting Started

Instructions on how to set up and run the backend.

### Prerequisites

- IntelliJ IDEA

### Dev setup step-by-step

1. The application uses [Visual Crossing API](https://www.visualcrossing.com/) to fetch weather data. To use the API you need to create an account and get API KEY. 
2. Create `.env` in project root and add API KEY to the file `API_KEY=XXXXXXXXXXXX`
3. Run the project from the `com/example/Application.kt` file
4. Go to [http://localhost:8080](http://localhost:8080)

### Tests

Integration tests have been implemented for the application to test CRUD operations. These tests can be executed by running the `com/example/ApplicationTest.kt` file.

## API documentation

### Overview
API provides endpoints to manage weather data for different days. It supports basic CRUD (Create, Read, Update, Delete) operations for day-related information.

### Base URL
The base URL in a local development environment, is [http://localhost:8080](http://localhost:8080).

### Endpoints

**1. GET /days**
- **Description**: Retrieves information about all available days.
- **HTTP Method**: GET
- **Response**: Returns a list of day objects.

**2. POST /days**
- **Description**: Creates a new day with the provided data.
- **HTTP Method**: POST
- **Request Body**: Expects a JSON object representing the day data (datetime, maxTemperature, minTemperature).
- **Response**: If successful, returns the ID of the created day.

**3. GET /days/{id}**
- **Description**: Retrieves information about a specific day based on its ID.
- **HTTP Method**: GET
- **Path Parameter**: {id} - ID of the day.
- **Response**: Returns the day object if found.

**4. PUT /days/{id}**
- **Description**: Updates information about a specific day based on its ID.
- **HTTP Method**: PUT
- **Path Parameter**: {id} - ID of the day.
- **Request Body**: Expects form parameters (datetime, maxTemperature, minTemperature) for updating the day.
- **Response**: Returns a message indicating the success or failure of the update operation.

**5. DELETE /days/{id}**
- **Description**: Deletes information about a specific day based on its ID.
- **HTTP Method**: DELETE
- **Path Parameter**: {id} - ID of the day.
- **Response**: Returns a message indicating the success or failure of the delete operation.

### Known Issues and To-Dos
- POST /days: Currently returns a 415 Unsupported Media Type error. This needs to be fixed.
- PUT /days/{id}: Currently not functional and needs to be fixed.
- Test coverage and validation for POST and PUT edge cases are yet to be implemented.

