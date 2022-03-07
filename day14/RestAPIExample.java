package day14;

/*
GET, POST, PUT
HTTP request and it is returning a response.
Especially in this case it is non - GUI
It's returning some data
HTTP API which you call and it returns some data it is also called
REST API
domain/ -> Get request and it has to return all the tweets
http://localhost:8080/tweets GET
These requests are handled by Tomcat server

Ex: Modify all the API's that you have implemented with the following:
(i) Include appropriate message and status code
(ii) When the API creates some data store it in an appropriate Data structure.
(iii) Store the tweets for a user
(iv) Do appropriate error handling by using status codes
(v) Ex: I make a call to tweet API ie. creation of a tweet {"id":"","tweet":"","date":""}
        (i) Check if a user exists with this userID? <-- userProfile.
(vi) containsInvalidChars implement this function

 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestAPIExample {
//    @GetMapping("/tweets")
//    List<String> getTweets() {
//        return Arrays.asList("tweet-1", "tweet-2", "tweet-3");
//    }
//    @GetMapping("/users")
//    List<String> getUsers() {
//        return Arrays.asList("user-1");
//    }
//    @GetMapping("/tweets")
//    List<String> getTweets(@RequestParam String mention, @RequestParam String word) {
//        return Arrays.asList(mention,word);
//    }
//    @PostMapping("/tweet")
//    List<String> postTweet(@RequestBody String body) {
//        return Arrays.asList(body);
//    }
//    @PostMapping("/create")
//    List<String> createFacebookAccount(@RequestBody String body) {
//        return Arrays.asList(body);
//    }
//    @PostMapping("/create")
//    List<String> createTwitterAccount(@RequestBody String body) {
//        return Arrays.asList(body);
//    }
//
private Map<String, String> userProfile = new HashMap<>();

    //    User can create an account  -->POST
    @PostMapping("/create")
    List<String> getTweets(@RequestBody Map<String, String> requestBodyMap) {
        String email = requestBodyMap.get("email");
        String name = requestBodyMap.get("name");

        userProfile.put(email, name);
        return Arrays.asList(name, email);
    }

    //    User can fetch account details --> GET
    @GetMapping("/fetch")
    Map<String, String> getAccDetails() {
        return userProfile;
    }

    @GetMapping("/getDetails")
    private String getAccDetails(@RequestParam String email) {
        return userProfile.get(email);
    }


    //    User can update account details  -->PUT
    @PutMapping("/update")
    private ResponseEntity<String> updateRecord(@RequestBody Map<String, String> requestBodyMap) {
        /*
        (i) email doesnot exist
        (ii) Email present and name is also same
        (iii) Email present and name is different
        Making my API complete or robust.
         */
        String email = requestBodyMap.get("email");
        String name = requestBodyMap.get("name");
        ResponseEntity<String> responseEntity = null;
        if (containsInvalidChars(name)) {
            responseEntity = new ResponseEntity<>("name contains invalid characters",
                    HttpStatus.BAD_REQUEST);
        } else if (userProfile.containsKey(email)) {
            String currName = userProfile.get(email);
            if (currName.equals(name)) {
                responseEntity = new ResponseEntity<>("No change rquired",
                        HttpStatus.OK);
            } else {
                userProfile.put(email, name);
                responseEntity = new ResponseEntity<>("update successful",
                        HttpStatus.OK);
            }
        } else {
            // (i) response body (ii) you specify the appropriate status codes
            // email does not exist
            responseEntity = new ResponseEntity<>("User doesn't exist",
                    HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    private boolean containsInvalidChars(String name) {
        // name contains any numbers or +-
        return false;
    }


    //    User can delete account  -->DELETE
    @DeleteMapping("/delete")
    String deleteRecord(@RequestParam String email) {
        if (userProfile.containsKey(email)) {
            userProfile.remove(email);
        }
        return email + " successfully deleted";
    }





}
