var updatebtn = document.getElementById("updateusername");

function updateUsername(userData) {
    fetch('http://127.0.0.1:8080/bookmark-1.0-SNAPSHOT/webresources/user/updateUserUsername', {
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
        console.log('Username changed:', data);
      })
      .catch(error => {
        console.error('Error:', error);
      });
  }

document.getElementById('updateusername').addEventListener('submit', function (event) {
    event.preventDefault();
  
    const id = localStorage.getItem("userId");
    const username = document.getElementById("username").value;
  
    const userData = {
      id: id,
      username: username
    };
  
    updateUsername(userData);
  });