import * as React from "react";
import { styled } from "@mui/material/styles";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell, { tableCellClasses } from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";

const StyledTableHead = styled(TableHead)(({ theme }) => ({
  backgroundColor: "#b2dfdb",
}));

const StyledTableCell = styled(TableCell)(({ theme }) => ({
  fontSize: 14,
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  "&:nth-of-type(odd)": {
    backgroundColor: theme.palette.action.hover,
  },
}));

const DataTable = ({ weatherData }) => {
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <StyledTableHead>
          <StyledTableRow>
            <StyledTableCell>Päivämäärä</StyledTableCell>
            <StyledTableCell align="right">Maksimi lämpötila</StyledTableCell>
            <StyledTableCell align="right">Minimi lämpötila</StyledTableCell>
          </StyledTableRow>
        </StyledTableHead>
        <TableBody>
          {weatherData.map((row) => (
            <StyledTableRow
              key={row.name}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <StyledTableCell component="th" scope="row">
                {row.datetime}
              </StyledTableCell>
              <StyledTableCell align="right">{row.tempmax}</StyledTableCell>
              <StyledTableCell align="right">{row.tempmin}</StyledTableCell>
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default DataTable;
