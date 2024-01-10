var updatebtn = document.getElementById("updatetown");

function updateTown(userData) {
    fetch('http://127.0.0.1:8080/bookmark-1.0-SNAPSHOT/webresources/user/updateUserTown', {
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
        console.log('Town changed:', data);
      })
      .catch(error => {
        console.error('Error:', error);
      });
  }

document.getElementById('updatetown').addEventListener('submit', function (event) {
    event.preventDefault();
  
    const id = localStorage.getItem("userId");
    const town = document.getElementById("town").value;
  
    const userData = {
      id: id,
      town: town
    };
  
    updateTown(userData);
  });