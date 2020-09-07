const url = "http://127.0.0.1:8080/project0/";
let info = document.cookie.split(';').map(cookie => cookie.split('=')).reduce((accumulator, [key, value]) => ({...accumulator, [key.trim()]: decodeURIComponent(value)}),
{});
let user = info.id;
let role = info.role;console.log(`role: ${role}`);

if(role == 1){
    viewTickets(user);
}else{
    viewManagerTickets();
}

async function viewTickets(user) {
    let resp = await fetch(url + "reimbursement/user/" + user, {
        credentials: 'include',
    });

    if (resp.status === 200) {
        let data = await resp.json();
        
        const pend = data.filter(ticket => ticket.status.status === "Pending");
        const comp = data.filter(ticket => ticket.status.status !== "Pending");

        for (let ticket of pend) {
            let reimb = ticket.reimbID;
            let amount = ticket.amount;

            let date = new Date(ticket.submitted).toLocaleDateString();
            //let time = new Date(ticket.submitted).toLocaleTimeString();
            let submitted = date;

            let resolved = "N/A"
            let description = ticket.description;
            let type = ticket.type.type;
            let status = "In process...";
            let author = ticket.author.firstName + " " + ticket.author.lastName;
            let resolver = "N/A";

            let container = document.createElement("div");
            let contain = document.createElement("div");
            let cell = document.createElement("h5");
            cell.innerHTML = `Ticket #${reimb}`;
            contain.appendChild(cell);
            let cell2 = document.createElement("h6");
            cell2.innerHTML = status;
            contain.appendChild(cell2);
            contain.className = "trans";
            container.appendChild(contain);
            let cell3 = document.createElement("h3");
            cell3.innerHTML = amount;
            container.appendChild(cell3);
            container.className = "transaction";
            document.getElementById("pending").appendChild(container);

            $(container).click(()=>{
                $("#details").fadeTo(500, 0.5).fadeTo(100,1);
                setTimeout(()=>{
                $("#ticket").html(reimb);
                $("#amount").html(amount);
                $("#submitted").html(submitted);
                $("#resolved").html(resolved);
                $("#description").html(description);
                $("#status").html(status);
                $("#type").html(type);
                $("#author").html(author);
                $("#resolver").html(resolver);
            }, 600)
            });
        }

        for (let ticket of comp) {
            let reimb = ticket.reimbID;
            let amount = ticket.amount;

            let date = new Date(ticket.submitted).toLocaleDateString();
            let submitted = date;

            let date2 = new Date(ticket.resolved).toLocaleDateString();
            let resolved = date2;

            let description = ticket.description;
            let type = ticket.type.type;
            let status = ticket.status.status;
            let author =` ${ticket.author.firstName} ${ticket.author.lastName}`;


            let container = document.createElement("div");
            let contain = document.createElement("div");
            let cell4 = document.createElement("h5");
            cell4.innerHTML = `Ticket #${reimb}`;
            contain.appendChild(cell4);
            let cell5 = document.createElement("h6");
            cell5.innerHTML = `${status}  ${resolved}`;
            contain.appendChild(cell5);
            contain.className = "trans";
            container.appendChild(contain);
            let cell6 = document.createElement("h3");
            cell6.innerHTML =`$${amount}`;
            container.appendChild(cell6);
            container.className = "transaction";
            
            document.getElementById("complete").appendChild(container);

            $(container).click(()=>{
                $("#details").fadeTo(500, 0.5).fadeTo(100,1);
                setTimeout(()=>{
                    $("#ticket").html(reimb);
                    $("#amount").html(amount);
                    $("#submitted").html(submitted);
                    $("#resolved").html(resolved);
                    $("#description").html(description);
                    $("#status").html(status);
                    $("#type").html(type);
                    $("#author").html(author);
                    if(ticket.resolver ==  null){
                        $("#resolver").html("N/A");
                    }else{
                        $("#resolver").html(`${ticket.resolver.firstName}  ${ticket.resolver.lastName}`);
                    }
                }, 600);
            });
            
        }

        let date = new Date(data[0].submitted).toLocaleDateString();
        let submitted = date;

        let date2 = new Date(data[0].resolved).toLocaleDateString();
        let resolved = date2;

        $("#ticket").html(data[0].reimbID);
        $("#amount").html(data[0].amount);
        $("#submitted").html(submitted);
        if(ticket.resolved ==  null){
            $("#resolved").html("N/A");
        }else{
            $("#resolved").html(resolved);
        }
        $("#description").html(data[0].description);
        $("#status").html(data[0].status.status);
        $("#type").html(data[0].type.type);
        $("#author").html(data[0].author.firstName + " " + data[0].author.lastName);
        if(ticket.resolver ==  null){
            $("#resolver").html("N/A");
        }else{
            $("#resolver").html(data[0].resolver);
        }

        $("#approveBtn").hide();
        $("#denyBtn").hide();
    }
}

/********************** 
 * MANAGER TICKET 
 * ********************/
