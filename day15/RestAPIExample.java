package day15;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class RestAPIExample {

    private Map<String,User> userProfile = new HashMap<>();
    private Map<String,List<Tweet>> tweets = new HashMap<>();
    private Map<String,List<String>> following=new HashMap<>();

    //User can create an account  -->POST
    @PostMapping("/create")
    private ResponseEntity<String>  createAccount(@RequestBody User user) {
        ResponseEntity<String>responseEntity=null;
        String email = user.getEmail();
        if(userProfile.containsKey(user.getEmail()))
        {
            responseEntity = new ResponseEntity<>("User already exits",
                    HttpStatus.BAD_REQUEST);
        }
        else {
            userProfile.put(email, user);
            responseEntity=new ResponseEntity<>("User registered successfully",HttpStatus.OK);
        }
        return responseEntity;
    }

    //User can fetch All account details --> GET
    @GetMapping("/fetch")
    Map<String,User> allAccDetails() {
        return userProfile;
    }

    //User can fetch particular account details
    @GetMapping("/getDetails")
    private ResponseEntity<User> getAccDetails(@RequestParam String email,String password) {
        ResponseEntity<User> responseEntity = null;
        String userPassword= userProfile.get(email).getPassword();
        if(userPassword.equals(password)){
        responseEntity= new ResponseEntity<>(userProfile.get(email),HttpStatus.OK);
        }
        else
        {
            responseEntity = new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
        return responseEntity;
    }


    // User can update account details  -->PUT
    @PutMapping("/update")
    private ResponseEntity<String> updateRecord(@RequestBody User user) {

        String email = user.getEmail();
        String updatedName = user.getName();
        String password= user.getPassword();
        ResponseEntity<String> responseEntity = null;
        if(password.equals(userProfile.get(email).getPassword())){
        if (containsInvalidChars(updatedName)) {
            responseEntity = new ResponseEntity<>("name contains invalid characters",
                    HttpStatus.BAD_REQUEST);
        } else if (userProfile.containsKey(email)) {
            String currName = userProfile.get(email).getName();
            if (currName.equals(updatedName)) {
                responseEntity = new ResponseEntity<>("No change required",
                        HttpStatus.OK);
            } else {

               userProfile.get(email).setName(updatedName);
                responseEntity = new ResponseEntity<>("update successful",
                        HttpStatus.OK);
            }
        }
        else {
            responseEntity = new ResponseEntity<>("User doesn't exist",
                    HttpStatus.NOT_FOUND);
        }}else {
            responseEntity = new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
        return responseEntity;
    }

    private boolean containsInvalidChars(String name) {
        // name contains any numbers or +-
        return false;
    }

    //followUser
    @PostMapping("/follow")
    private ResponseEntity<String> followUsers(@RequestParam String email, String userEmail){
        ResponseEntity<String> responseEntity = null;
        if (!userProfile.containsKey(email)){
            responseEntity = new ResponseEntity<>("User doesn't exist",HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
        if(userEmail.equals(email)){
            responseEntity = new ResponseEntity<>("You can't follow yourself",HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
        if (userProfile.get(userEmail) != null) {
            if (following.containsKey(email)) {
                following.get(email).add(userEmail);
            } else {
                List<String> list = new ArrayList<>();
                list.add(userEmail);
                following.put(email, list);
            }
            responseEntity = new ResponseEntity<>("User " + userEmail + " followed successfully"
                    ,HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>("User you are following doesn't exist"
                    ,HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    // User can delete account  -->DELETE
    @DeleteMapping("/delete")
    ResponseEntity<String>  deleteRecord(@RequestParam String email,String password) {
        ResponseEntity<String> responseEntity = null;
        if(password.equals(userProfile.get(email).getPassword())) {
            if (userProfile.containsKey(email)) {
                userProfile.remove(email);
            }
            responseEntity = new ResponseEntity<>("delete successful",
                    HttpStatus.OK);
        }

        else{
            responseEntity = new ResponseEntity<>("Wrong password",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }


    //create tweet
    @PostMapping("/createTweet")
    ResponseEntity<String>  createTweet(@RequestBody Tweet tweet,@RequestParam String password){
        ResponseEntity<String> responseEntity = null;
        String email = tweet.getEmail();
        if(password.equals(userProfile.get(email).getPassword())){
        if(userProfile.containsKey(email)) {
            if(tweets.get(email) != null)
                tweets.get(email).add(tweet);
            else {
                List<Tweet> list = new ArrayList<>();
                list.add(tweet);
                tweets.put(email, list);
            }
            return new ResponseEntity<>("Tweet post succesfull",HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("User is not registered",HttpStatus.BAD_REQUEST);
    }else {
            return new ResponseEntity<>(" wrong Password",HttpStatus.BAD_REQUEST);
        }
    }
    //Fetch all tweets
    @GetMapping("/fetchTweets")
    Map<String,List<Tweet>> allTweetDetails() {
        return tweets;
    }

    //User can fetch particular account Tweet details
    @GetMapping("/getTweetDetails")
    private List<Tweet> getTweetDetails(@RequestParam String email) {
        return  tweets.get(email);
    }



}
