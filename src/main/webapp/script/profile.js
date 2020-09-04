/* API and Time */

//Random Facts
let catfact = document.getElementById("catfact");

function randomFacts(){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200){
            let data = JSON.parse(xhr.responseText);
            renderHTML(data);
        }
    }
    xhr.open("GET", "https://cat-fact.herokuapp.com/facts/random");
    xhr.send();
}

function renderHTML(data) {
    catfact.innerText = data.text;
}

//Clock
function clock(){
    let date = document.getElementById("date");
    let time = document.getElementById("time");

    let d = new Date();
   
    date.innerHTML = d.toDateString();
    time.innerHTML = d.toLocaleTimeString();
}

//Weather
const api = {
    key:"e098f9be3c1c98b46bf0cde2b0ba98a7",
    base:"https://api.openweathermap.org/data/2.5/"
}

function getWeather(zipcode){
    fetch(`${api.base}weather?zip=${zipcode},us&units=metric&appid=${api.key}`)
    .then(weather =>{
        return weather.json();
    }).then(displayResults);
}

function displayResults (weather){
    let temp = document.getElementById("temp")
  temp.innerHTML = `${Math.round(weather.main.temp)}<span>°c</span>`;

  let weather_el = document.getElementById("weather");
  weather_el.innerText = weather.weather[0].main;

  let hilow = document.getElementById("hi-low");
  hilow.innerText = `${Math.round(weather.main.temp_min)}°c / ${Math.round(weather.main.temp_max)}°c`;
}

getWeather(30080);
randomFacts();
setInterval(clock, 1000);

/* Retrieve User Information */

const url = "http://127.0.0.1:8080/project0/";


async function getProfile(user){
   let resp = await fetch(url + "user/" + user,{
       credentials: "include"
   });

   if(resp.status === 200){
       let data = await resp.json();
           document.getElementById("photo").setAttribute("src",`/img/profile-${user}.png`)
           document.getElementById("name").innerHTML = `${data.firstName} ${data.lastName}`;
           document.getElementById("email").innerHTML = data.email;
   }
}

async function getTicket(user){
    let res = await fetch(url + "reimbursement/user/" + user,{
        credentials: "include"
    });

    if(res.status === 200){
        let data = await res.json();
            for (let ticket of data) {
                
                 //let d = new Date();
                //d.toDateString +" "+ d.toLocaleTimeString;
                let row = document.createElement("tr");
                let cell = document.createElement("td");
                cell.innerHTML = ticket.reimbID;
                row.appendChild(cell);
                let cell2 = document.createElement("td");
                cell2.innerHTML = `$${ticket.amount}`;
                row.appendChild(cell2);
                let cell3 = document.createElement("td");
                cell3.innerHTML = ticket.submitted;
                row.appendChild(cell3);
                if(ticket.resolved == null){
                    let cell4 = document.createElement("td");
                    cell4.innerHTML = "N/A";
                    row.appendChild(cell4);
                }else{
                    let cell4 = document.createElement("td");
                    cell4.innerHTML = ticket.resolved;
                    row.appendChild(cell4);
                }
                let cell6 = document.createElement("td");
                cell6.innerHTML = ticket.status.status;
                row.appendChild(cell6);

                document.getElementById("profileTicket").appendChild(row);
            }
    }
}
let user = 1;
addEventListener("onload", getProfile(user));
addEventListener("onload", getTicket(user));

// for (let ticket of data) {
//     let i =0;
//     i+=1;

//     //let d = new Date();
//     //d.toDateString +" "+ d.toLocaleTimeString;
//     let row = document.createElement("tr");
//     let cell = document.createElement("td");
//     cell.innerHTML = i;
//     row.appendChild(cell);
//     let cell2 = document.createElement("td");
//     cell2.innerHTML = `$${ticket.amount}`;
//     row.appendChild(cell2);
//     let cell3 = document.createElement("td");
//     cell3.innerHTML = ticket.submitted;
//     row.appendChild(cell3);
//     if(ticket.resolved == null){
//         let cell4 = document.createElement("td");
//         cell4.innerHTML = "pending";
//         row.appendChild(cell4);
//     }else{
//         let cell4 = document.createElement("td");
//         cell4.innerHTML = ticket.resolved;
//         row.appendChild(cell4);
//     }
//     let cell5 = document.createElement("td");
//     cell5.innerHTML = ticket.description;
//     row.appendChild(cell5);
//     let cell6 = document.createElement("td");
//     cell6.innerHTML = ticket.status.status;
//     row.appendChild(cell6);
//     let cell7 = document.createElement("td");
//     cell7.innerHTML = ticket.type.type;
//     row.appendChild(cell7);
//     let cell8 = document.createElement("td");
//     cell8.innerHTML = ticket.author.firstName + " " + ticket.author.lastName;
//     row.appendChild(cell8);
//     if(ticket.resolver == null){
//         let cell9 = document.createElement("td");
//         cell9.innerHTML = "pending";
//         row.appendChild(cell9);
//     }else{
//         let cell9 = document.createElement("td");
//         cell9.innerHTML = ticket.resolver.firstName + " " + ticket.resolver.lastName;
//         row.appendChild(cell9);
//     }

//     document.getElementById("profileTicket").appendChild(row);
// }