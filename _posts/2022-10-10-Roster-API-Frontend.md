---
layout: default
description: Testing the use of displaying frontend API
categories: [markdown,javascript]
comments: true
title: Roster
permalink: /data/roster
---

<table>
  <thead>
  <tr>
    <th>id</th>
    <th>name</th>
    <th>category</th>
    <th>grade</th>
  </tr>
  </thead>
  <tbody id = "result">

  </tbody>
</table>




<!-- Script is layed out in a sequence (no function) and will execute when page is loaded -->
<script>
  // prepare HTML result container for new output
  const resultContainer = document.getElementById("result");

  // prepare fetch options
  const url = "https://backend.dnhsscioly.tk/api/roster/";

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


          for (const row of data) {
            console.log(row);

            const tr = document.createElement("tr");

            const id = document.createElement("td");
            const name = document.createElement("td");
            const category = document.createElement("td");
            category.innerHTML = row.category;
              const category_select = document.createElement("select");
                var opt = document.createElement("option");
                opt.value = "anatomy";
                opt.innerHTML = "anatomy"
                category_select.appendChild(opt);
                category.appendChild(category_select);

              const category_button = document.createElement('button');
                category_button.innerHTML = "submit";
                category.appendChild(category_button);
            const grade = document.createElement("td");

            id.innerHTML = row.id;
            name.innerHTML = row.name;
            
            grade.innerHTML = row.grade;

            tr.appendChild(id);
            tr.appendChild(name);
            tr.appendChild(category);
            tr.appendChild(grade);

            resultContainer.appendChild(tr);
          }
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