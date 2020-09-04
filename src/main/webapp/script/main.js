const url = "http://127.0.0.1:8080/project0/";
let user = 1;

document.getElementById("loginbtn").addEventListener("click", loginFunc);
//document.getElementById("addTicketBtn").addEventListener("click", AddTicketFunc);

async function openFunc(){
    window.open("/profile.html");
}

async function loginFunc() {
    let uname = document.getElementById("user").value;
    let pass = document.getElementById("pwd").value;

    let user = {
        username: uname,
        password: pass
    }

    let res = await fetch(url + "login", {
        method:"POST",
        // headers:{
        //     'Content-Type':'application/json',
        // },
        body: JSON.stringify(user),
        credentials: "include"
    });

    if (res.status === 200) {
        console.log(res);
        let data = await res.json();
        console.log(data);
        document.getElementById("loginStatus").innerText = "Welcome back!.";
        let login = setTimeout(() => open("/profile.html"), 3000); 
        
    } else {
        console.log(res.status);
        document.getElementById("loginStatus").innerText = "Login failed!";
    }
}

async function AddTicketFunc(){

    let a = document.getElementById("addAmount").value;
    let d = document.getElementById("addDescription").value;
    let t = document.getElementById("addType").value;

     let day = new Date();
     let dd = day.toDateString +" "+ day.toLocaleTimeString;

    let ticket = {
        amount : a,
        submitted : dd,   
        resolved : "N/A",  
        description: d,
        status : "pending",
        type : t,
        author : user,
        resolver : "N/A"
    }

    let resp = await fetch(url + "reimbursement", {
        method: 'POST',
        body: JSON.stringify(ticket),
        credentials: "include"
    })

    if(resp.status === 201){
        document.getElementById("ticketStatus").innerText = "Ticket completed";
         let login = setTimeout(() => open("/profile.html"), 3000); 
    } else {
        document.getElementById("ticketStatus").innerText = "Ticket could not be added.";
    }

}


