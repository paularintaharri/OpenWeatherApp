# Open Weather App

The Open Weather App is an application that retrieves weather data from the public [Visual Crossing API](https://www.visualcrossing.com/). The Kotlin backend stores the data in an SQLite database and serves the data to the React frontend through an API interface.

## Getting Started

Instructions on how to get the project up and running can be found from Backend and Frontend README.MD files.
- [Backend](backend/README.md)
- [Frontend](frontend/README.md)

## Backend

The backend is implemented in Kotlin using the Ktor framework. The backend fetches data from the Visual Crossing weather API and stores it in an SQLite database, implemented using the Exposed library. The application features an API interface that serves data to the frontend, including all the basic CRUD operations.

Instructions on how to get the backend project up and running can be found in the backend's [README.MD](backend/README.md) file.

## Frontend

The frontend is a simple application implemented with the React framework. It retrieves weather data through the backend API and displays it in a simple table.

Instructions on how to get the frintend project up and running can be found in the frontend's [README.MD](frontend/README.md) file.


