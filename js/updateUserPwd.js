var updatebtn = document.getElementById("updatepwd");

function updatePassword(userData) {
    fetch('http://127.0.0.1:8080/bookmark-1.0-SNAPSHOT/webresources/user/updateUserPassword', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(userData),
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response;
      })
      .then(data => {
        console.log('Password changed:', data);
      })
      .catch(error => {
        console.error('Error:', error);
      });
  }

document.getElementById('updatepwd').addEventListener('submit', function (event) {
    event.preventDefault();
    
    var pwd = document.getElementById("pwd").value;
    var pwd2 = document.getElementById("pwd2").value;
    const errorMessageContainer = document.getElementById("error-message");
    const id = localStorage.getItem("userId");
  
    if (pwd == pwd2) {
        const userData = {
        id: id,
        pwd: pwd
        };
        updatePassword(userData);
        errorMessageContainer.innerText = "";    
    } else {
        errorMessageContainer.innerText = 'A két mező tartalma nem egyezik';
    }
  
  });