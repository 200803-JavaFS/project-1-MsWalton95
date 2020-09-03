const url = "http://127.0.0.1:8080/project0/";
async function viewReimbursement(user){
    let res = await fetch(url + "reimbursement/user/" + user,{
        credentials: "include"
    });

    if(res.status === 200){
        let data = await res.json();
            for (let ticket of data) {
                //let d = new Date();
                //d.toDateString +" "+ d.toLocaleTimeString;
                document.getElementById("ticket").innerHTML = ticket.reimbID;
                document.getElementById("amount").innerHTML = `$ ${ticket.amount}`;
                document.getElementById("submitted").innerHTML = ticket.submitted;
                if(ticket.resolved == null){
                    document.getElementById("resolved").innerHTML = "N/A";
                }else{
                    document.getElementById("resolved").innerHTML = ticket.resolved;
                }
                document.getElementById("description").innerHTML = ticket.description;
                document.getElementById("status").innerHTML = ticket.status.status;
                document.getElementById("type").innerHTML = ticket.type.type;
                document.getElementById("name").innerHTML = ticket.author.firstName + " " + ticket.author.lastName;
                if(ticket.resolver == null){
                    document.getElementById("resolver").innerHTML = "N/A";
                }else{
                document.getElementById("resolver").innerHTML = ticket.resolver.firstName + " " + ticket.resolver.lastName;
                }
            }
    }
}

viewReimbursement(2);

