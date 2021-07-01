# Test especification
#### Create a RESTfull API in order to get all indicated and Golden Raspberry Awards worst movie winners 
 
> ***System requirements***
- [X] Read the CSV file of movies and insert all data in a local database when application stated.
  
- [X] Get the producer with longest interval between twice awards, and that have two awards faster.

> ***non-functional requirements***
- [X] The web service RESTful should be implemented with level 2 from Richardson maturity.
  
- [X] Should be implemented only integration tests. They must guarantee that geted data are in 
  agreement with the data privoded in the proposal.
  
- [X] The Database should be in local memory, no external installations required.
  
- [X] The application should have a readme with instructions in order to run the project and tests. 

### Execution
- `mvn spring-boot:run`
- `curl http://localhost:8080/api/gra/movies/producer/intervalbetweenawards` GET

### How to Test
- Inside your prefered IDE, you can just run ApirestApplicationTests to get result.
- Or, if you want test whole application with Postman, you can insert this snippet
on Tests Tab (under URI bar, using the same URI that you have above) and Send, the result will showing in _Test Results_ under Script input:


    pm.test("Status OK", function () {
     pm.response.to.have.status(200);
    });

