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

Integration tests have been implemented for the application to test its CRUD operations. These tests can be executed by running the `com/example/ApplicationTest.kt` file.
