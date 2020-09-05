//Parse from JSON
    // let dob = 406771200000;
    // console.log(dob);
//Convert to Javascript to the time already submitted
    // let date = new Date(dob).toLocaleDateString();
    // let time = new Date(dob).toLocaleTimeString();
    // console.log(date + " " + time);
//Convert to Timestamp for SQL;
    // dob = new Date().toISOString().slice(0, 19).replace('T', ' ');
    // console.log(dob);

const url = "http://127.0.0.1:8080/project0/";

document.getElementById("loginbtn").addEventListener("click", loginFunc);

async function loginFunc() {
    let uname = document.getElementById("user").value;
    let pass = document.getElementById("pwd").value;

    let user = {
        username: uname,
        password: pass
    }

        let res = await fetch(url + "login", {
        method:"POST",
        body: JSON.stringify(user),
        credentials: "include"
    })

    if (res.status === 200) {
      try{
        let data = await res.json();
        document.getElementById("loginStatus").innerText = "Welcome back!";
        
        console.log(data.userID);
        let login = setTimeout(() => open("/profile.html"), 3000); 
        }catch(err){console.log(err)}
    } else if(res.status === 401) {
        document.getElementById("loginStatus").innerText = "Sorry! Wrong input";
       // document.getElementById("loginStatus").innerText = "That is incorrect";
    }  else{
        console.log("Sorry")
    }

}