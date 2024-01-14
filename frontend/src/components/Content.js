import React from "react";

const Content = () => {
  const containerStyle = {
    textAlign: "center",
  };

  const headerStyle = {
    color: "#333",
    marginBottom: "10px",
  };

  const subHeaderStyle = {
    color: "#555",
  };

  return (
    <div style={containerStyle}>
      <h1 style={headerStyle}>Open Weather App</h1>
      <h2 style={subHeaderStyle}>Helsingin sääennuste</h2>
    </div>
  );
};

export default Content;
