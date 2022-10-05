---
layout: default
description: Testing the use of displaying frontend API
categories: [markdown,javascript]
comments: true
title: Weather Fetch API
permalink: /data/weather
---

<table>
  <thead>
  <tr>
    <th>Image</th>
    <th>Weather F</th>
    <th>Feels like F</th>
    <th>Location</th>
  </tr>
  </thead>
  <tbody>
    <td id="image"></td>
    <td id="weather_f"></td>
    <td id="feels_like"></td>
    <td id="location"></td>
  </tbody>
</table>


<!-- Script is layed out in a sequence (no function) and will execute when page is loaded -->
<script>
  // prepare HTML result container for new output
  const resultContainer = document.getElementById("result");

  // prepare fetch options
  const url = "https://mengman.tk/api/weather/currentWeather";

  const options = {
    method: 'GET', // *GET, POST, PUT, DELETE, etc.
    mode: 'cors', // no-cors, *cors, same-origin
    cache: 'default', // *default, no-cache, reload, force-cache, only-if-cached
    credentials: 'omit', // include, *same-origin, omit
    headers: {
      'Content-Type': 'application/json'
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
  };

  // fetch the API
  fetch(url, options)
    // response is a RESTful "promise" on any successful fetch
    .then(response => {
      // check for response errors
      if (response.status !== 200) {
          const errorMsg = 'Database response error: ' + response.status;
          console.log(errorMsg);
          const tr = document.createElement("tr");
          const td = document.createElement("td");
          td.innerHTML = errorMsg;
          tr.appendChild(td);
          resultContainer.appendChild(tr);
          return;
      }
      // valid response will have json data
      response.json().then(data => {
          console.log(data);
          console.log(data);

          // World Data
          document.getElementById("image").innerHTML = data.current.condition.icon;
          document.getElementById("weather_f").innerHTML = data.current.temp_f;
          document.getElementById("feels_like").innerHTML = data.current.feelslike_f;
          document.getElementById("location").innerHTML = data.location.name;

          
      })
  })
  // catch fetch errors (ie ACCESS to server blocked)
  .catch(err => {
    console.error(err);
    const tr = document.createElement("tr");
    const td = document.createElement("td");
    td.innerHTML = err;
    tr.appendChild(td);
    resultContainer.appendChild(tr);
  });
</script>