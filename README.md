# Open Weather App

The Open Weather App is an application that retrieves weather data from the public [Visual Crossing API](https://www.visualcrossing.com/). The Kotlin backend stores the data in an SQLite database and serves the data to the React frontend through an API interface.

This project took approximately 1-2 htp to complete.

## Getting Started

Instructions on how to get the project up and running can be found from Backend and Frontend README.MD files.

- [Backend](backend/README.md)
- [Frontend](frontend/README.md)

## Backend

The backend is implemented in Kotlin using the Ktor framework. The backend fetches data from the Visual Crossing weather API and stores it in an SQLite database, implemented using the Exposed library. The application features an API interface that serves data to the frontend, including all the basic CRUD operations.

Instructions on how to get the backend project up and running can be found in the backend's [README.MD](backend/README.md) file.

## Frontend

The frontend is a simple application implemented with the React framework. It retrieves weather data through the backend API and displays it in a simple table.

Instructions on how to get the frontend project up and running can be found in the frontend's [README.MD](frontend/README.md) file.

## Future development

**Backend**

- Finish all CRUD operations and API endpoints to work (POST and PUT currently not working)
- Finish all integration tests for the application to work.

**Frontend**

- Adding more UI tests to the frontend.
- Sorting the table displaying weather data.
- Make the pages look more visually appealing and add functionalities such as a detailed view of weather data for a specific day.

**General**

- Deploy the project to run on a cloud platform such as Heroku.
- Generally add more tests.
- Fetch and use more weather data from the [Visual Crossing API].
- Integrated Docker into the project.
