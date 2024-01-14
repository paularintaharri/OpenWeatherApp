import { render, screen, fireEvent, waitFor } from "@testing-library/react";
import App from "./App";
import MainContainer from "./components/MainContainer";

test("renders Button and handles click event", async () => {
  render(<App />);

  const myElement = screen.getByText(/Näytä sääennuste/i);
  fireEvent.click(myElement);

  await waitFor(() => {
    expect(screen.getByText(/Piilota sääennuste/i)).toBeInTheDocument();
  });
});

test("renders DataTable when showTable is true", async () => {
  render(<MainContainer />);

  const button = screen.getByText(/Näytä sääennuste/i);
  fireEvent.click(button);

  const dataTable = screen.getByRole("table");
  expect(dataTable).toBeInTheDocument();
});
