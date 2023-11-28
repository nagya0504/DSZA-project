// Define the function to add a user to the server
function addUserToServer(userData) {
  fetch('http://127.0.0.1:8080/bookmark-1.0-SNAPSHOT/webresources/user/addUser', {
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
      return response.json();
    })
    .then(data => {
      // Handle the response data here
      console.log('User added:', data);
      // You can perform further actions like updating the UI or redirecting the user.
    })
    .catch(error => {
      // Handle errors here, such as network issues or server errors
      console.error('Error during user addition:', error);
      // Display an error message to the user or perform error-specific actions.
    });
}

// Attach an event listener to the form submit event
document.getElementById('regform').addEventListener('submit', function (event) {
  event.preventDefault(); // Prevent the default form submission

  // Get user data from input fields
  const username = document.getElementById('username').value;
  const familyname = document.getElementById('familyname').value;
  const givenname = document.getElementById('givenname').value;
  const email = document.getElementById('email').value;
  const password = document.getElementById('pwd').value;
  const phone = document.getElementById('phone').value;
  const town = document.getElementById('town').value;

  // Create a user data object
  const userData = {
    username: username,
    familyName: familyname,
    givenName: givenname,
    email: email,
    pwd: password,
    phone: phone,
    town: town,
  };

  // Call the addUserToServer function with the user data
  addUserToServer(userData);
});

