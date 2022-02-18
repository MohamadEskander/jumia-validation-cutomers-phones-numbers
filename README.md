# jumia-validation-customers-phones-numbers
single page application in Java using SQLite database to list and categorize country phone numbers (valid and not valid).

## Prerequisite:
 - Having docker installed on your machine.
 - Making sure that docker daemon is up and running.
 
## Running Steps:
 1. Clone the repo in any directory
 2. Open cmd and cd to that directory and run this command **"docker compose -f docker-compose.yml up"**
 3. Open **localhost:4200** in your browser to access the front end

## Postman collection:
 - Open postman and press import postman json file.
   
 - enpoints :
      - http://localhost:8081/customers 
      - http://localhost:8081/customers/filter?state=valid      
      - http://localhost:8081/customers/filter?country=Cameroon
      - http://localhost:8081/customers/filter?country=Cameroon&state=valid

## Technologies: 
- **Spring-Boot:** used For Backend
- **Angular:** used For Frontend
