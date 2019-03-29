package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PostsController {

    List<Post> fakePostFromDB = new ArrayList<>(); // var array = []

    @RequestMapping(method = RequestMethod.GET, path = "/posts")
    public Object getPosts() {

        System.out.println("Listing posts!");
        return fakePostFromDB;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/posts")
    public Object createPost(Post post) {

        System.out.println("Creating post!");
        fakePostFromDB.add(post);
        return fakePostFromDB;
    }

}
