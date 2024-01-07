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
        // console.log('Request Headers:', myHeaders);
        console.log('Request Payload:', JSON.stringify(bookData));

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
  
    var userId = localStorage.getItem('userId');
    const title = document.getElementById('title').value;
    const author = document.getElementById('author').value;
    const price = document.getElementById('price').value;
    const desc = document.getElementById('desc').value;
  
    const bookData = {
      userId: parseInt(userId),
      title: title,
      author: author,
      price: parseInt(price),
      description: desc,
      image: "kép"
    };
  
    addBook(bookData);
  });
  