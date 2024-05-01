import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class User {
    private String username;
    private String password;
    private List<Post> posts;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.posts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public List<Post> getPosts() {
        return posts;
    }
}

class Post {
    private String content;
    private User author;

    public Post(String content, User author) {
        this.content = content;
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }
}

public class DecentralizedSocialMediaPlatform {
    private Map<String, User> users;

    public DecentralizedSocialMediaPlatform() {
        this.users = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, new User(username, password));
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    public void loginUser(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.authenticate(password)) {
                System.out.println("Login successful. Welcome, " + username + "!");
            } else {
                System.out.println("Incorrect password.");
            }
        } else {
            System.out.println("User not found.");
        }
    }

    public void post(String username, String content) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            Post post = new Post(content, user);
            user.addPost(post);
            System.out.println("Post created successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    public List<Post> viewTimeline(String username) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            return user.getPosts();
        } else {
            System.out.println("User not found.");
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        DecentralizedSocialMediaPlatform platform = new DecentralizedSocialMediaPlatform();

        // Register users
        platform.registerUser("user1", "password1");
        platform.registerUser("user2", "password2");

        // Login
        platform.loginUser("user1", "password1");

        // Post
        platform.post("user1", "Hello, world!");

        // View timeline
        List<Post> user1Timeline = platform.viewTimeline("user1");
        for (Post post : user1Timeline) {
            System.out.println(post.getAuthor().getUsername() + ": " + post.getContent());
        }
    }
}