async function viewManagerTickets() {
    let resp = await fetch(url + "reimbursement/", {
        credentials: 'include',
    });

    if (resp.status === 200) {
        let data = await resp.json();
        
        const pend = data.filter(ticket => ticket.status.status === "Pending");
        const comp = data.filter(ticket => ticket.status.status !== "Pending");

        document.getElementById("approveBtn").addEventListener("click",()=>{
            if($("#status").html() === "In process..."){
                let id = $("#ticket").html();
                let stat = 1;
                getTicket(stat, id);
            }
            
        });
        document.getElementById("denyBtn").addEventListener("click",()=>{
            if($("#status").html() === "In process..."){
                let id = $("#ticket").html();
                let stat = 3;
                getTicket(stat, id);
            };
        });
        
        let date = new Date(data[0].submitted).toLocaleDateString();
        let submitted = date;

        let date2 = new Date(data[0].resolved).toLocaleDateString();
        let resolved = date2;

        $("#ticket").html(data[0].reimbID);
        $("#amount").html(data[0].amount);
        $("#submitted").html(submitted);
        if(ticket.resolved ==  null){
            $("#resolved").html("N/A");
        }else{
            $("#resolved").html(resolved);
        }
        $("#description").html(data[0].description);
        $("#status").html("In process...");
        $("#type").html(data[0].type.type);
        $("#author").html(data[0].author.firstName + " " + data[0].author.lastName);
        if(ticket.resolver ==  null){
            $("#resolver").html("N/A");
        }else{
            $("#resolver").html(data[0].resolver);
        }   
//For Pending and Complete
        for (let ticket of pend) {
            let reimb = ticket.reimbID;
            let amount = ticket.amount;
            let submitted = new Date(ticket.submitted).toLocaleDateString();
            let resolved = "N/A"
            let description = ticket.description;
            let type = ticket.type.type;
            let status = "In process...";
            let author = ticket.author.firstName + " " + ticket.author.lastName;
            let resolver = "N/A";

            let container = document.createElement("div");
            let contain = document.createElement("div");
            let cell = document.createElement("h5");
            cell.innerHTML = `Ticket #${reimb}`;
            contain.appendChild(cell);
            let cell2 = document.createElement("h6");
            cell2.innerHTML = status;
            contain.appendChild(cell2);
            contain.className = "trans";
            container.appendChild(contain);
            let cell3 = document.createElement("h3");
            cell3.innerHTML = amount;
            container.appendChild(cell3);
            container.className = "transaction";
            document.getElementById("pending").appendChild(container);

            $(container).click(()=>{
                $("#details").fadeTo(500, 0.5).fadeTo(100,1);
                setTimeout(()=>{
                    $("#ticket").html(reimb);
                    $("#amount").html(amount);
                    $("#submitted").html(submitted);
                    $("#resolved").html(resolved);
                    $("#description").html(description);
                    $("#status").html(status);
                    $("#type").html(type);
                    $("#author").html(author);
                    $("#resolver").html(resolver);
                }, 600);
            });
        }

        for (let ticket of comp) {
            let reimb = ticket.reimbID;
            let amount = ticket.amount;

            let date = new Date(ticket.submitted).toLocaleDateString();
            let submitted = date;

            let date2 = new Date(ticket.resolved).toLocaleDateString();
            let resolved = date2;

            let description = ticket.description;
            let type = ticket.type.type;
            let status = ticket.status.status;
            let author =` ${ticket.author.firstName} ${ticket.author.lastName}`;


            let container = document.createElement("div");
            let contain = document.createElement("div");
            let cell4 = document.createElement("h5");
            cell4.innerHTML = `Ticket #${reimb}`;
            contain.appendChild(cell4);
            let cell5 = document.createElement("h6");
            cell5.innerHTML = `${status}  ${resolved}`;
            contain.appendChild(cell5);
            contain.className = "trans";
            container.appendChild(contain);
            let cell6 = document.createElement("h3");
            cell6.innerHTML =`$${amount}`;
            container.appendChild(cell6);
            container.className = "transaction";
            
            document.getElementById("complete").appendChild(container);

            $(container).click(()=>{
                $("#details").fadeTo(500, 0.5).fadeTo(100,1);
                setTimeout(()=>{
                    $("#ticket").html(reimb);
                    $("#amount").html(amount);
                    $("#submitted").html(submitted);
                    $("#resolved").html(resolved);
                    $("#description").html(description);
                    $("#status").html(status);
                    $("#type").html(type);
                    $("#author").html(author);
                    if(ticket.resolver ==  null){
                        $("#resolver").html("N/A");
                    }else{
                        $("#resolver").html(`${ticket.resolver.firstName}  ${ticket.resolver.lastName}`);
                    }
                }, 600);
            });
        }
    }
}



async function getTicket(stat, id){
    let res = await fetch(url + "reimbursement/" + id, {
        credentials: 'include',
    });

    let res2 = await fetch(url + "status/" + stat, {
        credentials: 'include',
    });

    let res3 = await fetch(url + "user/" + user, {
        credentials: 'include',
    }); 
    
    if (res.status === 200) {
        let dataTicket = await res.json();
        let dataStatus = await res2.json();
        let dataUser = await res3.json();

        console.log(dataTicket);console.log(dataStatus);console.log(dataUser);

        updateTicketFunc(dataTicket, dataStatus, dataUser);
    }
}  

async function updateTicketFunc(ticket, stat, resolveUser){
    //reimbID, resolved, status, resolver
    let date = ticket.submitted;
    let submit = new Date(date).toUTCString();
    let resolve = new Date().toUTCString();

    let tickets = {
        reimbID : ticket.reimbID,
        amount : ticket.amount,
        submitted : submit,
        resolved : resolve,
        description : ticket.description,
        status : stat,
        type : ticket.type,
        author : ticket.author,
        resolver : resolveUser 
    }
    //reimbursement/user/1/status/3
    let res = await fetch(`${url}reimbursement/user/${ticket.reimbID}/status/${stat.statusID}`, {
        method: 'POST',
        body: JSON.stringify(tickets),
        credentials: 'include'
    });

    if (res.status === 200) {
        let data = await res.json();
        console.log(data);
        let login = setTimeout(() => open("/profile.html","_self"), 3000); 
    }else{
        console.log("Issues have occurred");
    }
}