package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PostsController {

    @RequestMapping(method = RequestMethod.GET, path = "/posts")
    public Object getPosts() {

        System.out.println("hey!");

        List<Post> fakePostFromDB = new ArrayList<>(); // var array = []

        Post post = new Post();
        post.setId(1);
        post.setUserId(324324);

        post.setTitle("I'm the title!!!!");
        post.setBody("I'm the body of the post");


        Post post2= new Post();
        post2.setId(2);
        post2.setUserId(324324);

        post2.setTitle("This is another post");
        post2.setBody("bla la bla blal");

        fakePostFromDB.add(post);
        fakePostFromDB.add(post2);

        return fakePostFromDB;
    }
}
