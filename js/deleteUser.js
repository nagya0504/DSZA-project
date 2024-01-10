const delbtn = document.getElementById("delbtn");

delbtn.addEventListener("click", async (e) => {
    e.preventDefault();
    var userId = localStorage.getItem("userId");
    // console.log(userId);

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
    "id": userId
    });

    var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
    };

    try {    
    fetch("http://127.0.0.1:8080/bookmark-1.0-SNAPSHOT/webresources/user/logDeleteUser", requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
    } catch (error) {
        console.error('error', error);
        var errorMessageContainer = document.getElementById('error-message');
        errorMessageContainer.innerText = 'Rossz adatokat adtál meg, kérlek próbáld újra.';
      }
})