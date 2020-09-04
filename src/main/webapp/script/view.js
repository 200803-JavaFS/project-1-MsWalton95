let user =1;
const url = "http://127.0.0.1:8080/project0/";

viewTickets(user);
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
            let submitted = ticket.submitted;
            let resolved = "N/A";
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
            cell3.innerHTML = `$${amount}`;
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
            let submitted = ticket.submitted;
            let resolved = ticket.resolved;
            let description = ticket.description;
            let type = ticket.type.type;
            let status = ticket.status.status;
            let author =` ${ticket.author.firstName} ${ticket.author.lastName}`;
            //let resolver = ;

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
                }, 600)
                
            });
            
        }

        $("#ticket").html(data[0].reimbID);
        $("#amount").html(data[0].amount);
        $("#submitted").html(data[0].submitted);
        $("#resolved").html(data[0].resolved);
        $("#description").html(data[0].description);
        $("#status").html(data[0].status.status);
        $("#type").html(data[0].type.type);
        $("#author").html(data[0].author.firstName + " " + data[0].author.lastName);
        $("#resolver").html("N/A");
        //$("#resolver").html(data[0].resolver.firstName + " " + data[0].resolver.lastName); // addEventListener("click", event =>{

        // });
    }
}
async function updateTicketFunc(){
    
}