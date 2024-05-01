```
# Decentralized Social Media Platform

This project is a simplified implementation of a decentralized social media platform using Java. It provides basic functionalities such as user registration, login, posting, and viewing posts. Note that this implementation does not include decentralized features like blockchain integration or peer-to-peer networking.

## Features

- User registration: Users can register with a unique username and password.
- User login: Registered users can log in with their username and password.
- Post creation: Logged-in users can create posts containing text content.
- Timeline view: Users can view their own posts on their timeline.

## Usage

1. **Clone the repository:**

   ```bash
   git clone <https://github.com/your-username/decentralized-social-media-platform.git>

```

1. **Compile and run the Java program:**
    
    ```bash
    cd decentralized-social-media-platform
    javac DecentralizedSocialMediaPlatform.java
    java DecentralizedSocialMediaPlatform
    
    ```
    
2. **Interact with the program:**
    - Register users using the `registerUser` method.
    - Login with registered users using the `loginUser` method.
    - Create posts using the `post` method.
    - View user timelines using the `viewTimeline` method.

## Example

```java
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

```

## Future Enhancements

- Integration with blockchain for decentralization.
- Implementation of peer-to-peer networking for communication between users.
- Development of a graphical user interface (GUI) for better user interaction.
