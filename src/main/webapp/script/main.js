const url = "http://127.0.0.1:8080/project0/";


//
document.getElementById("addTicketBtn").addEventListener("click", addTicketFunc1);

async function addTicketFunc1(){
    //INSERT: amount, submitted, description, status, type, author
    //Retrieve status, type, author
    let typ = document.getElementById("addType").value;
    let stat = 2;
    let user = 1;
    
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
        credentials: "include"
    });

    let resStatus = await fetch(url + "status/" + stat, {
        credentials: "include"
    });

    let resUser = await fetch(url + "user/" + user, {
        credentials: "include"
    });

    if(resStatus.status === 200 && resType.status === 200){
        let dataStatus = await resStatus.json();
        let dataType = await resType.json();
        let dataUser = await resUser.json();
        console.log(dataStatus);
        console.log(dataType);
        console.log(dataUser);
      
        addTicketFunc2(dataStatus, dataType, dataUser);
    }
}

async function addTicketFunc2(dataStatus, dataType, dataUser){
    let amt = document.getElementById("addAmount").value;
    let desc = document.getElementById("addDescription").value;

    var dt = new Date();
    var submit = dt.toUTCString(); 
   // let submit = new Date().toISOString().slice(0, 19).replace('T', ' ');

      let ticket = {
            amount : amt,
            submitted : submit,   
            description: desc,
            status : dataStatus,
            type : dataType,
            author : dataUser
        }
        console.log(ticket);

        let res = await fetch(url + "reimbursement", {
            method: 'POST',
            body: JSON.stringify(ticket),
            credentials: 'include'
         });
        
         if (res.status === 201) {
            let data = await res.json();
            console.log(data)
            //let login = setTimeout(() => open("/profile.html"), 3000); 
        
        } else{
            console.log("something is wrong")
        }
}
