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

randomFacts();

function clock(){
    let date = document.getElementById("date");
    let time = document.getElementById("time");

    let d = new Date();
   
    date.innerHTML = d.toDateString();
    time.innerHTML = d.toLocaleTimeString();
}

var interval = setInterval(clock, 1000);

//             backgroundColor: [
//                 '#9ee690',
//                 '#307262',
//                 '#323737',
//             ],
//             hoverBackgroundColor: [
//                 '#C1ECBA',
//                 '#2E9079',
//                 '#242727'
