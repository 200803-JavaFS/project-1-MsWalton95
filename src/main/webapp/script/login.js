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
    });

    document.getElementById("loginStatus").innerText = "Loading...";    

    if (res.status === 200) {
        let loading = document.getElementById("loginStatus");
        loading.innerText = "Loading...";
        loading.style.color = "silver";   
      try{
         
        let data = await res.json();
        document.getElementById("loginStatus").innerText = `Welcome back ${data.firstName}!`;

        document.cookie = `id=${data.userID}`;
        document.cookie = `firstname=${data.firstName}`;
        document.cookie = `lastname=${data.lastName}`;
        document.cookie = `role=${data.roleID.roleID}`;
        let userss = document.cookie;
        let login = setTimeout(() => open("/profile.html","_self"), 3000); 
        }catch(err){
            console.log(err);
        }
    } else if(res.status === 401) {
        document.getElementById("loginStatus").innerText = "Sorry! Wrong input";
    }  else{
        console.log("Sorry");
    }

}



