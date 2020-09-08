const url = "http://127.0.0.1:8080/project0/";
let info = document.cookie.split(';').map(cookie => cookie.split('=')).reduce((accumulator, [key, value]) => ({...accumulator, [key.trim()]: decodeURIComponent(value)}),
{});
let user = info.id;

document.getElementById("addTicketBtn").addEventListener("click", addTicketFunc);

async function addTicketFunc(){
     //INSERT: amount, submitted, description, type, author
    //Retrieve type, author
    let amt = document.getElementById("addAmount").value;
    let submit = new Date().toUTCString(); 
    let desc = document.getElementById("addDescription").value;
    let typ = document.getElementById("addType").value;
    
    switch(typ) {
        case "Lodging":
            typ = 1;
            break;
        case "Food":
            typ = 2;
            break;
        case "Travel":
            typ = 3;
            break;
        case "Other":
            typ = 4;
            break;
    }

    let resType = await fetch(url + "type/" + typ, {
        credentials: 'include',
    });

    let resUser = await fetch(url + "user/" + user, {
        credentials: 'include'
    });

    if(resType.status === 200 && resUser.status === 200){
        let dataType = await resType.json();
        let dataUser = await resUser.json();

        let ticket = {
            amount : amt,
            submitted : submit,   
            description: desc,
            type : dataType,
            author : dataUser
        }

        let res = await fetch(`${url}reimbursement/user/${user}/type/${typ}`, {
            method: 'POST',
            body: JSON.stringify(ticket),
            credentials: 'include'
         });

         if (res.status === 201) {
            let ticketStatus = document.getElementById("ticketStatus");
            ticketStatus.innerHTML = "Ticket added";
            ticketStatus.style.color = "darkgreen";
            let login = setTimeout(() => open("/profile.html","_self"), 3000); 
        
        } else {
            let ticketStatus = document.getElementById("ticketStatus");
            ticketStatus.innerHTML = "Unable to add ticket";
            ticketStatus.style.color = "darkred";
         }  

    } else{
        let ticketStatus = document.getElementById("ticketStatus");
            ticketStatus.innerHTML = "Unable to add ticket";
            ticketStatus.style.color = "darkred";
    }
}

