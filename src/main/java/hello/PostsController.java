package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController {

    @Autowired
    PostRepository postRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/posts")
    public Object getPosts() {

        System.out.println("Listing posts!");
        return postRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/posts")
    public Object createPost(Post post) {

        System.out.println("Creating post!");

        return postRepository.save(post);
    }

}
