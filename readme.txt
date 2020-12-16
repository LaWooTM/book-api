To run Book API locally:
 git clone https://github.com/LaWooTM/book-api.git
 cd book-api
 ./mvnw package
 java -jar target/*.jar

Access book-api at:
 GET http://localhost:8080/api/books
 GET http://localhost:8080/api/books/{id}

 POST http://localhost:8080/api/books

 sample data:
     {
         "title": "The Sun Also Rises",
         "author": "Ernest Hemingway"
     }

     {
         "title": "Pride and Prejudice",
         "author": "Jane Austen"
     }