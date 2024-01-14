import React, { useState, useEffect } from "react";
import { fetchDays } from "../api";
import Content from "./Content";
import DataTable from "./DataTable";
import Button from "@mui/material/Button";

const MainContainer = () => {
  const containerStyle = {
    textAlign: "center",
  };

  const buttonStyle = {
    marginBottom: "1em",
  };

  const [weatherData, setWeatherData] = useState([]);
  const [showTable, setShowTable] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetchDays();
        setWeatherData(response);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    fetchData();
  }, []);

  const toggleTableVisibility = () => {
    setShowTable(!showTable);
  };

  return (
    <main style={containerStyle} className="main-container">
      <Content />
      <Button
        style={buttonStyle}
        variant="contained"
        onClick={toggleTableVisibility}
      >
        {showTable ? "Näytä sääennuste" : "Piilota sääennuste"}
      </Button>
      {showTable && weatherData && <DataTable weatherData={weatherData} />}
    </main>
  );
};

export default MainContainer;
