# Automated-Teller-Machine-ATM-DeepakSahu
Ameriprise Financial assignment, Design and code ATM (Automated Teller Machine
1. DataBase Used :- MongoDB
   DataBase Name- USERATM
   collections used -: "ATM" for accounts
                       "Accounts" for one to many accounts. (single user id with multiple accounts records) 

2. Database connection-: spring.data.mongodb.host=localhost
                         spring.data.mongodb.port=27017
                         spring.data.mongodb.database=USERATM
  
3. Dependencies used -: Spring web, MongoDb, Dev tools

4. Api collection atteched 

reference{
4.1. http://localhost:8080/createaccount - creating account in ATM collection 
body-
{
         "id": 5,
        "ACnumber": 5555,
        "name": "arun chopra",
        "age": "55",
        "balance": 50000
        
}


4.2. http://localhost:8080/balance/:id - "to check the user balance"
4.3. http://localhost:8080/withdraw/:id/:amount - "to withdraw amount"
4.4. http://localhost:8080/deposit/:id/:amount - "to deposit amount"
4.5. http://localhost:8080/:transferfromid/:amount/:transfertoid - " to transfer amount from one account to another"
4.6. http://localhost:8080/createUseraccount - " to create account in Accounts collection"

body -
{
         "id": 1,
        "ACnumber": 1111,
        "name": "arun chopra",
        "age": "11",
        "balance": 10000
        
}

4.7. http://localhost:8080/getAccountsusers - " to check all accounts in the Accounts Collection"    
