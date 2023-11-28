const toggleButton = document.getElementById('toggleButton');
const toggleDiv = document.getElementById('toggleDiv');

toggleButton.addEventListener('click', function() {
  if (toggleDiv.style.display === 'none') {
    toggleDiv.style.display = 'block';
  } else {
    toggleDiv.style.display = 'none';
  }
});


function updateUserTownOnServer(userId, newTown) {
    // Create an object with the data to be sent
    const userData = {
      id: userId,
      town: newTown,
    };
  
    fetch('http://your-java-backend/api/updateUserTown', {
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
        console.log('User town updated:', data);
        // You can perform further actions like updating the UI or redirecting the user.
      })
      .catch(error => {
        // Handle errors here, such as network issues or server errors
        console.error('Error during user town update:', error);
        // Display an error message to the user or perform error-specific actions.
      });
  }
  
  // Example usage:
  const userId = 123; // Replace with the user's ID
  const newTown = 'NewTown'; // Replace with the new town name
  
  // Call the updateUserTownOnServer function with user data
  updateUserTownOnServer(userId, newTown);
  