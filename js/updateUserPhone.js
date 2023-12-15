var updatebtn = document.getElementById("updatephone");

function updatePhone(userData) {
    fetch('http://127.0.0.1:8080/bookmark-1.0-SNAPSHOT/webresources/user/updateUserPhone', {
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
        console.log('Phone number changed:', data);
      })
      .catch(error => {
        console.error('Error:', error);
      });
  }

document.getElementById('updatephone').addEventListener('submit', function (event) {
    event.preventDefault();
  
    const id = localStorage.getItem("userId");
    const phone = document.getElementById('phone').value;
  
    const userData = {
      id: id,
      phone: phone
    };
  
    updatePhone(userData);
  });