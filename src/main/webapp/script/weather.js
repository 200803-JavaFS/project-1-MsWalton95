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