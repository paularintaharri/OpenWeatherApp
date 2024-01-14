export const API_URL = process.env.REACT_APP_API_URL;

export const fetchDays = async () => {
  const res = await fetch(`${API_URL}/days`);
  const resultJson = await res.json();
  return resultJson;
};

export const fetchDayById = async (id) => {
  const res = await fetch(`${API_URL}/days/${id}`);
  const resultJson = await res.json();
  return resultJson.data;
};

export const addNewDay = async (entry) => {
  const res = await fetch(`${API_URL}/days`, {
    method: "POST",
    body: JSON.stringify(entry),
    headers: {
      "Content-Type": "application/json",
    },
  });
  return await res.json();
};

export const updateDay = async (data, id) => {
  const res = await fetch(`${API_URL}/days/${id}`, {
    method: "PUT",
    body: JSON.stringify(data),
    headers: {
      "Content-Type": "application/json",
    },
  });
  return res.json();
};

export const deleteDay = async (id) => {
  const res = await fetch(`${API_URL}/days/${id}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  });
  return res.json();
};
