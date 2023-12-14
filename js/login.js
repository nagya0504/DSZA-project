var login = document.getElementById("login");

login.addEventListener("click", async (e) => {
  e.preventDefault();
  
  var email = document.getElementById("email");
  var pwd = document.getElementById("pwd");

  console.log(email.value + pwd.value + "asd");

      const postData = JSON.stringify({
          "email": email.value,
          "pwd": pwd.value
      });

      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");

      var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: postData,
        redirect: 'follow'
      };

      try {
        const response = await fetch("http://127.0.0.1:8080/bookmark-1.0-SNAPSHOT/webresources/user/selectUserByEmail", requestOptions);
        if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
        }
    
        const result = await response.text();
        console.log(result);
    
        if (result.userId !== null) {
        const token = result.token;
        localStorage.setItem('Token', token);
        window.location.href = '/index.html';
        } else {
          errorMessageContainer.innerText = 'Rossz adatokat adtál meg, kérlek próbáld újra.';
        }
      } catch (error) {
        console.error('error', error);
        var errorMessageContainer = document.getElementById('error-message');
        errorMessageContainer.innerText = 'Rossz adatokat adtál meg, kérlek próbáld újra.';
      }
    });