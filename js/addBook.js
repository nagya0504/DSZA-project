function addBook(bookData) {
    console.log('Request Payload:', JSON.stringify(bookData));
  
    fetch('http://127.0.0.1:8080/bookmark-1.0-SNAPSHOT/webresources/product/addBook', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(bookData),
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        console.log('Request Payload:', JSON.stringify(bookData));
        alert("Sikeresen feltöltve!");
        window.location.href = "index.html"

        return response.json();
      })
      .then(data => {
        console.log('Book added:', data);
      })
      .catch(error => {
        console.error('Error during book addition:', error);
      });
  }
  
  const bookForm = document.getElementById('book-form');
  
  bookForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    
    const userId = localStorage.getItem('userId');
    const title = document.getElementById('title').value;
    const author = document.getElementById('author').value;
    const price = document.getElementById('price').value;
    const cond = document.getElementById('cond').value;
    const desc = document.getElementById('desc').value;
    const image = document.getElementById('img').value.split('\\').pop();
  
    const bookData = {
      userId: parseInt(userId),
      title: title,
      author: author,
      price: parseInt(price),
      cond: parseInt(cond),
      description: desc,
      image: "img/" + image
    };
  
    addBook(bookData);
  });
  